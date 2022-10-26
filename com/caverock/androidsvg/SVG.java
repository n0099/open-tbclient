package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.qk9;
import com.baidu.tieba.rk9;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.tieba.sk9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.caverock.androidsvg.CSSParser;
import com.coremedia.iso.boxes.TrackReferenceBox;
import com.fun.ad.sdk.FunAdSdk;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class SVG {
    public static /* synthetic */ Interceptable $ic = null;
    public static sk9 e = null;
    public static boolean f = true;
    public transient /* synthetic */ FieldHolder $fh;
    public d0 a;
    public float b;
    public CSSParser.n c;
    public Map d;

    /* loaded from: classes7.dex */
    public interface e0 {
        String a();

        void b(Set set);

        void d(Set set);

        Set e();

        Set f();

        void g(Set set);

        Set h();

        void j(Set set);

        void k(String str);

        Set m();
    }

    /* loaded from: classes7.dex */
    public interface h0 {
        List getChildren();

        void i(l0 l0Var) throws SVGParseException;
    }

    /* loaded from: classes7.dex */
    public interface m {
        void l(Matrix matrix);
    }

    /* loaded from: classes7.dex */
    public interface s {
    }

    /* loaded from: classes7.dex */
    public interface v0 {
        z0 c();
    }

    /* loaded from: classes7.dex */
    public interface w {
        void a(float f, float f2);

        void b(float f, float f2);

        void c(float f, float f2, float f3, float f4);

        void close();

        void d(float f, float f2, float f3, float f4, float f5, float f6);

        void e(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5);
    }

    /* loaded from: classes7.dex */
    public interface z0 {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1831194158, "Lcom/caverock/androidsvg/SVG;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1831194158, "Lcom/caverock/androidsvg/SVG;");
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class Style implements Cloneable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Boolean A;
        public Boolean B;
        public m0 C;
        public Float D;
        public String E;
        public FillRule F;
        public String G;
        public m0 H;
        public Float I;
        public m0 J;
        public Float K;
        public VectorEffect L;
        public RenderQuality M;
        public long a;
        public m0 b;
        public FillRule c;
        public Float d;
        public m0 e;
        public Float f;
        public o g;
        public LineCap h;
        public LineJoin i;
        public Float j;
        public o[] k;
        public o l;
        public Float m;
        public f n;
        public List o;
        public o p;
        public Integer q;
        public FontStyle r;
        public TextDecoration s;
        public TextDirection t;
        public TextAnchor u;
        public Boolean v;
        public c w;
        public String x;
        public String y;
        public String z;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes7.dex */
        public final class FillRule {
            public static final /* synthetic */ FillRule[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final FillRule EvenOdd;
            public static final FillRule NonZero;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1797845650, "Lcom/caverock/androidsvg/SVG$Style$FillRule;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1797845650, "Lcom/caverock/androidsvg/SVG$Style$FillRule;");
                        return;
                    }
                }
                NonZero = new FillRule("NonZero", 0);
                FillRule fillRule = new FillRule("EvenOdd", 1);
                EvenOdd = fillRule;
                $VALUES = new FillRule[]{NonZero, fillRule};
            }

            public FillRule(String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static FillRule valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                    return (FillRule) Enum.valueOf(FillRule.class, str);
                }
                return (FillRule) invokeL.objValue;
            }

            public static FillRule[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                    return (FillRule[]) $VALUES.clone();
                }
                return (FillRule[]) invokeV.objValue;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes7.dex */
        public final class FontStyle {
            public static final /* synthetic */ FontStyle[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final FontStyle Italic;
            public static final FontStyle Normal;
            public static final FontStyle Oblique;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-332335357, "Lcom/caverock/androidsvg/SVG$Style$FontStyle;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-332335357, "Lcom/caverock/androidsvg/SVG$Style$FontStyle;");
                        return;
                    }
                }
                Normal = new FontStyle("Normal", 0);
                Italic = new FontStyle("Italic", 1);
                FontStyle fontStyle = new FontStyle("Oblique", 2);
                Oblique = fontStyle;
                $VALUES = new FontStyle[]{Normal, Italic, fontStyle};
            }

            public FontStyle(String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static FontStyle valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                    return (FontStyle) Enum.valueOf(FontStyle.class, str);
                }
                return (FontStyle) invokeL.objValue;
            }

            public static FontStyle[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                    return (FontStyle[]) $VALUES.clone();
                }
                return (FontStyle[]) invokeV.objValue;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes7.dex */
        public final class LineCap {
            public static final /* synthetic */ LineCap[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final LineCap Butt;
            public static final LineCap Round;
            public static final LineCap Square;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-241507225, "Lcom/caverock/androidsvg/SVG$Style$LineCap;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-241507225, "Lcom/caverock/androidsvg/SVG$Style$LineCap;");
                        return;
                    }
                }
                Butt = new LineCap("Butt", 0);
                Round = new LineCap("Round", 1);
                LineCap lineCap = new LineCap("Square", 2);
                Square = lineCap;
                $VALUES = new LineCap[]{Butt, Round, lineCap};
            }

            public LineCap(String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static LineCap valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                    return (LineCap) Enum.valueOf(LineCap.class, str);
                }
                return (LineCap) invokeL.objValue;
            }

            public static LineCap[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                    return (LineCap[]) $VALUES.clone();
                }
                return (LineCap[]) invokeV.objValue;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes7.dex */
        public final class LineJoin {
            public static final /* synthetic */ LineJoin[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final LineJoin Bevel;
            public static final LineJoin Miter;
            public static final LineJoin Round;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1110087251, "Lcom/caverock/androidsvg/SVG$Style$LineJoin;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1110087251, "Lcom/caverock/androidsvg/SVG$Style$LineJoin;");
                        return;
                    }
                }
                Miter = new LineJoin("Miter", 0);
                Round = new LineJoin("Round", 1);
                LineJoin lineJoin = new LineJoin("Bevel", 2);
                Bevel = lineJoin;
                $VALUES = new LineJoin[]{Miter, Round, lineJoin};
            }

            public LineJoin(String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static LineJoin valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                    return (LineJoin) Enum.valueOf(LineJoin.class, str);
                }
                return (LineJoin) invokeL.objValue;
            }

            public static LineJoin[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                    return (LineJoin[]) $VALUES.clone();
                }
                return (LineJoin[]) invokeV.objValue;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes7.dex */
        public final class RenderQuality {
            public static final /* synthetic */ RenderQuality[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final RenderQuality auto;
            public static final RenderQuality optimizeQuality;
            public static final RenderQuality optimizeSpeed;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2053208324, "Lcom/caverock/androidsvg/SVG$Style$RenderQuality;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-2053208324, "Lcom/caverock/androidsvg/SVG$Style$RenderQuality;");
                        return;
                    }
                }
                auto = new RenderQuality("auto", 0);
                optimizeQuality = new RenderQuality("optimizeQuality", 1);
                RenderQuality renderQuality = new RenderQuality("optimizeSpeed", 2);
                optimizeSpeed = renderQuality;
                $VALUES = new RenderQuality[]{auto, optimizeQuality, renderQuality};
            }

            public RenderQuality(String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static RenderQuality valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                    return (RenderQuality) Enum.valueOf(RenderQuality.class, str);
                }
                return (RenderQuality) invokeL.objValue;
            }

            public static RenderQuality[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                    return (RenderQuality[]) $VALUES.clone();
                }
                return (RenderQuality[]) invokeV.objValue;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes7.dex */
        public final class TextAnchor {
            public static final /* synthetic */ TextAnchor[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final TextAnchor End;
            public static final TextAnchor Middle;
            public static final TextAnchor Start;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(983085647, "Lcom/caverock/androidsvg/SVG$Style$TextAnchor;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(983085647, "Lcom/caverock/androidsvg/SVG$Style$TextAnchor;");
                        return;
                    }
                }
                Start = new TextAnchor("Start", 0);
                Middle = new TextAnchor("Middle", 1);
                TextAnchor textAnchor = new TextAnchor("End", 2);
                End = textAnchor;
                $VALUES = new TextAnchor[]{Start, Middle, textAnchor};
            }

            public TextAnchor(String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static TextAnchor valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                    return (TextAnchor) Enum.valueOf(TextAnchor.class, str);
                }
                return (TextAnchor) invokeL.objValue;
            }

            public static TextAnchor[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                    return (TextAnchor[]) $VALUES.clone();
                }
                return (TextAnchor[]) invokeV.objValue;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes7.dex */
        public final class TextDecoration {
            public static final /* synthetic */ TextDecoration[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final TextDecoration Blink;
            public static final TextDecoration LineThrough;
            public static final TextDecoration None;
            public static final TextDecoration Overline;
            public static final TextDecoration Underline;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2087764172, "Lcom/caverock/androidsvg/SVG$Style$TextDecoration;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-2087764172, "Lcom/caverock/androidsvg/SVG$Style$TextDecoration;");
                        return;
                    }
                }
                None = new TextDecoration("None", 0);
                Underline = new TextDecoration("Underline", 1);
                Overline = new TextDecoration("Overline", 2);
                LineThrough = new TextDecoration("LineThrough", 3);
                TextDecoration textDecoration = new TextDecoration("Blink", 4);
                Blink = textDecoration;
                $VALUES = new TextDecoration[]{None, Underline, Overline, LineThrough, textDecoration};
            }

            public TextDecoration(String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static TextDecoration valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                    return (TextDecoration) Enum.valueOf(TextDecoration.class, str);
                }
                return (TextDecoration) invokeL.objValue;
            }

            public static TextDecoration[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                    return (TextDecoration[]) $VALUES.clone();
                }
                return (TextDecoration[]) invokeV.objValue;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes7.dex */
        public final class TextDirection {
            public static final /* synthetic */ TextDirection[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final TextDirection LTR;
            public static final TextDirection RTL;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1244900819, "Lcom/caverock/androidsvg/SVG$Style$TextDirection;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1244900819, "Lcom/caverock/androidsvg/SVG$Style$TextDirection;");
                        return;
                    }
                }
                LTR = new TextDirection(StaticLayoutBuilderCompat.TEXT_DIR_CLASS_LTR, 0);
                TextDirection textDirection = new TextDirection(StaticLayoutBuilderCompat.TEXT_DIR_CLASS_RTL, 1);
                RTL = textDirection;
                $VALUES = new TextDirection[]{LTR, textDirection};
            }

            public TextDirection(String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static TextDirection valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                    return (TextDirection) Enum.valueOf(TextDirection.class, str);
                }
                return (TextDirection) invokeL.objValue;
            }

            public static TextDirection[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                    return (TextDirection[]) $VALUES.clone();
                }
                return (TextDirection[]) invokeV.objValue;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes7.dex */
        public final class VectorEffect {
            public static final /* synthetic */ VectorEffect[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final VectorEffect NonScalingStroke;
            public static final VectorEffect None;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1436505955, "Lcom/caverock/androidsvg/SVG$Style$VectorEffect;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-1436505955, "Lcom/caverock/androidsvg/SVG$Style$VectorEffect;");
                        return;
                    }
                }
                None = new VectorEffect("None", 0);
                VectorEffect vectorEffect = new VectorEffect("NonScalingStroke", 1);
                NonScalingStroke = vectorEffect;
                $VALUES = new VectorEffect[]{None, vectorEffect};
            }

            public VectorEffect(String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static VectorEffect valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                    return (VectorEffect) Enum.valueOf(VectorEffect.class, str);
                }
                return (VectorEffect) invokeL.objValue;
            }

            public static VectorEffect[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                    return (VectorEffect[]) $VALUES.clone();
                }
                return (VectorEffect[]) invokeV.objValue;
            }
        }

        public Style() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0L;
        }

        public Object clone() throws CloneNotSupportedException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Style style = (Style) super.clone();
                o[] oVarArr = this.k;
                if (oVarArr != null) {
                    style.k = (o[]) oVarArr.clone();
                }
                return style;
            }
            return invokeV.objValue;
        }

        public static Style a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                Style style = new Style();
                style.a = -1L;
                style.b = f.b;
                style.c = FillRule.NonZero;
                Float valueOf = Float.valueOf(1.0f);
                style.d = valueOf;
                style.e = null;
                style.f = valueOf;
                style.g = new o(1.0f);
                style.h = LineCap.Butt;
                style.i = LineJoin.Miter;
                style.j = Float.valueOf(4.0f);
                style.k = null;
                style.l = new o(0.0f);
                style.m = valueOf;
                style.n = f.b;
                style.o = null;
                style.p = new o(12.0f, Unit.pt);
                style.q = 400;
                style.r = FontStyle.Normal;
                style.s = TextDecoration.None;
                style.t = TextDirection.LTR;
                style.u = TextAnchor.Start;
                Boolean bool = Boolean.TRUE;
                style.v = bool;
                style.w = null;
                style.x = null;
                style.y = null;
                style.z = null;
                style.A = bool;
                style.B = bool;
                style.C = f.b;
                style.D = valueOf;
                style.E = null;
                style.F = FillRule.NonZero;
                style.G = null;
                style.H = null;
                style.I = valueOf;
                style.J = null;
                style.K = valueOf;
                style.L = VectorEffect.None;
                style.M = RenderQuality.auto;
                return style;
            }
            return (Style) invokeV.objValue;
        }

        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                Boolean bool = Boolean.TRUE;
                this.A = bool;
                if (!z) {
                    bool = Boolean.FALSE;
                }
                this.v = bool;
                this.w = null;
                this.E = null;
                this.m = Float.valueOf(1.0f);
                this.C = f.b;
                this.D = Float.valueOf(1.0f);
                this.G = null;
                this.H = null;
                this.I = Float.valueOf(1.0f);
                this.J = null;
                this.K = Float.valueOf(1.0f);
                this.L = VectorEffect.None;
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public final class GradientSpread {
        public static final /* synthetic */ GradientSpread[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final GradientSpread pad;
        public static final GradientSpread reflect;
        public static final GradientSpread repeat;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1325891391, "Lcom/caverock/androidsvg/SVG$GradientSpread;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1325891391, "Lcom/caverock/androidsvg/SVG$GradientSpread;");
                    return;
                }
            }
            pad = new GradientSpread("pad", 0);
            reflect = new GradientSpread("reflect", 1);
            GradientSpread gradientSpread = new GradientSpread("repeat", 2);
            repeat = gradientSpread;
            $VALUES = new GradientSpread[]{pad, reflect, gradientSpread};
        }

        public GradientSpread(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static GradientSpread valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (GradientSpread) Enum.valueOf(GradientSpread.class, str);
            }
            return (GradientSpread) invokeL.objValue;
        }

        public static GradientSpread[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (GradientSpread[]) $VALUES.clone();
            }
            return (GradientSpread[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public final class Unit {
        public static final /* synthetic */ Unit[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Unit cm;
        public static final Unit em;
        public static final Unit ex;
        public static final Unit in;
        public static final Unit mm;
        public static final Unit pc;
        public static final Unit percent;
        public static final Unit pt;
        public static final Unit px;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1268002976, "Lcom/caverock/androidsvg/SVG$Unit;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1268002976, "Lcom/caverock/androidsvg/SVG$Unit;");
                    return;
                }
            }
            px = new Unit("px", 0);
            em = new Unit("em", 1);
            ex = new Unit(Config.EXCEPTION_PART, 2);
            in = new Unit("in", 3);
            cm = new Unit(FunAdSdk.PLATFORM_CM, 4);
            mm = new Unit(FunAdSdk.PLATFORM_MM, 5);
            pt = new Unit(Config.PLATFORM_TYPE, 6);
            pc = new Unit("pc", 7);
            Unit unit = new Unit("percent", 8);
            percent = unit;
            $VALUES = new Unit[]{px, em, ex, in, cm, mm, pt, pc, unit};
        }

        public Unit(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Unit valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (Unit) Enum.valueOf(Unit.class, str);
            }
            return (Unit) invokeL.objValue;
        }

        public static Unit[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Unit[]) $VALUES.clone();
            }
            return (Unit[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1159024559, "Lcom/caverock/androidsvg/SVG$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1159024559, "Lcom/caverock/androidsvg/SVG$a;");
                    return;
                }
            }
            int[] iArr = new int[Unit.values().length];
            a = iArr;
            try {
                iArr[Unit.px.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Unit.em.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Unit.ex.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Unit.in.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Unit.cm.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Unit.mm.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[Unit.pt.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[Unit.pc.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[Unit.percent.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 extends k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public o o;
        public o p;
        public o q;
        public o r;
        public o s;
        public o t;

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "rect" : (String) invokeV.objValue;
        }

        public a0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a1 extends l0 implements v0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String c;
        public z0 d;

        public a1(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = str;
        }

        @Override // com.caverock.androidsvg.SVG.v0
        public z0 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.d;
            }
            return (z0) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "TextChild: '" + this.c + "'";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public float b;
        public float c;
        public float d;

        public b(float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
        }

        public b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = bVar.a;
            this.b = bVar.b;
            this.c = bVar.c;
            this.d = bVar.d;
        }

        public static b a(float f, float f2, float f3, float f4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
                return new b(f, f2, f3 - f, f4 - f2);
            }
            return (b) invokeCommon.objValue;
        }

        public float b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a + this.c;
            }
            return invokeV.floatValue;
        }

        public float c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b + this.d;
            }
            return invokeV.floatValue;
        }

        public void d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
                float f = bVar.a;
                if (f < this.a) {
                    this.a = f;
                }
                float f2 = bVar.b;
                if (f2 < this.b) {
                    this.b = f2;
                }
                if (bVar.b() > b()) {
                    this.c = bVar.b() - this.a;
                }
                if (bVar.c() > c()) {
                    this.d = bVar.c() - this.b;
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return PreferencesUtil.LEFT_MOUNT + this.a + " " + this.b + " " + this.c + " " + this.d + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b0 extends j0 implements h0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.caverock.androidsvg.SVG.h0
        public void i(l0 l0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l0Var) == null) {
            }
        }

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "solidColor" : (String) invokeV.objValue;
        }

        public b0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public List getChildren() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return Collections.emptyList();
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b1 extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String o;
        public o p;
        public o q;
        public o r;
        public o s;

        @Override // com.caverock.androidsvg.SVG.l, com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TbConfig.ST_TYPE_USE : (String) invokeV.objValue;
        }

        public b1() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public o a;
        public o b;
        public o c;
        public o d;

        public c(o oVar, o oVar2, o oVar3, o oVar4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, oVar2, oVar3, oVar4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oVar;
            this.b = oVar2;
            this.c = oVar3;
            this.d = oVar4;
        }
    }

    /* loaded from: classes7.dex */
    public class c0 extends j0 implements h0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Float h;

        @Override // com.caverock.androidsvg.SVG.h0
        public void i(l0 l0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l0Var) == null) {
            }
        }

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? IntentConfig.STOP : (String) invokeV.objValue;
        }

        public c0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public List getChildren() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return Collections.emptyList();
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c1 extends p0 implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? NativeConstants.TYPE_VIEW : (String) invokeV.objValue;
        }

        public c1() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public o o;
        public o p;
        public o q;

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Config.TRACE_CIRCLE : (String) invokeV.objValue;
        }

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d0 extends p0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public o p;
        public o q;
        public o r;
        public o s;
        public String t;

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "svg" : (String) invokeV.objValue;
        }

        public d0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends l implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Boolean o;

        @Override // com.caverock.androidsvg.SVG.l, com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "clipPath" : (String) invokeV.objValue;
        }

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends m0 {
        public static /* synthetic */ Interceptable $ic;
        public static final f b;
        public static final f c;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1159024404, "Lcom/caverock/androidsvg/SVG$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1159024404, "Lcom/caverock/androidsvg/SVG$f;");
                    return;
                }
            }
            b = new f(-16777216);
            c = new f(0);
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return String.format("#%08x", Integer.valueOf(this.a));
            }
            return (String) invokeV.objValue;
        }

        public f(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i;
        }
    }

    /* loaded from: classes7.dex */
    public abstract class f0 extends i0 implements h0, e0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List i;
        public Set j;
        public String k;
        public Set l;
        public Set m;

        @Override // com.caverock.androidsvg.SVG.e0
        public void d(Set set) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, set) == null) {
            }
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (Set) invokeV.objValue;
        }

        public f0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = new ArrayList();
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.k;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.l;
            }
            return (Set) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public List getChildren() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.i;
            }
            return (List) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.j;
            }
            return (Set) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.m;
            }
            return (Set) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void b(Set set) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set) == null) {
                this.m = set;
            }
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void g(Set set) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, set) == null) {
                this.j = set;
            }
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public void i(l0 l0Var) throws SVGParseException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, l0Var) == null) {
                this.i.add(l0Var);
            }
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void j(Set set) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, set) == null) {
                this.l = set;
            }
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void k(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                this.k = str;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends m0 {
        public static /* synthetic */ Interceptable $ic;
        public static g a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1159024373, "Lcom/caverock/androidsvg/SVG$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1159024373, "Lcom/caverock/androidsvg/SVG$g;");
                    return;
                }
            }
            a = new g();
        }

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static g a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                return a;
            }
            return (g) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public abstract class g0 extends i0 implements e0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Set i;
        public String j;
        public Set k;
        public Set l;
        public Set m;

        public g0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = null;
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.j;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.l;
            }
            return (Set) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.k;
            }
            return (Set) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.i;
            }
            return (Set) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.m;
            }
            return (Set) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void b(Set set) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set) == null) {
                this.m = set;
            }
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void d(Set set) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, set) == null) {
                this.k = set;
            }
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void g(Set set) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, set) == null) {
                this.i = set;
            }
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void j(Set set) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, set) == null) {
                this.l = set;
            }
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void k(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.j = str;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends l implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.caverock.androidsvg.SVG.l, com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "defs" : (String) invokeV.objValue;
        }

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public o o;
        public o p;
        public o q;
        public o r;

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "ellipse" : (String) invokeV.objValue;
        }

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public abstract class i0 extends j0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b h;

        public i0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = null;
        }
    }

    /* loaded from: classes7.dex */
    public abstract class j extends j0 implements h0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List h;
        public Boolean i;
        public Matrix j;
        public GradientSpread k;
        public String l;

        public j() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = new ArrayList();
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public List getChildren() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.h;
            }
            return (List) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public void i(l0 l0Var) throws SVGParseException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l0Var) == null) {
                if (l0Var instanceof c0) {
                    this.h.add(l0Var);
                    return;
                }
                throw new SVGParseException("Gradient elements cannot contain " + l0Var + " elements.");
            }
        }
    }

    /* loaded from: classes7.dex */
    public abstract class j0 extends l0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String c;
        public Boolean d;
        public Style e;
        public Style f;
        public List g;

        public j0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return n();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public abstract class k extends g0 implements m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Matrix n;

        public k() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.caverock.androidsvg.SVG.m
        public void l(Matrix matrix) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, matrix) == null) {
                this.n = matrix;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k0 extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public o m;
        public o n;
        public o o;
        public o p;

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "linearGradient" : (String) invokeV.objValue;
        }

        public k0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l extends f0 implements m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Matrix n;

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "group" : (String) invokeV.objValue;
        }

        public l() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.caverock.androidsvg.SVG.m
        public void l(Matrix matrix) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, matrix) == null) {
                this.n = matrix;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SVG a;
        public h0 b;

        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "" : (String) invokeV.objValue;
        }

        public l0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public abstract class m0 implements Cloneable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n extends n0 implements m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String o;
        public o p;
        public o q;
        public o r;
        public o s;
        public Matrix t;

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "image" : (String) invokeV.objValue;
        }

        public n() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.caverock.androidsvg.SVG.m
        public void l(Matrix matrix) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, matrix) == null) {
                this.t = matrix;
            }
        }
    }

    /* loaded from: classes7.dex */
    public abstract class n0 extends f0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PreserveAspectRatio n;

        public n0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = null;
        }
    }

    /* loaded from: classes7.dex */
    public class o implements Cloneable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public Unit b;

        public o(float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f;
            this.b = Unit.px;
        }

        public o(float f, Unit unit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f), unit};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = f;
            this.b = unit;
        }

        public float a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.floatValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (this.a < 0.0f) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.a == 0.0f) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return String.valueOf(this.a) + this.b;
            }
            return (String) invokeV.objValue;
        }

        public float b(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
                int i = a.a[this.b.ordinal()];
                if (i != 1) {
                    switch (i) {
                        case 4:
                            return this.a * f;
                        case 5:
                            return (this.a * f) / 2.54f;
                        case 6:
                            return (this.a * f) / 25.4f;
                        case 7:
                            return (this.a * f) / 72.0f;
                        case 8:
                            return (this.a * f) / 6.0f;
                        default:
                            return this.a;
                    }
                }
                return this.a;
            }
            return invokeF.floatValue;
        }

        public float c(rk9 rk9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rk9Var)) == null) {
                if (this.b == Unit.percent) {
                    b a0 = rk9Var.a0();
                    if (a0 == null) {
                        return this.a;
                    }
                    float f = a0.c;
                    float f2 = a0.d;
                    if (f == f2) {
                        return (this.a * f) / 100.0f;
                    }
                    return (this.a * ((float) (Math.sqrt((f * f) + (f2 * f2)) / 1.414213562373095d))) / 100.0f;
                }
                return e(rk9Var);
            }
            return invokeL.floatValue;
        }

        public float d(rk9 rk9Var, float f) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLF = interceptable.invokeLF(1048579, this, rk9Var, f)) == null) {
                if (this.b == Unit.percent) {
                    return (this.a * f) / 100.0f;
                }
                return e(rk9Var);
            }
            return invokeLF.floatValue;
        }

        public float e(rk9 rk9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rk9Var)) == null) {
                switch (a.a[this.b.ordinal()]) {
                    case 1:
                        return this.a;
                    case 2:
                        return this.a * rk9Var.Y();
                    case 3:
                        return this.a * rk9Var.Z();
                    case 4:
                        return this.a * rk9Var.b0();
                    case 5:
                        return (this.a * rk9Var.b0()) / 2.54f;
                    case 6:
                        return (this.a * rk9Var.b0()) / 25.4f;
                    case 7:
                        return (this.a * rk9Var.b0()) / 72.0f;
                    case 8:
                        return (this.a * rk9Var.b0()) / 6.0f;
                    case 9:
                        b a0 = rk9Var.a0();
                        if (a0 == null) {
                            return this.a;
                        }
                        return (this.a * a0.c) / 100.0f;
                    default:
                        return this.a;
                }
            }
            return invokeL.floatValue;
        }

        public float f(rk9 rk9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, rk9Var)) == null) {
                if (this.b == Unit.percent) {
                    b a0 = rk9Var.a0();
                    if (a0 == null) {
                        return this.a;
                    }
                    return (this.a * a0.d) / 100.0f;
                }
                return e(rk9Var);
            }
            return invokeL.floatValue;
        }
    }

    /* loaded from: classes7.dex */
    public class o0 extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public o m;
        public o n;
        public o o;
        public o p;
        public o q;

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "radialGradient" : (String) invokeV.objValue;
        }

        public o0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p extends k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public o o;
        public o p;
        public o q;
        public o r;

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "line" : (String) invokeV.objValue;
        }

        public p() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public abstract class p0 extends n0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b o;

        public p0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q extends p0 implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean p;
        public o q;
        public o r;
        public o s;
        public o t;
        public Float u;

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "marker" : (String) invokeV.objValue;
        }

        public q() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q0 extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.caverock.androidsvg.SVG.l, com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SetImageWatermarkTypeReqMsg.SWITCH : (String) invokeV.objValue;
        }

        public q0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r extends f0 implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Boolean n;
        public Boolean o;
        public o p;
        public o q;
        public o r;
        public o s;

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "mask" : (String) invokeV.objValue;
        }

        public r() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r0 extends p0 implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "symbol" : (String) invokeV.objValue;
        }

        public r0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s0 extends w0 implements v0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String n;
        public z0 o;

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TrackReferenceBox.TYPE : (String) invokeV.objValue;
        }

        public s0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.caverock.androidsvg.SVG.v0
        public z0 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.o;
            }
            return (z0) invokeV.objValue;
        }

        public void o(z0 z0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, z0Var) == null) {
                this.o = z0Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t extends m0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public m0 b;

        public t(String str, m0 m0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, m0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = m0Var;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a + " " + this.b;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class t0 extends y0 implements v0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public z0 r;

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "tspan" : (String) invokeV.objValue;
        }

        public t0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.caverock.androidsvg.SVG.v0
        public z0 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.r;
            }
            return (z0) invokeV.objValue;
        }

        public void o(z0 z0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, z0Var) == null) {
                this.r = z0Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u extends k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public v o;
        public Float p;

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "path" : (String) invokeV.objValue;
        }

        public u() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u0 extends y0 implements z0, m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Matrix r;

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "text" : (String) invokeV.objValue;
        }

        public u0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.caverock.androidsvg.SVG.m
        public void l(Matrix matrix) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, matrix) == null) {
                this.r = matrix;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] a;
        public int b;
        public float[] c;
        public int d;

        public v() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = 0;
            this.d = 0;
            this.a = new byte[8];
            this.c = new float[16];
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void a(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                f((byte) 0);
                g(2);
                float[] fArr = this.c;
                int i = this.d;
                int i2 = i + 1;
                this.d = i2;
                fArr[i] = f;
                this.d = i2 + 1;
                fArr[i2] = f2;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void b(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                f((byte) 1);
                g(2);
                float[] fArr = this.c;
                int i = this.d;
                int i2 = i + 1;
                this.d = i2;
                fArr[i] = f;
                this.d = i2 + 1;
                fArr[i2] = f2;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void c(float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                f((byte) 3);
                g(4);
                float[] fArr = this.c;
                int i = this.d;
                int i2 = i + 1;
                this.d = i2;
                fArr[i] = f;
                int i3 = i2 + 1;
                this.d = i3;
                fArr[i2] = f2;
                int i4 = i3 + 1;
                this.d = i4;
                fArr[i3] = f3;
                this.d = i4 + 1;
                fArr[i4] = f4;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                f((byte) 8);
            }
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                if (this.b == 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void d(float f, float f2, float f3, float f4, float f5, float f6) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)}) == null) {
                f((byte) 2);
                g(6);
                float[] fArr = this.c;
                int i = this.d;
                int i2 = i + 1;
                this.d = i2;
                fArr[i] = f;
                int i3 = i2 + 1;
                this.d = i3;
                fArr[i2] = f2;
                int i4 = i3 + 1;
                this.d = i4;
                fArr[i3] = f3;
                int i5 = i4 + 1;
                this.d = i5;
                fArr[i4] = f4;
                int i6 = i5 + 1;
                this.d = i6;
                fArr[i5] = f5;
                this.d = i6 + 1;
                fArr[i6] = f6;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void e(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
                if (z) {
                    i = 2;
                } else {
                    i = 0;
                }
                f((byte) (i | 4 | (z2 ? 1 : 0)));
                g(5);
                float[] fArr = this.c;
                int i2 = this.d;
                int i3 = i2 + 1;
                this.d = i3;
                fArr[i2] = f;
                int i4 = i3 + 1;
                this.d = i4;
                fArr[i3] = f2;
                int i5 = i4 + 1;
                this.d = i5;
                fArr[i4] = f3;
                int i6 = i5 + 1;
                this.d = i6;
                fArr[i5] = f4;
                this.d = i6 + 1;
                fArr[i6] = f5;
            }
        }

        public final void f(byte b) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeB(1048582, this, b) == null) {
                int i = this.b;
                byte[] bArr = this.a;
                if (i == bArr.length) {
                    byte[] bArr2 = new byte[bArr.length * 2];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.a = bArr2;
                }
                byte[] bArr3 = this.a;
                int i2 = this.b;
                this.b = i2 + 1;
                bArr3[i2] = b;
            }
        }

        public final void g(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
                float[] fArr = this.c;
                if (fArr.length < this.d + i) {
                    float[] fArr2 = new float[fArr.length * 2];
                    System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                    this.c = fArr2;
                }
            }
        }

        public void h(w wVar) {
            int i;
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wVar) == null) {
                int i2 = 0;
                for (int i3 = 0; i3 < this.b; i3++) {
                    byte b = this.a[i3];
                    if (b != 0) {
                        if (b != 1) {
                            if (b != 2) {
                                if (b != 3) {
                                    if (b != 8) {
                                        if ((b & 2) != 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if ((b & 1) != 0) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        float[] fArr = this.c;
                                        int i4 = i2 + 1;
                                        float f = fArr[i2];
                                        int i5 = i4 + 1;
                                        float f2 = fArr[i4];
                                        int i6 = i5 + 1;
                                        float f3 = fArr[i5];
                                        int i7 = i6 + 1;
                                        wVar.e(f, f2, f3, z, z2, fArr[i6], fArr[i7]);
                                        i2 = i7 + 1;
                                    } else {
                                        wVar.close();
                                    }
                                } else {
                                    float[] fArr2 = this.c;
                                    int i8 = i2 + 1;
                                    int i9 = i8 + 1;
                                    int i10 = i9 + 1;
                                    wVar.c(fArr2[i2], fArr2[i8], fArr2[i9], fArr2[i10]);
                                    i2 = i10 + 1;
                                }
                            } else {
                                float[] fArr3 = this.c;
                                int i11 = i2 + 1;
                                float f4 = fArr3[i2];
                                int i12 = i11 + 1;
                                float f5 = fArr3[i11];
                                int i13 = i12 + 1;
                                float f6 = fArr3[i12];
                                int i14 = i13 + 1;
                                float f7 = fArr3[i13];
                                int i15 = i14 + 1;
                                float f8 = fArr3[i14];
                                i2 = i15 + 1;
                                wVar.d(f4, f5, f6, f7, f8, fArr3[i15]);
                            }
                        } else {
                            float[] fArr4 = this.c;
                            int i16 = i2 + 1;
                            i = i16 + 1;
                            wVar.b(fArr4[i2], fArr4[i16]);
                        }
                    } else {
                        float[] fArr5 = this.c;
                        int i17 = i2 + 1;
                        i = i17 + 1;
                        wVar.a(fArr5[i2], fArr5[i17]);
                    }
                    i2 = i;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public abstract class w0 extends f0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public w0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.caverock.androidsvg.SVG.f0, com.caverock.androidsvg.SVG.h0
        public void i(l0 l0Var) throws SVGParseException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, l0Var) == null) {
                if (l0Var instanceof v0) {
                    this.i.add(l0Var);
                    return;
                }
                throw new SVGParseException("Text content elements cannot contain " + l0Var + " elements.");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x extends p0 implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Boolean p;
        public Boolean q;
        public Matrix r;
        public o s;
        public o t;
        public o u;
        public o v;
        public String w;

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "pattern" : (String) invokeV.objValue;
        }

        public x() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x0 extends w0 implements v0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String n;
        public o o;
        public z0 p;

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "textPath" : (String) invokeV.objValue;
        }

        public x0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.caverock.androidsvg.SVG.v0
        public z0 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.p;
            }
            return (z0) invokeV.objValue;
        }

        public void o(z0 z0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, z0Var) == null) {
                this.p = z0Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y extends k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float[] o;

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "polyline" : (String) invokeV.objValue;
        }

        public y() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public abstract class y0 extends w0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List n;
        public List o;
        public List p;
        public List q;

        public y0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z extends y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.caverock.androidsvg.SVG.y, com.caverock.androidsvg.SVG.l0
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "polygon" : (String) invokeV.objValue;
        }

        public z() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public SVG() {
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
        this.a = null;
        this.b = 96.0f;
        this.c = new CSSParser.n();
        this.d = new HashMap();
    }

    public static sk9 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return e;
        }
        return (sk9) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.e(CSSParser.Source.RenderOptions);
        }
    }

    public List d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c.c();
        }
        return (List) invokeV.objValue;
    }

    public d0 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return (d0) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return !this.c.d();
        }
        return invokeV.booleanValue;
    }

    public static SVG h(InputStream inputStream) throws SVGParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, inputStream)) == null) {
            return new SVGParser().z(inputStream, f);
        }
        return (SVG) invokeL.objValue;
    }

    public static SVG k(String str) throws SVGParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            return new SVGParser().z(new ByteArrayInputStream(str.getBytes()), f);
        }
        return (SVG) invokeL.objValue;
    }

    public void a(CSSParser.n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nVar) == null) {
            this.c.b(nVar);
        }
    }

    public void r(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, d0Var) == null) {
            this.a = d0Var;
        }
    }

    public static SVG i(Context context, int i2) throws SVGParseException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i2)) == null) {
            return j(context.getResources(), i2);
        }
        return (SVG) invokeLI.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public static SVG j(Resources resources, int i2) throws SVGParseException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, resources, i2)) == null) {
            SVGParser sVGParser = new SVGParser();
            InputStream openRawResource = resources.openRawResource(i2);
            try {
                return sVGParser.z(openRawResource, f);
            } finally {
                try {
                    openRawResource.close();
                } catch (IOException unused) {
                }
            }
        }
        return (SVG) invokeLI.objValue;
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str.startsWith("\"") && str.endsWith("\"")) {
                str = str.substring(1, str.length() - 1).replace("\\\"", "\"");
            } else if (str.startsWith("'") && str.endsWith("'")) {
                str = str.substring(1, str.length() - 1).replace("\\'", "'");
            }
            return str.replace("\\\n", "").replace("\\A", "\n");
        }
        return (String) invokeL.objValue;
    }

    public j0 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str != null && str.length() != 0) {
                if (str.equals(this.a.c)) {
                    return this.a;
                }
                if (this.d.containsKey(str)) {
                    return (j0) this.d.get(str);
                }
                j0 e2 = e(this.a, str);
                this.d.put(str, e2);
                return e2;
            }
            return null;
        }
        return (j0) invokeL.objValue;
    }

    public final j0 e(h0 h0Var, String str) {
        InterceptResult invokeLL;
        j0 e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, h0Var, str)) == null) {
            j0 j0Var = (j0) h0Var;
            if (str.equals(j0Var.c)) {
                return j0Var;
            }
            for (l0 l0Var : h0Var.getChildren()) {
                if (l0Var instanceof j0) {
                    j0 j0Var2 = (j0) l0Var;
                    if (str.equals(j0Var2.c)) {
                        return j0Var2;
                    }
                    if ((l0Var instanceof h0) && (e2 = e((h0) l0Var, str)) != null) {
                        return e2;
                    }
                }
            }
            return null;
        }
        return (j0) invokeLL.objValue;
    }

    public Picture n(int i2, int i3, qk9 qk9Var) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, qk9Var)) == null) {
            Picture picture = new Picture();
            Canvas beginRecording = picture.beginRecording(i2, i3);
            if (qk9Var == null || qk9Var.f == null) {
                if (qk9Var == null) {
                    qk9Var = new qk9();
                } else {
                    qk9Var = new qk9(qk9Var);
                }
                qk9Var.h(0.0f, 0.0f, i2, i3);
            }
            new rk9(beginRecording, this.b).O0(this, qk9Var);
            picture.endRecording();
            return picture;
        }
        return (Picture) invokeIIL.objValue;
    }

    public Picture o(qk9 qk9Var) {
        InterceptResult invokeL;
        b bVar;
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, qk9Var)) == null) {
            if (qk9Var != null && qk9Var.f()) {
                bVar = qk9Var.d;
            } else {
                bVar = this.a.o;
            }
            if (qk9Var != null && qk9Var.g()) {
                return n((int) Math.ceil(qk9Var.f.b()), (int) Math.ceil(qk9Var.f.c()), qk9Var);
            }
            d0 d0Var = this.a;
            o oVar2 = d0Var.r;
            if (oVar2 != null) {
                Unit unit = oVar2.b;
                Unit unit2 = Unit.percent;
                if (unit != unit2 && (oVar = d0Var.s) != null && oVar.b != unit2) {
                    return n((int) Math.ceil(oVar2.b(this.b)), (int) Math.ceil(this.a.s.b(this.b)), qk9Var);
                }
            }
            o oVar3 = this.a.r;
            if (oVar3 != null && bVar != null) {
                float b2 = oVar3.b(this.b);
                return n((int) Math.ceil(b2), (int) Math.ceil((bVar.d * b2) / bVar.c), qk9Var);
            }
            o oVar4 = this.a.s;
            if (oVar4 != null && bVar != null) {
                float b3 = oVar4.b(this.b);
                return n((int) Math.ceil((bVar.c * b3) / bVar.d), (int) Math.ceil(b3), qk9Var);
            }
            return n(512, 512, qk9Var);
        }
        return (Picture) invokeL.objValue;
    }

    public l0 p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (str == null) {
                return null;
            }
            String c2 = c(str);
            if (c2.length() <= 1 || !c2.startsWith("#")) {
                return null;
            }
            return f(c2.substring(1));
        }
        return (l0) invokeL.objValue;
    }
}
