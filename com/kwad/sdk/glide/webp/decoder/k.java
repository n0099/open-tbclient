package com.kwad.sdk.glide.webp.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.webp.decoder.o;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class k extends Drawable implements Animatable, Animatable2Compat, o.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a f38418a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f38419b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38420c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f38421d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f38422e;

    /* renamed from: f  reason: collision with root package name */
    public int f38423f;

    /* renamed from: g  reason: collision with root package name */
    public int f38424g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f38425h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f38426i;
    public Rect j;
    public List<Animatable2Compat.AnimationCallback> k;

    /* loaded from: classes7.dex */
    public static class a extends Drawable.ConstantState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f38427a;

        /* renamed from: b  reason: collision with root package name */
        public final o f38428b;

        public a(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38427a = eVar;
            this.f38428b = oVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new k(this) : (Drawable) invokeV.objValue;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resources)) == null) ? newDrawable() : (Drawable) invokeL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(Context context, i iVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.h<Bitmap> hVar, int i2, int i3, Bitmap bitmap) {
        this(new a(eVar, new o(com.kwad.sdk.glide.c.a(context), iVar, i2, i3, hVar, bitmap)));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, iVar, eVar, hVar, Integer.valueOf(i2), Integer.valueOf(i3), bitmap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                this((a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public k(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38422e = true;
        this.f38424g = -1;
        this.f38422e = true;
        this.f38424g = -1;
        this.f38418a = (a) com.kwad.sdk.glide.g.j.a(aVar);
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f38423f = 0;
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            com.kwad.sdk.glide.g.j.a(!this.f38421d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
            if (this.f38418a.f38428b.g() != 1) {
                if (this.f38419b) {
                    return;
                }
                this.f38419b = true;
                this.f38418a.f38428b.a(this);
            }
            invalidateSelf();
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            this.f38419b = false;
            this.f38418a.f38428b.b(this);
        }
    }

    private Rect l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            if (this.j == null) {
                this.j = new Rect();
            }
            return this.j;
        }
        return (Rect) invokeV.objValue;
    }

    private Paint m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            if (this.f38426i == null) {
                this.f38426i = new Paint(2);
            }
            return this.f38426i;
        }
        return (Paint) invokeV.objValue;
    }

    private Drawable.Callback n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            Drawable.Callback callback = getCallback();
            while (callback instanceof Drawable) {
                callback = ((Drawable) callback).getCallback();
            }
            return callback;
        }
        return (Drawable.Callback) invokeV.objValue;
    }

    private void o() {
        List<Animatable2Compat.AnimationCallback> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (list = this.k) == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.k.get(i2).onAnimationEnd(this);
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38418a.f38428b.d() : invokeV.intValue;
    }

    public void a(com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, bitmap) == null) {
            this.f38418a.f38428b.a(hVar, bitmap);
        }
    }

    public Bitmap b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f38418a.f38428b.a() : (Bitmap) invokeV.objValue;
    }

    public ByteBuffer c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f38418a.f38428b.f() : (ByteBuffer) invokeV.objValue;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.k) == null) {
            return;
        }
        list.clear();
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f38418a.f38428b.g() : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) || h()) {
            return;
        }
        if (this.f38425h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), l());
            this.f38425h = false;
        }
        canvas.drawBitmap(this.f38418a.f38428b.i(), (Rect) null, l(), m());
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f38418a.f38428b.e() : invokeV.intValue;
    }

    @Override // com.kwad.sdk.glide.webp.decoder.o.b
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (n() == null) {
                stop();
                invalidateSelf();
                return;
            }
            invalidateSelf();
            if (e() == d() - 1) {
                this.f38423f++;
            }
            int i2 = this.f38424g;
            if (i2 == -1 || this.f38423f < i2) {
                return;
            }
            stop();
            o();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f38421d = true;
            this.f38418a.f38428b.h();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f38418a : (Drawable.ConstantState) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f38418a.f38428b.c() : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f38418a.f38428b.b() : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return -2;
        }
        return invokeV.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f38421d : invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f38419b : invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, rect) == null) {
            super.onBoundsChange(rect);
            this.f38425h = true;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, animationCallback) == null) || animationCallback == null) {
            return;
        }
        if (this.k == null) {
            this.k = new ArrayList();
        }
        this.k.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            m().setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, colorFilter) == null) {
            m().setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            com.kwad.sdk.glide.g.j.a(!this.f38421d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
            this.f38422e = z;
            if (!z) {
                k();
            } else if (this.f38420c) {
                j();
            }
            return super.setVisible(z, z2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f38420c = true;
            i();
            if (this.f38422e) {
                j();
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f38420c = false;
            k();
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, animationCallback)) == null) {
            List<Animatable2Compat.AnimationCallback> list = this.k;
            if (list == null || animationCallback == null) {
                return false;
            }
            return list.remove(animationCallback);
        }
        return invokeL.booleanValue;
    }
}
