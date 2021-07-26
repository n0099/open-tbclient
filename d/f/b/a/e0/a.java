package d.f.b.a.e0;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.i0.v;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final a f70580g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f70581a;

    /* renamed from: b  reason: collision with root package name */
    public final int f70582b;

    /* renamed from: c  reason: collision with root package name */
    public final int f70583c;

    /* renamed from: d  reason: collision with root package name */
    public final int f70584d;

    /* renamed from: e  reason: collision with root package name */
    public final int f70585e;

    /* renamed from: f  reason: collision with root package name */
    public final Typeface f70586f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(81692643, "Ld/f/b/a/e0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(81692643, "Ld/f/b/a/e0/a;");
                return;
            }
        }
        f70580g = new a(-1, -16777216, 0, 0, -1, null);
    }

    public a(int i2, int i3, int i4, int i5, int i6, Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), typeface};
            interceptable.invokeUnInit(65537, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f70581a = i2;
        this.f70582b = i3;
        this.f70583c = i4;
        this.f70584d = i5;
        this.f70585e = i6;
        this.f70586f = typeface;
    }

    @TargetApi(19)
    public static a a(CaptioningManager.CaptionStyle captionStyle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, captionStyle)) == null) {
            if (v.f70969a >= 21) {
                return c(captionStyle);
            }
            return b(captionStyle);
        }
        return (a) invokeL.objValue;
    }

    @TargetApi(19)
    public static a b(CaptioningManager.CaptionStyle captionStyle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, captionStyle)) == null) ? new a(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface()) : (a) invokeL.objValue;
    }

    @TargetApi(21)
    public static a c(CaptioningManager.CaptionStyle captionStyle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, captionStyle)) == null) {
            return new a(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f70580g.f70581a, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f70580g.f70582b, captionStyle.hasWindowColor() ? captionStyle.windowColor : f70580g.f70583c, captionStyle.hasEdgeType() ? captionStyle.edgeType : f70580g.f70584d, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f70580g.f70585e, captionStyle.getTypeface());
        }
        return (a) invokeL.objValue;
    }
}
