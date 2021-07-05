package com.kwad.sdk.contentalliance.tube.profile;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.tube.b.b;
import com.kwad.sdk.contentalliance.tube.model.TubeProfileResultData;
import com.kwad.sdk.core.g.a.f;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.internal.api.SceneImpl;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f35788a;

    /* renamed from: b  reason: collision with root package name */
    public a f35789b;

    /* renamed from: c  reason: collision with root package name */
    public i<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData> f35790c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35791d;

    /* renamed from: e  reason: collision with root package name */
    public long f35792e;

    /* renamed from: f  reason: collision with root package name */
    public SceneImpl f35793f;

    public c(SceneImpl sceneImpl, long j, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sceneImpl, Long.valueOf(j), aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35791d = false;
        this.f35788a = new Handler(Looper.getMainLooper());
        this.f35792e = j;
        this.f35789b = aVar;
        this.f35793f = sceneImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, this, i2, str) == null) {
            com.kwad.sdk.core.d.a.c("TubeProfileDataFetcher", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
            b(i2, str);
            this.f35791d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TubeProfileResultData tubeProfileResultData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, tubeProfileResultData) == null) {
            b(tubeProfileResultData);
            d();
            this.f35791d = false;
        }
    }

    private void b(int i2, String str) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65543, this, i2, str) == null) || (aVar = this.f35789b) == null) {
            return;
        }
        aVar.a(i2, str);
    }

    private void b(TubeProfileResultData tubeProfileResultData) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, tubeProfileResultData) == null) || (aVar = this.f35789b) == null) {
            return;
        }
        aVar.a(tubeProfileResultData);
    }

    private void c() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (aVar = this.f35789b) == null) {
            return;
        }
        aVar.a();
    }

    private void d() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || (aVar = this.f35789b) == null) {
            return;
        }
        aVar.b();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f35791d) {
            return;
        }
        c();
        f fVar = new f(this.f35793f);
        fVar.f36139b = this.f35793f.getPageScene();
        i<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData> iVar = new i<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData>(this, new b.a(fVar, this.f35792e, true)) { // from class: com.kwad.sdk.contentalliance.tube.profile.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b.a f35794a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f35795b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, r7};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f35795b = this;
                this.f35794a = r7;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public TubeProfileResultData b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) {
                    JSONObject jSONObject = new JSONObject(str);
                    TubeProfileResultData tubeProfileResultData = new TubeProfileResultData(this.f35795b.f35793f);
                    tubeProfileResultData.parseJson(jSONObject);
                    return tubeProfileResultData;
                }
                return (TubeProfileResultData) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: c */
            public com.kwad.sdk.contentalliance.tube.b.b b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? new com.kwad.sdk.contentalliance.tube.b.b(this.f35794a) : (com.kwad.sdk.contentalliance.tube.b.b) invokeV.objValue;
            }
        };
        this.f35790c = iVar;
        iVar.a(new j<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData>(this) { // from class: com.kwad.sdk.contentalliance.tube.profile.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f35796a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f35796a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.contentalliance.tube.b.b bVar, int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, bVar, i2, str) == null) {
                    this.f35796a.f35788a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.contentalliance.tube.profile.c.2.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f35799a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f35800b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f35801c;

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
                            this.f35801c = this;
                            this.f35799a = i2;
                            this.f35800b = str;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.f35801c.f35796a.a(this.f35799a, this.f35800b);
                            }
                        }
                    });
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.contentalliance.tube.b.b bVar, @NonNull TubeProfileResultData tubeProfileResultData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, tubeProfileResultData) == null) {
                    this.f35796a.f35788a.post(new Runnable(this, tubeProfileResultData) { // from class: com.kwad.sdk.contentalliance.tube.profile.c.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ TubeProfileResultData f35797a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f35798b;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, tubeProfileResultData};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f35798b = this;
                            this.f35797a = tubeProfileResultData;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.f35798b.f35796a.a(this.f35797a);
                            }
                        }
                    });
                }
            }
        });
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            i<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData> iVar = this.f35790c;
            if (iVar != null) {
                iVar.e();
            }
            this.f35789b = null;
            this.f35788a.removeCallbacksAndMessages(null);
        }
    }
}
