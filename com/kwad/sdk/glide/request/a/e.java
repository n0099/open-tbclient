package com.kwad.sdk.glide.request.a;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.request.b.b;
/* loaded from: classes7.dex */
public abstract class e<Z> extends k<ImageView, Z> implements b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public Animatable f38335b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ImageView imageView) {
        super(imageView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void b(@Nullable Z z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, z) == null) {
            a((e<Z>) z);
            c((e<Z>) z);
        }
    }

    private void c(@Nullable Z z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, z) == null) {
            if (!(z instanceof Animatable)) {
                this.f38335b = null;
                return;
            }
            Animatable animatable = (Animatable) z;
            this.f38335b = animatable;
            animatable.start();
        }
    }

    @Override // com.kwad.sdk.glide.request.a.k, com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    public void a(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
            super.a(drawable);
            Animatable animatable = this.f38335b;
            if (animatable != null) {
                animatable.stop();
            }
            b((e<Z>) null);
            e(drawable);
        }
    }

    public abstract void a(@Nullable Z z);

    @Override // com.kwad.sdk.glide.request.a.j
    public void a(@NonNull Z z, @Nullable com.kwad.sdk.glide.request.b.b<? super Z> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, z, bVar) == null) {
            if (bVar == null || !bVar.a(z, this)) {
                b((e<Z>) z);
            } else {
                c((e<Z>) z);
            }
        }
    }

    @Override // com.kwad.sdk.glide.request.a.k, com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    public void b(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, drawable) == null) {
            super.b(drawable);
            b((e<Z>) null);
            e(drawable);
        }
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.c.i
    public void c() {
        Animatable animatable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (animatable = this.f38335b) == null) {
            return;
        }
        animatable.start();
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    public void c(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, drawable) == null) {
            super.c(drawable);
            b((e<Z>) null);
            e(drawable);
        }
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.c.i
    public void d() {
        Animatable animatable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (animatable = this.f38335b) == null) {
            return;
        }
        animatable.stop();
    }

    public void e(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, drawable) == null) {
            ((ImageView) ((k) this).f38342a).setImageDrawable(drawable);
        }
    }
}
