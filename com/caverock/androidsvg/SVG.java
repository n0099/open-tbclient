package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Picture;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.sapi2.SapiOptions;
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
/* loaded from: classes2.dex */
public class SVG {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d0 a;

    /* renamed from: b  reason: collision with root package name */
    public c.c.a.d f55379b;

    /* renamed from: c  reason: collision with root package name */
    public float f55380c;

    /* renamed from: d  reason: collision with root package name */
    public CSSParser.e f55381d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, j0> f55382e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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

        public GradientSpread(String str, int i2) {
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

    /* loaded from: classes2.dex */
    public static class Style implements Cloneable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c A;
        public String B;
        public String C;
        public String D;
        public Boolean E;
        public Boolean F;
        public m0 G;
        public Float H;
        public String I;
        public FillRule J;
        public String K;
        public m0 L;
        public Float M;
        public m0 N;
        public Float O;
        public VectorEffect P;

        /* renamed from: e  reason: collision with root package name */
        public long f55383e;

        /* renamed from: f  reason: collision with root package name */
        public m0 f55384f;

        /* renamed from: g  reason: collision with root package name */
        public FillRule f55385g;

        /* renamed from: h  reason: collision with root package name */
        public Float f55386h;

        /* renamed from: i  reason: collision with root package name */
        public m0 f55387i;

        /* renamed from: j  reason: collision with root package name */
        public Float f55388j;

        /* renamed from: k  reason: collision with root package name */
        public o f55389k;
        public LineCaps l;
        public LineJoin m;
        public Float n;
        public o[] o;
        public o p;
        public Float q;
        public f r;
        public List<String> s;
        public o t;
        public Integer u;
        public FontStyle v;
        public TextDecoration w;
        public TextDirection x;
        public TextAnchor y;
        public Boolean z;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes2.dex */
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

            public FillRule(String str, int i2) {
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
        /* loaded from: classes2.dex */
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

            public FontStyle(String str, int i2) {
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
        /* loaded from: classes2.dex */
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

            public LineCaps(String str, int i2) {
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
        /* loaded from: classes2.dex */
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

            public LineJoin(String str, int i2) {
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
        /* loaded from: classes2.dex */
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

            public TextAnchor(String str, int i2) {
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
        /* loaded from: classes2.dex */
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

            public TextDecoration(String str, int i2) {
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
        /* loaded from: classes2.dex */
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

            public TextDirection(String str, int i2) {
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
        /* loaded from: classes2.dex */
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

            public VectorEffect(String str, int i2) {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55383e = 0L;
        }

        public static Style a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                Style style = new Style();
                style.f55383e = -1L;
                style.f55384f = f.f55400f;
                style.f55385g = FillRule.NonZero;
                Float valueOf = Float.valueOf(1.0f);
                style.f55386h = valueOf;
                style.f55387i = null;
                style.f55388j = valueOf;
                style.f55389k = new o(1.0f);
                style.l = LineCaps.Butt;
                style.m = LineJoin.Miter;
                style.n = Float.valueOf(4.0f);
                style.o = null;
                style.p = new o(0.0f);
                style.q = valueOf;
                style.r = f.f55400f;
                style.s = null;
                style.t = new o(12.0f, Unit.pt);
                style.u = 400;
                style.v = FontStyle.Normal;
                style.w = TextDecoration.None;
                style.x = TextDirection.LTR;
                style.y = TextAnchor.Start;
                Boolean bool = Boolean.TRUE;
                style.z = bool;
                style.A = null;
                style.B = null;
                style.C = null;
                style.D = null;
                style.E = bool;
                style.F = bool;
                style.G = f.f55400f;
                style.H = valueOf;
                style.I = null;
                style.J = FillRule.NonZero;
                style.K = null;
                style.L = null;
                style.M = valueOf;
                style.N = null;
                style.O = valueOf;
                style.P = VectorEffect.None;
                return style;
            }
            return (Style) invokeV.objValue;
        }

        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                Boolean bool = Boolean.TRUE;
                this.E = bool;
                if (!z) {
                    bool = Boolean.FALSE;
                }
                this.z = bool;
                this.A = null;
                this.I = null;
                this.q = Float.valueOf(1.0f);
                this.G = f.f55400f;
                this.H = Float.valueOf(1.0f);
                this.K = null;
                this.L = null;
                this.M = Float.valueOf(1.0f);
                this.N = null;
                this.O = Float.valueOf(1.0f);
                this.P = VectorEffect.None;
            }
        }

        public Object clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                try {
                    Style style = (Style) super.clone();
                    if (this.o != null) {
                        style.o = (o[]) this.o.clone();
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
    /* loaded from: classes2.dex */
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
            ex = new Unit("ex", 2);
            in = new Unit("in", 3);
            cm = new Unit("cm", 4);
            mm = new Unit("mm", 5);
            pt = new Unit("pt", 6);
            pc = new Unit("pc", 7);
            Unit unit = new Unit(SapiOptions.KEY_CACHE_PERCENT, 8);
            percent = unit;
            $VALUES = new Unit[]{px, em, ex, in, cm, mm, pt, pc, unit};
        }

        public Unit(String str, int i2) {
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

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a1 extends l0 implements v0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public String f55390c;

        /* renamed from: d  reason: collision with root package name */
        public z0 f55391d;

        public a1(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55390c = str;
        }

        @Override // com.caverock.androidsvg.SVG.v0
        public z0 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55391d : (z0) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.l0
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return a1.class.getSimpleName() + " '" + this.f55390c + "'";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Cloneable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public float f55392e;

        /* renamed from: f  reason: collision with root package name */
        public float f55393f;

        /* renamed from: g  reason: collision with root package name */
        public float f55394g;

        /* renamed from: h  reason: collision with root package name */
        public float f55395h;

        public b(float f2, float f3, float f4, float f5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55392e = f2;
            this.f55393f = f3;
            this.f55394g = f4;
            this.f55395h = f5;
        }

        public static b a(float f2, float f3, float f4, float f5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) ? new b(f2, f3, f4 - f2, f5 - f3) : (b) invokeCommon.objValue;
        }

        public float b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55392e + this.f55394g : invokeV.floatValue;
        }

        public float c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f55393f + this.f55395h : invokeV.floatValue;
        }

        public void e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
                float f2 = bVar.f55392e;
                if (f2 < this.f55392e) {
                    this.f55392e = f2;
                }
                float f3 = bVar.f55393f;
                if (f3 < this.f55393f) {
                    this.f55393f = f3;
                }
                if (bVar.b() > b()) {
                    this.f55394g = bVar.b() - this.f55392e;
                }
                if (bVar.c() > c()) {
                    this.f55395h = bVar.c() - this.f55393f;
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return PreferencesUtil.LEFT_MOUNT + this.f55392e + " " + this.f55393f + " " + this.f55394g + " " + this.f55395h + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class b0 extends j0 implements h0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b0() {
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

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public o a;

        /* renamed from: b  reason: collision with root package name */
        public o f55396b;

        /* renamed from: c  reason: collision with root package name */
        public o f55397c;

        /* renamed from: d  reason: collision with root package name */
        public o f55398d;

        public c(o oVar, o oVar2, o oVar3, o oVar4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, oVar2, oVar3, oVar4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oVar;
            this.f55396b = oVar2;
            this.f55397c = oVar3;
            this.f55398d = oVar4;
        }
    }

    /* loaded from: classes2.dex */
    public static class c0 extends j0 implements h0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public Float f55399h;

        public c0() {
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

    /* loaded from: classes2.dex */
    public static class c1 extends p0 implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c1() {
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

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends l implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Boolean o;

        public e() {
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

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public static class f extends m0 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: f  reason: collision with root package name */
        public static final f f55400f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f55401e;

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
            f55400f = new f(0);
        }

        public f(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f55401e = i2;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("#%06x", Integer.valueOf(this.f55401e)) : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class f0 extends i0 implements h0, e0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public List<l0> f55402i;

        /* renamed from: j  reason: collision with root package name */
        public Set<String> f55403j;

        /* renamed from: k  reason: collision with root package name */
        public String f55404k;
        public Set<String> l;
        public Set<String> m;

        public f0() {
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
            this.f55402i = new ArrayList();
            this.f55403j = null;
            this.f55404k = null;
            this.l = null;
            this.m = null;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55404k : (String) invokeV.objValue;
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
                this.f55403j = set;
            }
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public List<l0> getChildren() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f55402i : (List) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f55403j : (Set) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public void i(l0 l0Var) throws SAXException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, l0Var) == null) {
                this.f55402i.add(l0Var);
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
                this.f55404k = str;
            }
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.m : (Set) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class g extends m0 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static g f55405e;
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
            f55405e = new g();
        }

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static g a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f55405e : (g) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class g0 extends i0 implements e0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public Set<String> f55406i;

        /* renamed from: j  reason: collision with root package name */
        public String f55407j;

        /* renamed from: k  reason: collision with root package name */
        public Set<String> f55408k;
        public Set<String> l;
        public Set<String> m;

        public g0() {
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
            this.f55406i = null;
            this.f55407j = null;
            this.f55408k = null;
            this.l = null;
            this.m = null;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55407j : (String) invokeV.objValue;
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
                this.f55408k = set;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f55408k : (Set) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void g(Set<String> set) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, set) == null) {
                this.f55406i = set;
            }
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f55406i : (Set) invokeV.objValue;
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
                this.f55407j = str;
            }
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m : (Set) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class h extends l implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
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

    /* loaded from: classes2.dex */
    public interface h0 {
        List<l0> getChildren();

        void i(l0 l0Var) throws SAXException;
    }

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class i0 extends j0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public b f55409h;

        public i0() {
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
            this.f55409h = null;
        }
    }

    /* loaded from: classes2.dex */
    public static class j extends j0 implements h0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public List<l0> f55410h;

        /* renamed from: i  reason: collision with root package name */
        public Boolean f55411i;

        /* renamed from: j  reason: collision with root package name */
        public Matrix f55412j;

        /* renamed from: k  reason: collision with root package name */
        public GradientSpread f55413k;
        public String l;

        public j() {
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
            this.f55410h = new ArrayList();
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public List<l0> getChildren() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55410h : (List) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public void i(l0 l0Var) throws SAXException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l0Var) == null) {
                if (l0Var instanceof c0) {
                    this.f55410h.add(l0Var);
                    return;
                }
                throw new SAXException("Gradient elements cannot contain " + l0Var + " elements.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class j0 extends l0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public String f55414c;

        /* renamed from: d  reason: collision with root package name */
        public Boolean f55415d;

        /* renamed from: e  reason: collision with root package name */
        public Style f55416e;

        /* renamed from: f  reason: collision with root package name */
        public Style f55417f;

        /* renamed from: g  reason: collision with root package name */
        public List<String> f55418g;

        public j0() {
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
            this.f55414c = null;
            this.f55415d = null;
            this.f55416e = null;
            this.f55417f = null;
            this.f55418g = null;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class k extends g0 implements m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Matrix n;

        public k() {
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

        @Override // com.caverock.androidsvg.SVG.m
        public void l(Matrix matrix) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, matrix) == null) {
                this.n = matrix;
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class l extends f0 implements m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Matrix n;

        public l() {
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

        @Override // com.caverock.androidsvg.SVG.m
        public void l(Matrix matrix) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, matrix) == null) {
                this.n = matrix;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class l0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SVG a;

        /* renamed from: b  reason: collision with root package name */
        public h0 f55419b;

        public l0() {
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

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getClass().getSimpleName() : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface m {
        void l(Matrix matrix);
    }

    /* loaded from: classes2.dex */
    public static abstract class m0 implements Cloneable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m0() {
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

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes2.dex */
    public static class n0 extends f0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PreserveAspectRatio n;

        public n0() {
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
            this.n = null;
        }
    }

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class p0 extends n0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b o;

        public p0() {
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

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class q0 extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public q0() {
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

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class r0 extends p0 implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public r0() {
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

    /* loaded from: classes2.dex */
    public interface s {
    }

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes2.dex */
    public static class t extends m0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f55422e;

        /* renamed from: f  reason: collision with root package name */
        public m0 f55423f;

        public t(String str, m0 m0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, m0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55422e = str;
            this.f55423f = m0Var;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.f55422e + " " + this.f55423f;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class t0 extends y0 implements v0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public z0 r;

        public t0() {
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

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class u0 extends y0 implements z0, m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Matrix r;

        public u0() {
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

        @Override // com.caverock.androidsvg.SVG.m
        public void l(Matrix matrix) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, matrix) == null) {
                this.r = matrix;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class v implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] a;

        /* renamed from: b  reason: collision with root package name */
        public int f55424b;

        /* renamed from: c  reason: collision with root package name */
        public float[] f55425c;

        /* renamed from: d  reason: collision with root package name */
        public int f55426d;

        public v() {
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
            this.f55424b = 0;
            this.f55425c = null;
            this.f55426d = 0;
            this.a = new byte[8];
            this.f55425c = new float[16];
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void a(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                f((byte) 0);
                g(2);
                float[] fArr = this.f55425c;
                int i2 = this.f55426d;
                int i3 = i2 + 1;
                this.f55426d = i3;
                fArr[i2] = f2;
                this.f55426d = i3 + 1;
                fArr[i3] = f3;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void b(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                f((byte) 1);
                g(2);
                float[] fArr = this.f55425c;
                int i2 = this.f55426d;
                int i3 = i2 + 1;
                this.f55426d = i3;
                fArr[i2] = f2;
                this.f55426d = i3 + 1;
                fArr[i3] = f3;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void c(float f2, float f3, float f4, float f5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
                f((byte) 3);
                g(4);
                float[] fArr = this.f55425c;
                int i2 = this.f55426d;
                int i3 = i2 + 1;
                this.f55426d = i3;
                fArr[i2] = f2;
                int i4 = i3 + 1;
                this.f55426d = i4;
                fArr[i3] = f3;
                int i5 = i4 + 1;
                this.f55426d = i5;
                fArr[i4] = f4;
                this.f55426d = i5 + 1;
                fArr[i5] = f5;
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
                float[] fArr = this.f55425c;
                int i2 = this.f55426d;
                int i3 = i2 + 1;
                this.f55426d = i3;
                fArr[i2] = f2;
                int i4 = i3 + 1;
                this.f55426d = i4;
                fArr[i3] = f3;
                int i5 = i4 + 1;
                this.f55426d = i5;
                fArr[i4] = f4;
                int i6 = i5 + 1;
                this.f55426d = i6;
                fArr[i5] = f5;
                int i7 = i6 + 1;
                this.f55426d = i7;
                fArr[i6] = f6;
                this.f55426d = i7 + 1;
                fArr[i7] = f7;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void e(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f5), Float.valueOf(f6)}) == null) {
                f((byte) ((z ? 2 : 0) | 4 | (z2 ? 1 : 0)));
                g(5);
                float[] fArr = this.f55425c;
                int i2 = this.f55426d;
                int i3 = i2 + 1;
                this.f55426d = i3;
                fArr[i2] = f2;
                int i4 = i3 + 1;
                this.f55426d = i4;
                fArr[i3] = f3;
                int i5 = i4 + 1;
                this.f55426d = i5;
                fArr[i4] = f4;
                int i6 = i5 + 1;
                this.f55426d = i6;
                fArr[i5] = f5;
                this.f55426d = i6 + 1;
                fArr[i6] = f6;
            }
        }

        public final void f(byte b2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeB(1048582, this, b2) == null) {
                int i2 = this.f55424b;
                byte[] bArr = this.a;
                if (i2 == bArr.length) {
                    byte[] bArr2 = new byte[bArr.length * 2];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.a = bArr2;
                }
                byte[] bArr3 = this.a;
                int i3 = this.f55424b;
                this.f55424b = i3 + 1;
                bArr3[i3] = b2;
            }
        }

        public final void g(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
                float[] fArr = this.f55425c;
                if (fArr.length < this.f55426d + i2) {
                    float[] fArr2 = new float[fArr.length * 2];
                    System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                    this.f55425c = fArr2;
                }
            }
        }

        public void h(w wVar) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wVar) == null) {
                int i3 = 0;
                for (int i4 = 0; i4 < this.f55424b; i4++) {
                    byte b2 = this.a[i4];
                    if (b2 == 0) {
                        float[] fArr = this.f55425c;
                        int i5 = i3 + 1;
                        i2 = i5 + 1;
                        wVar.a(fArr[i3], fArr[i5]);
                    } else if (b2 != 1) {
                        if (b2 == 2) {
                            float[] fArr2 = this.f55425c;
                            int i6 = i3 + 1;
                            float f2 = fArr2[i3];
                            int i7 = i6 + 1;
                            float f3 = fArr2[i6];
                            int i8 = i7 + 1;
                            float f4 = fArr2[i7];
                            int i9 = i8 + 1;
                            float f5 = fArr2[i8];
                            int i10 = i9 + 1;
                            float f6 = fArr2[i9];
                            i3 = i10 + 1;
                            wVar.d(f2, f3, f4, f5, f6, fArr2[i10]);
                        } else if (b2 == 3) {
                            float[] fArr3 = this.f55425c;
                            int i11 = i3 + 1;
                            int i12 = i11 + 1;
                            int i13 = i12 + 1;
                            wVar.c(fArr3[i3], fArr3[i11], fArr3[i12], fArr3[i13]);
                            i3 = i13 + 1;
                        } else if (b2 != 8) {
                            boolean z = (b2 & 2) != 0;
                            boolean z2 = (b2 & 1) != 0;
                            float[] fArr4 = this.f55425c;
                            int i14 = i3 + 1;
                            float f7 = fArr4[i3];
                            int i15 = i14 + 1;
                            float f8 = fArr4[i14];
                            int i16 = i15 + 1;
                            float f9 = fArr4[i15];
                            int i17 = i16 + 1;
                            wVar.e(f7, f8, f9, z, z2, fArr4[i16], fArr4[i17]);
                            i3 = i17 + 1;
                        } else {
                            wVar.close();
                        }
                    } else {
                        float[] fArr5 = this.f55425c;
                        int i18 = i3 + 1;
                        i2 = i18 + 1;
                        wVar.b(fArr5[i3], fArr5[i18]);
                    }
                    i3 = i2;
                }
            }
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f55424b == 0 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface v0 {
        z0 c();
    }

    /* loaded from: classes2.dex */
    public interface w {
        void a(float f2, float f3);

        void b(float f2, float f3);

        void c(float f2, float f3, float f4, float f5);

        void close();

        void d(float f2, float f3, float f4, float f5, float f6, float f7);

        void e(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6);
    }

    /* loaded from: classes2.dex */
    public static class w0 extends f0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public w0() {
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

        @Override // com.caverock.androidsvg.SVG.f0, com.caverock.androidsvg.SVG.h0
        public void i(l0 l0Var) throws SAXException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, l0Var) == null) {
                if (l0Var instanceof v0) {
                    this.f55402i.add(l0Var);
                    return;
                }
                throw new SAXException("Text content elements cannot contain " + l0Var + " elements.");
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes2.dex */
    public static class y extends k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float[] o;

        public y() {
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

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class z extends y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public z() {
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

    /* loaded from: classes2.dex */
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
        this.f55379b = null;
        this.f55380c = 96.0f;
        this.f55381d = new CSSParser.e();
        this.f55382e = new HashMap();
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
            this.f55381d.b(eVar);
        }
    }

    public List<CSSParser.d> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f55381d.c() : (List) invokeV.objValue;
    }

    public final j0 c(h0 h0Var, String str) {
        InterceptResult invokeLL;
        j0 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, h0Var, str)) == null) {
            j0 j0Var = (j0) h0Var;
            if (str.equals(j0Var.f55414c)) {
                return j0Var;
            }
            for (l0 l0Var : h0Var.getChildren()) {
                if (l0Var instanceof j0) {
                    j0 j0Var2 = (j0) l0Var;
                    if (str.equals(j0Var2.f55414c)) {
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
            if (str.equals(this.a.f55414c)) {
                return this.a;
            }
            if (this.f55382e.containsKey(str)) {
                return this.f55382e.get(str);
            }
            j0 c2 = c(this.a, str);
            this.f55382e.put(str, c2);
            return c2;
        }
        return (l0) invokeL.objValue;
    }

    public c.c.a.d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f55379b : (c.c.a.d) invokeV.objValue;
    }

    public d0 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (d0) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !this.f55381d.d() : invokeV.booleanValue;
    }

    public Picture l() {
        InterceptResult invokeV;
        float b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            o oVar = this.a.r;
            if (oVar != null) {
                float b3 = oVar.b(this.f55380c);
                d0 d0Var = this.a;
                b bVar = d0Var.o;
                if (bVar != null) {
                    b2 = (bVar.f55395h * b3) / bVar.f55394g;
                } else {
                    o oVar2 = d0Var.s;
                    b2 = oVar2 != null ? oVar2.b(this.f55380c) : b3;
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
            new c.c.a.c(picture.beginRecording(i2, i3), new b(0.0f, 0.0f, i2, i3), this.f55380c).G0(this, null, null, false);
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

    /* loaded from: classes2.dex */
    public static class o implements Cloneable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public float f55420e;

        /* renamed from: f  reason: collision with root package name */
        public Unit f55421f;

        public o(float f2, Unit unit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f2), unit};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f55420e = 0.0f;
            this.f55421f = Unit.px;
            this.f55420e = f2;
            this.f55421f = unit;
        }

        public float a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55420e : invokeV.floatValue;
        }

        public float b(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) {
                int i2 = a.a[this.f55421f.ordinal()];
                if (i2 != 1) {
                    switch (i2) {
                        case 4:
                            return this.f55420e * f2;
                        case 5:
                            return (this.f55420e * f2) / 2.54f;
                        case 6:
                            return (this.f55420e * f2) / 25.4f;
                        case 7:
                            return (this.f55420e * f2) / 72.0f;
                        case 8:
                            return (this.f55420e * f2) / 6.0f;
                        default:
                            return this.f55420e;
                    }
                }
                return this.f55420e;
            }
            return invokeF.floatValue;
        }

        public float c(c.c.a.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
                if (this.f55421f == Unit.percent) {
                    b W = cVar.W();
                    if (W == null) {
                        return this.f55420e;
                    }
                    float f2 = W.f55394g;
                    float f3 = W.f55395h;
                    if (f2 == f3) {
                        return (this.f55420e * f2) / 100.0f;
                    }
                    return (this.f55420e * ((float) (Math.sqrt((f2 * f2) + (f3 * f3)) / 1.414213562373095d))) / 100.0f;
                }
                return f(cVar);
            }
            return invokeL.floatValue;
        }

        public float e(c.c.a.c cVar, float f2) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLF = interceptable.invokeLF(1048579, this, cVar, f2)) == null) {
                if (this.f55421f == Unit.percent) {
                    return (this.f55420e * f2) / 100.0f;
                }
                return f(cVar);
            }
            return invokeLF.floatValue;
        }

        public float f(c.c.a.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) {
                switch (a.a[this.f55421f.ordinal()]) {
                    case 1:
                        return this.f55420e;
                    case 2:
                        return this.f55420e * cVar.U();
                    case 3:
                        return this.f55420e * cVar.V();
                    case 4:
                        return this.f55420e * cVar.X();
                    case 5:
                        return (this.f55420e * cVar.X()) / 2.54f;
                    case 6:
                        return (this.f55420e * cVar.X()) / 25.4f;
                    case 7:
                        return (this.f55420e * cVar.X()) / 72.0f;
                    case 8:
                        return (this.f55420e * cVar.X()) / 6.0f;
                    case 9:
                        b W = cVar.W();
                        if (W == null) {
                            return this.f55420e;
                        }
                        return (this.f55420e * W.f55394g) / 100.0f;
                    default:
                        return this.f55420e;
                }
            }
            return invokeL.floatValue;
        }

        public float g(c.c.a.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
                if (this.f55421f == Unit.percent) {
                    b W = cVar.W();
                    if (W == null) {
                        return this.f55420e;
                    }
                    return (this.f55420e * W.f55395h) / 100.0f;
                }
                return f(cVar);
            }
            return invokeL.floatValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f55420e < 0.0f : invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f55420e == 0.0f : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return String.valueOf(this.f55420e) + this.f55421f;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55420e = 0.0f;
            Unit unit = Unit.px;
            this.f55421f = unit;
            this.f55420e = f2;
            this.f55421f = unit;
        }
    }
}
