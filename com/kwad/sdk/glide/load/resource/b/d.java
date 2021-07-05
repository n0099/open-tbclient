package com.kwad.sdk.glide.load.resource.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.util.UriUtil;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.load.f;
import java.util.List;
/* loaded from: classes7.dex */
public class d implements f<Uri, Drawable> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f38189a;

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38189a = context.getApplicationContext();
    }

    @DrawableRes
    private int a(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, context, uri)) == null) {
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() == 2) {
                return b(context, uri);
            }
            if (pathSegments.size() == 1) {
                return a(uri);
            }
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
        }
        return invokeLL.intValue;
    }

    @DrawableRes
    private int a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, uri)) == null) {
            try {
                return Integer.parseInt(uri.getPathSegments().get(0));
            } catch (NumberFormatException e2) {
                throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e2);
            }
        }
        return invokeL.intValue;
    }

    @NonNull
    private Context a(Uri uri, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, uri, str)) == null) {
            if (str.equals(this.f38189a.getPackageName())) {
                return this.f38189a;
            }
            try {
                return this.f38189a.createPackageContext(str, 0);
            } catch (PackageManager.NameNotFoundException e2) {
                if (str.contains(this.f38189a.getPackageName())) {
                    return this.f38189a;
                }
                throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e2);
            }
        }
        return (Context) invokeLL.objValue;
    }

    @DrawableRes
    private int b(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, this, context, uri)) == null) {
            List<String> pathSegments = uri.getPathSegments();
            String authority = uri.getAuthority();
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            int identifier = context.getResources().getIdentifier(str2, str, authority);
            if (identifier == 0) {
                identifier = Resources.getSystem().getIdentifier(str2, str, "android");
            }
            if (identifier != 0) {
                return identifier;
            }
            throw new IllegalArgumentException("Failed to find resource id for: " + uri);
        }
        return invokeLL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    @Nullable
    public s<Drawable> a(@NonNull Uri uri, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{uri, Integer.valueOf(i2), Integer.valueOf(i3), eVar})) == null) {
            Context a2 = a(uri, uri.getAuthority());
            return c.a(a.a(this.f38189a, a2, a(a2, uri)));
        }
        return (s) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull Uri uri, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uri, eVar)) == null) ? uri.getScheme().equals(UriUtil.QUALIFIED_RESOURCE_SCHEME) : invokeLL.booleanValue;
    }
}
