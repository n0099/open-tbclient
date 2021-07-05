package com.kwad.sdk.core.g;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.CommentResponse;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f36263a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface a {
        @MainThread
        void a(int i2, String str);

        @MainThread
        void a(@NonNull CommentResponse commentResponse);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1890041681, "Lcom/kwad/sdk/core/g/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1890041681, "Lcom/kwad/sdk/core/g/g;");
                return;
            }
        }
        f36263a = new Handler(Looper.getMainLooper());
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void a(long j, @NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j, aVar) == null) {
            new com.kwad.sdk.core.network.i<b, CommentResponse>(this, j) { // from class: com.kwad.sdk.core.g.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ long f36264a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ g f36265b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36265b = this;
                    this.f36264a = j;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public CommentResponse b(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) {
                        JSONObject jSONObject = new JSONObject(str);
                        CommentResponse commentResponse = new CommentResponse();
                        commentResponse.parseJson(jSONObject);
                        return commentResponse;
                    }
                    return (CommentResponse) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: c */
                public b b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? new b(this.f36264a) : (b) invokeV.objValue;
                }
            }.a(new com.kwad.sdk.core.network.j<b, CommentResponse>(this, aVar) { // from class: com.kwad.sdk.core.g.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f36266a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ g f36267b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36267b = this;
                    this.f36266a = aVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull b bVar, int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, bVar, i2, str) == null) {
                        g.f36263a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.g.2.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f36270a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f36271b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f36272c;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i2), str};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f36272c = this;
                                this.f36270a = i2;
                                this.f36271b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.d("PhotoCommentRequestManager", "load onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f36270a), this.f36271b));
                                    this.f36272c.f36266a.a(this.f36270a, this.f36271b);
                                }
                            }
                        });
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull b bVar, @NonNull CommentResponse commentResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, commentResponse) == null) {
                        g.f36263a.post(new Runnable(this, commentResponse) { // from class: com.kwad.sdk.core.g.g.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ CommentResponse f36268a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f36269b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, commentResponse};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f36269b = this;
                                this.f36268a = commentResponse;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f36269b.f36266a.a(this.f36268a);
                                }
                            }
                        });
                    }
                }
            });
        }
    }
}
