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
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f36253a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface a {
        @MainThread
        void a(int i2, String str);

        @MainThread
        void a(long j, AdTemplate adTemplate);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1890041650, "Lcom/kwad/sdk/core/g/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1890041650, "Lcom/kwad/sdk/core/g/f;");
                return;
            }
        }
        f36253a = new Handler(Looper.getMainLooper());
    }

    public static void a(long j, com.kwad.sdk.core.g.a.f fVar, com.kwad.sdk.core.g.a.l lVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), fVar, lVar, aVar}) == null) {
            new com.kwad.sdk.core.network.i<com.kwad.sdk.core.g.a, AdResultData>(fVar, lVar) { // from class: com.kwad.sdk.core.g.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.g.a.f f36254a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.g.a.l f36255b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fVar, lVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36254a = fVar;
                    this.f36255b = lVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public AdResultData b(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) {
                        JSONObject jSONObject = new JSONObject(str);
                        AdResultData adResultData = new AdResultData(this.f36254a.f36138a);
                        adResultData.parseJson(jSONObject);
                        return adResultData;
                    }
                    return (AdResultData) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: c */
                public com.kwad.sdk.core.g.a b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? new com.kwad.sdk.core.g.a(this.f36254a, this.f36255b) : (com.kwad.sdk.core.g.a) invokeV.objValue;
                }
            }.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.core.g.a, AdResultData>(aVar, j) { // from class: com.kwad.sdk.core.g.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f36256a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f36257b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36256a = aVar;
                    this.f36257b = j;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.g.a aVar2, int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, aVar2, i2, str) == null) {
                        f.f36253a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.f.2.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f36260a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f36261b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f36262c;

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
                                this.f36262c = this;
                                this.f36260a = i2;
                                this.f36261b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.c("PatchAdRequestManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f36260a), this.f36261b));
                                    this.f36262c.f36256a.a(this.f36260a, this.f36261b);
                                }
                            }
                        });
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.g.a aVar2, @NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2, adResultData) == null) {
                        if (!adResultData.isAdResultDataEmpty()) {
                            f.f36253a.post(new Runnable(this, adResultData) { // from class: com.kwad.sdk.core.g.f.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AdResultData f36258a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass2 f36259b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, adResultData};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f36259b = this;
                                    this.f36258a = adResultData;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        AnonymousClass2 anonymousClass2 = this.f36259b;
                                        anonymousClass2.f36256a.a(anonymousClass2.f36257b, this.f36258a.adTemplateList.get(0));
                                    }
                                }
                            });
                            return;
                        }
                        com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.f36360c;
                        a(aVar2, fVar2.k, fVar2.l);
                    }
                }
            });
        }
    }
}
