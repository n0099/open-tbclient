package com.kwad.sdk.glide.load.engine.a;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper;
import com.kwad.sdk.glide.a.a;
import com.kwad.sdk.glide.load.engine.a.a;
import java.io.File;
import java.io.IOException;
/* loaded from: classes7.dex */
public class e implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final j f37970a;

    /* renamed from: b  reason: collision with root package name */
    public final File f37971b;

    /* renamed from: c  reason: collision with root package name */
    public final long f37972c;

    /* renamed from: d  reason: collision with root package name */
    public final c f37973d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.a.a f37974e;

    @Deprecated
    public e(File file, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37973d = new c();
        this.f37971b = file;
        this.f37972c = j;
        this.f37970a = new j();
    }

    private synchronized com.kwad.sdk.glide.a.a a() {
        InterceptResult invokeV;
        com.kwad.sdk.glide.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            synchronized (this) {
                if (this.f37974e == null) {
                    this.f37974e = com.kwad.sdk.glide.a.a.a(this.f37971b, 1, 1, this.f37972c);
                }
                aVar = this.f37974e;
            }
            return aVar;
        }
        return (com.kwad.sdk.glide.a.a) invokeV.objValue;
    }

    public static a a(File file, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, file, j)) == null) ? new e(file, j) : (a) invokeLJ.objValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a
    public File a(com.kwad.sdk.glide.load.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            String a2 = this.f37970a.a(cVar);
            if (Log.isLoggable(DiskLruCacheWrapper.TAG, 2)) {
                Log.v(DiskLruCacheWrapper.TAG, "Get: Obtained: " + a2 + " for for Key: " + cVar);
            }
            try {
                a.d a3 = a().a(a2);
                if (a3 != null) {
                    return a3.a(0);
                }
                return null;
            } catch (IOException e2) {
                if (Log.isLoggable(DiskLruCacheWrapper.TAG, 5)) {
                    Log.w(DiskLruCacheWrapper.TAG, "Unable to get from disk cache", e2);
                    return null;
                }
                return null;
            }
        }
        return (File) invokeL.objValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a
    public void a(com.kwad.sdk.glide.load.c cVar, a.b bVar) {
        com.kwad.sdk.glide.a.a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, bVar) == null) {
            String a3 = this.f37970a.a(cVar);
            this.f37973d.a(a3);
            try {
                if (Log.isLoggable(DiskLruCacheWrapper.TAG, 2)) {
                    Log.v(DiskLruCacheWrapper.TAG, "Put: Obtained: " + a3 + " for for Key: " + cVar);
                }
                try {
                    a2 = a();
                } catch (IOException e2) {
                    if (Log.isLoggable(DiskLruCacheWrapper.TAG, 5)) {
                        Log.w(DiskLruCacheWrapper.TAG, "Unable to put to disk cache", e2);
                    }
                }
                if (a2.a(a3) != null) {
                    return;
                }
                a.b b2 = a2.b(a3);
                if (b2 == null) {
                    throw new IllegalStateException("Had two simultaneous puts for: " + a3);
                }
                try {
                    if (bVar.a(b2.a(0))) {
                        b2.a();
                    }
                    b2.c();
                } catch (Throwable th) {
                    b2.c();
                    throw th;
                }
            } finally {
                this.f37973d.b(a3);
            }
        }
    }
}
