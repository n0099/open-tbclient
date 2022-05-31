package com.repackage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallbacks;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class r32 implements k32, q32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s32 b;

    /* loaded from: classes6.dex */
    public class a implements u32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l32 a;

        public a(r32 r32Var, l32 l32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r32Var, l32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l32Var;
        }

        @Override // com.repackage.u32
        public void a(ImageRequest imageRequest) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, imageRequest) == null) {
            }
        }

        @Override // com.repackage.u32
        public void b(ImageRequest imageRequest) {
            l32 l32Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageRequest) == null) || (l32Var = this.a) == null) {
                return;
            }
            l32Var.a();
        }

        @Override // com.repackage.u32
        public void c(ImageRequest imageRequest, Throwable th) {
            l32 l32Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imageRequest, th) == null) || (l32Var = this.a) == null) {
                return;
            }
            l32Var.a();
        }

        @Override // com.repackage.u32
        public void onCancel(String str) {
            l32 l32Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (l32Var = this.a) == null) {
                return;
            }
            l32Var.a();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements s32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(r32 r32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.s32
        public CacheKey a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(ImageRequest.fromUri(Uri.parse(str)), null);
            }
            return (CacheKey) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static r32 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-91237535, "Lcom/repackage/r32$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-91237535, "Lcom/repackage/r32$c;");
                    return;
                }
            }
            a = new r32(null);
        }
    }

    public /* synthetic */ r32(a aVar) {
        this();
    }

    public static r32 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.a : (r32) invokeV.objValue;
    }

    @Override // com.repackage.k32
    public void a(String str, File file, l32 l32Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, file, l32Var) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = false;
        if (file != null && file.exists()) {
            z = b(str, file);
        }
        if (z) {
            l32Var.a();
        } else {
            e(str, new a(this, l32Var));
        }
    }

    public final boolean b(String str, File file) {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, file)) == null) {
            CacheKey a2 = this.b.a(str);
            boolean z = false;
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                BinaryResource insert = Fresco.getImagePipelineFactory().getMainFileCache().insert(a2, WriterCallbacks.from(fileInputStream));
                if (insert != null) {
                    if (insert.size() > 0) {
                        z = true;
                    }
                }
                kf4.d(fileInputStream);
                return z;
            } catch (IOException e2) {
                e = e2;
                fileInputStream2 = fileInputStream;
                if (q32.a) {
                    Log.e("HybridIntercept", Log.getStackTraceString(e));
                }
                kf4.d(fileInputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                kf4.d(fileInputStream2);
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public final File c(String str) {
        InterceptResult invokeL;
        BinaryResource resource;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            CacheKey a2 = this.b.a(str);
            if (a2 == null) {
                return null;
            }
            if (ImagePipelineFactory.getInstance().getMainFileCache().hasKey(a2)) {
                BinaryResource resource2 = ImagePipelineFactory.getInstance().getMainFileCache().getResource(a2);
                if (resource2 != null) {
                    return ((FileBinaryResource) resource2).getFile();
                }
                return null;
            } else if (!ImagePipelineFactory.getInstance().getSmallImageFileCache().hasKey(a2) || (resource = ImagePipelineFactory.getInstance().getSmallImageFileCache().getResource(a2)) == null) {
                return null;
            } else {
                return ((FileBinaryResource) resource).getFile();
            }
        }
        return (File) invokeL.objValue;
    }

    public final DataSource<Void> e(String str, u32 u32Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, u32Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                if (u32Var != null) {
                    u32Var.c(null, new Exception("url is empty"));
                }
                return null;
            }
            ImagePipeline imagePipeline = Fresco.getImagePipeline();
            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.parse(str));
            if (u32Var != null) {
                newBuilderWithSource.setRequestListener(oi2.B().a(u32Var));
            }
            return imagePipeline.prefetchToDiskCache(newBuilderWithSource.build(), null);
        }
        return (DataSource) invokeLL.objValue;
    }

    @Override // com.repackage.k32
    public InputStream get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            File c2 = c(str);
            if (c2 == null || !c2.exists()) {
                return null;
            }
            try {
                return new FileInputStream(c2);
            } catch (IOException e) {
                if (q32.a) {
                    Log.e("HybridIntercept", Log.getStackTraceString(e));
                    return null;
                }
                return null;
            }
        }
        return (InputStream) invokeL.objValue;
    }

    @Override // com.repackage.k32
    public boolean isClosed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public r32() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new b(this);
    }
}
