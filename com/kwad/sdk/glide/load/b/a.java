package com.kwad.sdk.glide.load.b;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.kwad.sdk.glide.load.b.n;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class a<Data> implements n<Uri, Data> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f37818a = 22;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final AssetManager f37819b;

    /* renamed from: c  reason: collision with root package name */
    public final InterfaceC0458a<Data> f37820c;

    /* renamed from: com.kwad.sdk.glide.load.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0458a<Data> {
        com.kwad.sdk.glide.load.a.d<Data> a(AssetManager assetManager, String str);
    }

    /* loaded from: classes7.dex */
    public static class b implements InterfaceC0458a<ParcelFileDescriptor>, o<Uri, ParcelFileDescriptor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final AssetManager f37826a;

        public b(AssetManager assetManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {assetManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37826a = assetManager;
        }

        @Override // com.kwad.sdk.glide.load.b.a.InterfaceC0458a
        public com.kwad.sdk.glide.load.a.d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, assetManager, str)) == null) ? new com.kwad.sdk.glide.load.a.h(assetManager, str) : (com.kwad.sdk.glide.load.a.d) invokeLL.objValue;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Uri, ParcelFileDescriptor> a(r rVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rVar)) == null) ? new a(this.f37826a, this) : (n) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements InterfaceC0458a<InputStream>, o<Uri, InputStream> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final AssetManager f37828a;

        public c(AssetManager assetManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {assetManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37828a = assetManager;
        }

        @Override // com.kwad.sdk.glide.load.b.a.InterfaceC0458a
        public com.kwad.sdk.glide.load.a.d<InputStream> a(AssetManager assetManager, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, assetManager, str)) == null) ? new com.kwad.sdk.glide.load.a.m(assetManager, str) : (com.kwad.sdk.glide.load.a.d) invokeLL.objValue;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Uri, InputStream> a(r rVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rVar)) == null) ? new a(this.f37828a, this) : (n) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(85360171, "Lcom/kwad/sdk/glide/load/b/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(85360171, "Lcom/kwad/sdk/glide/load/b/a;");
        }
    }

    public a(AssetManager assetManager, InterfaceC0458a<Data> interfaceC0458a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {assetManager, interfaceC0458a};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37819b = assetManager;
        this.f37820c = interfaceC0458a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<Data> a(@NonNull Uri uri, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{uri, Integer.valueOf(i2), Integer.valueOf(i3), eVar})) == null) ? new n.a<>(new com.kwad.sdk.glide.f.b(uri), this.f37820c.a(this.f37819b, uri.toString().substring(f37818a))) : (n.a) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uri)) == null) ? "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && AssetUriLoader.ASSET_PATH_SEGMENT.equals(uri.getPathSegments().get(0)) : invokeL.booleanValue;
    }
}
