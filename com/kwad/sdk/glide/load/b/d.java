package com.kwad.sdk.glide.load.b;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class d implements n<File, ByteBuffer> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a implements com.kwad.sdk.glide.load.a.d<ByteBuffer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final File f37838a;

        public a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37838a = file;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public Class<ByteBuffer> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ByteBuffer.class : (Class) invokeV.objValue;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super ByteBuffer> aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, priority, aVar) == null) {
                try {
                    aVar.a((d.a<? super ByteBuffer>) com.kwad.sdk.glide.g.a.a(this.f37838a));
                } catch (IOException e2) {
                    if (Log.isLoggable(ByteBufferFileLoader.TAG, 3)) {
                        Log.d(ByteBufferFileLoader.TAG, "Failed to obtain ByteBuffer for file", e2);
                    }
                    aVar.a((Exception) e2);
                }
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public DataSource d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? DataSource.LOCAL : (DataSource) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements o<File, ByteBuffer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<File, ByteBuffer> a(@NonNull r rVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rVar)) == null) ? new d() : (n) invokeL.objValue;
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<ByteBuffer> a(@NonNull File file, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{file, Integer.valueOf(i2), Integer.valueOf(i3), eVar})) == null) ? new n.a<>(new com.kwad.sdk.glide.f.b(file), new a(file)) : (n.a) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }
}
