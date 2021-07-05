package com.kwad.sdk.glide.load.a;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.data.AssetPathFetcher;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import java.io.IOException;
/* loaded from: classes7.dex */
public abstract class b<T> implements d<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f37790a;

    /* renamed from: b  reason: collision with root package name */
    public final AssetManager f37791b;

    /* renamed from: c  reason: collision with root package name */
    public T f37792c;

    public b(AssetManager assetManager, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {assetManager, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37791b = assetManager;
        this.f37790a = str;
    }

    public abstract T a(AssetManager assetManager, String str);

    @Override // com.kwad.sdk.glide.load.a.d
    public void a(@NonNull Priority priority, @NonNull d.a<? super T> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, priority, aVar) == null) {
            try {
                T a2 = a(this.f37791b, this.f37790a);
                this.f37792c = a2;
                aVar.a((d.a<? super T>) a2);
            } catch (IOException e2) {
                if (Log.isLoggable(AssetPathFetcher.TAG, 3)) {
                    Log.d(AssetPathFetcher.TAG, "Failed to load data from asset manager", e2);
                }
                aVar.a((Exception) e2);
            }
        }
    }

    public abstract void a(T t);

    @Override // com.kwad.sdk.glide.load.a.d
    public void b() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (t = this.f37792c) == null) {
            return;
        }
        try {
            a(t);
        } catch (IOException unused) {
        }
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.kwad.sdk.glide.load.a.d
    @NonNull
    public DataSource d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? DataSource.LOCAL : (DataSource) invokeV.objValue;
    }
}
