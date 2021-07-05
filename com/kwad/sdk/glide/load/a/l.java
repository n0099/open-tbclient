package com.kwad.sdk.glide.load.a;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.data.LocalUriFetcher;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes7.dex */
public abstract class l<T> implements d<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Uri f37814a;

    /* renamed from: b  reason: collision with root package name */
    public final ContentResolver f37815b;

    /* renamed from: c  reason: collision with root package name */
    public T f37816c;

    public l(ContentResolver contentResolver, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {contentResolver, uri};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37815b = contentResolver;
        this.f37814a = uri;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public final void a(@NonNull Priority priority, @NonNull d.a<? super T> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, priority, aVar) == null) {
            try {
                T b2 = b(this.f37814a, this.f37815b);
                this.f37816c = b2;
                aVar.a((d.a<? super T>) b2);
            } catch (FileNotFoundException e2) {
                if (Log.isLoggable(LocalUriFetcher.TAG, 3)) {
                    Log.d(LocalUriFetcher.TAG, "Failed to open Uri", e2);
                }
                aVar.a((Exception) e2);
            }
        }
    }

    public abstract void a(T t);

    public abstract T b(Uri uri, ContentResolver contentResolver);

    @Override // com.kwad.sdk.glide.load.a.d
    public void b() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (t = this.f37816c) == null) {
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
