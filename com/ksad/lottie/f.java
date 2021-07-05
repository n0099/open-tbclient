package com.ksad.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.L;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.c.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes7.dex */
public class f extends Drawable implements Animatable, Drawable.Callback {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final String f33794c;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public com.ksad.lottie.a f33795a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public m f33796b;

    /* renamed from: d  reason: collision with root package name */
    public final Matrix f33797d;

    /* renamed from: e  reason: collision with root package name */
    public d f33798e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.d.c f33799f;

    /* renamed from: g  reason: collision with root package name */
    public float f33800g;

    /* renamed from: h  reason: collision with root package name */
    public final Set<Object> f33801h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<a> f33802i;
    @Nullable
    public com.ksad.lottie.b.b j;
    @Nullable
    public String k;
    @Nullable
    public b l;
    @Nullable
    public com.ksad.lottie.b.a m;
    public boolean n;
    @Nullable
    public com.ksad.lottie.model.layer.b o;
    public int p;
    public boolean q;

    /* loaded from: classes7.dex */
    public interface a {
        void a(d dVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1819786011, "Lcom/ksad/lottie/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1819786011, "Lcom/ksad/lottie/f;");
                return;
            }
        }
        f33794c = f.class.getSimpleName();
    }

    public f() {
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
        this.f33797d = new Matrix();
        this.f33799f = new com.ksad.lottie.d.c();
        this.f33800g = 1.0f;
        this.f33801h = new HashSet();
        this.f33802i = new ArrayList<>();
        this.p = 255;
        this.f33799f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.ksad.lottie.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f33803a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f33803a = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) || this.f33803a.o == null) {
                    return;
                }
                this.f33803a.o.a(this.f33803a.f33799f.d());
            }
        });
    }

    private float a(@NonNull Canvas canvas) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, canvas)) == null) ? Math.min(canvas.getWidth() / this.f33798e.b().width(), canvas.getHeight() / this.f33798e.b().height()) : invokeL.floatValue;
    }

    private void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.o = new com.ksad.lottie.model.layer.b(this, s.a(this.f33798e), this.f33798e.g(), this.f33798e);
        }
    }

    private void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || this.f33798e == null) {
            return;
        }
        float q = q();
        setBounds(0, 0, (int) (this.f33798e.b().width() * q), (int) (this.f33798e.b().height() * q));
    }

    private com.ksad.lottie.b.b w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (getCallback() == null) {
                return null;
            }
            com.ksad.lottie.b.b bVar = this.j;
            if (bVar != null && !bVar.a(y())) {
                this.j.a();
                this.j = null;
            }
            if (this.j == null) {
                this.j = new com.ksad.lottie.b.b(getCallback(), this.k, this.l, this.f33798e.j());
            }
            return this.j;
        }
        return (com.ksad.lottie.b.b) invokeV.objValue;
    }

    private com.ksad.lottie.b.a x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (getCallback() == null) {
                return null;
            }
            if (this.m == null) {
                this.m = new com.ksad.lottie.b.a(getCallback(), this.f33795a);
            }
            return this.m;
        }
        return (com.ksad.lottie.b.a) invokeV.objValue;
    }

    @Nullable
    private Context y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            Drawable.Callback callback = getCallback();
            if (callback != null && (callback instanceof View)) {
                return ((View) callback).getContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    @Nullable
    public Typeface a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            com.ksad.lottie.b.a x = x();
            if (x != null) {
                return x.a(str, str2);
            }
            return null;
        }
        return (Typeface) invokeLL.objValue;
    }

    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            d dVar = this.f33798e;
            if (dVar == null) {
                this.f33802i.add(new a(this, f2) { // from class: com.ksad.lottie.f.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ float f33811a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ f f33812b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Float.valueOf(f2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f33812b = this;
                        this.f33811a = f2;
                    }

                    @Override // com.ksad.lottie.f.a
                    public void a(d dVar2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dVar2) == null) {
                            this.f33812b.a(this.f33811a);
                        }
                    }
                });
            } else {
                a((int) com.ksad.lottie.d.e.a(dVar.d(), this.f33798e.e(), f2));
            }
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f33798e == null) {
                this.f33802i.add(new a(this, i2) { // from class: com.ksad.lottie.f.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f33809a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ f f33810b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f33810b = this;
                        this.f33809a = i2;
                    }

                    @Override // com.ksad.lottie.f.a
                    public void a(d dVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dVar) == null) {
                            this.f33810b.a(this.f33809a);
                        }
                    }
                });
            } else {
                this.f33799f.b(i2);
            }
        }
    }

    public void a(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, animatorListener) == null) {
            this.f33799f.addListener(animatorListener);
        }
    }

    public void a(com.ksad.lottie.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f33795a = aVar;
            com.ksad.lottie.b.a aVar2 = this.m;
            if (aVar2 != null) {
                aVar2.a(aVar);
            }
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.l = bVar;
            com.ksad.lottie.b.b bVar2 = this.j;
            if (bVar2 != null) {
                bVar2.a(bVar);
            }
        }
    }

    public void a(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mVar) == null) {
            this.f33796b = mVar;
        }
    }

    public void a(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.k = str;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || this.n == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            Log.w(f33794c, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.n = z;
        if (this.f33798e != null) {
            u();
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean a(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, dVar)) == null) {
            if (this.f33798e == dVar) {
                return false;
            }
            e();
            this.f33798e = dVar;
            u();
            this.f33799f.a(dVar);
            d(this.f33799f.getAnimatedFraction());
            e(this.f33800g);
            v();
            Iterator it = new ArrayList(this.f33802i).iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(dVar);
                it.remove();
            }
            this.f33802i.clear();
            dVar.a(this.q);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public Bitmap b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            com.ksad.lottie.b.b w = w();
            if (w != null) {
                return w.a(str);
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public void b(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            d dVar = this.f33798e;
            if (dVar == null) {
                this.f33802i.add(new a(this, f2) { // from class: com.ksad.lottie.f.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ float f33815a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ f f33816b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Float.valueOf(f2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f33816b = this;
                        this.f33815a = f2;
                    }

                    @Override // com.ksad.lottie.f.a
                    public void a(d dVar2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dVar2) == null) {
                            this.f33816b.b(this.f33815a);
                        }
                    }
                });
            } else {
                b((int) com.ksad.lottie.d.e.a(dVar.d(), this.f33798e.e(), f2));
            }
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            if (this.f33798e == null) {
                this.f33802i.add(new a(this, i2) { // from class: com.ksad.lottie.f.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f33813a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ f f33814b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f33814b = this;
                        this.f33813a = i2;
                    }

                    @Override // com.ksad.lottie.f.a
                    public void a(d dVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dVar) == null) {
                            this.f33814b.b(this.f33813a);
                        }
                    }
                });
            } else {
                this.f33799f.c(i2);
            }
        }
    }

    public void b(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, animatorListener) == null) {
            this.f33799f.removeListener(animatorListener);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.q = z;
            d dVar = this.f33798e;
            if (dVar != null) {
                dVar.a(z);
            }
        }
    }

    public void c() {
        com.ksad.lottie.b.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (bVar = this.j) == null) {
            return;
        }
        bVar.a();
    }

    public void c(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f2) == null) {
            this.f33799f.a(f2);
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            if (this.f33798e == null) {
                this.f33802i.add(new a(this, i2) { // from class: com.ksad.lottie.f.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f33804a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ f f33805b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f33805b = this;
                        this.f33804a = i2;
                    }

                    @Override // com.ksad.lottie.f.a
                    public void a(d dVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dVar) == null) {
                            this.f33805b.c(this.f33804a);
                        }
                    }
                });
            } else {
                this.f33799f.a(i2);
            }
        }
    }

    @Nullable
    public l d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            d dVar = this.f33798e;
            if (dVar != null) {
                return dVar.a();
            }
            return null;
        }
        return (l) invokeV.objValue;
    }

    public void d(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f2) == null) {
            d dVar = this.f33798e;
            if (dVar == null) {
                this.f33802i.add(new a(this, f2) { // from class: com.ksad.lottie.f.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ float f33806a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ f f33807b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Float.valueOf(f2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f33807b = this;
                        this.f33806a = f2;
                    }

                    @Override // com.ksad.lottie.f.a
                    public void a(d dVar2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dVar2) == null) {
                            this.f33807b.d(this.f33806a);
                        }
                    }
                });
            } else {
                c((int) com.ksad.lottie.d.e.a(dVar.d(), this.f33798e.e(), f2));
            }
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f33799f.setRepeatMode(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, canvas) == null) {
            c.c("Drawable#draw");
            if (this.o == null) {
                return;
            }
            float f3 = this.f33800g;
            float a2 = a(canvas);
            if (f3 > a2) {
                f2 = this.f33800g / a2;
            } else {
                a2 = f3;
                f2 = 1.0f;
            }
            int i2 = (f2 > 1.0f ? 1 : (f2 == 1.0f ? 0 : -1));
            if (i2 > 0) {
                canvas.save();
                float width = this.f33798e.b().width() / 2.0f;
                float height = this.f33798e.b().height() / 2.0f;
                float f4 = width * a2;
                float f5 = height * a2;
                canvas.translate((q() * width) - f4, (q() * height) - f5);
                canvas.scale(f2, f2, f4, f5);
            }
            this.f33797d.reset();
            this.f33797d.preScale(a2, a2);
            this.o.a(canvas, this.f33797d, this.p);
            c.d("Drawable#draw");
            if (i2 > 0) {
                canvas.restore();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            c();
            if (this.f33799f.isRunning()) {
                this.f33799f.cancel();
            }
            this.f33798e = null;
            this.o = null;
            this.j = null;
            this.f33799f.f();
            invalidateSelf();
        }
    }

    public void e(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048601, this, f2) == null) {
            this.f33800g = f2;
            v();
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.f33799f.setRepeatCount(i2);
        }
    }

    @MainThread
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (this.o == null) {
                this.f33802i.add(new a(this) { // from class: com.ksad.lottie.f.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ f f33808a;

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
                        this.f33808a = this;
                    }

                    @Override // com.ksad.lottie.f.a
                    public void a(d dVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dVar) == null) {
                            this.f33808a.f();
                        }
                    }
                });
            } else {
                this.f33799f.i();
            }
        }
    }

    @MainThread
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.f33802i.clear();
            this.f33799f.j();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.p : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            d dVar = this.f33798e;
            if (dVar == null) {
                return -1;
            }
            return (int) (dVar.b().height() * q());
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            d dVar = this.f33798e;
            if (dVar == null) {
                return -1;
            }
            return (int) (dVar.b().width() * q());
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    public float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f33799f.k() : invokeV.floatValue;
    }

    public float i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f33799f.l() : invokeV.floatValue;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, drawable) == null) || (callback = getCallback()) == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable.Callback callback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (callback = getCallback()) == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? n() : invokeV.booleanValue;
    }

    public float j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f33799f.h() : invokeV.floatValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? (int) this.f33799f.e() : invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f33799f.getRepeatMode() : invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.f33799f.getRepeatCount() : invokeV.intValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.f33799f.isRunning() : invokeV.booleanValue;
    }

    @Nullable
    public m o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f33796b : (m) invokeV.objValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.f33796b == null && this.f33798e.h().size() > 0 : invokeV.booleanValue;
    }

    public float q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.f33800g : invokeV.floatValue;
    }

    public d r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f33798e : (d) invokeV.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.f33802i.clear();
            this.f33799f.cancel();
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable.Callback callback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{drawable, runnable, Long.valueOf(j)}) == null) || (callback = getCallback()) == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            this.p = i2;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, colorFilter) == null) {
            Log.w(L.TAG, "Use addColorFilter instead.");
        }
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            f();
        }
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            g();
        }
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.f33799f.d() : invokeV.floatValue;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048630, this, drawable, runnable) == null) || (callback = getCallback()) == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }
}
