package d.a.n0.a.c0.a.c;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
/* loaded from: classes7.dex */
public class a implements LineHeightSpan {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f43459f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f43460e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1093386240, "Ld/a/n0/a/c0/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1093386240, "Ld/a/n0/a/c0/a/c/a;");
                return;
            }
        }
        f43459f = k.f45831a;
    }

    public a(int i2) {
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
        this.f43460e = i2;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i2, int i3, int i4, int i5, Paint.FontMetricsInt fontMetricsInt) {
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), fontMetricsInt}) == null) {
            if (f43459f) {
                Log.i("AdjustLineHeightSpan", "chooseHeight :: in fm=" + fontMetricsInt);
                Log.i("AdjustLineHeightSpan", "chooseHeight :: in height=" + this.f43460e);
            }
            if (this.f43460e < 0 || (i6 = fontMetricsInt.descent - fontMetricsInt.ascent) < 0) {
                return;
            }
            if (f43459f) {
                Log.i("AdjustLineHeightSpan", "chooseHeight :: in originHeight=" + i6);
            }
            int i7 = (this.f43460e - i6) / 2;
            if (f43459f) {
                Log.i("AdjustLineHeightSpan", "chooseHeight :: in hafDiff=" + i7);
            }
            fontMetricsInt.descent += i7;
            fontMetricsInt.ascent -= i7;
            if (f43459f) {
                Log.i("AdjustLineHeightSpan", "chooseHeight :: out fm=" + fontMetricsInt);
            }
        }
    }
}
