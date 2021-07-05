package com.kwad.sdk.glide.load.resource.b;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.g.j;
import com.kwad.sdk.glide.load.engine.o;
import com.kwad.sdk.glide.load.engine.s;
/* loaded from: classes7.dex */
public abstract class b<T extends Drawable> implements o, s<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final T f38188a;

    public b(T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38188a = (T) j.a(t);
    }

    @Override // com.kwad.sdk.glide.load.engine.o
    public void b() {
        Bitmap b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            T t = this.f38188a;
            if (t instanceof BitmapDrawable) {
                b2 = ((BitmapDrawable) t).getBitmap();
            } else if (!(t instanceof com.kwad.sdk.glide.load.resource.d.c)) {
                return;
            } else {
                b2 = ((com.kwad.sdk.glide.load.resource.d.c) t).b();
            }
            b2.prepareToDraw();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    /* renamed from: f */
    public final T e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Drawable.ConstantState constantState = this.f38188a.getConstantState();
            return constantState == null ? this.f38188a : (T) constantState.newDrawable();
        }
        return (T) invokeV.objValue;
    }
}
