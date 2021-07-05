package com.ksad.lottie.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f33712a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Context f33713b;

    /* renamed from: c  reason: collision with root package name */
    public String f33714c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public com.ksad.lottie.b f33715d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, g> f33716e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(762539500, "Lcom/ksad/lottie/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(762539500, "Lcom/ksad/lottie/b/b;");
                return;
            }
        }
        f33712a = new Object();
    }

    public b(Drawable.Callback callback, String str, com.ksad.lottie.b bVar, Map<String, g> map) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callback, str, bVar, map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f33714c = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.f33714c.charAt(str2.length() - 1) != '/') {
                this.f33714c += '/';
            }
        }
        if (callback instanceof View) {
            this.f33713b = ((View) callback).getContext();
            this.f33716e = map;
            a(bVar);
            return;
        }
        Log.w(L.TAG, "LottieDrawable must be inside of a view for images to work.");
        this.f33716e = new HashMap();
        this.f33713b = null;
    }

    private Bitmap a(String str, @Nullable Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, bitmap)) == null) {
            synchronized (f33712a) {
                this.f33716e.get(str).a(bitmap);
            }
            return bitmap;
        }
        return (Bitmap) invokeLL.objValue;
    }

    @Nullable
    public Bitmap a(String str) {
        InterceptResult invokeL;
        String str2;
        Bitmap decodeStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            g gVar = this.f33716e.get(str);
            if (gVar == null) {
                return null;
            }
            Bitmap c2 = gVar.c();
            if (c2 != null) {
                return c2;
            }
            com.ksad.lottie.b bVar = this.f33715d;
            if (bVar != null) {
                Bitmap a2 = bVar.a(gVar);
                if (a2 != null) {
                    a(str, a2);
                }
                return a2;
            }
            String b2 = gVar.b();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = true;
            options.inDensity = 160;
            if (!b2.startsWith(WebGLImageLoader.DATA_URL) || b2.indexOf("base64,") <= 0) {
                try {
                    if (TextUtils.isEmpty(this.f33714c)) {
                        throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                    }
                    AssetManager assets = this.f33713b.getAssets();
                    decodeStream = BitmapFactory.decodeStream(assets.open(this.f33714c + b2), null, options);
                } catch (IOException e2) {
                    e = e2;
                    str2 = "Unable to open asset.";
                    Log.w(L.TAG, str2, e);
                    return null;
                }
            } else {
                try {
                    byte[] decode = Base64.decode(b2.substring(b2.indexOf(44) + 1), 0);
                    decodeStream = BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
                } catch (IllegalArgumentException e3) {
                    e = e3;
                    str2 = "data URL did not have correct base64 format.";
                    Log.w(L.TAG, str2, e);
                    return null;
                }
            }
            return a(str, decodeStream);
        }
        return (Bitmap) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (f33712a) {
                for (Map.Entry<String, g> entry : this.f33716e.entrySet()) {
                    g value = entry.getValue();
                    Bitmap c2 = value.c();
                    if (c2 != null) {
                        c2.recycle();
                        value.a(null);
                    }
                }
            }
        }
    }

    public void a(@Nullable com.ksad.lottie.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f33715d = bVar;
        }
    }

    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? (context == null && this.f33713b == null) || this.f33713b.equals(context) : invokeL.booleanValue;
    }
}
