package d.a.o0.v;

import android.util.Log;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f51636a;

    /* renamed from: b  reason: collision with root package name */
    public int f51637b;

    /* renamed from: c  reason: collision with root package name */
    public int f51638c;

    /* renamed from: d  reason: collision with root package name */
    public int f51639d;

    /* renamed from: e  reason: collision with root package name */
    public int f51640e;

    /* renamed from: f  reason: collision with root package name */
    public int f51641f;

    /* renamed from: g  reason: collision with root package name */
    public int f51642g;

    /* renamed from: h  reason: collision with root package name */
    public int f51643h;

    public b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51643h = 0;
        new WeakReference(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00af, code lost:
        if (r4 != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b2, code lost:
        if (r4 != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b4, code lost:
        r12 = (int) (r0 / r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b8, code lost:
        r11 = (int) (r3 * r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00f8, code lost:
        if (r1 > r11) goto L77;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i2, int i3) {
        int i4;
        float f2;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            int i6 = this.f51640e;
            if (i6 == 90 || i6 == 270) {
                i3 = i2;
                i2 = i3;
            }
            int defaultSize = View.getDefaultSize(this.f51636a, i2);
            int defaultSize2 = View.getDefaultSize(this.f51637b, i3);
            if (this.f51643h != 3) {
                if (this.f51636a > 0 && this.f51637b > 0) {
                    int mode = View.MeasureSpec.getMode(i2);
                    i2 = View.MeasureSpec.getSize(i2);
                    int mode2 = View.MeasureSpec.getMode(i3);
                    i3 = View.MeasureSpec.getSize(i3);
                    if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
                        float f3 = i2;
                        float f4 = i3;
                        float f5 = f3 / f4;
                        int i7 = this.f51643h;
                        if (i7 == 4) {
                            int i8 = this.f51640e;
                            f2 = (i8 == 90 || i8 == 270) ? 0.5625f : 1.7777778f;
                        } else if (i7 != 5) {
                            f2 = this.f51636a / this.f51637b;
                            int i9 = this.f51638c;
                            if (i9 > 0 && (i5 = this.f51639d) > 0) {
                                f2 = (f2 * i9) / i5;
                            }
                        } else {
                            int i10 = this.f51640e;
                            f2 = (i10 == 90 || i10 == 270) ? 0.75f : 1.3333334f;
                        }
                        boolean z = f2 > f5;
                        int i11 = this.f51643h;
                        if (i11 != 0) {
                            if (i11 != 1) {
                                if (i11 != 4 && i11 != 5) {
                                    if (z) {
                                        i2 = Math.min(this.f51636a, i2);
                                        i3 = (int) (i2 / f2);
                                    } else {
                                        i3 = Math.min(this.f51637b, i3);
                                        i2 = (int) (i3 * f2);
                                    }
                                }
                            }
                        }
                    } else if (mode == 1073741824 && mode2 == 1073741824) {
                        int i12 = this.f51636a;
                        int i13 = i12 * i3;
                        int i14 = this.f51637b;
                        if (i13 < i2 * i14) {
                            i2 = (i12 * i3) / i14;
                        } else if (i12 * i3 > i2 * i14) {
                            i3 = (i14 * i2) / i12;
                        }
                    } else if (mode == 1073741824) {
                        int i15 = (this.f51637b * i2) / this.f51636a;
                        if (mode2 != Integer.MIN_VALUE || i15 <= i3) {
                            i3 = i15;
                        }
                    } else if (mode2 == 1073741824) {
                        i4 = (this.f51636a * i3) / this.f51637b;
                        if (mode == Integer.MIN_VALUE) {
                        }
                        i2 = i4;
                    } else {
                        i4 = this.f51636a;
                        int i16 = this.f51637b;
                        if (mode2 != Integer.MIN_VALUE || i16 <= i3) {
                            i3 = i16;
                        } else {
                            i4 = (i4 * i3) / i16;
                        }
                        if (mode == Integer.MIN_VALUE && i4 > i2) {
                            i3 = (this.f51637b * i2) / this.f51636a;
                        }
                        i2 = i4;
                    }
                } else {
                    Log.d("MeasureHelper", "no size yet");
                    i2 = defaultSize;
                    i3 = defaultSize2;
                }
            }
            this.f51641f = i2;
            this.f51642g = i3;
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51642g : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f51641f : invokeV.intValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f51643h = i2;
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f51640e = i2;
        }
    }

    public void f(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            this.f51638c = i2;
            this.f51639d = i3;
        }
    }

    public void g(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            this.f51636a = i2;
            this.f51637b = i3;
        }
    }
}
