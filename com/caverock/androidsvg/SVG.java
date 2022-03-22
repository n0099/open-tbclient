package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Picture;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.caverock.androidsvg.CSSParser;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.xml.sax.SAXException;
/* loaded from: classes6.dex */
public class SVG {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d0 a;

    /* renamed from: b  reason: collision with root package name */
    public c.c.a.d f38322b;

    /* renamed from: c  reason: collision with root package name */
    public float f38323c;

    /* renamed from: d  reason: collision with root package name */
    public CSSParser.e f38324d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, j0> f38325e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class GradientSpread {
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (GradientSpread) Enum.valueOf(GradientSpread.class, str) : (GradientSpread) invokeL.objValue;
        }

        public static GradientSpread[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (GradientSpread[]) $VALUES.clone() : (GradientSpread[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class Style implements Cloneable {
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
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public m0 f38326b;

        /* renamed from: c  reason: collision with root package name */
        public FillRule f38327c;

        /* renamed from: d  reason: collision with root package name */
        public Float f38328d;

        /* renamed from: e  reason: collision with root package name */
        public m0 f38329e;

        /* renamed from: f  reason: collision with root package name */
        public Float f38330f;

        /* renamed from: g  reason: collision with root package name */
        public o f38331g;

        /* renamed from: h  reason: collision with root package name */
        public LineCaps f38332h;
        public LineJoin i;
        public Float j;
        public o[] k;
        public o l;
        public Float m;
        public f n;
        public List<String> o;
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
        /* loaded from: classes6.dex */
        public static final class FillRule {
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
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (FillRule) Enum.valueOf(FillRule.class, str) : (FillRule) invokeL.objValue;
            }

            public static FillRule[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (FillRule[]) $VALUES.clone() : (FillRule[]) invokeV.objValue;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes6.dex */
        public static final class FontStyle {
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
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (FontStyle) Enum.valueOf(FontStyle.class, str) : (FontStyle) invokeL.objValue;
            }

            public static FontStyle[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (FontStyle[]) $VALUES.clone() : (FontStyle[]) invokeV.objValue;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes6.dex */
        public static final class LineCaps {
            public static final /* synthetic */ LineCaps[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final LineCaps Butt;
            public static final LineCaps Round;
            public static final LineCaps Square;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1103212412, "Lcom/caverock/androidsvg/SVG$Style$LineCaps;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1103212412, "Lcom/caverock/androidsvg/SVG$Style$LineCaps;");
                        return;
                    }
                }
                Butt = new LineCaps("Butt", 0);
                Round = new LineCaps("Round", 1);
                LineCaps lineCaps = new LineCaps("Square", 2);
                Square = lineCaps;
                $VALUES = new LineCaps[]{Butt, Round, lineCaps};
            }

            public LineCaps(String str, int i) {
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

            public static LineCaps valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LineCaps) Enum.valueOf(LineCaps.class, str) : (LineCaps) invokeL.objValue;
            }

            public static LineCaps[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LineCaps[]) $VALUES.clone() : (LineCaps[]) invokeV.objValue;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes6.dex */
        public static final class LineJoin {
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
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LineJoin) Enum.valueOf(LineJoin.class, str) : (LineJoin) invokeL.objValue;
            }

            public static LineJoin[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LineJoin[]) $VALUES.clone() : (LineJoin[]) invokeV.objValue;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes6.dex */
        public static final class TextAnchor {
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
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TextAnchor) Enum.valueOf(TextAnchor.class, str) : (TextAnchor) invokeL.objValue;
            }

            public static TextAnchor[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TextAnchor[]) $VALUES.clone() : (TextAnchor[]) invokeV.objValue;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes6.dex */
        public static final class TextDecoration {
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
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TextDecoration) Enum.valueOf(TextDecoration.class, str) : (TextDecoration) invokeL.objValue;
            }

            public static TextDecoration[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TextDecoration[]) $VALUES.clone() : (TextDecoration[]) invokeV.objValue;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes6.dex */
        public static final class TextDirection {
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
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TextDirection) Enum.valueOf(TextDirection.class, str) : (TextDirection) invokeL.objValue;
            }

            public static TextDirection[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TextDirection[]) $VALUES.clone() : (TextDirection[]) invokeV.objValue;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes6.dex */
        public static final class VectorEffect {
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
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (VectorEffect) Enum.valueOf(VectorEffect.class, str) : (VectorEffect) invokeL.objValue;
            }

            public static VectorEffect[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (VectorEffect[]) $VALUES.clone() : (VectorEffect[]) invokeV.objValue;
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

        public static Style a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                Style style = new Style();
                style.a = -1L;
                style.f38326b = f.f38342b;
                style.f38327c = FillRule.NonZero;
                Float valueOf = Float.valueOf(1.0f);
                style.f38328d = valueOf;
                style.f38329e = null;
                style.f38330f = valueOf;
                style.f38331g = new o(1.0f);
                style.f38332h = LineCaps.Butt;
                style.i = LineJoin.Miter;
                style.j = Float.valueOf(4.0f);
                style.k = null;
                style.l = new o(0.0f);
                style.m = valueOf;
                style.n = f.f38342b;
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
                style.C = f.f38342b;
                style.D = valueOf;
                style.E = null;
                style.F = FillRule.NonZero;
                style.G = null;
                style.H = null;
                style.I = valueOf;
                style.J = null;
                style.K = valueOf;
                style.L = VectorEffect.None;
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
                this.C = f.f38342b;
                this.D = Float.valueOf(1.0f);
                this.G = null;
                this.H = null;
                this.I = Float.valueOf(1.0f);
                this.J = null;
                this.K = Float.valueOf(1.0f);
                this.L = VectorEffect.None;
            }
        }

        public Object clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                try {
                    Style style = (Style) super.clone();
                    if (this.k != null) {
                        style.k = (o[]) this.k.clone();
                    }
                    return style;
                } catch (CloneNotSupportedException e2) {
                    throw new InternalError(e2.toString());
                }
            }
            return invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class Unit {
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
            cm = new Unit("cm", 4);
            mm = new Unit("mm", 5);
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Unit) Enum.valueOf(Unit.class, str) : (Unit) invokeL.objValue;
        }

        public static Unit[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Unit[]) $VALUES.clone() : (Unit[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
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

    /* loaded from: classes6.dex */
    public static class a0 extends k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public o o;
        public o p;
        public o q;
        public o r;
        public o s;
        public o t;

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

    /* loaded from: classes6.dex */
    public static class a1 extends l0 implements v0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public String f38333c;

        /* renamed from: d  reason: collision with root package name */
        public z0 f38334d;

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
            this.f38333c = str;
        }

        @Override // com.caverock.androidsvg.SVG.v0
        public z0 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38334d : (z0) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.l0
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return a1.class.getSimpleName() + " '" + this.f38333c + "'";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Cloneable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public float f38335b;

        /* renamed from: c  reason: collision with root package name */
        public float f38336c;

        /* renamed from: d  reason: collision with root package name */
        public float f38337d;

        public b(float f2, float f3, float f4, float f5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f2;
            this.f38335b = f3;
            this.f38336c = f4;
            this.f38337d = f5;
        }

        public static b a(float f2, float f3, float f4, float f5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) ? new b(f2, f3, f4 - f2, f5 - f3) : (b) invokeCommon.objValue;
        }

        public float b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a + this.f38336c : invokeV.floatValue;
        }

        public float c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38335b + this.f38337d : invokeV.floatValue;
        }

        public void d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
                float f2 = bVar.a;
                if (f2 < this.a) {
                    this.a = f2;
                }
                float f3 = bVar.f38335b;
                if (f3 < this.f38335b) {
                    this.f38335b = f3;
                }
                if (bVar.b() > b()) {
                    this.f38336c = bVar.b() - this.a;
                }
                if (bVar.c() > c()) {
                    this.f38337d = bVar.c() - this.f38335b;
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return PreferencesUtil.LEFT_MOUNT + this.a + " " + this.f38335b + " " + this.f38336c + " " + this.f38337d + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b0 extends j0 implements h0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
        public List<l0> getChildren() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Collections.emptyList() : (List) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public void i(l0 l0Var) throws SAXException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l0Var) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b1 extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String o;
        public o p;
        public o q;
        public o r;
        public o s;

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

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public o a;

        /* renamed from: b  reason: collision with root package name */
        public o f38338b;

        /* renamed from: c  reason: collision with root package name */
        public o f38339c;

        /* renamed from: d  reason: collision with root package name */
        public o f38340d;

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
            this.f38338b = oVar2;
            this.f38339c = oVar3;
            this.f38340d = oVar4;
        }
    }

    /* loaded from: classes6.dex */
    public static class c0 extends j0 implements h0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public Float f38341h;

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
        public List<l0> getChildren() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Collections.emptyList() : (List) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public void i(l0 l0Var) throws SAXException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l0Var) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c1 extends p0 implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

    /* loaded from: classes6.dex */
    public static class d extends k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public o o;
        public o p;
        public o q;

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

    /* loaded from: classes6.dex */
    public static class d0 extends p0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public o p;
        public o q;
        public o r;
        public o s;
        public String t;

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

    /* loaded from: classes6.dex */
    public static class e extends l implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Boolean o;

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

    /* loaded from: classes6.dex */
    public interface e0 {
        String a();

        void b(Set<String> set);

        void d(Set<String> set);

        Set<String> e();

        Set<String> f();

        void g(Set<String> set);

        Set<String> h();

        void j(Set<String> set);

        void k(String str);

        Set<String> m();
    }

    /* loaded from: classes6.dex */
    public static class f extends m0 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final f f38342b;
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
            f38342b = new f(0);
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

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("#%06x", Integer.valueOf(this.a)) : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f0 extends i0 implements h0, e0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<l0> i;
        public Set<String> j;
        public String k;
        public Set<String> l;
        public Set<String> m;

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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (String) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void b(Set<String> set) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set) == null) {
                this.m = set;
            }
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void d(Set<String> set) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, set) == null) {
            }
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : (Set) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (Set) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void g(Set<String> set) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, set) == null) {
                this.j = set;
            }
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public List<l0> getChildren() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : (List) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : (Set) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public void i(l0 l0Var) throws SAXException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, l0Var) == null) {
                this.i.add(l0Var);
            }
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void j(Set<String> set) {
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

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.m : (Set) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends m0 {
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a : (g) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class g0 extends i0 implements e0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Set<String> i;
        public String j;
        public Set<String> k;
        public Set<String> l;
        public Set<String> m;

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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (String) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void b(Set<String> set) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set) == null) {
                this.m = set;
            }
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void d(Set<String> set) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, set) == null) {
                this.k = set;
            }
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : (Set) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (Set) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void g(Set<String> set) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, set) == null) {
                this.i = set;
            }
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : (Set) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void j(Set<String> set) {
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

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m : (Set) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class h extends l implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

    /* loaded from: classes6.dex */
    public interface h0 {
        List<l0> getChildren();

        void i(l0 l0Var) throws SAXException;
    }

    /* loaded from: classes6.dex */
    public static class i extends k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public o o;
        public o p;
        public o q;
        public o r;

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

    /* loaded from: classes6.dex */
    public static class i0 extends j0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public b f38343h;

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
            this.f38343h = null;
        }
    }

    /* loaded from: classes6.dex */
    public static class j extends j0 implements h0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public List<l0> f38344h;
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
            this.f38344h = new ArrayList();
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public List<l0> getChildren() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38344h : (List) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public void i(l0 l0Var) throws SAXException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l0Var) == null) {
                if (l0Var instanceof c0) {
                    this.f38344h.add(l0Var);
                    return;
                }
                throw new SAXException("Gradient elements cannot contain " + l0Var + " elements.");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class j0 extends l0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public String f38345c;

        /* renamed from: d  reason: collision with root package name */
        public Boolean f38346d;

        /* renamed from: e  reason: collision with root package name */
        public Style f38347e;

        /* renamed from: f  reason: collision with root package name */
        public Style f38348f;

        /* renamed from: g  reason: collision with root package name */
        public List<String> f38349g;

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
            this.f38345c = null;
            this.f38346d = null;
            this.f38347e = null;
            this.f38348f = null;
            this.f38349g = null;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class k extends g0 implements m {
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

    /* loaded from: classes6.dex */
    public static class k0 extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public o m;
        public o n;
        public o o;
        public o p;

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

    /* loaded from: classes6.dex */
    public static class l extends f0 implements m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Matrix n;

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

    /* loaded from: classes6.dex */
    public static class l0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SVG a;

        /* renamed from: b  reason: collision with root package name */
        public h0 f38350b;

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

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getClass().getSimpleName() : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface m {
        void l(Matrix matrix);
    }

    /* loaded from: classes6.dex */
    public static abstract class m0 implements Cloneable {
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

    /* loaded from: classes6.dex */
    public static class n extends n0 implements m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String o;
        public o p;
        public o q;
        public o r;
        public o s;
        public Matrix t;

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

    /* loaded from: classes6.dex */
    public static class n0 extends f0 {
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

    /* loaded from: classes6.dex */
    public static class o0 extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public o m;
        public o n;
        public o o;
        public o p;
        public o q;

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

    /* loaded from: classes6.dex */
    public static class p extends k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public o o;
        public o p;
        public o q;
        public o r;

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

    /* loaded from: classes6.dex */
    public static class p0 extends n0 {
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

    /* loaded from: classes6.dex */
    public static class q extends p0 implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean p;
        public o q;
        public o r;
        public o s;
        public o t;
        public Float u;

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

    /* loaded from: classes6.dex */
    public static class q0 extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

    /* loaded from: classes6.dex */
    public static class r extends f0 implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Boolean n;
        public Boolean o;
        public o p;
        public o q;
        public o r;
        public o s;

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

    /* loaded from: classes6.dex */
    public static class r0 extends p0 implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

    /* loaded from: classes6.dex */
    public interface s {
    }

    /* loaded from: classes6.dex */
    public static class s0 extends w0 implements v0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String n;
        public z0 o;

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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o : (z0) invokeV.objValue;
        }

        public void n(z0 z0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z0Var) == null) {
                this.o = z0Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class t extends m0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public m0 f38352b;

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
            this.f38352b = m0Var;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a + " " + this.f38352b;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class t0 extends y0 implements v0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public z0 r;

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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.r : (z0) invokeV.objValue;
        }

        public void n(z0 z0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z0Var) == null) {
                this.r = z0Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class u extends k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public v o;
        public Float p;

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

    /* loaded from: classes6.dex */
    public static class u0 extends y0 implements z0, m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Matrix r;

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

    /* loaded from: classes6.dex */
    public static class v implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] a;

        /* renamed from: b  reason: collision with root package name */
        public int f38353b;

        /* renamed from: c  reason: collision with root package name */
        public float[] f38354c;

        /* renamed from: d  reason: collision with root package name */
        public int f38355d;

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
            this.a = null;
            this.f38353b = 0;
            this.f38354c = null;
            this.f38355d = 0;
            this.a = new byte[8];
            this.f38354c = new float[16];
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void a(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                f((byte) 0);
                g(2);
                float[] fArr = this.f38354c;
                int i = this.f38355d;
                int i2 = i + 1;
                this.f38355d = i2;
                fArr[i] = f2;
                this.f38355d = i2 + 1;
                fArr[i2] = f3;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void b(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                f((byte) 1);
                g(2);
                float[] fArr = this.f38354c;
                int i = this.f38355d;
                int i2 = i + 1;
                this.f38355d = i2;
                fArr[i] = f2;
                this.f38355d = i2 + 1;
                fArr[i2] = f3;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void c(float f2, float f3, float f4, float f5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
                f((byte) 3);
                g(4);
                float[] fArr = this.f38354c;
                int i = this.f38355d;
                int i2 = i + 1;
                this.f38355d = i2;
                fArr[i] = f2;
                int i3 = i2 + 1;
                this.f38355d = i3;
                fArr[i2] = f3;
                int i4 = i3 + 1;
                this.f38355d = i4;
                fArr[i3] = f4;
                this.f38355d = i4 + 1;
                fArr[i4] = f5;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                f((byte) 8);
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void d(float f2, float f3, float f4, float f5, float f6, float f7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)}) == null) {
                f((byte) 2);
                g(6);
                float[] fArr = this.f38354c;
                int i = this.f38355d;
                int i2 = i + 1;
                this.f38355d = i2;
                fArr[i] = f2;
                int i3 = i2 + 1;
                this.f38355d = i3;
                fArr[i2] = f3;
                int i4 = i3 + 1;
                this.f38355d = i4;
                fArr[i3] = f4;
                int i5 = i4 + 1;
                this.f38355d = i5;
                fArr[i4] = f5;
                int i6 = i5 + 1;
                this.f38355d = i6;
                fArr[i5] = f6;
                this.f38355d = i6 + 1;
                fArr[i6] = f7;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void e(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f5), Float.valueOf(f6)}) == null) {
                f((byte) ((z ? 2 : 0) | 4 | (z2 ? 1 : 0)));
                g(5);
                float[] fArr = this.f38354c;
                int i = this.f38355d;
                int i2 = i + 1;
                this.f38355d = i2;
                fArr[i] = f2;
                int i3 = i2 + 1;
                this.f38355d = i3;
                fArr[i2] = f3;
                int i4 = i3 + 1;
                this.f38355d = i4;
                fArr[i3] = f4;
                int i5 = i4 + 1;
                this.f38355d = i5;
                fArr[i4] = f5;
                this.f38355d = i5 + 1;
                fArr[i5] = f6;
            }
        }

        public final void f(byte b2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeB(1048582, this, b2) == null) {
                int i = this.f38353b;
                byte[] bArr = this.a;
                if (i == bArr.length) {
                    byte[] bArr2 = new byte[bArr.length * 2];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.a = bArr2;
                }
                byte[] bArr3 = this.a;
                int i2 = this.f38353b;
                this.f38353b = i2 + 1;
                bArr3[i2] = b2;
            }
        }

        public final void g(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
                float[] fArr = this.f38354c;
                if (fArr.length < this.f38355d + i) {
                    float[] fArr2 = new float[fArr.length * 2];
                    System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                    this.f38354c = fArr2;
                }
            }
        }

        public void h(w wVar) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wVar) == null) {
                int i2 = 0;
                for (int i3 = 0; i3 < this.f38353b; i3++) {
                    byte b2 = this.a[i3];
                    if (b2 == 0) {
                        float[] fArr = this.f38354c;
                        int i4 = i2 + 1;
                        i = i4 + 1;
                        wVar.a(fArr[i2], fArr[i4]);
                    } else if (b2 != 1) {
                        if (b2 == 2) {
                            float[] fArr2 = this.f38354c;
                            int i5 = i2 + 1;
                            float f2 = fArr2[i2];
                            int i6 = i5 + 1;
                            float f3 = fArr2[i5];
                            int i7 = i6 + 1;
                            float f4 = fArr2[i6];
                            int i8 = i7 + 1;
                            float f5 = fArr2[i7];
                            int i9 = i8 + 1;
                            float f6 = fArr2[i8];
                            i2 = i9 + 1;
                            wVar.d(f2, f3, f4, f5, f6, fArr2[i9]);
                        } else if (b2 == 3) {
                            float[] fArr3 = this.f38354c;
                            int i10 = i2 + 1;
                            int i11 = i10 + 1;
                            int i12 = i11 + 1;
                            wVar.c(fArr3[i2], fArr3[i10], fArr3[i11], fArr3[i12]);
                            i2 = i12 + 1;
                        } else if (b2 != 8) {
                            boolean z = (b2 & 2) != 0;
                            boolean z2 = (b2 & 1) != 0;
                            float[] fArr4 = this.f38354c;
                            int i13 = i2 + 1;
                            float f7 = fArr4[i2];
                            int i14 = i13 + 1;
                            float f8 = fArr4[i13];
                            int i15 = i14 + 1;
                            float f9 = fArr4[i14];
                            int i16 = i15 + 1;
                            wVar.e(f7, f8, f9, z, z2, fArr4[i15], fArr4[i16]);
                            i2 = i16 + 1;
                        } else {
                            wVar.close();
                        }
                    } else {
                        float[] fArr5 = this.f38354c;
                        int i17 = i2 + 1;
                        i = i17 + 1;
                        wVar.b(fArr5[i2], fArr5[i17]);
                    }
                    i2 = i;
                }
            }
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f38353b == 0 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface v0 {
        z0 c();
    }

    /* loaded from: classes6.dex */
    public interface w {
        void a(float f2, float f3);

        void b(float f2, float f3);

        void c(float f2, float f3, float f4, float f5);

        void close();

        void d(float f2, float f3, float f4, float f5, float f6, float f7);

        void e(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6);
    }

    /* loaded from: classes6.dex */
    public static class w0 extends f0 {
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
        public void i(l0 l0Var) throws SAXException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, l0Var) == null) {
                if (l0Var instanceof v0) {
                    this.i.add(l0Var);
                    return;
                }
                throw new SAXException("Text content elements cannot contain " + l0Var + " elements.");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class x extends p0 implements s {
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

    /* loaded from: classes6.dex */
    public static class x0 extends w0 implements v0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String n;
        public o o;
        public z0 p;

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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.p : (z0) invokeV.objValue;
        }

        public void n(z0 z0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z0Var) == null) {
                this.p = z0Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class y extends k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float[] o;

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

    /* loaded from: classes6.dex */
    public static class y0 extends w0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<o> n;
        public List<o> o;
        public List<o> p;
        public List<o> q;

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

    /* loaded from: classes6.dex */
    public static class z extends y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

    /* loaded from: classes6.dex */
    public interface z0 {
    }

    public SVG() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f38322b = null;
        this.f38323c = 96.0f;
        this.f38324d = new CSSParser.e();
        this.f38325e = new HashMap();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public static SVG f(AssetManager assetManager, String str) throws SVGParseException, IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, assetManager, str)) == null) {
            SVGParser sVGParser = new SVGParser();
            InputStream open = assetManager.open(str);
            try {
                return sVGParser.n(open);
            } finally {
                try {
                    open.close();
                } catch (IOException unused) {
                }
            }
        }
        return (SVG) invokeLL.objValue;
    }

    public static SVG g(InputStream inputStream) throws SVGParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, inputStream)) == null) ? new SVGParser().n(inputStream) : (SVG) invokeL.objValue;
    }

    public static SVG h(Context context, int i2) throws SVGParseException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, context, i2)) == null) ? i(context.getResources(), i2) : (SVG) invokeLI.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public static SVG i(Resources resources, int i2) throws SVGParseException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, resources, i2)) == null) {
            SVGParser sVGParser = new SVGParser();
            InputStream openRawResource = resources.openRawResource(i2);
            try {
                return sVGParser.n(openRawResource);
            } finally {
                try {
                    openRawResource.close();
                } catch (IOException unused) {
                }
            }
        }
        return (SVG) invokeLI.objValue;
    }

    public void a(CSSParser.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.f38324d.b(eVar);
        }
    }

    public List<CSSParser.d> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38324d.c() : (List) invokeV.objValue;
    }

    public final j0 c(h0 h0Var, String str) {
        InterceptResult invokeLL;
        j0 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, h0Var, str)) == null) {
            j0 j0Var = (j0) h0Var;
            if (str.equals(j0Var.f38345c)) {
                return j0Var;
            }
            for (l0 l0Var : h0Var.getChildren()) {
                if (l0Var instanceof j0) {
                    j0 j0Var2 = (j0) l0Var;
                    if (str.equals(j0Var2.f38345c)) {
                        return j0Var2;
                    }
                    if ((l0Var instanceof h0) && (c2 = c((h0) l0Var, str)) != null) {
                        return c2;
                    }
                }
            }
            return null;
        }
        return (j0) invokeLL.objValue;
    }

    public l0 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str == null || str.length() == 0) {
                return null;
            }
            if (str.equals(this.a.f38345c)) {
                return this.a;
            }
            if (this.f38325e.containsKey(str)) {
                return this.f38325e.get(str);
            }
            j0 c2 = c(this.a, str);
            this.f38325e.put(str, c2);
            return c2;
        }
        return (l0) invokeL.objValue;
    }

    public c.c.a.d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f38322b : (c.c.a.d) invokeV.objValue;
    }

    public d0 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (d0) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !this.f38324d.d() : invokeV.booleanValue;
    }

    public Picture l() {
        InterceptResult invokeV;
        float b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            o oVar = this.a.r;
            if (oVar != null) {
                float b3 = oVar.b(this.f38323c);
                d0 d0Var = this.a;
                b bVar = d0Var.o;
                if (bVar != null) {
                    b2 = (bVar.f38337d * b3) / bVar.f38336c;
                } else {
                    o oVar2 = d0Var.s;
                    b2 = oVar2 != null ? oVar2.b(this.f38323c) : b3;
                }
                return m((int) Math.ceil(b3), (int) Math.ceil(b2));
            }
            return m(512, 512);
        }
        return (Picture) invokeV.objValue;
    }

    public Picture m(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3)) == null) {
            Picture picture = new Picture();
            new c.c.a.c(picture.beginRecording(i2, i3), new b(0.0f, 0.0f, i2, i3), this.f38323c).G0(this, null, null, false);
            picture.endRecording();
            return picture;
        }
        return (Picture) invokeII.objValue;
    }

    public l0 n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (str != null && str.length() > 1 && str.startsWith("#")) {
                return d(str.substring(1));
            }
            return null;
        }
        return (l0) invokeL.objValue;
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
        }
    }

    public void p(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, d0Var) == null) {
            this.a = d0Var;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class o implements Cloneable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public Unit f38351b;

        public o(float f2, Unit unit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f2), unit};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = 0.0f;
            this.f38351b = Unit.px;
            this.a = f2;
            this.f38351b = unit;
        }

        public float a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.floatValue;
        }

        public float b(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) {
                int i = a.a[this.f38351b.ordinal()];
                if (i != 1) {
                    switch (i) {
                        case 4:
                            return this.a * f2;
                        case 5:
                            return (this.a * f2) / 2.54f;
                        case 6:
                            return (this.a * f2) / 25.4f;
                        case 7:
                            return (this.a * f2) / 72.0f;
                        case 8:
                            return (this.a * f2) / 6.0f;
                        default:
                            return this.a;
                    }
                }
                return this.a;
            }
            return invokeF.floatValue;
        }

        public float c(c.c.a.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
                if (this.f38351b == Unit.percent) {
                    b W = cVar.W();
                    if (W == null) {
                        return this.a;
                    }
                    float f2 = W.f38336c;
                    float f3 = W.f38337d;
                    if (f2 == f3) {
                        return (this.a * f2) / 100.0f;
                    }
                    return (this.a * ((float) (Math.sqrt((f2 * f2) + (f3 * f3)) / 1.414213562373095d))) / 100.0f;
                }
                return e(cVar);
            }
            return invokeL.floatValue;
        }

        public float d(c.c.a.c cVar, float f2) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLF = interceptable.invokeLF(1048579, this, cVar, f2)) == null) {
                if (this.f38351b == Unit.percent) {
                    return (this.a * f2) / 100.0f;
                }
                return e(cVar);
            }
            return invokeLF.floatValue;
        }

        public float e(c.c.a.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) {
                switch (a.a[this.f38351b.ordinal()]) {
                    case 1:
                        return this.a;
                    case 2:
                        return this.a * cVar.U();
                    case 3:
                        return this.a * cVar.V();
                    case 4:
                        return this.a * cVar.X();
                    case 5:
                        return (this.a * cVar.X()) / 2.54f;
                    case 6:
                        return (this.a * cVar.X()) / 25.4f;
                    case 7:
                        return (this.a * cVar.X()) / 72.0f;
                    case 8:
                        return (this.a * cVar.X()) / 6.0f;
                    case 9:
                        b W = cVar.W();
                        if (W == null) {
                            return this.a;
                        }
                        return (this.a * W.f38336c) / 100.0f;
                    default:
                        return this.a;
                }
            }
            return invokeL.floatValue;
        }

        public float f(c.c.a.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
                if (this.f38351b == Unit.percent) {
                    b W = cVar.W();
                    if (W == null) {
                        return this.a;
                    }
                    return (this.a * W.f38337d) / 100.0f;
                }
                return e(cVar);
            }
            return invokeL.floatValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a < 0.0f : invokeV.booleanValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a == 0.0f : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return String.valueOf(this.a) + this.f38351b;
            }
            return (String) invokeV.objValue;
        }

        public o(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0.0f;
            Unit unit = Unit.px;
            this.f38351b = unit;
            this.a = f2;
            this.f38351b = unit;
        }
    }
}
