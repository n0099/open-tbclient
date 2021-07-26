package d.c.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import android.util.Log;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.core.graphics.TypefaceCompatApi28Impl;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static HashSet<String> l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Canvas f69508a;

    /* renamed from: b  reason: collision with root package name */
    public SVG.b f69509b;

    /* renamed from: c  reason: collision with root package name */
    public float f69510c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f69511d;

    /* renamed from: e  reason: collision with root package name */
    public SVG f69512e;

    /* renamed from: f  reason: collision with root package name */
    public h f69513f;

    /* renamed from: g  reason: collision with root package name */
    public Stack<h> f69514g;

    /* renamed from: h  reason: collision with root package name */
    public Stack<SVG.h0> f69515h;

    /* renamed from: i  reason: collision with root package name */
    public Stack<Matrix> f69516i;
    public Stack<Canvas> j;
    public Stack<Bitmap> k;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f69517a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f69518b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f69519c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ int[] f69520d;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1674106508, "Ld/c/a/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1674106508, "Ld/c/a/c$a;");
                    return;
                }
            }
            int[] iArr = new int[SVG.Style.FillRule.values().length];
            f69520d = iArr;
            try {
                iArr[SVG.Style.FillRule.EvenOdd.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f69520d[SVG.Style.FillRule.NonZero.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[SVG.Style.LineJoin.values().length];
            f69519c = iArr2;
            try {
                iArr2[SVG.Style.LineJoin.Miter.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f69519c[SVG.Style.LineJoin.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f69519c[SVG.Style.LineJoin.Bevel.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[SVG.Style.LineCaps.values().length];
            f69518b = iArr3;
            try {
                iArr3[SVG.Style.LineCaps.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f69518b[SVG.Style.LineCaps.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f69518b[SVG.Style.LineCaps.Square.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr4 = new int[PreserveAspectRatio.Alignment.values().length];
            f69517a = iArr4;
            try {
                iArr4[PreserveAspectRatio.Alignment.XMidYMin.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f69517a[PreserveAspectRatio.Alignment.XMidYMid.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f69517a[PreserveAspectRatio.Alignment.XMidYMax.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f69517a[PreserveAspectRatio.Alignment.XMaxYMin.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f69517a[PreserveAspectRatio.Alignment.XMaxYMid.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f69517a[PreserveAspectRatio.Alignment.XMaxYMax.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f69517a[PreserveAspectRatio.Alignment.XMinYMid.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f69517a[PreserveAspectRatio.Alignment.XMinYMax.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements SVG.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<C1966c> f69521a;

        /* renamed from: b  reason: collision with root package name */
        public float f69522b;

        /* renamed from: c  reason: collision with root package name */
        public float f69523c;

        /* renamed from: d  reason: collision with root package name */
        public C1966c f69524d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f69525e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f69526f;

        /* renamed from: g  reason: collision with root package name */
        public int f69527g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f69528h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f69529i;

        public b(c cVar, SVG.v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69529i = cVar;
            this.f69521a = new ArrayList();
            this.f69524d = null;
            this.f69525e = false;
            this.f69526f = true;
            this.f69527g = -1;
            if (vVar == null) {
                return;
            }
            vVar.h(this);
            if (this.f69528h) {
                this.f69524d.b(this.f69521a.get(this.f69527g));
                this.f69521a.set(this.f69527g, this.f69524d);
                this.f69528h = false;
            }
            C1966c c1966c = this.f69524d;
            if (c1966c != null) {
                this.f69521a.add(c1966c);
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void a(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                if (this.f69528h) {
                    this.f69524d.b(this.f69521a.get(this.f69527g));
                    this.f69521a.set(this.f69527g, this.f69524d);
                    this.f69528h = false;
                }
                C1966c c1966c = this.f69524d;
                if (c1966c != null) {
                    this.f69521a.add(c1966c);
                }
                this.f69522b = f2;
                this.f69523c = f3;
                this.f69524d = new C1966c(this.f69529i, f2, f3, 0.0f, 0.0f);
                this.f69527g = this.f69521a.size();
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void b(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.f69524d.a(f2, f3);
                this.f69521a.add(this.f69524d);
                c cVar = this.f69529i;
                C1966c c1966c = this.f69524d;
                this.f69524d = new C1966c(cVar, f2, f3, f2 - c1966c.f69530a, f3 - c1966c.f69531b);
                this.f69528h = false;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void c(float f2, float f3, float f4, float f5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
                this.f69524d.a(f2, f3);
                this.f69521a.add(this.f69524d);
                this.f69524d = new C1966c(this.f69529i, f4, f5, f4 - f2, f5 - f3);
                this.f69528h = false;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f69521a.add(this.f69524d);
                b(this.f69522b, this.f69523c);
                this.f69528h = true;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void d(float f2, float f3, float f4, float f5, float f6, float f7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)}) == null) {
                if (this.f69526f || this.f69525e) {
                    this.f69524d.a(f2, f3);
                    this.f69521a.add(this.f69524d);
                    this.f69525e = false;
                }
                this.f69524d = new C1966c(this.f69529i, f6, f7, f6 - f4, f7 - f5);
                this.f69528h = false;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void e(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f5), Float.valueOf(f6)}) == null) {
                this.f69525e = true;
                this.f69526f = false;
                C1966c c1966c = this.f69524d;
                c.m(c1966c.f69530a, c1966c.f69531b, f2, f3, f4, z, z2, f5, f6, this);
                this.f69526f = true;
                this.f69528h = false;
            }
        }

        public List<C1966c> f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f69521a : (List) invokeV.objValue;
        }
    }

    /* renamed from: d.c.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1966c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public float f69530a;

        /* renamed from: b  reason: collision with root package name */
        public float f69531b;

        /* renamed from: c  reason: collision with root package name */
        public float f69532c;

        /* renamed from: d  reason: collision with root package name */
        public float f69533d;

        public C1966c(c cVar, float f2, float f3, float f4, float f5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69532c = 0.0f;
            this.f69533d = 0.0f;
            this.f69530a = f2;
            this.f69531b = f3;
            double sqrt = Math.sqrt((f4 * f4) + (f5 * f5));
            if (sqrt != 0.0d) {
                this.f69532c = (float) (f4 / sqrt);
                this.f69533d = (float) (f5 / sqrt);
            }
        }

        public void a(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                float f4 = f2 - this.f69530a;
                float f5 = f3 - this.f69531b;
                double sqrt = Math.sqrt((f4 * f4) + (f5 * f5));
                if (sqrt != 0.0d) {
                    this.f69532c += (float) (f4 / sqrt);
                    this.f69533d += (float) (f5 / sqrt);
                }
            }
        }

        public void b(C1966c c1966c) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1966c) == null) {
                this.f69532c += c1966c.f69532c;
                this.f69533d += c1966c.f69533d;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return "(" + this.f69530a + "," + this.f69531b + " " + this.f69532c + "," + this.f69533d + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements SVG.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Path f69534a;

        /* renamed from: b  reason: collision with root package name */
        public float f69535b;

        /* renamed from: c  reason: collision with root package name */
        public float f69536c;

        public d(c cVar, SVG.v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69534a = new Path();
            if (vVar == null) {
                return;
            }
            vVar.h(this);
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void a(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.f69534a.moveTo(f2, f3);
                this.f69535b = f2;
                this.f69536c = f3;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void b(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.f69534a.lineTo(f2, f3);
                this.f69535b = f2;
                this.f69536c = f3;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void c(float f2, float f3, float f4, float f5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
                this.f69534a.quadTo(f2, f3, f4, f5);
                this.f69535b = f4;
                this.f69536c = f5;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f69534a.close();
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void d(float f2, float f3, float f4, float f5, float f6, float f7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)}) == null) {
                this.f69534a.cubicTo(f2, f3, f4, f5, f6, f7);
                this.f69535b = f6;
                this.f69536c = f7;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void e(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f5), Float.valueOf(f6)}) == null) {
                c.m(this.f69535b, this.f69536c, f2, f3, f4, z, z2, f5, f6, this);
                this.f69535b = f5;
                this.f69536c = f6;
            }
        }

        public Path f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f69534a : (Path) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public Path f69537d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f69538e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(c cVar, Path path, float f2, float f3) {
            super(cVar, f2, f3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, path, Float.valueOf(f2), Float.valueOf(f3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((c) objArr2[0], ((Float) objArr2[1]).floatValue(), ((Float) objArr2[2]).floatValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69538e = cVar;
            this.f69537d = path;
        }

        @Override // d.c.a.c.f, d.c.a.c.j
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f69538e.Y0()) {
                    if (this.f69538e.f69513f.f69547f) {
                        this.f69538e.f69508a.drawTextOnPath(str, this.f69537d, this.f69539a, this.f69540b, this.f69538e.f69513f.f69549h);
                    }
                    if (this.f69538e.f69513f.f69548g) {
                        this.f69538e.f69508a.drawTextOnPath(str, this.f69537d, this.f69539a, this.f69540b, this.f69538e.f69513f.f69550i);
                    }
                }
                this.f69539a += this.f69538e.f69513f.f69549h.measureText(str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public float f69539a;

        /* renamed from: b  reason: collision with root package name */
        public float f69540b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f69541c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(c cVar, float f2, float f3) {
            super(cVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Float.valueOf(f2), Float.valueOf(f3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((c) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69541c = cVar;
            this.f69539a = f2;
            this.f69540b = f3;
        }

        @Override // d.c.a.c.j
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.C("TextSequence render", new Object[0]);
                if (this.f69541c.Y0()) {
                    if (this.f69541c.f69513f.f69547f) {
                        this.f69541c.f69508a.drawText(str, this.f69539a, this.f69540b, this.f69541c.f69513f.f69549h);
                    }
                    if (this.f69541c.f69513f.f69548g) {
                        this.f69541c.f69508a.drawText(str, this.f69539a, this.f69540b, this.f69541c.f69513f.f69550i);
                    }
                }
                this.f69539a += this.f69541c.f69513f.f69549h.measureText(str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public float f69542a;

        /* renamed from: b  reason: collision with root package name */
        public float f69543b;

        /* renamed from: c  reason: collision with root package name */
        public Path f69544c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f69545d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(c cVar, float f2, float f3, Path path) {
            super(cVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Float.valueOf(f2), Float.valueOf(f3), path};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((c) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69545d = cVar;
            this.f69542a = f2;
            this.f69543b = f3;
            this.f69544c = path;
        }

        @Override // d.c.a.c.j
        public boolean a(SVG.w0 w0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w0Var)) == null) {
                if (w0Var instanceof SVG.x0) {
                    c.Z0("Using <textPath> elements in a clip path is not supported.", new Object[0]);
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // d.c.a.c.j
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.f69545d.Y0()) {
                    Path path = new Path();
                    this.f69545d.f69513f.f69549h.getTextPath(str, 0, str.length(), this.f69542a, this.f69543b, path);
                    this.f69544c.addPath(path);
                }
                this.f69542a += this.f69545d.f69513f.f69549h.measureText(str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Cloneable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public SVG.Style f69546e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f69547f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f69548g;

        /* renamed from: h  reason: collision with root package name */
        public Paint f69549h;

        /* renamed from: i  reason: collision with root package name */
        public Paint f69550i;
        public SVG.b j;
        public SVG.b k;
        public boolean l;
        public boolean m;

        public h(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Paint paint = new Paint();
            this.f69549h = paint;
            paint.setFlags(385);
            this.f69549h.setStyle(Paint.Style.FILL);
            this.f69549h.setTypeface(Typeface.DEFAULT);
            Paint paint2 = new Paint();
            this.f69550i = paint2;
            paint2.setFlags(385);
            this.f69550i.setStyle(Paint.Style.STROKE);
            this.f69550i.setTypeface(Typeface.DEFAULT);
            this.f69546e = SVG.Style.d();
        }

        public Object clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    h hVar = (h) super.clone();
                    hVar.f69546e = (SVG.Style) this.f69546e.clone();
                    hVar.f69549h = new Paint(this.f69549h);
                    hVar.f69550i = new Paint(this.f69550i);
                    return hVar;
                } catch (CloneNotSupportedException e2) {
                    throw new InternalError(e2.toString());
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class i extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public float f69551a;

        /* renamed from: b  reason: collision with root package name */
        public float f69552b;

        /* renamed from: c  reason: collision with root package name */
        public RectF f69553c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f69554d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(c cVar, float f2, float f3) {
            super(cVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Float.valueOf(f2), Float.valueOf(f3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((c) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69554d = cVar;
            this.f69553c = new RectF();
            this.f69551a = f2;
            this.f69552b = f3;
        }

        @Override // d.c.a.c.j
        public boolean a(SVG.w0 w0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w0Var)) == null) {
                if (w0Var instanceof SVG.x0) {
                    SVG.x0 x0Var = (SVG.x0) w0Var;
                    SVG.l0 n = w0Var.f32644a.n(x0Var.n);
                    if (n == null) {
                        c.J("TextPath path reference '%s' not found", x0Var.n);
                        return false;
                    }
                    SVG.u uVar = (SVG.u) n;
                    Path f2 = new d(this.f69554d, uVar.o).f();
                    Matrix matrix = uVar.n;
                    if (matrix != null) {
                        f2.transform(matrix);
                    }
                    RectF rectF = new RectF();
                    f2.computeBounds(rectF, true);
                    this.f69553c.union(rectF);
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // d.c.a.c.j
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.f69554d.Y0()) {
                    Rect rect = new Rect();
                    this.f69554d.f69513f.f69549h.getTextBounds(str, 0, str.length(), rect);
                    RectF rectF = new RectF(rect);
                    rectF.offset(this.f69551a, this.f69552b);
                    this.f69553c.union(rectF);
                }
                this.f69551a += this.f69554d.f69513f.f69549h.measureText(str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public abstract class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public boolean a(SVG.w0 w0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w0Var)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        public abstract void b(String str);

        public /* synthetic */ j(c cVar, a aVar) {
            this(cVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-96581847, "Ld/c/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-96581847, "Ld/c/a/c;");
        }
    }

    public c(Canvas canvas, SVG.b bVar, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {canvas, bVar, Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f69508a = canvas;
        this.f69510c = f2;
        this.f69509b = bVar;
    }

    public static void C(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, objArr) == null) {
        }
    }

    public static void J(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, objArr) == null) {
            Log.e("SVGAndroidRenderer", String.format(str, objArr));
        }
    }

    public static synchronized void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (c.class) {
                HashSet<String> hashSet = new HashSet<>();
                l = hashSet;
                hashSet.add("Structure");
                l.add("BasicStructure");
                l.add("ConditionalProcessing");
                l.add("Image");
                l.add("Style");
                l.add("ViewportAttribute");
                l.add("Shape");
                l.add("BasicText");
                l.add("PaintAttribute");
                l.add("BasicPaintAttribute");
                l.add("OpacityAttribute");
                l.add("BasicGraphicsAttribute");
                l.add("Marker");
                l.add("Gradient");
                l.add("Pattern");
                l.add("Clip");
                l.add("BasicClip");
                l.add("Mask");
                l.add("View");
            }
        }
    }

    public static void Z0(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, objArr) == null) {
            Log.w("SVGAndroidRenderer", String.format(str, objArr));
        }
    }

    public static void m(float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, float f7, float f8, SVG.w wVar) {
        float f9;
        SVG.w wVar2;
        double d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f7), Float.valueOf(f8), wVar}) == null) {
            if (f2 == f7 && f3 == f8) {
                return;
            }
            if (f4 == 0.0f) {
                f9 = f7;
                wVar2 = wVar;
            } else if (f5 != 0.0f) {
                float abs = Math.abs(f4);
                float abs2 = Math.abs(f5);
                double radians = (float) Math.toRadians(f6 % 360.0d);
                double cos = Math.cos(radians);
                double sin = Math.sin(radians);
                double d3 = (f2 - f7) / 2.0d;
                double d4 = (f3 - f8) / 2.0d;
                double d5 = (cos * d3) + (sin * d4);
                double d6 = ((-sin) * d3) + (d4 * cos);
                double d7 = abs * abs;
                double d8 = abs2 * abs2;
                double d9 = d5 * d5;
                double d10 = d6 * d6;
                double d11 = (d9 / d7) + (d10 / d8);
                if (d11 > 1.0d) {
                    abs *= (float) Math.sqrt(d11);
                    abs2 *= (float) Math.sqrt(d11);
                    d7 = abs * abs;
                    d8 = abs2 * abs2;
                }
                double d12 = z == z2 ? -1.0d : 1.0d;
                double d13 = d7 * d8;
                double d14 = d7 * d10;
                double d15 = d8 * d9;
                double d16 = ((d13 - d14) - d15) / (d14 + d15);
                if (d16 < 0.0d) {
                    d16 = 0.0d;
                }
                double sqrt = d12 * Math.sqrt(d16);
                double d17 = abs;
                double d18 = abs2;
                double d19 = ((d17 * d6) / d18) * sqrt;
                float f10 = abs;
                float f11 = abs2;
                double d20 = sqrt * (-((d18 * d5) / d17));
                double d21 = ((f2 + f7) / 2.0d) + ((cos * d19) - (sin * d20));
                double d22 = ((f3 + f8) / 2.0d) + (sin * d19) + (cos * d20);
                double d23 = (d5 - d19) / d17;
                double d24 = (d6 - d20) / d18;
                double d25 = ((-d5) - d19) / d17;
                double d26 = ((-d6) - d20) / d18;
                double d27 = (d23 * d23) + (d24 * d24);
                double degrees = Math.toDegrees((d24 < 0.0d ? -1.0d : 1.0d) * Math.acos(d23 / Math.sqrt(d27)));
                double degrees2 = Math.toDegrees(((d23 * d26) - (d24 * d25) < 0.0d ? -1.0d : 1.0d) * Math.acos(((d23 * d25) + (d24 * d26)) / Math.sqrt(d27 * ((d25 * d25) + (d26 * d26)))));
                if (z2 || degrees2 <= 0.0d) {
                    d2 = 360.0d;
                    if (z2 && degrees2 < 0.0d) {
                        degrees2 += 360.0d;
                    }
                } else {
                    d2 = 360.0d;
                    degrees2 -= 360.0d;
                }
                float[] n = n(degrees % d2, degrees2 % d2);
                Matrix matrix = new Matrix();
                matrix.postScale(f10, f11);
                matrix.postRotate(f6);
                matrix.postTranslate((float) d21, (float) d22);
                matrix.mapPoints(n);
                n[n.length - 2] = f7;
                n[n.length - 1] = f8;
                for (int i2 = 0; i2 < n.length; i2 += 6) {
                    wVar.d(n[i2], n[i2 + 1], n[i2 + 2], n[i2 + 3], n[i2 + 4], n[i2 + 5]);
                }
                return;
            } else {
                wVar2 = wVar;
                f9 = f7;
            }
            wVar2.b(f9, f8);
        }
    }

    public static float[] n(double d2, double d3) {
        InterceptResult invokeCommon;
        float radians;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) {
            int ceil = (int) Math.ceil(Math.abs(d3) / 90.0d);
            double radians2 = Math.toRadians(d2);
            double radians3 = (float) (Math.toRadians(d3) / ceil);
            double d4 = radians3 / 2.0d;
            double sin = (Math.sin(d4) * 1.3333333333333333d) / (Math.cos(d4) + 1.0d);
            float[] fArr = new float[ceil * 6];
            int i2 = 0;
            int i3 = 0;
            while (i2 < ceil) {
                double d5 = (i2 * radians) + radians2;
                double cos = Math.cos(d5);
                double sin2 = Math.sin(d5);
                int i4 = i3 + 1;
                int i5 = ceil;
                double d6 = radians2;
                fArr[i3] = (float) (cos - (sin * sin2));
                int i6 = i4 + 1;
                fArr[i4] = (float) (sin2 + (cos * sin));
                double d7 = d5 + radians3;
                double cos2 = Math.cos(d7);
                double sin3 = Math.sin(d7);
                int i7 = i6 + 1;
                fArr[i6] = (float) ((sin * sin3) + cos2);
                int i8 = i7 + 1;
                fArr[i7] = (float) (sin3 - (sin * cos2));
                int i9 = i8 + 1;
                fArr[i8] = (float) cos2;
                fArr[i9] = (float) sin3;
                i2++;
                radians2 = d6;
                i3 = i9 + 1;
                ceil = i5;
            }
            return fArr;
        }
        return (float[]) invokeCommon.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f69508a.restore();
            this.f69513f = this.f69514g.pop();
        }
    }

    public final void A0(SVG.l0 l0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l0Var) == null) || (l0Var instanceof SVG.s)) {
            return;
        }
        S0();
        y(l0Var);
        if (l0Var instanceof SVG.d0) {
            x0((SVG.d0) l0Var);
        } else if (l0Var instanceof SVG.b1) {
            E0((SVG.b1) l0Var);
        } else if (l0Var instanceof SVG.q0) {
            B0((SVG.q0) l0Var);
        } else if (l0Var instanceof SVG.l) {
            q0((SVG.l) l0Var);
        } else if (l0Var instanceof SVG.n) {
            r0((SVG.n) l0Var);
        } else if (l0Var instanceof SVG.u) {
            t0((SVG.u) l0Var);
        } else if (l0Var instanceof SVG.a0) {
            w0((SVG.a0) l0Var);
        } else if (l0Var instanceof SVG.d) {
            o0((SVG.d) l0Var);
        } else if (l0Var instanceof SVG.i) {
            p0((SVG.i) l0Var);
        } else if (l0Var instanceof SVG.p) {
            s0((SVG.p) l0Var);
        } else if (l0Var instanceof SVG.z) {
            v0((SVG.z) l0Var);
        } else if (l0Var instanceof SVG.y) {
            u0((SVG.y) l0Var);
        } else if (l0Var instanceof SVG.u0) {
            D0((SVG.u0) l0Var);
        }
        R0();
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f69508a.save();
            this.f69514g.push(this.f69513f);
            this.f69513f = (h) this.f69513f.clone();
        }
    }

    public final void B0(SVG.q0 q0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, q0Var) == null) {
            C("Switch render", new Object[0]);
            W0(this.f69513f, q0Var);
            if (E()) {
                Matrix matrix = q0Var.n;
                if (matrix != null) {
                    this.f69508a.concat(matrix);
                }
                t(q0Var);
                boolean n0 = n0();
                K0(q0Var);
                if (n0) {
                    k0(q0Var);
                }
                U0(q0Var);
            }
        }
    }

    public final void C0(SVG.r0 r0Var, SVG.o oVar, SVG.o oVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, r0Var, oVar, oVar2) == null) {
            C("Symbol render", new Object[0]);
            if (oVar == null || !oVar.k()) {
                if (oVar2 == null || !oVar2.k()) {
                    PreserveAspectRatio preserveAspectRatio = r0Var.n;
                    if (preserveAspectRatio == null) {
                        preserveAspectRatio = PreserveAspectRatio.f32606d;
                    }
                    W0(this.f69513f, r0Var);
                    this.f69513f.j = new SVG.b(0.0f, 0.0f, oVar != null ? oVar.h(this) : this.f69513f.j.f32624g, oVar2 != null ? oVar2.h(this) : this.f69513f.j.f32625h);
                    if (!this.f69513f.f69546e.z.booleanValue()) {
                        SVG.b bVar = this.f69513f.j;
                        O0(bVar.f32622e, bVar.f32623f, bVar.f32624g, bVar.f32625h);
                    }
                    SVG.b bVar2 = r0Var.o;
                    if (bVar2 != null) {
                        this.f69508a.concat(s(this.f69513f.j, bVar2, preserveAspectRatio));
                        this.f69513f.k = r0Var.o;
                    }
                    boolean n0 = n0();
                    F0(r0Var, true);
                    if (n0) {
                        k0(r0Var);
                    }
                    U0(r0Var);
                }
            }
        }
    }

    public final void D(boolean z, SVG.b bVar, SVG.t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), bVar, tVar}) == null) {
            SVG.l0 n = this.f69512e.n(tVar.f32648e);
            if (n == null) {
                Object[] objArr = new Object[2];
                objArr[0] = z ? "Fill" : "Stroke";
                objArr[1] = tVar.f32648e;
                J("%s reference '%s' not found", objArr);
                SVG.m0 m0Var = tVar.f32649f;
                if (m0Var != null) {
                    P0(this.f69513f, z, m0Var);
                    return;
                } else if (z) {
                    this.f69513f.f69547f = false;
                    return;
                } else {
                    this.f69513f.f69548g = false;
                    return;
                }
            }
            if (n instanceof SVG.k0) {
                b0(z, bVar, (SVG.k0) n);
            }
            if (n instanceof SVG.o0) {
                h0(z, bVar, (SVG.o0) n);
            }
            if (n instanceof SVG.b0) {
                Q0(z, (SVG.b0) n);
            }
        }
    }

    public final void D0(SVG.u0 u0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, u0Var) == null) {
            C("Text render", new Object[0]);
            W0(this.f69513f, u0Var);
            if (E()) {
                Matrix matrix = u0Var.r;
                if (matrix != null) {
                    this.f69508a.concat(matrix);
                }
                List<SVG.o> list = u0Var.n;
                float f2 = 0.0f;
                float h2 = (list == null || list.size() == 0) ? 0.0f : u0Var.n.get(0).h(this);
                List<SVG.o> list2 = u0Var.o;
                float i2 = (list2 == null || list2.size() == 0) ? 0.0f : u0Var.o.get(0).i(this);
                List<SVG.o> list3 = u0Var.p;
                float h3 = (list3 == null || list3.size() == 0) ? 0.0f : u0Var.p.get(0).h(this);
                List<SVG.o> list4 = u0Var.q;
                if (list4 != null && list4.size() != 0) {
                    f2 = u0Var.q.get(0).i(this);
                }
                SVG.Style.TextAnchor S = S();
                if (S != SVG.Style.TextAnchor.Start) {
                    float r = r(u0Var);
                    if (S == SVG.Style.TextAnchor.Middle) {
                        r /= 2.0f;
                    }
                    h2 -= r;
                }
                if (u0Var.f32636h == null) {
                    i iVar = new i(this, h2, i2);
                    I(u0Var, iVar);
                    RectF rectF = iVar.f69553c;
                    u0Var.f32636h = new SVG.b(rectF.left, rectF.top, rectF.width(), iVar.f69553c.height());
                }
                U0(u0Var);
                v(u0Var);
                t(u0Var);
                boolean n0 = n0();
                I(u0Var, new f(this, h2 + h3, i2 + f2));
                if (n0) {
                    k0(u0Var);
                }
            }
        }
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Boolean bool = this.f69513f.f69546e.E;
            if (bool != null) {
                return bool.booleanValue();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void E0(SVG.b1 b1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, b1Var) == null) {
            C("Use render", new Object[0]);
            SVG.o oVar = b1Var.r;
            if (oVar == null || !oVar.k()) {
                SVG.o oVar2 = b1Var.s;
                if (oVar2 == null || !oVar2.k()) {
                    W0(this.f69513f, b1Var);
                    if (E()) {
                        SVG.l0 n = b1Var.f32644a.n(b1Var.o);
                        if (n == null) {
                            J("Use reference '%s' not found", b1Var.o);
                            return;
                        }
                        Matrix matrix = b1Var.n;
                        if (matrix != null) {
                            this.f69508a.concat(matrix);
                        }
                        Matrix matrix2 = new Matrix();
                        SVG.o oVar3 = b1Var.p;
                        float h2 = oVar3 != null ? oVar3.h(this) : 0.0f;
                        SVG.o oVar4 = b1Var.q;
                        matrix2.preTranslate(h2, oVar4 != null ? oVar4.i(this) : 0.0f);
                        this.f69508a.concat(matrix2);
                        t(b1Var);
                        boolean n0 = n0();
                        j0(b1Var);
                        if (n instanceof SVG.d0) {
                            S0();
                            SVG.d0 d0Var = (SVG.d0) n;
                            SVG.o oVar5 = b1Var.r;
                            if (oVar5 == null) {
                                oVar5 = d0Var.r;
                            }
                            SVG.o oVar6 = b1Var.s;
                            if (oVar6 == null) {
                                oVar6 = d0Var.s;
                            }
                            y0(d0Var, oVar5, oVar6);
                            R0();
                        } else if (n instanceof SVG.r0) {
                            SVG.o oVar7 = b1Var.r;
                            if (oVar7 == null) {
                                oVar7 = new SVG.o(100.0f, SVG.Unit.percent);
                            }
                            SVG.o oVar8 = b1Var.s;
                            if (oVar8 == null) {
                                oVar8 = new SVG.o(100.0f, SVG.Unit.percent);
                            }
                            S0();
                            C0((SVG.r0) n, oVar7, oVar8);
                            R0();
                        } else {
                            A0(n);
                        }
                        i0();
                        if (n0) {
                            k0(b1Var);
                        }
                        U0(b1Var);
                    }
                }
            }
        }
    }

    public final void F(SVG.i0 i0Var, Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, i0Var, path) == null) {
            SVG.m0 m0Var = this.f69513f.f69546e.f32615f;
            if (m0Var instanceof SVG.t) {
                SVG.l0 n = this.f69512e.n(((SVG.t) m0Var).f32648e);
                if (n instanceof SVG.x) {
                    P(i0Var, path, (SVG.x) n);
                    return;
                }
            }
            this.f69508a.drawPath(path, this.f69513f.f69549h);
        }
    }

    public final void F0(SVG.h0 h0Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, h0Var, z) == null) {
            if (z) {
                j0(h0Var);
            }
            for (SVG.l0 l0Var : h0Var.getChildren()) {
                A0(l0Var);
            }
            if (z) {
                i0();
            }
        }
    }

    public final void G(Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, path) == null) {
            h hVar = this.f69513f;
            if (hVar.f69546e.P == SVG.Style.VectorEffect.NonScalingStroke) {
                Matrix matrix = this.f69508a.getMatrix();
                Path path2 = new Path();
                path.transform(matrix, path2);
                this.f69508a.setMatrix(new Matrix());
                Shader shader = this.f69513f.f69550i.getShader();
                Matrix matrix2 = new Matrix();
                if (shader != null) {
                    shader.getLocalMatrix(matrix2);
                    Matrix matrix3 = new Matrix(matrix2);
                    matrix3.postConcat(matrix);
                    shader.setLocalMatrix(matrix3);
                }
                this.f69508a.drawPath(path2, this.f69513f.f69550i);
                this.f69508a.setMatrix(matrix);
                if (shader != null) {
                    shader.setLocalMatrix(matrix2);
                    return;
                }
                return;
            }
            this.f69508a.drawPath(path, hVar.f69550i);
        }
    }

    public void G0(SVG svg, SVG.b bVar, PreserveAspectRatio preserveAspectRatio, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{svg, bVar, preserveAspectRatio, Boolean.valueOf(z)}) == null) {
            this.f69512e = svg;
            this.f69511d = z;
            SVG.d0 j2 = svg.j();
            if (j2 == null) {
                Z0("Nothing to render. Document is empty.", new Object[0]);
                return;
            }
            N0();
            y(j2);
            SVG.o oVar = j2.r;
            SVG.o oVar2 = j2.s;
            if (bVar == null) {
                bVar = j2.o;
            }
            SVG.b bVar2 = bVar;
            if (preserveAspectRatio == null) {
                preserveAspectRatio = j2.n;
            }
            z0(j2, oVar, oVar2, bVar2, preserveAspectRatio);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(this.f69508a.getWidth(), this.f69508a.getHeight(), Bitmap.Config.ARGB_8888);
                this.k.push(createBitmap);
                Canvas canvas = new Canvas(createBitmap);
                canvas.setMatrix(this.f69508a.getMatrix());
                this.f69508a = canvas;
            } catch (OutOfMemoryError e2) {
                J("Not enough memory to create temporary bitmaps for mask processing", new Object[0]);
                throw e2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x010c, code lost:
        if (r7 != 8) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void H0(SVG.q qVar, C1966c c1966c) {
        float f2;
        SVG.b bVar;
        boolean n0;
        float f3;
        float f4;
        float f5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, qVar, c1966c) == null) {
            S0();
            Float f6 = qVar.u;
            float f7 = 0.0f;
            if (f6 != null) {
                if (Float.isNaN(f6.floatValue())) {
                    if (c1966c.f69532c != 0.0f || c1966c.f69533d != 0.0f) {
                        f2 = (float) Math.toDegrees(Math.atan2(c1966c.f69533d, c1966c.f69532c));
                    }
                } else {
                    f2 = qVar.u.floatValue();
                }
                float e2 = !qVar.p ? 1.0f : this.f69513f.f69546e.k.e(this.f69510c);
                this.f69513f = Q(qVar);
                Matrix matrix = new Matrix();
                matrix.preTranslate(c1966c.f69530a, c1966c.f69531b);
                matrix.preRotate(f2);
                matrix.preScale(e2, e2);
                SVG.o oVar = qVar.q;
                float h2 = oVar == null ? oVar.h(this) : 0.0f;
                SVG.o oVar2 = qVar.r;
                float i2 = oVar2 == null ? oVar2.i(this) : 0.0f;
                SVG.o oVar3 = qVar.s;
                float h3 = oVar3 == null ? oVar3.h(this) : 3.0f;
                SVG.o oVar4 = qVar.t;
                float i3 = oVar4 != null ? oVar4.i(this) : 3.0f;
                bVar = qVar.o;
                if (bVar == null) {
                    float f8 = h3 / bVar.f32624g;
                    float f9 = i3 / bVar.f32625h;
                    PreserveAspectRatio preserveAspectRatio = qVar.n;
                    if (preserveAspectRatio == null) {
                        preserveAspectRatio = PreserveAspectRatio.f32606d;
                    }
                    if (!preserveAspectRatio.equals(PreserveAspectRatio.f32605c)) {
                        f8 = preserveAspectRatio.b() == PreserveAspectRatio.Scale.Slice ? Math.max(f8, f9) : Math.min(f8, f9);
                        f9 = f8;
                    }
                    matrix.preTranslate((-h2) * f8, (-i2) * f9);
                    this.f69508a.concat(matrix);
                    SVG.b bVar2 = qVar.o;
                    float f10 = bVar2.f32624g * f8;
                    float f11 = bVar2.f32625h * f9;
                    switch (a.f69517a[preserveAspectRatio.a().ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                            f3 = (h3 - f10) / 2.0f;
                            f4 = 0.0f - f3;
                            break;
                        case 4:
                        case 5:
                        case 6:
                            f3 = h3 - f10;
                            f4 = 0.0f - f3;
                            break;
                        default:
                            f4 = 0.0f;
                            break;
                    }
                    int i4 = a.f69517a[preserveAspectRatio.a().ordinal()];
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 != 5) {
                                if (i4 != 6) {
                                    if (i4 != 7) {
                                    }
                                }
                            }
                        }
                        f5 = i3 - f11;
                        f7 = 0.0f - f5;
                        if (!this.f69513f.f69546e.z.booleanValue()) {
                            O0(f4, f7, h3, i3);
                        }
                        matrix.reset();
                        matrix.preScale(f8, f9);
                        this.f69508a.concat(matrix);
                    }
                    f5 = (i3 - f11) / 2.0f;
                    f7 = 0.0f - f5;
                    if (!this.f69513f.f69546e.z.booleanValue()) {
                    }
                    matrix.reset();
                    matrix.preScale(f8, f9);
                    this.f69508a.concat(matrix);
                } else {
                    matrix.preTranslate(-h2, -i2);
                    this.f69508a.concat(matrix);
                    if (!this.f69513f.f69546e.z.booleanValue()) {
                        O0(0.0f, 0.0f, h3, i3);
                    }
                }
                n0 = n0();
                F0(qVar, false);
                if (n0) {
                    k0(qVar);
                }
                R0();
            }
            f2 = 0.0f;
            if (!qVar.p) {
            }
            this.f69513f = Q(qVar);
            Matrix matrix2 = new Matrix();
            matrix2.preTranslate(c1966c.f69530a, c1966c.f69531b);
            matrix2.preRotate(f2);
            matrix2.preScale(e2, e2);
            SVG.o oVar5 = qVar.q;
            if (oVar5 == null) {
            }
            SVG.o oVar22 = qVar.r;
            if (oVar22 == null) {
            }
            SVG.o oVar32 = qVar.s;
            if (oVar32 == null) {
            }
            SVG.o oVar42 = qVar.t;
            if (oVar42 != null) {
            }
            bVar = qVar.o;
            if (bVar == null) {
            }
            n0 = n0();
            F0(qVar, false);
            if (n0) {
            }
            R0();
        }
    }

    public final void I(SVG.w0 w0Var, j jVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, w0Var, jVar) == null) && E()) {
            Iterator<SVG.l0> it = w0Var.f32633i.iterator();
            boolean z = true;
            while (it.hasNext()) {
                SVG.l0 next = it.next();
                if (next instanceof SVG.a1) {
                    jVar.b(T0(((SVG.a1) next).f32620c, z, !it.hasNext()));
                } else {
                    m0(next, jVar);
                }
                z = false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a2 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void I0(SVG.k kVar) {
        SVG.q qVar;
        String str;
        SVG.q qVar2;
        String str2;
        SVG.q qVar3;
        List<C1966c> p;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048592, this, kVar) != null) {
            return;
        }
        SVG.Style style = this.f69513f.f69546e;
        if (style.B == null && style.C == null && style.D == null) {
            return;
        }
        String str3 = this.f69513f.f69546e.B;
        if (str3 != null) {
            SVG.l0 n = kVar.f32644a.n(str3);
            if (n != null) {
                qVar = (SVG.q) n;
                str = this.f69513f.f69546e.C;
                if (str != null) {
                    SVG.l0 n2 = kVar.f32644a.n(str);
                    if (n2 != null) {
                        qVar2 = (SVG.q) n2;
                        str2 = this.f69513f.f69546e.D;
                        if (str2 != null) {
                            SVG.l0 n3 = kVar.f32644a.n(str2);
                            if (n3 != null) {
                                qVar3 = (SVG.q) n3;
                                if (!(kVar instanceof SVG.u)) {
                                    p = new b(this, ((SVG.u) kVar).o).f();
                                } else if (kVar instanceof SVG.p) {
                                    p = o((SVG.p) kVar);
                                } else {
                                    p = p((SVG.y) kVar);
                                }
                                if (p == null && (size = p.size()) != 0) {
                                    SVG.Style style2 = this.f69513f.f69546e;
                                    style2.D = null;
                                    style2.C = null;
                                    style2.B = null;
                                    if (qVar != null) {
                                        H0(qVar, p.get(0));
                                    }
                                    if (qVar2 != null) {
                                        for (int i2 = 1; i2 < size - 1; i2++) {
                                            H0(qVar2, p.get(i2));
                                        }
                                    }
                                    if (qVar3 == null) {
                                        H0(qVar3, p.get(size - 1));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            J("Marker reference '%s' not found", this.f69513f.f69546e.D);
                        }
                        qVar3 = null;
                        if (!(kVar instanceof SVG.u)) {
                        }
                        if (p == null) {
                            return;
                        }
                        SVG.Style style22 = this.f69513f.f69546e;
                        style22.D = null;
                        style22.C = null;
                        style22.B = null;
                        if (qVar != null) {
                        }
                        if (qVar2 != null) {
                        }
                        if (qVar3 == null) {
                        }
                    } else {
                        J("Marker reference '%s' not found", this.f69513f.f69546e.C);
                    }
                }
                qVar2 = null;
                str2 = this.f69513f.f69546e.D;
                if (str2 != null) {
                }
                qVar3 = null;
                if (!(kVar instanceof SVG.u)) {
                }
                if (p == null) {
                }
            } else {
                J("Marker reference '%s' not found", this.f69513f.f69546e.B);
            }
        }
        qVar = null;
        str = this.f69513f.f69546e.C;
        if (str != null) {
        }
        qVar2 = null;
        str2 = this.f69513f.f69546e.D;
        if (str2 != null) {
        }
        qVar3 = null;
        if (!(kVar instanceof SVG.u)) {
        }
        if (p == null) {
        }
    }

    public final void J0(SVG.r rVar, SVG.i0 i0Var) {
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, rVar, i0Var) == null) {
            C("Mask render", new Object[0]);
            Boolean bool = rVar.n;
            boolean z = true;
            if (bool != null && bool.booleanValue()) {
                SVG.o oVar = rVar.r;
                f2 = oVar != null ? oVar.h(this) : i0Var.f32636h.f32624g;
                SVG.o oVar2 = rVar.s;
                f3 = oVar2 != null ? oVar2.i(this) : i0Var.f32636h.f32625h;
                SVG.o oVar3 = rVar.p;
                if (oVar3 != null) {
                    oVar3.h(this);
                } else {
                    SVG.b bVar = i0Var.f32636h;
                    float f4 = bVar.f32622e;
                    float f5 = bVar.f32624g;
                }
                SVG.o oVar4 = rVar.q;
                if (oVar4 != null) {
                    oVar4.i(this);
                } else {
                    SVG.b bVar2 = i0Var.f32636h;
                    float f6 = bVar2.f32623f;
                    float f7 = bVar2.f32625h;
                }
            } else {
                SVG.o oVar5 = rVar.p;
                if (oVar5 != null) {
                    oVar5.g(this, 1.0f);
                }
                SVG.o oVar6 = rVar.q;
                if (oVar6 != null) {
                    oVar6.g(this, 1.0f);
                }
                SVG.o oVar7 = rVar.r;
                float g2 = oVar7 != null ? oVar7.g(this, 1.0f) : 1.2f;
                SVG.o oVar8 = rVar.s;
                float g3 = oVar8 != null ? oVar8.g(this, 1.0f) : 1.2f;
                SVG.b bVar3 = i0Var.f32636h;
                float f8 = bVar3.f32622e;
                float f9 = bVar3.f32624g;
                float f10 = bVar3.f32623f;
                f2 = g2 * f9;
                f3 = g3 * bVar3.f32625h;
            }
            if (f2 == 0.0f || f3 == 0.0f) {
                return;
            }
            S0();
            h Q = Q(rVar);
            this.f69513f = Q;
            Q.f69546e.q = Float.valueOf(1.0f);
            Boolean bool2 = rVar.o;
            if (bool2 != null && !bool2.booleanValue()) {
                z = false;
            }
            if (!z) {
                Canvas canvas = this.f69508a;
                SVG.b bVar4 = i0Var.f32636h;
                canvas.translate(bVar4.f32622e, bVar4.f32623f);
                Canvas canvas2 = this.f69508a;
                SVG.b bVar5 = i0Var.f32636h;
                canvas2.scale(bVar5.f32624g, bVar5.f32625h);
            }
            F0(rVar, false);
            R0();
        }
    }

    public final void K(SVG.w0 w0Var, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, w0Var, sb) == null) {
            Iterator<SVG.l0> it = w0Var.f32633i.iterator();
            boolean z = true;
            while (it.hasNext()) {
                SVG.l0 next = it.next();
                if (next instanceof SVG.w0) {
                    K((SVG.w0) next, sb);
                } else if (next instanceof SVG.a1) {
                    sb.append(T0(((SVG.a1) next).f32620c, z, !it.hasNext()));
                }
                z = false;
            }
        }
    }

    public final void K0(SVG.q0 q0Var) {
        Set<String> f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, q0Var) == null) {
            String language = Locale.getDefault().getLanguage();
            d.c.a.d e2 = this.f69512e.e();
            for (SVG.l0 l0Var : q0Var.getChildren()) {
                if (l0Var instanceof SVG.e0) {
                    SVG.e0 e0Var = (SVG.e0) l0Var;
                    if (e0Var.a() == null && ((f2 = e0Var.f()) == null || (!f2.isEmpty() && f2.contains(language)))) {
                        Set<String> h2 = e0Var.h();
                        if (h2 != null) {
                            if (l == null) {
                                Z();
                            }
                            if (!h2.isEmpty() && l.containsAll(h2)) {
                            }
                        }
                        Set<String> e3 = e0Var.e();
                        if (e3 != null) {
                            if (!e3.isEmpty() && e2 != null) {
                                for (String str : e3) {
                                    if (!e2.a(str)) {
                                        break;
                                    }
                                }
                            }
                        }
                        Set<String> m = e0Var.m();
                        if (m != null) {
                            if (!m.isEmpty() && e2 != null) {
                                for (String str2 : m) {
                                    if (e2.b(str2, this.f69513f.f69546e.u.intValue(), String.valueOf(this.f69513f.f69546e.v)) == null) {
                                        break;
                                    }
                                }
                            }
                        }
                        A0(l0Var);
                        return;
                    }
                }
            }
        }
    }

    public final void L(SVG.j jVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, jVar, str) == null) {
            SVG.l0 n = jVar.f32644a.n(str);
            if (n == null) {
                Z0("Gradient reference '%s' not found", str);
            } else if (!(n instanceof SVG.j)) {
                J("Gradient href attributes must point to other gradient elements", new Object[0]);
            } else if (n == jVar) {
                J("Circular reference in gradient href attribute '%s'", str);
            } else {
                SVG.j jVar2 = (SVG.j) n;
                if (jVar.f32638i == null) {
                    jVar.f32638i = jVar2.f32638i;
                }
                if (jVar.j == null) {
                    jVar.j = jVar2.j;
                }
                if (jVar.k == null) {
                    jVar.k = jVar2.k;
                }
                if (jVar.f32637h.isEmpty()) {
                    jVar.f32637h = jVar2.f32637h;
                }
                try {
                    if (jVar instanceof SVG.k0) {
                        M((SVG.k0) jVar, (SVG.k0) n);
                    } else {
                        N((SVG.o0) jVar, (SVG.o0) n);
                    }
                } catch (ClassCastException unused) {
                }
                String str2 = jVar2.l;
                if (str2 != null) {
                    L(jVar, str2);
                }
            }
        }
    }

    public final void L0(SVG.x0 x0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, x0Var) == null) {
            C("TextPath render", new Object[0]);
            W0(this.f69513f, x0Var);
            if (E() && Y0()) {
                SVG.l0 n = x0Var.f32644a.n(x0Var.n);
                if (n == null) {
                    J("TextPath reference '%s' not found", x0Var.n);
                    return;
                }
                SVG.u uVar = (SVG.u) n;
                Path f2 = new d(this, uVar.o).f();
                Matrix matrix = uVar.n;
                if (matrix != null) {
                    f2.transform(matrix);
                }
                PathMeasure pathMeasure = new PathMeasure(f2, false);
                SVG.o oVar = x0Var.o;
                float g2 = oVar != null ? oVar.g(this, pathMeasure.getLength()) : 0.0f;
                SVG.Style.TextAnchor S = S();
                if (S != SVG.Style.TextAnchor.Start) {
                    float r = r(x0Var);
                    if (S == SVG.Style.TextAnchor.Middle) {
                        r /= 2.0f;
                    }
                    g2 -= r;
                }
                v((SVG.i0) x0Var.c());
                boolean n0 = n0();
                I(x0Var, new e(this, f2, g2, 0.0f));
                if (n0) {
                    k0(x0Var);
                }
            }
        }
    }

    public final void M(SVG.k0 k0Var, SVG.k0 k0Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, k0Var, k0Var2) == null) {
            if (k0Var.m == null) {
                k0Var.m = k0Var2.m;
            }
            if (k0Var.n == null) {
                k0Var.n = k0Var2.n;
            }
            if (k0Var.o == null) {
                k0Var.o = k0Var2.o;
            }
            if (k0Var.p == null) {
                k0Var.p = k0Var2.p;
            }
        }
    }

    public final boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            h hVar = this.f69513f;
            if (hVar.f69546e.K != null && !hVar.m) {
                Z0("Masks are not supported when using getPicture()", new Object[0]);
            }
            if (this.f69513f.f69546e.q.floatValue() >= 1.0f) {
                h hVar2 = this.f69513f;
                if (hVar2.f69546e.K == null || !hVar2.m) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void N(SVG.o0 o0Var, SVG.o0 o0Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, o0Var, o0Var2) == null) {
            if (o0Var.m == null) {
                o0Var.m = o0Var2.m;
            }
            if (o0Var.n == null) {
                o0Var.n = o0Var2.n;
            }
            if (o0Var.o == null) {
                o0Var.o = o0Var2.o;
            }
            if (o0Var.p == null) {
                o0Var.p = o0Var2.p;
            }
            if (o0Var.q == null) {
                o0Var.q = o0Var2.q;
            }
        }
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f69513f = new h(this);
            this.f69514g = new Stack<>();
            V0(this.f69513f, SVG.Style.d());
            h hVar = this.f69513f;
            hVar.j = this.f69509b;
            hVar.l = false;
            hVar.m = this.f69511d;
            this.f69514g.push((h) hVar.clone());
            this.j = new Stack<>();
            this.k = new Stack<>();
            this.f69516i = new Stack<>();
            this.f69515h = new Stack<>();
        }
    }

    public final void O(SVG.x xVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, xVar, str) == null) {
            SVG.l0 n = xVar.f32644a.n(str);
            if (n == null) {
                Z0("Pattern reference '%s' not found", str);
            } else if (!(n instanceof SVG.x)) {
                J("Pattern href attributes must point to other pattern elements", new Object[0]);
            } else if (n == xVar) {
                J("Circular reference in pattern href attribute '%s'", str);
            } else {
                SVG.x xVar2 = (SVG.x) n;
                if (xVar.p == null) {
                    xVar.p = xVar2.p;
                }
                if (xVar.q == null) {
                    xVar.q = xVar2.q;
                }
                if (xVar.r == null) {
                    xVar.r = xVar2.r;
                }
                if (xVar.s == null) {
                    xVar.s = xVar2.s;
                }
                if (xVar.t == null) {
                    xVar.t = xVar2.t;
                }
                if (xVar.u == null) {
                    xVar.u = xVar2.u;
                }
                if (xVar.v == null) {
                    xVar.v = xVar2.v;
                }
                if (xVar.f32633i.isEmpty()) {
                    xVar.f32633i = xVar2.f32633i;
                }
                if (xVar.o == null) {
                    xVar.o = xVar2.o;
                }
                if (xVar.n == null) {
                    xVar.n = xVar2.n;
                }
                String str2 = xVar2.w;
                if (str2 != null) {
                    O(xVar, str2);
                }
            }
        }
    }

    public final void O0(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            float f6 = f4 + f2;
            float f7 = f5 + f3;
            SVG.c cVar = this.f69513f.f69546e.A;
            if (cVar != null) {
                f2 += cVar.f32629d.h(this);
                f3 += this.f69513f.f69546e.A.f32626a.i(this);
                f6 -= this.f69513f.f69546e.A.f32627b.h(this);
                f7 -= this.f69513f.f69546e.A.f32628c.i(this);
            }
            this.f69508a.clipRect(f2, f3, f6, f7);
        }
    }

    public final void P(SVG.i0 i0Var, Path path, SVG.x xVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048604, this, i0Var, path, xVar) == null) {
            Boolean bool = xVar.p;
            boolean z = bool != null && bool.booleanValue();
            String str = xVar.w;
            if (str != null) {
                O(xVar, str);
            }
            if (z) {
                SVG.o oVar = xVar.s;
                f2 = oVar != null ? oVar.h(this) : 0.0f;
                SVG.o oVar2 = xVar.t;
                f4 = oVar2 != null ? oVar2.i(this) : 0.0f;
                SVG.o oVar3 = xVar.u;
                f5 = oVar3 != null ? oVar3.h(this) : 0.0f;
                SVG.o oVar4 = xVar.v;
                f3 = oVar4 != null ? oVar4.i(this) : 0.0f;
            } else {
                SVG.o oVar5 = xVar.s;
                float g2 = oVar5 != null ? oVar5.g(this, 1.0f) : 0.0f;
                SVG.o oVar6 = xVar.t;
                float g3 = oVar6 != null ? oVar6.g(this, 1.0f) : 0.0f;
                SVG.o oVar7 = xVar.u;
                float g4 = oVar7 != null ? oVar7.g(this, 1.0f) : 0.0f;
                SVG.o oVar8 = xVar.v;
                float g5 = oVar8 != null ? oVar8.g(this, 1.0f) : 0.0f;
                SVG.b bVar = i0Var.f32636h;
                float f6 = bVar.f32622e;
                float f7 = bVar.f32624g;
                f2 = (g2 * f7) + f6;
                float f8 = bVar.f32623f;
                float f9 = bVar.f32625h;
                float f10 = g4 * f7;
                f3 = g5 * f9;
                f4 = (g3 * f9) + f8;
                f5 = f10;
            }
            if (f5 == 0.0f || f3 == 0.0f) {
                return;
            }
            PreserveAspectRatio preserveAspectRatio = xVar.n;
            if (preserveAspectRatio == null) {
                preserveAspectRatio = PreserveAspectRatio.f32606d;
            }
            S0();
            this.f69508a.clipPath(path);
            h hVar = new h(this);
            V0(hVar, SVG.Style.d());
            hVar.f69546e.z = Boolean.FALSE;
            R(xVar, hVar);
            this.f69513f = hVar;
            SVG.b bVar2 = i0Var.f32636h;
            Matrix matrix = xVar.r;
            if (matrix != null) {
                this.f69508a.concat(matrix);
                Matrix matrix2 = new Matrix();
                if (xVar.r.invert(matrix2)) {
                    SVG.b bVar3 = i0Var.f32636h;
                    SVG.b bVar4 = i0Var.f32636h;
                    SVG.b bVar5 = i0Var.f32636h;
                    float[] fArr = {bVar3.f32622e, bVar3.f32623f, bVar3.d(), bVar4.f32623f, bVar4.d(), i0Var.f32636h.e(), bVar5.f32622e, bVar5.e()};
                    matrix2.mapPoints(fArr);
                    RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
                    for (int i2 = 2; i2 <= 6; i2 += 2) {
                        if (fArr[i2] < rectF.left) {
                            rectF.left = fArr[i2];
                        }
                        if (fArr[i2] > rectF.right) {
                            rectF.right = fArr[i2];
                        }
                        int i3 = i2 + 1;
                        if (fArr[i3] < rectF.top) {
                            rectF.top = fArr[i3];
                        }
                        if (fArr[i3] > rectF.bottom) {
                            rectF.bottom = fArr[i3];
                        }
                    }
                    float f11 = rectF.left;
                    float f12 = rectF.top;
                    bVar2 = new SVG.b(f11, f12, rectF.right - f11, rectF.bottom - f12);
                }
            }
            float floor = f2 + (((float) Math.floor((bVar2.f32622e - f2) / f5)) * f5);
            float d2 = bVar2.d();
            float e2 = bVar2.e();
            SVG.b bVar6 = new SVG.b(0.0f, 0.0f, f5, f3);
            for (float floor2 = f4 + (((float) Math.floor((bVar2.f32623f - f4) / f3)) * f3); floor2 < e2; floor2 += f3) {
                for (float f13 = floor; f13 < d2; f13 += f5) {
                    bVar6.f32622e = f13;
                    bVar6.f32623f = floor2;
                    S0();
                    if (!this.f69513f.f69546e.z.booleanValue()) {
                        O0(bVar6.f32622e, bVar6.f32623f, bVar6.f32624g, bVar6.f32625h);
                    }
                    SVG.b bVar7 = xVar.o;
                    if (bVar7 != null) {
                        this.f69508a.concat(s(bVar6, bVar7, preserveAspectRatio));
                    } else {
                        Boolean bool2 = xVar.q;
                        boolean z2 = bool2 == null || bool2.booleanValue();
                        this.f69508a.translate(f13, floor2);
                        if (!z2) {
                            Canvas canvas = this.f69508a;
                            SVG.b bVar8 = i0Var.f32636h;
                            canvas.scale(bVar8.f32624g, bVar8.f32625h);
                        }
                    }
                    boolean n0 = n0();
                    for (SVG.l0 l0Var : xVar.f32633i) {
                        A0(l0Var);
                    }
                    if (n0) {
                        k0(xVar);
                    }
                    R0();
                }
            }
            R0();
        }
    }

    public final void P0(h hVar, boolean z, SVG.m0 m0Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{hVar, Boolean.valueOf(z), m0Var}) == null) {
            SVG.Style style = hVar.f69546e;
            float floatValue = (z ? style.f32617h : style.j).floatValue();
            if (m0Var instanceof SVG.f) {
                i2 = ((SVG.f) m0Var).f32632e;
            } else if (!(m0Var instanceof SVG.g)) {
                return;
            } else {
                i2 = hVar.f69546e.r.f32632e;
            }
            int z2 = i2 | (z(floatValue) << 24);
            if (z) {
                hVar.f69549h.setColor(z2);
            } else {
                hVar.f69550i.setColor(z2);
            }
        }
    }

    public final h Q(SVG.l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, l0Var)) == null) {
            h hVar = new h(this);
            V0(hVar, SVG.Style.d());
            R(l0Var, hVar);
            return hVar;
        }
        return (h) invokeL.objValue;
    }

    public final void Q0(boolean z, SVG.b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, b0Var) == null) {
            if (z) {
                if (a0(b0Var.f32641e, 2147483648L)) {
                    h hVar = this.f69513f;
                    SVG.Style style = hVar.f69546e;
                    SVG.m0 m0Var = b0Var.f32641e.L;
                    style.f32615f = m0Var;
                    hVar.f69547f = m0Var != null;
                }
                if (a0(b0Var.f32641e, 4294967296L)) {
                    this.f69513f.f69546e.f32617h = b0Var.f32641e.M;
                }
                if (a0(b0Var.f32641e, 6442450944L)) {
                    h hVar2 = this.f69513f;
                    P0(hVar2, z, hVar2.f69546e.f32615f);
                    return;
                }
                return;
            }
            if (a0(b0Var.f32641e, 2147483648L)) {
                h hVar3 = this.f69513f;
                SVG.Style style2 = hVar3.f69546e;
                SVG.m0 m0Var2 = b0Var.f32641e.L;
                style2.f32618i = m0Var2;
                hVar3.f69548g = m0Var2 != null;
            }
            if (a0(b0Var.f32641e, 4294967296L)) {
                this.f69513f.f69546e.j = b0Var.f32641e.M;
            }
            if (a0(b0Var.f32641e, 6442450944L)) {
                h hVar4 = this.f69513f;
                P0(hVar4, z, hVar4.f69546e.f32618i);
            }
        }
    }

    public final h R(SVG.l0 l0Var, h hVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, l0Var, hVar)) == null) {
            ArrayList<SVG.j0> arrayList = new ArrayList();
            while (true) {
                if (l0Var instanceof SVG.j0) {
                    arrayList.add(0, (SVG.j0) l0Var);
                }
                SVG.h0 h0Var = l0Var.f32645b;
                if (h0Var == null) {
                    break;
                }
                l0Var = (SVG.l0) h0Var;
            }
            for (SVG.j0 j0Var : arrayList) {
                W0(hVar, j0Var);
            }
            SVG.b bVar = this.f69512e.j().o;
            hVar.k = bVar;
            if (bVar == null) {
                hVar.k = this.f69509b;
            }
            hVar.j = this.f69509b;
            hVar.m = this.f69513f.m;
            return hVar;
        }
        return (h) invokeLL.objValue;
    }

    public final void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.f69508a.restore();
            this.f69513f = this.f69514g.pop();
        }
    }

    public final SVG.Style.TextAnchor S() {
        InterceptResult invokeV;
        SVG.Style.TextAnchor textAnchor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            SVG.Style style = this.f69513f.f69546e;
            if (style.x != SVG.Style.TextDirection.LTR && (textAnchor = style.y) != SVG.Style.TextAnchor.Middle) {
                SVG.Style.TextAnchor textAnchor2 = SVG.Style.TextAnchor.Start;
                return textAnchor == textAnchor2 ? SVG.Style.TextAnchor.End : textAnchor2;
            }
            return this.f69513f.f69546e.y;
        }
        return (SVG.Style.TextAnchor) invokeV.objValue;
    }

    public final void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.f69508a.save();
            this.f69514g.push(this.f69513f);
            this.f69513f = (h) this.f69513f.clone();
        }
    }

    public final Path.FillType T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            SVG.Style.FillRule fillRule = this.f69513f.f69546e.J;
            if (fillRule == null) {
                return Path.FillType.WINDING;
            }
            if (a.f69520d[fillRule.ordinal()] != 1) {
                return Path.FillType.WINDING;
            }
            return Path.FillType.EVEN_ODD;
        }
        return (Path.FillType) invokeV.objValue;
    }

    public final String T0(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048613, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.f69513f.l) {
                return str.replaceAll("[\\n\\t]", " ");
            }
            String replaceAll = str.replaceAll("\\n", "").replaceAll("\\t", " ");
            if (z) {
                replaceAll = replaceAll.replaceAll("^\\s+", "");
            }
            if (z2) {
                replaceAll = replaceAll.replaceAll("\\s+$", "");
            }
            return replaceAll.replaceAll("\\s{2,}", " ");
        }
        return (String) invokeCommon.objValue;
    }

    public float U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f69513f.f69549h.getTextSize() : invokeV.floatValue;
    }

    public final void U0(SVG.i0 i0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, i0Var) == null) || i0Var.f32645b == null || i0Var.f32636h == null) {
            return;
        }
        Matrix matrix = new Matrix();
        if (this.f69516i.peek().invert(matrix)) {
            SVG.b bVar = i0Var.f32636h;
            SVG.b bVar2 = i0Var.f32636h;
            SVG.b bVar3 = i0Var.f32636h;
            float[] fArr = {bVar.f32622e, bVar.f32623f, bVar.d(), bVar2.f32623f, bVar2.d(), i0Var.f32636h.e(), bVar3.f32622e, bVar3.e()};
            matrix.preConcat(this.f69508a.getMatrix());
            matrix.mapPoints(fArr);
            RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
            for (int i2 = 2; i2 <= 6; i2 += 2) {
                if (fArr[i2] < rectF.left) {
                    rectF.left = fArr[i2];
                }
                if (fArr[i2] > rectF.right) {
                    rectF.right = fArr[i2];
                }
                int i3 = i2 + 1;
                if (fArr[i3] < rectF.top) {
                    rectF.top = fArr[i3];
                }
                if (fArr[i3] > rectF.bottom) {
                    rectF.bottom = fArr[i3];
                }
            }
            SVG.i0 i0Var2 = (SVG.i0) this.f69515h.peek();
            SVG.b bVar4 = i0Var2.f32636h;
            if (bVar4 == null) {
                i0Var2.f32636h = SVG.b.a(rectF.left, rectF.top, rectF.right, rectF.bottom);
            } else {
                bVar4.f(SVG.b.a(rectF.left, rectF.top, rectF.right, rectF.bottom));
            }
        }
    }

    public float V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f69513f.f69549h.getTextSize() / 2.0f : invokeV.floatValue;
    }

    public final void V0(h hVar, SVG.Style style) {
        SVG svg;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, hVar, style) == null) {
            if (a0(style, 4096L)) {
                hVar.f69546e.r = style.r;
            }
            if (a0(style, 2048L)) {
                hVar.f69546e.q = style.q;
            }
            if (a0(style, 1L)) {
                hVar.f69546e.f32615f = style.f32615f;
                hVar.f69547f = style.f32615f != null;
            }
            if (a0(style, 4L)) {
                hVar.f69546e.f32617h = style.f32617h;
            }
            if (a0(style, 6149L)) {
                P0(hVar, true, hVar.f69546e.f32615f);
            }
            if (a0(style, 2L)) {
                hVar.f69546e.f32616g = style.f32616g;
            }
            if (a0(style, 8L)) {
                hVar.f69546e.f32618i = style.f32618i;
                hVar.f69548g = style.f32618i != null;
            }
            if (a0(style, 16L)) {
                hVar.f69546e.j = style.j;
            }
            if (a0(style, 6168L)) {
                P0(hVar, false, hVar.f69546e.f32618i);
            }
            if (a0(style, 34359738368L)) {
                hVar.f69546e.P = style.P;
            }
            if (a0(style, 32L)) {
                SVG.Style style2 = hVar.f69546e;
                SVG.o oVar = style.k;
                style2.k = oVar;
                hVar.f69550i.setStrokeWidth(oVar.f(this));
            }
            if (a0(style, 64L)) {
                hVar.f69546e.l = style.l;
                int i2 = a.f69518b[style.l.ordinal()];
                if (i2 == 1) {
                    hVar.f69550i.setStrokeCap(Paint.Cap.BUTT);
                } else if (i2 == 2) {
                    hVar.f69550i.setStrokeCap(Paint.Cap.ROUND);
                } else if (i2 == 3) {
                    hVar.f69550i.setStrokeCap(Paint.Cap.SQUARE);
                }
            }
            if (a0(style, 128L)) {
                hVar.f69546e.m = style.m;
                int i3 = a.f69519c[style.m.ordinal()];
                if (i3 == 1) {
                    hVar.f69550i.setStrokeJoin(Paint.Join.MITER);
                } else if (i3 == 2) {
                    hVar.f69550i.setStrokeJoin(Paint.Join.ROUND);
                } else if (i3 == 3) {
                    hVar.f69550i.setStrokeJoin(Paint.Join.BEVEL);
                }
            }
            if (a0(style, 256L)) {
                hVar.f69546e.n = style.n;
                hVar.f69550i.setStrokeMiter(style.n.floatValue());
            }
            if (a0(style, 512L)) {
                hVar.f69546e.o = style.o;
            }
            if (a0(style, 1024L)) {
                hVar.f69546e.p = style.p;
            }
            Typeface typeface = null;
            if (a0(style, 1536L)) {
                SVG.o[] oVarArr = hVar.f69546e.o;
                if (oVarArr == null) {
                    hVar.f69550i.setPathEffect(null);
                } else {
                    int length = oVarArr.length;
                    int i4 = length % 2 == 0 ? length : length * 2;
                    float[] fArr = new float[i4];
                    float f2 = 0.0f;
                    for (int i5 = 0; i5 < i4; i5++) {
                        fArr[i5] = hVar.f69546e.o[i5 % length].f(this);
                        f2 += fArr[i5];
                    }
                    if (f2 == 0.0f) {
                        hVar.f69550i.setPathEffect(null);
                    } else {
                        float f3 = hVar.f69546e.p.f(this);
                        if (f3 < 0.0f) {
                            f3 = (f3 % f2) + f2;
                        }
                        hVar.f69550i.setPathEffect(new DashPathEffect(fArr, f3));
                    }
                }
            }
            if (a0(style, 16384L)) {
                float U = U();
                hVar.f69546e.t = style.t;
                hVar.f69549h.setTextSize(style.t.g(this, U));
                hVar.f69550i.setTextSize(style.t.g(this, U));
            }
            if (a0(style, 8192L)) {
                hVar.f69546e.s = style.s;
            }
            if (a0(style, 32768L)) {
                if (style.u.intValue() == -1 && hVar.f69546e.u.intValue() > 100) {
                    SVG.Style style3 = hVar.f69546e;
                    style3.u = Integer.valueOf(style3.u.intValue() - 100);
                } else if (style.u.intValue() == 1 && hVar.f69546e.u.intValue() < 900) {
                    SVG.Style style4 = hVar.f69546e;
                    style4.u = Integer.valueOf(style4.u.intValue() + 100);
                } else {
                    hVar.f69546e.u = style.u;
                }
            }
            if (a0(style, 65536L)) {
                hVar.f69546e.v = style.v;
            }
            if (a0(style, 106496L)) {
                if (hVar.f69546e.s != null && (svg = this.f69512e) != null) {
                    d.c.a.d e2 = svg.e();
                    for (String str : hVar.f69546e.s) {
                        SVG.Style style5 = hVar.f69546e;
                        Typeface x = x(str, style5.u, style5.v);
                        if (x != null || e2 == null) {
                            typeface = x;
                            continue;
                        } else {
                            typeface = e2.b(str, hVar.f69546e.u.intValue(), String.valueOf(hVar.f69546e.v));
                            continue;
                        }
                        if (typeface != null) {
                            break;
                        }
                    }
                }
                if (typeface == null) {
                    SVG.Style style6 = hVar.f69546e;
                    typeface = x(TypefaceCompatApi28Impl.DEFAULT_FAMILY, style6.u, style6.v);
                }
                hVar.f69549h.setTypeface(typeface);
                hVar.f69550i.setTypeface(typeface);
            }
            if (a0(style, PlaybackStateCompat.ACTION_PREPARE_FROM_URI)) {
                hVar.f69546e.w = style.w;
                hVar.f69549h.setStrikeThruText(style.w == SVG.Style.TextDecoration.LineThrough);
                hVar.f69549h.setUnderlineText(style.w == SVG.Style.TextDecoration.Underline);
                if (Build.VERSION.SDK_INT >= 17) {
                    hVar.f69550i.setStrikeThruText(style.w == SVG.Style.TextDecoration.LineThrough);
                    hVar.f69550i.setUnderlineText(style.w == SVG.Style.TextDecoration.Underline);
                }
            }
            if (a0(style, 68719476736L)) {
                hVar.f69546e.x = style.x;
            }
            if (a0(style, PlaybackStateCompat.ACTION_SET_REPEAT_MODE)) {
                hVar.f69546e.y = style.y;
            }
            if (a0(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
                hVar.f69546e.z = style.z;
            }
            if (a0(style, 2097152L)) {
                hVar.f69546e.B = style.B;
            }
            if (a0(style, 4194304L)) {
                hVar.f69546e.C = style.C;
            }
            if (a0(style, 8388608L)) {
                hVar.f69546e.D = style.D;
            }
            if (a0(style, 16777216L)) {
                hVar.f69546e.E = style.E;
            }
            if (a0(style, 33554432L)) {
                hVar.f69546e.F = style.F;
            }
            if (a0(style, 1048576L)) {
                hVar.f69546e.A = style.A;
            }
            if (a0(style, AccountConstants.TYPE_MODIFY_NICKNAME)) {
                hVar.f69546e.I = style.I;
            }
            if (a0(style, 536870912L)) {
                hVar.f69546e.J = style.J;
            }
            if (a0(style, 1073741824L)) {
                hVar.f69546e.K = style.K;
            }
            if (a0(style, 67108864L)) {
                hVar.f69546e.G = style.G;
            }
            if (a0(style, 134217728L)) {
                hVar.f69546e.H = style.H;
            }
            if (a0(style, AnimatedStateListDrawableCompat.AnimatedStateListState.REVERSIBLE_FLAG_BIT)) {
                hVar.f69546e.N = style.N;
            }
            if (a0(style, 17179869184L)) {
                hVar.f69546e.O = style.O;
            }
        }
    }

    public SVG.b W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            h hVar = this.f69513f;
            SVG.b bVar = hVar.k;
            return bVar != null ? bVar : hVar.j;
        }
        return (SVG.b) invokeV.objValue;
    }

    public final void W0(h hVar, SVG.j0 j0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, hVar, j0Var) == null) {
            hVar.f69546e.e(j0Var.f32645b == null);
            SVG.Style style = j0Var.f32641e;
            if (style != null) {
                V0(hVar, style);
            }
            if (this.f69512e.k()) {
                for (CSSParser.d dVar : this.f69512e.b()) {
                    if (CSSParser.m(dVar.f32596a, j0Var)) {
                        V0(hVar, dVar.f32597b);
                    }
                }
            }
            SVG.Style style2 = j0Var.f32642f;
            if (style2 != null) {
                V0(hVar, style2);
            }
        }
    }

    public float X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.f69510c : invokeV.floatValue;
    }

    public final void X0() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            SVG.Style style = this.f69513f.f69546e;
            SVG.m0 m0Var = style.N;
            if (m0Var instanceof SVG.f) {
                i2 = ((SVG.f) m0Var).f32632e;
            } else if (!(m0Var instanceof SVG.g)) {
                return;
            } else {
                i2 = style.r.f32632e;
            }
            Float f2 = this.f69513f.f69546e.O;
            if (f2 != null) {
                i2 |= z(f2.floatValue()) << 24;
            }
            this.f69508a.drawColor(i2);
        }
    }

    public final Path.FillType Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            SVG.Style.FillRule fillRule = this.f69513f.f69546e.f32616g;
            if (fillRule == null) {
                return Path.FillType.WINDING;
            }
            if (a.f69520d[fillRule.ordinal()] != 1) {
                return Path.FillType.WINDING;
            }
            return Path.FillType.EVEN_ODD;
        }
        return (Path.FillType) invokeV.objValue;
    }

    public final boolean Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            Boolean bool = this.f69513f.f69546e.F;
            if (bool != null) {
                return bool.booleanValue();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean a0(SVG.Style style, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048624, this, style, j2)) == null) ? (style.f32614e & j2) != 0 : invokeLJ.booleanValue;
    }

    public final void b0(boolean z, SVG.b bVar, SVG.k0 k0Var) {
        float g2;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Boolean.valueOf(z), bVar, k0Var}) == null) {
            String str = k0Var.l;
            if (str != null) {
                L(k0Var, str);
            }
            Boolean bool = k0Var.f32638i;
            int i2 = 0;
            boolean z2 = bool != null && bool.booleanValue();
            h hVar = this.f69513f;
            Paint paint = z ? hVar.f69549h : hVar.f69550i;
            if (z2) {
                SVG.b W = W();
                SVG.o oVar = k0Var.m;
                float h2 = oVar != null ? oVar.h(this) : 0.0f;
                SVG.o oVar2 = k0Var.n;
                float i3 = oVar2 != null ? oVar2.i(this) : 0.0f;
                SVG.o oVar3 = k0Var.o;
                float h3 = oVar3 != null ? oVar3.h(this) : W.f32624g;
                SVG.o oVar4 = k0Var.p;
                g2 = oVar4 != null ? oVar4.i(this) : 0.0f;
                f4 = h3;
                f2 = h2;
                f3 = i3;
            } else {
                SVG.o oVar5 = k0Var.m;
                float g3 = oVar5 != null ? oVar5.g(this, 1.0f) : 0.0f;
                SVG.o oVar6 = k0Var.n;
                float g4 = oVar6 != null ? oVar6.g(this, 1.0f) : 0.0f;
                SVG.o oVar7 = k0Var.o;
                float g5 = oVar7 != null ? oVar7.g(this, 1.0f) : 1.0f;
                SVG.o oVar8 = k0Var.p;
                g2 = oVar8 != null ? oVar8.g(this, 1.0f) : 0.0f;
                f2 = g3;
                f3 = g4;
                f4 = g5;
            }
            S0();
            this.f69513f = Q(k0Var);
            Matrix matrix = new Matrix();
            if (!z2) {
                matrix.preTranslate(bVar.f32622e, bVar.f32623f);
                matrix.preScale(bVar.f32624g, bVar.f32625h);
            }
            Matrix matrix2 = k0Var.j;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            int size = k0Var.f32637h.size();
            if (size == 0) {
                R0();
                if (z) {
                    this.f69513f.f69547f = false;
                    return;
                } else {
                    this.f69513f.f69548g = false;
                    return;
                }
            }
            int[] iArr = new int[size];
            float[] fArr = new float[size];
            float f5 = -1.0f;
            Iterator<SVG.l0> it = k0Var.f32637h.iterator();
            while (it.hasNext()) {
                SVG.c0 c0Var = (SVG.c0) it.next();
                if (i2 != 0 && c0Var.f32630h.floatValue() < f5) {
                    fArr[i2] = f5;
                } else {
                    fArr[i2] = c0Var.f32630h.floatValue();
                    f5 = c0Var.f32630h.floatValue();
                }
                S0();
                W0(this.f69513f, c0Var);
                SVG.f fVar = (SVG.f) this.f69513f.f69546e.G;
                if (fVar == null) {
                    fVar = SVG.f.f32631f;
                }
                iArr[i2] = fVar.f32632e | (z(this.f69513f.f69546e.H.floatValue()) << 24);
                i2++;
                R0();
            }
            if ((f2 == f4 && f3 == g2) || size == 1) {
                R0();
                paint.setColor(iArr[size - 1]);
                return;
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            SVG.GradientSpread gradientSpread = k0Var.k;
            if (gradientSpread != null) {
                if (gradientSpread == SVG.GradientSpread.reflect) {
                    tileMode = Shader.TileMode.MIRROR;
                } else if (gradientSpread == SVG.GradientSpread.repeat) {
                    tileMode = Shader.TileMode.REPEAT;
                }
            }
            R0();
            LinearGradient linearGradient = new LinearGradient(f2, f3, f4, g2, iArr, fArr, tileMode);
            linearGradient.setLocalMatrix(matrix);
            paint.setShader(linearGradient);
        }
    }

    public final Path c0(SVG.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, dVar)) == null) {
            SVG.o oVar = dVar.o;
            float h2 = oVar != null ? oVar.h(this) : 0.0f;
            SVG.o oVar2 = dVar.p;
            float i2 = oVar2 != null ? oVar2.i(this) : 0.0f;
            float f2 = dVar.q.f(this);
            float f3 = h2 - f2;
            float f4 = i2 - f2;
            float f5 = h2 + f2;
            float f6 = i2 + f2;
            if (dVar.f32636h == null) {
                float f7 = 2.0f * f2;
                dVar.f32636h = new SVG.b(f3, f4, f7, f7);
            }
            float f8 = 0.5522848f * f2;
            Path path = new Path();
            path.moveTo(h2, f4);
            float f9 = h2 + f8;
            float f10 = i2 - f8;
            path.cubicTo(f9, f4, f5, f10, f5, i2);
            float f11 = i2 + f8;
            path.cubicTo(f5, f11, f9, f6, h2, f6);
            float f12 = h2 - f8;
            path.cubicTo(f12, f6, f3, f11, f3, i2);
            path.cubicTo(f3, f10, f12, f4, h2, f4);
            path.close();
            return path;
        }
        return (Path) invokeL.objValue;
    }

    public final Path d0(SVG.i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, iVar)) == null) {
            SVG.o oVar = iVar.o;
            float h2 = oVar != null ? oVar.h(this) : 0.0f;
            SVG.o oVar2 = iVar.p;
            float i2 = oVar2 != null ? oVar2.i(this) : 0.0f;
            float h3 = iVar.q.h(this);
            float i3 = iVar.r.i(this);
            float f2 = h2 - h3;
            float f3 = i2 - i3;
            float f4 = h2 + h3;
            float f5 = i2 + i3;
            if (iVar.f32636h == null) {
                iVar.f32636h = new SVG.b(f2, f3, h3 * 2.0f, 2.0f * i3);
            }
            float f6 = h3 * 0.5522848f;
            float f7 = 0.5522848f * i3;
            Path path = new Path();
            path.moveTo(h2, f3);
            float f8 = h2 + f6;
            float f9 = i2 - f7;
            path.cubicTo(f8, f3, f4, f9, f4, i2);
            float f10 = f7 + i2;
            path.cubicTo(f4, f10, f8, f5, h2, f5);
            float f11 = h2 - f6;
            path.cubicTo(f11, f5, f2, f10, f2, i2);
            path.cubicTo(f2, f9, f11, f3, h2, f3);
            path.close();
            return path;
        }
        return (Path) invokeL.objValue;
    }

    public final Path e0(SVG.p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, pVar)) == null) {
            SVG.o oVar = pVar.o;
            float h2 = oVar == null ? 0.0f : oVar.h(this);
            SVG.o oVar2 = pVar.p;
            float i2 = oVar2 == null ? 0.0f : oVar2.i(this);
            SVG.o oVar3 = pVar.q;
            float h3 = oVar3 == null ? 0.0f : oVar3.h(this);
            SVG.o oVar4 = pVar.r;
            float i3 = oVar4 != null ? oVar4.i(this) : 0.0f;
            if (pVar.f32636h == null) {
                pVar.f32636h = new SVG.b(Math.min(h2, i2), Math.min(i2, i3), Math.abs(h3 - h2), Math.abs(i3 - i2));
            }
            Path path = new Path();
            path.moveTo(h2, i2);
            path.lineTo(h3, i3);
            return path;
        }
        return (Path) invokeL.objValue;
    }

    public final Path f0(SVG.y yVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, yVar)) == null) {
            Path path = new Path();
            float[] fArr = yVar.o;
            path.moveTo(fArr[0], fArr[1]);
            int i2 = 2;
            while (true) {
                float[] fArr2 = yVar.o;
                if (i2 >= fArr2.length) {
                    break;
                }
                path.lineTo(fArr2[i2], fArr2[i2 + 1]);
                i2 += 2;
            }
            if (yVar instanceof SVG.z) {
                path.close();
            }
            if (yVar.f32636h == null) {
                yVar.f32636h = q(path);
            }
            path.setFillType(T());
            return path;
        }
        return (Path) invokeL.objValue;
    }

    public final Path g0(SVG.a0 a0Var) {
        InterceptResult invokeL;
        float h2;
        float i2;
        Path path;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, a0Var)) == null) {
            if (a0Var.s == null && a0Var.t == null) {
                h2 = 0.0f;
                i2 = 0.0f;
            } else {
                SVG.o oVar = a0Var.s;
                if (oVar == null) {
                    h2 = a0Var.t.i(this);
                } else if (a0Var.t == null) {
                    h2 = oVar.h(this);
                } else {
                    h2 = oVar.h(this);
                    i2 = a0Var.t.i(this);
                }
                i2 = h2;
            }
            float min = Math.min(h2, a0Var.q.h(this) / 2.0f);
            float min2 = Math.min(i2, a0Var.r.i(this) / 2.0f);
            SVG.o oVar2 = a0Var.o;
            float h3 = oVar2 != null ? oVar2.h(this) : 0.0f;
            SVG.o oVar3 = a0Var.p;
            float i3 = oVar3 != null ? oVar3.i(this) : 0.0f;
            float h4 = a0Var.q.h(this);
            float i4 = a0Var.r.i(this);
            if (a0Var.f32636h == null) {
                a0Var.f32636h = new SVG.b(h3, i3, h4, i4);
            }
            float f2 = h3 + h4;
            float f3 = i3 + i4;
            Path path2 = new Path();
            if (min != 0.0f && min2 != 0.0f) {
                float f4 = min * 0.5522848f;
                float f5 = 0.5522848f * min2;
                float f6 = i3 + min2;
                path2.moveTo(h3, f6);
                float f7 = f6 - f5;
                float f8 = h3 + min;
                float f9 = f8 - f4;
                path2.cubicTo(h3, f7, f9, i3, f8, i3);
                float f10 = f2 - min;
                path2.lineTo(f10, i3);
                float f11 = f10 + f4;
                path2.cubicTo(f11, i3, f2, f7, f2, f6);
                float f12 = f3 - min2;
                path2.lineTo(f2, f12);
                float f13 = f12 + f5;
                path = path2;
                path2.cubicTo(f2, f13, f11, f3, f10, f3);
                path.lineTo(f8, f3);
                path.cubicTo(f9, f3, h3, f13, h3, f12);
                path.lineTo(h3, f6);
            } else {
                path = path2;
                path.moveTo(h3, i3);
                path.lineTo(f2, i3);
                path.lineTo(f2, f3);
                path.lineTo(h3, f3);
                path.lineTo(h3, i3);
            }
            path.close();
            return path;
        }
        return (Path) invokeL.objValue;
    }

    public final void h(SVG.k kVar, Path path, Matrix matrix) {
        Path f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048631, this, kVar, path, matrix) == null) {
            W0(this.f69513f, kVar);
            if (E() && Y0()) {
                Matrix matrix2 = kVar.n;
                if (matrix2 != null) {
                    matrix.preConcat(matrix2);
                }
                if (kVar instanceof SVG.a0) {
                    f0 = g0((SVG.a0) kVar);
                } else if (kVar instanceof SVG.d) {
                    f0 = c0((SVG.d) kVar);
                } else if (kVar instanceof SVG.i) {
                    f0 = d0((SVG.i) kVar);
                } else if (!(kVar instanceof SVG.y)) {
                    return;
                } else {
                    f0 = f0((SVG.y) kVar);
                }
                t(kVar);
                path.setFillType(f0.getFillType());
                path.addPath(f0, matrix);
            }
        }
    }

    public final void h0(boolean z, SVG.b bVar, SVG.o0 o0Var) {
        float f2;
        float g2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{Boolean.valueOf(z), bVar, o0Var}) == null) {
            String str = o0Var.l;
            if (str != null) {
                L(o0Var, str);
            }
            Boolean bool = o0Var.f32638i;
            int i2 = 0;
            boolean z2 = bool != null && bool.booleanValue();
            h hVar = this.f69513f;
            Paint paint = z ? hVar.f69549h : hVar.f69550i;
            if (z2) {
                SVG.o oVar = new SVG.o(50.0f, SVG.Unit.percent);
                SVG.o oVar2 = o0Var.m;
                float h2 = oVar2 != null ? oVar2.h(this) : oVar.h(this);
                SVG.o oVar3 = o0Var.n;
                float i3 = oVar3 != null ? oVar3.i(this) : oVar.i(this);
                SVG.o oVar4 = o0Var.o;
                g2 = oVar4 != null ? oVar4.f(this) : oVar.f(this);
                f2 = h2;
                f3 = i3;
            } else {
                SVG.o oVar5 = o0Var.m;
                float g3 = oVar5 != null ? oVar5.g(this, 1.0f) : 0.5f;
                SVG.o oVar6 = o0Var.n;
                float g4 = oVar6 != null ? oVar6.g(this, 1.0f) : 0.5f;
                SVG.o oVar7 = o0Var.o;
                f2 = g3;
                g2 = oVar7 != null ? oVar7.g(this, 1.0f) : 0.5f;
                f3 = g4;
            }
            S0();
            this.f69513f = Q(o0Var);
            Matrix matrix = new Matrix();
            if (!z2) {
                matrix.preTranslate(bVar.f32622e, bVar.f32623f);
                matrix.preScale(bVar.f32624g, bVar.f32625h);
            }
            Matrix matrix2 = o0Var.j;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            int size = o0Var.f32637h.size();
            if (size == 0) {
                R0();
                if (z) {
                    this.f69513f.f69547f = false;
                    return;
                } else {
                    this.f69513f.f69548g = false;
                    return;
                }
            }
            int[] iArr = new int[size];
            float[] fArr = new float[size];
            float f4 = -1.0f;
            Iterator<SVG.l0> it = o0Var.f32637h.iterator();
            while (it.hasNext()) {
                SVG.c0 c0Var = (SVG.c0) it.next();
                if (i2 != 0 && c0Var.f32630h.floatValue() < f4) {
                    fArr[i2] = f4;
                } else {
                    fArr[i2] = c0Var.f32630h.floatValue();
                    f4 = c0Var.f32630h.floatValue();
                }
                S0();
                W0(this.f69513f, c0Var);
                SVG.f fVar = (SVG.f) this.f69513f.f69546e.G;
                if (fVar == null) {
                    fVar = SVG.f.f32631f;
                }
                iArr[i2] = fVar.f32632e | (z(this.f69513f.f69546e.H.floatValue()) << 24);
                i2++;
                R0();
            }
            if (g2 != 0.0f && size != 1) {
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                SVG.GradientSpread gradientSpread = o0Var.k;
                if (gradientSpread != null) {
                    if (gradientSpread == SVG.GradientSpread.reflect) {
                        tileMode = Shader.TileMode.MIRROR;
                    } else if (gradientSpread == SVG.GradientSpread.repeat) {
                        tileMode = Shader.TileMode.REPEAT;
                    }
                }
                R0();
                RadialGradient radialGradient = new RadialGradient(f2, f3, g2, iArr, fArr, tileMode);
                radialGradient.setLocalMatrix(matrix);
                paint.setShader(radialGradient);
                return;
            }
            R0();
            paint.setColor(iArr[size - 1]);
        }
    }

    public final void i(SVG.u uVar, Path path, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048633, this, uVar, path, matrix) == null) {
            W0(this.f69513f, uVar);
            if (E() && Y0()) {
                Matrix matrix2 = uVar.n;
                if (matrix2 != null) {
                    matrix.preConcat(matrix2);
                }
                Path f2 = new d(this, uVar.o).f();
                if (uVar.f32636h == null) {
                    uVar.f32636h = q(f2);
                }
                t(uVar);
                path.setFillType(T());
                path.addPath(f2, matrix);
            }
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            this.f69515h.pop();
            this.f69516i.pop();
        }
    }

    public final void j(SVG.l0 l0Var, boolean z, Path path, Matrix matrix) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{l0Var, Boolean.valueOf(z), path, matrix}) == null) && E()) {
            B();
            if (l0Var instanceof SVG.b1) {
                if (z) {
                    l((SVG.b1) l0Var, path, matrix);
                } else {
                    J("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
            } else if (l0Var instanceof SVG.u) {
                i((SVG.u) l0Var, path, matrix);
            } else if (l0Var instanceof SVG.u0) {
                k((SVG.u0) l0Var, path, matrix);
            } else if (l0Var instanceof SVG.k) {
                h((SVG.k) l0Var, path, matrix);
            } else {
                J("Invalid %s element found in clipPath definition", l0Var.getClass().getSimpleName());
            }
            A();
        }
    }

    public final void j0(SVG.h0 h0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, h0Var) == null) {
            this.f69515h.push(h0Var);
            this.f69516i.push(this.f69508a.getMatrix());
        }
    }

    public final void k(SVG.u0 u0Var, Path path, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048637, this, u0Var, path, matrix) == null) {
            W0(this.f69513f, u0Var);
            if (E()) {
                Matrix matrix2 = u0Var.r;
                if (matrix2 != null) {
                    matrix.preConcat(matrix2);
                }
                List<SVG.o> list = u0Var.n;
                float f2 = 0.0f;
                float h2 = (list == null || list.size() == 0) ? 0.0f : u0Var.n.get(0).h(this);
                List<SVG.o> list2 = u0Var.o;
                float i2 = (list2 == null || list2.size() == 0) ? 0.0f : u0Var.o.get(0).i(this);
                List<SVG.o> list3 = u0Var.p;
                float h3 = (list3 == null || list3.size() == 0) ? 0.0f : u0Var.p.get(0).h(this);
                List<SVG.o> list4 = u0Var.q;
                if (list4 != null && list4.size() != 0) {
                    f2 = u0Var.q.get(0).i(this);
                }
                if (this.f69513f.f69546e.y != SVG.Style.TextAnchor.Start) {
                    float r = r(u0Var);
                    if (this.f69513f.f69546e.y == SVG.Style.TextAnchor.Middle) {
                        r /= 2.0f;
                    }
                    h2 -= r;
                }
                if (u0Var.f32636h == null) {
                    i iVar = new i(this, h2, i2);
                    I(u0Var, iVar);
                    RectF rectF = iVar.f69553c;
                    u0Var.f32636h = new SVG.b(rectF.left, rectF.top, rectF.width(), iVar.f69553c.height());
                }
                t(u0Var);
                Path path2 = new Path();
                I(u0Var, new g(this, h2 + h3, i2 + f2, path2));
                path.setFillType(T());
                path.addPath(path2, matrix);
            }
        }
    }

    public final void k0(SVG.i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, i0Var) == null) {
            h hVar = this.f69513f;
            String str = hVar.f69546e.K;
            if (str != null && hVar.m) {
                SVG.l0 n = this.f69512e.n(str);
                H();
                J0((SVG.r) n, i0Var);
                Bitmap l0 = l0();
                Canvas pop = this.j.pop();
                this.f69508a = pop;
                pop.save();
                this.f69508a.setMatrix(new Matrix());
                this.f69508a.drawBitmap(l0, 0.0f, 0.0f, this.f69513f.f69549h);
                l0.recycle();
                this.f69508a.restore();
            }
            R0();
        }
    }

    public final void l(SVG.b1 b1Var, Path path, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048639, this, b1Var, path, matrix) == null) {
            W0(this.f69513f, b1Var);
            if (E() && Y0()) {
                Matrix matrix2 = b1Var.n;
                if (matrix2 != null) {
                    matrix.preConcat(matrix2);
                }
                SVG.l0 n = b1Var.f32644a.n(b1Var.o);
                if (n == null) {
                    J("Use reference '%s' not found", b1Var.o);
                    return;
                }
                t(b1Var);
                j(n, false, path, matrix);
            }
        }
    }

    public final Bitmap l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            Bitmap pop = this.k.pop();
            Bitmap pop2 = this.k.pop();
            int width = pop.getWidth();
            int height = pop.getHeight();
            int[] iArr = new int[width];
            int[] iArr2 = new int[width];
            int i2 = 0;
            while (i2 < height) {
                pop.getPixels(iArr, 0, width, 0, i2, width, 1);
                int i3 = i2;
                pop2.getPixels(iArr2, 0, width, 0, i2, width, 1);
                for (int i4 = 0; i4 < width; i4++) {
                    int i5 = iArr[i4];
                    int i6 = i5 & 255;
                    int i7 = (i5 >> 8) & 255;
                    int i8 = (i5 >> 16) & 255;
                    int i9 = (i5 >> 24) & 255;
                    if (i9 == 0) {
                        iArr2[i4] = 0;
                    } else {
                        int i10 = iArr2[i4];
                        iArr2[i4] = (i10 & 16777215) | (((((i10 >> 24) & 255) * (((((i8 * 6963) + (i7 * 23442)) + (i6 * 2362)) * i9) / 8355840)) / 255) << 24);
                    }
                }
                pop2.setPixels(iArr2, 0, width, 0, i3, width, 1);
                i2 = i3 + 1;
            }
            pop.recycle();
            return pop2;
        }
        return (Bitmap) invokeV.objValue;
    }

    public final void m0(SVG.l0 l0Var, j jVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048641, this, l0Var, jVar) == null) && jVar.a((SVG.w0) l0Var)) {
            if (l0Var instanceof SVG.x0) {
                S0();
                L0((SVG.x0) l0Var);
                R0();
            } else if (l0Var instanceof SVG.t0) {
                C("TSpan render", new Object[0]);
                S0();
                SVG.t0 t0Var = (SVG.t0) l0Var;
                W0(this.f69513f, t0Var);
                if (E()) {
                    boolean z = jVar instanceof f;
                    float f6 = 0.0f;
                    if (z) {
                        List<SVG.o> list = t0Var.n;
                        if (list != null && list.size() != 0) {
                            f5 = t0Var.n.get(0).h(this);
                        } else {
                            f5 = ((f) jVar).f69539a;
                        }
                        List<SVG.o> list2 = t0Var.o;
                        if (list2 != null && list2.size() != 0) {
                            f3 = t0Var.o.get(0).i(this);
                        } else {
                            f3 = ((f) jVar).f69540b;
                        }
                        List<SVG.o> list3 = t0Var.p;
                        f4 = (list3 == null || list3.size() == 0) ? 0.0f : t0Var.p.get(0).h(this);
                        List<SVG.o> list4 = t0Var.q;
                        if (list4 != null && list4.size() != 0) {
                            f6 = t0Var.q.get(0).i(this);
                        }
                        f2 = f6;
                        f6 = f5;
                    } else {
                        f2 = 0.0f;
                        f3 = 0.0f;
                        f4 = 0.0f;
                    }
                    v((SVG.i0) t0Var.c());
                    if (z) {
                        f fVar = (f) jVar;
                        fVar.f69539a = f6 + f4;
                        fVar.f69540b = f3 + f2;
                    }
                    boolean n0 = n0();
                    I(t0Var, jVar);
                    if (n0) {
                        k0(t0Var);
                    }
                }
                R0();
            } else if (l0Var instanceof SVG.s0) {
                S0();
                SVG.s0 s0Var = (SVG.s0) l0Var;
                W0(this.f69513f, s0Var);
                if (E()) {
                    v((SVG.i0) s0Var.c());
                    SVG.l0 n = l0Var.f32644a.n(s0Var.n);
                    if (n == null || !(n instanceof SVG.w0)) {
                        J("Tref reference '%s' not found", s0Var.n);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        K((SVG.w0) n, sb);
                        if (sb.length() > 0) {
                            jVar.b(sb.toString());
                        }
                    }
                }
                R0();
            }
        }
    }

    public final boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            if (M0()) {
                this.f69508a.saveLayerAlpha(null, z(this.f69513f.f69546e.q.floatValue()), 31);
                this.f69514g.push(this.f69513f);
                h hVar = (h) this.f69513f.clone();
                this.f69513f = hVar;
                String str = hVar.f69546e.K;
                if (str != null && hVar.m) {
                    SVG.l0 n = this.f69512e.n(str);
                    if (n != null && (n instanceof SVG.r)) {
                        this.j.push(this.f69508a);
                        H();
                    } else {
                        J("Mask reference '%s' not found", this.f69513f.f69546e.K);
                        this.f69513f.f69546e.K = null;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final List<C1966c> o(SVG.p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, pVar)) == null) {
            SVG.o oVar = pVar.o;
            float h2 = oVar != null ? oVar.h(this) : 0.0f;
            SVG.o oVar2 = pVar.p;
            float i2 = oVar2 != null ? oVar2.i(this) : 0.0f;
            SVG.o oVar3 = pVar.q;
            float h3 = oVar3 != null ? oVar3.h(this) : 0.0f;
            SVG.o oVar4 = pVar.r;
            float i3 = oVar4 != null ? oVar4.i(this) : 0.0f;
            ArrayList arrayList = new ArrayList(2);
            float f2 = h3 - h2;
            float f3 = i3 - i2;
            arrayList.add(new C1966c(this, h2, i2, f2, f3));
            arrayList.add(new C1966c(this, h3, i3, f2, f3));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void o0(SVG.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, dVar) == null) {
            C("Circle render", new Object[0]);
            SVG.o oVar = dVar.q;
            if (oVar == null || oVar.k()) {
                return;
            }
            W0(this.f69513f, dVar);
            if (E() && Y0()) {
                Matrix matrix = dVar.n;
                if (matrix != null) {
                    this.f69508a.concat(matrix);
                }
                Path c0 = c0(dVar);
                U0(dVar);
                v(dVar);
                t(dVar);
                boolean n0 = n0();
                if (this.f69513f.f69547f) {
                    F(dVar, c0);
                }
                if (this.f69513f.f69548g) {
                    G(c0);
                }
                if (n0) {
                    k0(dVar);
                }
            }
        }
    }

    public final List<C1966c> p(SVG.y yVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, yVar)) == null) {
            int length = yVar.o.length;
            int i2 = 2;
            if (length < 2) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            float[] fArr = yVar.o;
            C1966c c1966c = new C1966c(this, fArr[0], fArr[1], 0.0f, 0.0f);
            float f2 = 0.0f;
            float f3 = 0.0f;
            while (i2 < length) {
                float[] fArr2 = yVar.o;
                float f4 = fArr2[i2];
                float f5 = fArr2[i2 + 1];
                c1966c.a(f4, f5);
                arrayList.add(c1966c);
                i2 += 2;
                c1966c = new C1966c(this, f4, f5, f4 - c1966c.f69530a, f5 - c1966c.f69531b);
                f3 = f5;
                f2 = f4;
            }
            if (yVar instanceof SVG.z) {
                float[] fArr3 = yVar.o;
                if (f2 != fArr3[0] && f3 != fArr3[1]) {
                    float f6 = fArr3[0];
                    float f7 = fArr3[1];
                    c1966c.a(f6, f7);
                    arrayList.add(c1966c);
                    C1966c c1966c2 = new C1966c(this, f6, f7, f6 - c1966c.f69530a, f7 - c1966c.f69531b);
                    c1966c2.b((C1966c) arrayList.get(0));
                    arrayList.add(c1966c2);
                    arrayList.set(0, c1966c2);
                }
            } else {
                arrayList.add(c1966c);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void p0(SVG.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, iVar) == null) {
            C("Ellipse render", new Object[0]);
            SVG.o oVar = iVar.q;
            if (oVar == null || iVar.r == null || oVar.k() || iVar.r.k()) {
                return;
            }
            W0(this.f69513f, iVar);
            if (E() && Y0()) {
                Matrix matrix = iVar.n;
                if (matrix != null) {
                    this.f69508a.concat(matrix);
                }
                Path d0 = d0(iVar);
                U0(iVar);
                v(iVar);
                t(iVar);
                boolean n0 = n0();
                if (this.f69513f.f69547f) {
                    F(iVar, d0);
                }
                if (this.f69513f.f69548g) {
                    G(d0);
                }
                if (n0) {
                    k0(iVar);
                }
            }
        }
    }

    public final SVG.b q(Path path) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, path)) == null) {
            RectF rectF = new RectF();
            path.computeBounds(rectF, true);
            return new SVG.b(rectF.left, rectF.top, rectF.width(), rectF.height());
        }
        return (SVG.b) invokeL.objValue;
    }

    public final void q0(SVG.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, lVar) == null) {
            C("Group render", new Object[0]);
            W0(this.f69513f, lVar);
            if (E()) {
                Matrix matrix = lVar.n;
                if (matrix != null) {
                    this.f69508a.concat(matrix);
                }
                t(lVar);
                boolean n0 = n0();
                F0(lVar, true);
                if (n0) {
                    k0(lVar);
                }
                U0(lVar);
            }
        }
    }

    public final float r(SVG.w0 w0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, w0Var)) == null) {
            k kVar = new k(this, null);
            I(w0Var, kVar);
            return kVar.f69555a;
        }
        return invokeL.floatValue;
    }

    public final void r0(SVG.n nVar) {
        SVG.o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, nVar) == null) {
            C("Image render", new Object[0]);
            SVG.o oVar2 = nVar.r;
            if (oVar2 == null || oVar2.k() || (oVar = nVar.s) == null || oVar.k() || nVar.o == null) {
                return;
            }
            PreserveAspectRatio preserveAspectRatio = nVar.n;
            if (preserveAspectRatio == null) {
                preserveAspectRatio = PreserveAspectRatio.f32606d;
            }
            Bitmap w = w(nVar.o);
            if (w == null) {
                d.c.a.d e2 = this.f69512e.e();
                if (e2 == null) {
                    return;
                }
                w = e2.c(nVar.o);
            }
            if (w == null) {
                J("Could not locate image '%s'", nVar.o);
                return;
            }
            W0(this.f69513f, nVar);
            if (E() && Y0()) {
                Matrix matrix = nVar.t;
                if (matrix != null) {
                    this.f69508a.concat(matrix);
                }
                SVG.o oVar3 = nVar.p;
                float h2 = oVar3 != null ? oVar3.h(this) : 0.0f;
                SVG.o oVar4 = nVar.q;
                this.f69513f.j = new SVG.b(h2, oVar4 != null ? oVar4.i(this) : 0.0f, nVar.r.h(this), nVar.s.h(this));
                if (!this.f69513f.f69546e.z.booleanValue()) {
                    SVG.b bVar = this.f69513f.j;
                    O0(bVar.f32622e, bVar.f32623f, bVar.f32624g, bVar.f32625h);
                }
                SVG.b bVar2 = new SVG.b(0.0f, 0.0f, w.getWidth(), w.getHeight());
                nVar.f32636h = bVar2;
                this.f69508a.concat(s(this.f69513f.j, bVar2, preserveAspectRatio));
                U0(nVar);
                t(nVar);
                boolean n0 = n0();
                X0();
                this.f69508a.drawBitmap(w, 0.0f, 0.0f, new Paint());
                if (n0) {
                    k0(nVar);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0088, code lost:
        if (r11 != 8) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Matrix s(SVG.b bVar, SVG.b bVar2, PreserveAspectRatio preserveAspectRatio) {
        InterceptResult invokeLLL;
        int i2;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048651, this, bVar, bVar2, preserveAspectRatio)) == null) {
            Matrix matrix = new Matrix();
            if (preserveAspectRatio != null && preserveAspectRatio.a() != null) {
                float f4 = bVar.f32624g / bVar2.f32624g;
                float f5 = bVar.f32625h / bVar2.f32625h;
                float f6 = -bVar2.f32622e;
                float f7 = -bVar2.f32623f;
                if (preserveAspectRatio.equals(PreserveAspectRatio.f32605c)) {
                    matrix.preTranslate(bVar.f32622e, bVar.f32623f);
                    matrix.preScale(f4, f5);
                    matrix.preTranslate(f6, f7);
                    return matrix;
                }
                float max = preserveAspectRatio.b() == PreserveAspectRatio.Scale.Slice ? Math.max(f4, f5) : Math.min(f4, f5);
                float f8 = bVar.f32624g / max;
                float f9 = bVar.f32625h / max;
                switch (a.f69517a[preserveAspectRatio.a().ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        f3 = (bVar2.f32624g - f8) / 2.0f;
                        f6 -= f3;
                        i2 = a.f69517a[preserveAspectRatio.a().ordinal()];
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 != 5) {
                                    if (i2 != 6) {
                                        if (i2 != 7) {
                                            break;
                                        }
                                    }
                                }
                            }
                            f2 = bVar2.f32625h - f9;
                            f7 -= f2;
                            matrix.preTranslate(bVar.f32622e, bVar.f32623f);
                            matrix.preScale(max, max);
                            matrix.preTranslate(f6, f7);
                            break;
                        }
                        f2 = (bVar2.f32625h - f9) / 2.0f;
                        f7 -= f2;
                        matrix.preTranslate(bVar.f32622e, bVar.f32623f);
                        matrix.preScale(max, max);
                        matrix.preTranslate(f6, f7);
                    case 4:
                    case 5:
                    case 6:
                        f3 = bVar2.f32624g - f8;
                        f6 -= f3;
                        i2 = a.f69517a[preserveAspectRatio.a().ordinal()];
                        if (i2 != 2) {
                        }
                        f2 = (bVar2.f32625h - f9) / 2.0f;
                        f7 -= f2;
                        matrix.preTranslate(bVar.f32622e, bVar.f32623f);
                        matrix.preScale(max, max);
                        matrix.preTranslate(f6, f7);
                        break;
                    default:
                        i2 = a.f69517a[preserveAspectRatio.a().ordinal()];
                        if (i2 != 2) {
                        }
                        f2 = (bVar2.f32625h - f9) / 2.0f;
                        f7 -= f2;
                        matrix.preTranslate(bVar.f32622e, bVar.f32623f);
                        matrix.preScale(max, max);
                        matrix.preTranslate(f6, f7);
                        break;
                }
            }
            return matrix;
        }
        return (Matrix) invokeLLL.objValue;
    }

    public final void s0(SVG.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, pVar) == null) {
            C("Line render", new Object[0]);
            W0(this.f69513f, pVar);
            if (E() && Y0() && this.f69513f.f69548g) {
                Matrix matrix = pVar.n;
                if (matrix != null) {
                    this.f69508a.concat(matrix);
                }
                Path e0 = e0(pVar);
                U0(pVar);
                v(pVar);
                t(pVar);
                boolean n0 = n0();
                G(e0);
                I0(pVar);
                if (n0) {
                    k0(pVar);
                }
            }
        }
    }

    public final void t(SVG.i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, i0Var) == null) {
            u(i0Var, i0Var.f32636h);
        }
    }

    public final void t0(SVG.u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, uVar) == null) {
            C("Path render", new Object[0]);
            if (uVar.o == null) {
                return;
            }
            W0(this.f69513f, uVar);
            if (E() && Y0()) {
                h hVar = this.f69513f;
                if (hVar.f69548g || hVar.f69547f) {
                    Matrix matrix = uVar.n;
                    if (matrix != null) {
                        this.f69508a.concat(matrix);
                    }
                    Path f2 = new d(this, uVar.o).f();
                    if (uVar.f32636h == null) {
                        uVar.f32636h = q(f2);
                    }
                    U0(uVar);
                    v(uVar);
                    t(uVar);
                    boolean n0 = n0();
                    if (this.f69513f.f69547f) {
                        f2.setFillType(Y());
                        F(uVar, f2);
                    }
                    if (this.f69513f.f69548g) {
                        G(f2);
                    }
                    I0(uVar);
                    if (n0) {
                        k0(uVar);
                    }
                }
            }
        }
    }

    public final void u(SVG.i0 i0Var, SVG.b bVar) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048655, this, i0Var, bVar) == null) || (str = this.f69513f.f69546e.I) == null) {
            return;
        }
        SVG.l0 n = i0Var.f32644a.n(str);
        if (n == null) {
            J("ClipPath reference '%s' not found", this.f69513f.f69546e.I);
            return;
        }
        SVG.e eVar = (SVG.e) n;
        if (eVar.f32633i.isEmpty()) {
            this.f69508a.clipRect(0, 0, 0, 0);
            return;
        }
        Boolean bool = eVar.o;
        boolean z = bool == null || bool.booleanValue();
        if ((i0Var instanceof SVG.l) && !z) {
            Z0("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", i0Var.getClass().getSimpleName());
            return;
        }
        B();
        if (!z) {
            Matrix matrix = new Matrix();
            matrix.preTranslate(bVar.f32622e, bVar.f32623f);
            matrix.preScale(bVar.f32624g, bVar.f32625h);
            this.f69508a.concat(matrix);
        }
        Matrix matrix2 = eVar.n;
        if (matrix2 != null) {
            this.f69508a.concat(matrix2);
        }
        this.f69513f = Q(eVar);
        t(eVar);
        Path path = new Path();
        for (SVG.l0 l0Var : eVar.f32633i) {
            j(l0Var, true, path, new Matrix());
        }
        this.f69508a.clipPath(path);
        A();
    }

    public final void u0(SVG.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, yVar) == null) {
            C("PolyLine render", new Object[0]);
            W0(this.f69513f, yVar);
            if (E() && Y0()) {
                h hVar = this.f69513f;
                if (hVar.f69548g || hVar.f69547f) {
                    Matrix matrix = yVar.n;
                    if (matrix != null) {
                        this.f69508a.concat(matrix);
                    }
                    if (yVar.o.length < 2) {
                        return;
                    }
                    Path f0 = f0(yVar);
                    U0(yVar);
                    v(yVar);
                    t(yVar);
                    boolean n0 = n0();
                    if (this.f69513f.f69547f) {
                        F(yVar, f0);
                    }
                    if (this.f69513f.f69548g) {
                        G(f0);
                    }
                    I0(yVar);
                    if (n0) {
                        k0(yVar);
                    }
                }
            }
        }
    }

    public final void v(SVG.i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, i0Var) == null) {
            SVG.m0 m0Var = this.f69513f.f69546e.f32615f;
            if (m0Var instanceof SVG.t) {
                D(true, i0Var.f32636h, (SVG.t) m0Var);
            }
            SVG.m0 m0Var2 = this.f69513f.f69546e.f32618i;
            if (m0Var2 instanceof SVG.t) {
                D(false, i0Var.f32636h, (SVG.t) m0Var2);
            }
        }
    }

    public final void v0(SVG.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, zVar) == null) {
            C("Polygon render", new Object[0]);
            W0(this.f69513f, zVar);
            if (E() && Y0()) {
                h hVar = this.f69513f;
                if (hVar.f69548g || hVar.f69547f) {
                    Matrix matrix = zVar.n;
                    if (matrix != null) {
                        this.f69508a.concat(matrix);
                    }
                    if (zVar.o.length < 2) {
                        return;
                    }
                    Path f0 = f0(zVar);
                    U0(zVar);
                    v(zVar);
                    t(zVar);
                    boolean n0 = n0();
                    if (this.f69513f.f69547f) {
                        F(zVar, f0);
                    }
                    if (this.f69513f.f69548g) {
                        G(f0);
                    }
                    I0(zVar);
                    if (n0) {
                        k0(zVar);
                    }
                }
            }
        }
    }

    public final Bitmap w(String str) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048659, this, str)) == null) {
            if (str.startsWith(WebGLImageLoader.DATA_URL) && str.length() >= 14 && (indexOf = str.indexOf(44)) != -1 && indexOf >= 12 && DataUrlLoader.BASE64_TAG.equals(str.substring(indexOf - 7, indexOf))) {
                byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
                return BitmapFactory.decodeByteArray(decode, 0, decode.length);
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public final void w0(SVG.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, a0Var) == null) {
            C("Rect render", new Object[0]);
            SVG.o oVar = a0Var.q;
            if (oVar == null || a0Var.r == null || oVar.k() || a0Var.r.k()) {
                return;
            }
            W0(this.f69513f, a0Var);
            if (E() && Y0()) {
                Matrix matrix = a0Var.n;
                if (matrix != null) {
                    this.f69508a.concat(matrix);
                }
                Path g0 = g0(a0Var);
                U0(a0Var);
                v(a0Var);
                t(a0Var);
                boolean n0 = n0();
                if (this.f69513f.f69547f) {
                    F(a0Var, g0);
                }
                if (this.f69513f.f69548g) {
                    G(g0);
                }
                if (n0) {
                    k0(a0Var);
                }
            }
        }
    }

    public final Typeface x(String str, Integer num, SVG.Style.FontStyle fontStyle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048661, this, str, num, fontStyle)) == null) {
            int i2 = 1;
            boolean z = fontStyle == SVG.Style.FontStyle.Italic;
            if (num.intValue() <= 500) {
                i2 = z ? 2 : 0;
            } else if (z) {
                i2 = 3;
            }
            if (str.equals("serif")) {
                return Typeface.create(Typeface.SERIF, i2);
            }
            if (str.equals(TypefaceCompatApi28Impl.DEFAULT_FAMILY)) {
                return Typeface.create(Typeface.SANS_SERIF, i2);
            }
            if (str.equals("monospace")) {
                return Typeface.create(Typeface.MONOSPACE, i2);
            }
            if (str.equals("cursive")) {
                return Typeface.create(Typeface.SANS_SERIF, i2);
            }
            if (str.equals("fantasy")) {
                return Typeface.create(Typeface.SANS_SERIF, i2);
            }
            return null;
        }
        return (Typeface) invokeLLL.objValue;
    }

    public final void x0(SVG.d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, d0Var) == null) {
            y0(d0Var, d0Var.r, d0Var.s);
        }
    }

    public final void y(SVG.l0 l0Var) {
        Boolean bool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048663, this, l0Var) == null) && (l0Var instanceof SVG.j0) && (bool = ((SVG.j0) l0Var).f32640d) != null) {
            this.f69513f.l = bool.booleanValue();
        }
    }

    public final void y0(SVG.d0 d0Var, SVG.o oVar, SVG.o oVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048664, this, d0Var, oVar, oVar2) == null) {
            z0(d0Var, oVar, oVar2, d0Var.o, d0Var.n);
        }
    }

    public final int z(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048665, this, f2)) == null) {
            int i2 = (int) (f2 * 256.0f);
            if (i2 < 0) {
                return 0;
            }
            if (i2 > 255) {
                return 255;
            }
            return i2;
        }
        return invokeF.intValue;
    }

    public final void z0(SVG.d0 d0Var, SVG.o oVar, SVG.o oVar2, SVG.b bVar, PreserveAspectRatio preserveAspectRatio) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048666, this, d0Var, oVar, oVar2, bVar, preserveAspectRatio) == null) {
            C("Svg render", new Object[0]);
            if (oVar == null || !oVar.k()) {
                if (oVar2 == null || !oVar2.k()) {
                    if (preserveAspectRatio == null && (preserveAspectRatio = d0Var.n) == null) {
                        preserveAspectRatio = PreserveAspectRatio.f32606d;
                    }
                    W0(this.f69513f, d0Var);
                    if (E()) {
                        if (d0Var.f32645b != null) {
                            SVG.o oVar3 = d0Var.p;
                            float h2 = oVar3 != null ? oVar3.h(this) : 0.0f;
                            SVG.o oVar4 = d0Var.q;
                            r1 = h2;
                            f2 = oVar4 != null ? oVar4.i(this) : 0.0f;
                        } else {
                            f2 = 0.0f;
                        }
                        SVG.b W = W();
                        this.f69513f.j = new SVG.b(r1, f2, oVar != null ? oVar.h(this) : W.f32624g, oVar2 != null ? oVar2.i(this) : W.f32625h);
                        if (!this.f69513f.f69546e.z.booleanValue()) {
                            SVG.b bVar2 = this.f69513f.j;
                            O0(bVar2.f32622e, bVar2.f32623f, bVar2.f32624g, bVar2.f32625h);
                        }
                        u(d0Var, this.f69513f.j);
                        if (bVar != null) {
                            this.f69508a.concat(s(this.f69513f.j, bVar, preserveAspectRatio));
                            this.f69513f.k = d0Var.o;
                        } else {
                            this.f69508a.translate(r1, f2);
                        }
                        boolean n0 = n0();
                        X0();
                        F0(d0Var, true);
                        if (n0) {
                            k0(d0Var);
                        }
                        U0(d0Var);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public float f69555a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f69556b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(c cVar) {
            super(cVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((c) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69556b = cVar;
            this.f69555a = 0.0f;
        }

        @Override // d.c.a.c.j
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f69555a += this.f69556b.f69513f.f69549h.measureText(str);
            }
        }

        public /* synthetic */ k(c cVar, a aVar) {
            this(cVar);
        }
    }
}
