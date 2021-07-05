package com.kwad.sdk.contentalliance.profile.home;

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
import com.kwad.sdk.contentalliance.profile.home.model.ProfileResultData;
import com.kwad.sdk.contentalliance.profile.home.model.UserProfile;
import com.kwad.sdk.core.g.a.f;
import com.kwad.sdk.core.g.q;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f35313a;

    /* renamed from: b  reason: collision with root package name */
    public a f35314b;

    /* renamed from: c  reason: collision with root package name */
    public i<q, ProfileResultData> f35315c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35316d;

    /* renamed from: e  reason: collision with root package name */
    public f f35317e;

    /* renamed from: f  reason: collision with root package name */
    public long f35318f;

    /* loaded from: classes7.dex */
    public interface a {
        @MainThread
        void a();

        @MainThread
        void a(int i2, String str);

        @MainThread
        void a(UserProfile userProfile);

        @MainThread
        void b();
    }

    public b(f fVar, long j, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, Long.valueOf(j), aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35316d = false;
        this.f35313a = new Handler(Looper.getMainLooper());
        this.f35317e = fVar;
        this.f35318f = j;
        this.f35314b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, this, i2, str) == null) {
            com.kwad.sdk.core.d.a.c("DataFetcherProfile", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
            b(i2, str);
            this.f35316d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ProfileResultData profileResultData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, profileResultData) == null) {
            a(profileResultData.userProfile);
            d();
            this.f35316d = false;
        }
    }

    private void a(UserProfile userProfile) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, userProfile) == null) || (aVar = this.f35314b) == null) {
            return;
        }
        aVar.a(userProfile);
    }

    private void b(int i2, String str) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65544, this, i2, str) == null) || (aVar = this.f35314b) == null) {
            return;
        }
        aVar.a(i2, str);
    }

    private void c() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || (aVar = this.f35314b) == null) {
            return;
        }
        aVar.a();
    }

    private void d() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (aVar = this.f35314b) == null) {
            return;
        }
        aVar.b();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f35316d) {
            return;
        }
        c();
        i<q, ProfileResultData> iVar = new i<q, ProfileResultData>(this) { // from class: com.kwad.sdk.contentalliance.profile.home.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f35319a;

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
                this.f35319a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public ProfileResultData b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) {
                    JSONObject jSONObject = new JSONObject(str);
                    ProfileResultData profileResultData = new ProfileResultData();
                    profileResultData.parseJson(jSONObject);
                    return profileResultData;
                }
                return (ProfileResultData) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: c */
            public q b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? new q(this.f35319a.f35317e, this.f35319a.f35318f) : (q) invokeV.objValue;
            }
        };
        this.f35315c = iVar;
        iVar.a(new j<q, ProfileResultData>(this) { // from class: com.kwad.sdk.contentalliance.profile.home.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f35320a;

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
                this.f35320a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull q qVar, int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, qVar, i2, str) == null) {
                    this.f35320a.f35313a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.contentalliance.profile.home.b.2.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f35323a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f35324b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f35325c;

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
                            this.f35325c = this;
                            this.f35323a = i2;
                            this.f35324b = str;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.f35325c.f35320a.a(this.f35323a, this.f35324b);
                            }
                        }
                    });
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull q qVar, @NonNull ProfileResultData profileResultData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar, profileResultData) == null) {
                    this.f35320a.f35313a.post(new Runnable(this, profileResultData) { // from class: com.kwad.sdk.contentalliance.profile.home.b.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ ProfileResultData f35321a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f35322b;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, profileResultData};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f35322b = this;
                            this.f35321a = profileResultData;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.f35322b.f35320a.a(this.f35321a);
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
            i<q, ProfileResultData> iVar = this.f35315c;
            if (iVar != null) {
                iVar.e();
            }
            this.f35314b = null;
            this.f35313a.removeCallbacksAndMessages(null);
        }
    }
}
