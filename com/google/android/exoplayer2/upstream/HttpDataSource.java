package com.google.android.exoplayer2.upstream;

import b.i.b.a.h0.e;
import b.i.b.a.h0.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public interface HttpDataSource extends e {

    /* loaded from: classes11.dex */
    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String contentType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidContentTypeException(String str, g gVar) {
            super("Invalid content type: " + str, gVar, 1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (g) objArr2[1], ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.contentType = str;
        }
    }

    /* loaded from: classes11.dex */
    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<String, List<String>> headerFields;
        public final int responseCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidResponseCodeException(int i2, Map<String, List<String>> map, g gVar) {
            super("Response code: " + i2, gVar, 1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), map, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (g) objArr2[1], ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.responseCode = i2;
            this.headerFields = map;
        }
    }

    /* loaded from: classes11.dex */
    public static abstract class a implements e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final b f63067a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63067a = new b();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.i.b.a.h0.e.a
        /* renamed from: b */
        public final HttpDataSource a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c(this.f63067a) : (HttpDataSource) invokeV.objValue;
        }

        public abstract HttpDataSource c(b bVar);
    }

    /* loaded from: classes11.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, String> f63068a;

        /* renamed from: b  reason: collision with root package name */
        public Map<String, String> f63069b;

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
                    return;
                }
            }
            this.f63068a = new HashMap();
        }

        public synchronized Map<String, String> a() {
            InterceptResult invokeV;
            Map<String, String> map;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this) {
                    if (this.f63069b == null) {
                        this.f63069b = Collections.unmodifiableMap(new HashMap(this.f63068a));
                    }
                    map = this.f63069b;
                }
                return map;
            }
            return (Map) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class HttpDataSourceException extends IOException {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int TYPE_CLOSE = 3;
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_READ = 2;
        public transient /* synthetic */ FieldHolder $fh;
        public final g dataSpec;
        public final int type;

        public HttpDataSourceException(g gVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.dataSpec = gVar;
            this.type = i2;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HttpDataSourceException(String str, g gVar, int i2) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, gVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.dataSpec = gVar;
            this.type = i2;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HttpDataSourceException(IOException iOException, g gVar, int i2) {
            super(iOException);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iOException, gVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((Throwable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.dataSpec = gVar;
            this.type = i2;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HttpDataSourceException(String str, IOException iOException, g gVar, int i2) {
            super(str, iOException);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, iOException, gVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65539, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.dataSpec = gVar;
            this.type = i2;
        }
    }
}
