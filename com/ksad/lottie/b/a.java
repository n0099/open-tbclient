package com.ksad.lottie.b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.model.f;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final f<String> f33706a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<f<String>, Typeface> f33707b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Typeface> f33708c;

    /* renamed from: d  reason: collision with root package name */
    public final AssetManager f33709d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.ksad.lottie.a f33710e;

    /* renamed from: f  reason: collision with root package name */
    public String f33711f;

    public a(Drawable.Callback callback, @Nullable com.ksad.lottie.a aVar) {
        AssetManager assets;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callback, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33706a = new f<>();
        this.f33707b = new HashMap();
        this.f33708c = new HashMap();
        this.f33711f = ".ttf";
        this.f33710e = aVar;
        if (callback instanceof View) {
            assets = ((View) callback).getContext().getAssets();
        } else {
            Log.w(L.TAG, "LottieDrawable must be inside of a view for images to work.");
            assets = null;
        }
        this.f33709d = assets;
    }

    private Typeface a(Typeface typeface, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, typeface, str)) == null) {
            boolean contains = str.contains("Italic");
            boolean contains2 = str.contains("Bold");
            int i2 = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
            return typeface.getStyle() == i2 ? typeface : Typeface.create(typeface, i2);
        }
        return (Typeface) invokeLL.objValue;
    }

    private Typeface a(String str) {
        InterceptResult invokeL;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            Typeface typeface = this.f33708c.get(str);
            if (typeface != null) {
                return typeface;
            }
            com.ksad.lottie.a aVar = this.f33710e;
            Typeface a2 = aVar != null ? aVar.a(str) : null;
            com.ksad.lottie.a aVar2 = this.f33710e;
            if (aVar2 != null && a2 == null && (b2 = aVar2.b(str)) != null) {
                a2 = Typeface.createFromAsset(this.f33709d, b2);
            }
            if (a2 == null) {
                a2 = Typeface.createFromAsset(this.f33709d, "fonts/" + str + this.f33711f);
            }
            this.f33708c.put(str, a2);
            return a2;
        }
        return (Typeface) invokeL.objValue;
    }

    public Typeface a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            this.f33706a.a(str, str2);
            Typeface typeface = this.f33707b.get(this.f33706a);
            if (typeface != null) {
                return typeface;
            }
            Typeface a2 = a(a(str), str2);
            this.f33707b.put(this.f33706a, a2);
            return a2;
        }
        return (Typeface) invokeLL.objValue;
    }

    public void a(@Nullable com.ksad.lottie.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f33710e = aVar;
        }
    }
}
