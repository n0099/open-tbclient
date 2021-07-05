package com.kwad.sdk.contentalliance.tube;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.tube.b.a;
import com.kwad.sdk.core.g.a.f;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f35606a;

    /* renamed from: b  reason: collision with root package name */
    public a f35607b;

    /* renamed from: c  reason: collision with root package name */
    public i<com.kwad.sdk.contentalliance.tube.b.a, AdResultData> f35608c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f35609d;

    /* renamed from: e  reason: collision with root package name */
    public long f35610e;

    /* renamed from: f  reason: collision with root package name */
    public SceneImpl f35611f;

    /* loaded from: classes7.dex */
    public interface a {
        @MainThread
        void a(boolean z);

        @MainThread
        void a(boolean z, int i2, String str);

        @MainThread
        void a(boolean z, @NonNull AdResultData adResultData);

        @MainThread
        void b(boolean z);
    }

    public b(SceneImpl sceneImpl, long j, a aVar) {
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
        this.f35609d = new AtomicBoolean(false);
        this.f35606a = new Handler(Looper.getMainLooper());
        this.f35611f = sceneImpl;
        this.f35610e = j;
        this.f35607b = aVar;
    }

    private void a(boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, this, z) == null) || (aVar = this.f35607b) == null) {
            return;
        }
        aVar.a(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i2, String str) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str}) == null) || (aVar = this.f35607b) == null) {
            return;
        }
        aVar.a(z, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AdResultData adResultData) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(65543, this, z, adResultData) == null) || (aVar = this.f35607b) == null) {
            return;
        }
        aVar.a(z, adResultData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65545, this, z) == null) || (aVar = this.f35607b) == null) {
            return;
        }
        aVar.b(z);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i<com.kwad.sdk.contentalliance.tube.b.a, AdResultData> iVar = this.f35608c;
            if (iVar != null) {
                iVar.e();
            }
            this.f35607b = null;
            this.f35606a.removeCallbacksAndMessages(null);
        }
    }

    public void a(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) || this.f35609d.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.a("TubeFeedLoadManager", "loadData startRequest loadMore =" + z + " lastPhotoId=" + j);
        a(z);
        f fVar = new f(this.f35611f);
        fVar.f36139b = (long) this.f35611f.getPageScene();
        fVar.f36140c = 100L;
        com.kwad.sdk.core.d.a.a("TubeFeedLoadManager", "pageScene=" + fVar.f36139b + " lastPhotoId=" + j);
        i<com.kwad.sdk.contentalliance.tube.b.a, AdResultData> iVar = new i<com.kwad.sdk.contentalliance.tube.b.a, AdResultData>(this, new a.C0418a(fVar, this.f35610e, j, 15)) { // from class: com.kwad.sdk.contentalliance.tube.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a.C0418a f35612a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f35613b;

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
                this.f35613b = this;
                this.f35612a = r7;
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
                    AdResultData adResultData = new AdResultData(this.f35613b.f35611f);
                    adResultData.parseJson(jSONObject);
                    return adResultData;
                }
                return (AdResultData) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: c */
            public com.kwad.sdk.contentalliance.tube.b.a b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? new com.kwad.sdk.contentalliance.tube.b.a(this.f35612a) : (com.kwad.sdk.contentalliance.tube.b.a) invokeV.objValue;
            }
        };
        this.f35608c = iVar;
        iVar.a(new j<com.kwad.sdk.contentalliance.tube.b.a, AdResultData>(this, z, j) { // from class: com.kwad.sdk.contentalliance.tube.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean f35614a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f35615b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f35616c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Boolean.valueOf(z), Long.valueOf(j)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f35616c = this;
                this.f35614a = z;
                this.f35615b = j;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.contentalliance.tube.b.a aVar, int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, aVar, i2, str) == null) {
                    com.kwad.sdk.core.d.a.a("TubeFeedLoadManager", "lastPhotoId=" + this.f35615b + " errorCode = " + i2 + " errorMsg=" + str);
                    this.f35616c.f35606a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.contentalliance.tube.b.2.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f35619a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f35620b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f35621c;

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
                            this.f35621c = this;
                            this.f35619a = i2;
                            this.f35620b = str;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                com.kwad.sdk.core.d.a.c("TubeFeedLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f35619a), this.f35620b));
                                AnonymousClass2 anonymousClass2 = this.f35621c;
                                anonymousClass2.f35616c.a(anonymousClass2.f35614a, this.f35619a, this.f35620b);
                                this.f35621c.f35616c.f35609d.set(false);
                            }
                        }
                    });
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.contentalliance.tube.b.a aVar, @NonNull AdResultData adResultData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, adResultData) == null) {
                    this.f35616c.f35606a.post(new Runnable(this, adResultData) { // from class: com.kwad.sdk.contentalliance.tube.b.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdResultData f35617a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f35618b;

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
                            this.f35618b = this;
                            this.f35617a = adResultData;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                AnonymousClass2 anonymousClass2 = this.f35618b;
                                anonymousClass2.f35616c.a(anonymousClass2.f35614a, this.f35617a);
                                AnonymousClass2 anonymousClass22 = this.f35618b;
                                anonymousClass22.f35616c.b(anonymousClass22.f35614a);
                                this.f35618b.f35616c.f35609d.set(false);
                            }
                        }
                    });
                }
            }
        });
    }
}
