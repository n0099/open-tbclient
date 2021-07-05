package com.kwad.sdk.glide.load.a.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.a.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class c implements com.kwad.sdk.glide.load.a.d<InputStream> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Uri f37777a;

    /* renamed from: b  reason: collision with root package name */
    public final e f37778b;

    /* renamed from: c  reason: collision with root package name */
    public InputStream f37779c;

    /* loaded from: classes7.dex */
    public static class a implements d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f37780b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ContentResolver f37781a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(329825691, "Lcom/kwad/sdk/glide/load/a/a/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(329825691, "Lcom/kwad/sdk/glide/load/a/a/c$a;");
                    return;
                }
            }
            f37780b = new String[]{"_data"};
        }

        public a(ContentResolver contentResolver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contentResolver};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f37781a = contentResolver;
        }

        @Override // com.kwad.sdk.glide.load.a.a.d
        public Cursor a(Uri uri) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uri)) == null) ? this.f37781a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f37780b, ThumbFetcher.ImageThumbnailQuery.PATH_SELECTION, new String[]{uri.getLastPathSegment()}, null) : (Cursor) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f37782b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ContentResolver f37783a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(329825722, "Lcom/kwad/sdk/glide/load/a/a/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(329825722, "Lcom/kwad/sdk/glide/load/a/a/c$b;");
                    return;
                }
            }
            f37782b = new String[]{"_data"};
        }

        public b(ContentResolver contentResolver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contentResolver};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f37783a = contentResolver;
        }

        @Override // com.kwad.sdk.glide.load.a.a.d
        public Cursor a(Uri uri) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uri)) == null) ? this.f37783a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f37782b, ThumbFetcher.VideoThumbnailQuery.PATH_SELECTION, new String[]{uri.getLastPathSegment()}, null) : (Cursor) invokeL.objValue;
        }
    }

    @VisibleForTesting
    public c(Uri uri, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37777a = uri;
        this.f37778b = eVar;
    }

    public static c a(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, uri)) == null) ? a(context, uri, new a(context.getContentResolver())) : (c) invokeLL.objValue;
    }

    public static c a(Context context, Uri uri, d dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, uri, dVar)) == null) ? new c(uri, new e(com.kwad.sdk.glide.c.a(context).h().a(), dVar, com.kwad.sdk.glide.c.a(context).b(), context.getContentResolver())) : (c) invokeLLL.objValue;
    }

    public static c b(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, uri)) == null) ? a(context, uri, new b(context.getContentResolver())) : (c) invokeLL.objValue;
    }

    private InputStream e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            InputStream b2 = this.f37778b.b(this.f37777a);
            int a2 = b2 != null ? this.f37778b.a(this.f37777a) : -1;
            return a2 != -1 ? new g(b2, a2) : b2;
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    @NonNull
    public Class<InputStream> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? InputStream.class : (Class) invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public void a(@NonNull Priority priority, @NonNull d.a<? super InputStream> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, priority, aVar) == null) {
            try {
                InputStream e2 = e();
                this.f37779c = e2;
                aVar.a((d.a<? super InputStream>) e2);
            } catch (FileNotFoundException e3) {
                if (Log.isLoggable(ThumbFetcher.TAG, 3)) {
                    Log.d(ThumbFetcher.TAG, "Failed to find thumbnail file", e3);
                }
                aVar.a((Exception) e3);
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public void b() {
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (inputStream = this.f37779c) == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException unused) {
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
