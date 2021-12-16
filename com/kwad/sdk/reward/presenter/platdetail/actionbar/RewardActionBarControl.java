package com.kwad.sdk.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public class RewardActionBarControl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public d f59785b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public a f59786c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public c f59787d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f59788e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f59789f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f59790g;

    /* renamed from: h  reason: collision with root package name */
    public final long f59791h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f59792i;

    /* renamed from: j  reason: collision with root package name */
    public Context f59793j;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class ShowActionBarResult {
        public static final /* synthetic */ ShowActionBarResult[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ShowActionBarResult SHOW_FOLLOW;
        public static final ShowActionBarResult SHOW_H5_FAILURE;
        public static final ShowActionBarResult SHOW_H5_SUCCESS;
        public static final ShowActionBarResult SHOW_NATIVE;
        public static final ShowActionBarResult SHOW_NEW_STYLE;
        public static final ShowActionBarResult SHOW_ORDER;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2029077022, "Lcom/kwad/sdk/reward/presenter/platdetail/actionbar/RewardActionBarControl$ShowActionBarResult;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2029077022, "Lcom/kwad/sdk/reward/presenter/platdetail/actionbar/RewardActionBarControl$ShowActionBarResult;");
                    return;
                }
            }
            SHOW_NEW_STYLE = new ShowActionBarResult("SHOW_NEW_STYLE", 0);
            SHOW_NATIVE = new ShowActionBarResult("SHOW_NATIVE", 1);
            SHOW_H5_SUCCESS = new ShowActionBarResult("SHOW_H5_SUCCESS", 2);
            SHOW_H5_FAILURE = new ShowActionBarResult("SHOW_H5_FAILURE", 3);
            SHOW_FOLLOW = new ShowActionBarResult("SHOW_FOLLOW", 4);
            ShowActionBarResult showActionBarResult = new ShowActionBarResult("SHOW_ORDER", 5);
            SHOW_ORDER = showActionBarResult;
            $VALUES = new ShowActionBarResult[]{SHOW_NEW_STYLE, SHOW_NATIVE, SHOW_H5_SUCCESS, SHOW_H5_FAILURE, SHOW_FOLLOW, showActionBarResult};
        }

        public ShowActionBarResult(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ShowActionBarResult valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ShowActionBarResult) Enum.valueOf(ShowActionBarResult.class, str) : (ShowActionBarResult) invokeL.objValue;
        }

        public static ShowActionBarResult[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ShowActionBarResult[]) $VALUES.clone() : (ShowActionBarResult[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface a {
        void d();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void d();
    }

    /* loaded from: classes3.dex */
    public interface d {
        boolean a();
    }

    public RewardActionBarControl(Context context, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adTemplate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59793j = context;
        this.f59788e = adTemplate;
        this.f59789f = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f59790g = new Handler(Looper.getMainLooper());
        this.f59792i = false;
        long c2 = com.kwad.sdk.core.response.a.b.c(adTemplate);
        this.f59791h = c2 <= 0 ? 1000L : c2;
    }

    private ShowActionBarResult a(boolean z) {
        InterceptResult invokeZ;
        c cVar;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, this, z)) == null) {
            if (com.kwad.sdk.core.response.a.a.aH(this.f59789f) && (aVar = this.f59786c) != null) {
                aVar.d();
                return ShowActionBarResult.SHOW_FOLLOW;
            } else if (com.kwad.sdk.core.response.a.a.aI(this.f59789f) && (cVar = this.f59787d) != null) {
                cVar.d();
                return ShowActionBarResult.SHOW_ORDER;
            } else if (com.kwad.sdk.core.response.a.a.T(this.f59789f)) {
                return ShowActionBarResult.SHOW_NEW_STYLE;
            } else {
                if (!com.kwad.sdk.core.response.a.b.d(this.f59788e) || this.f59785b == null) {
                    b(z);
                    return ShowActionBarResult.SHOW_NATIVE;
                }
                com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success in " + this.f59791h);
                return this.f59785b.a() ? ShowActionBarResult.SHOW_H5_SUCCESS : ShowActionBarResult.SHOW_H5_FAILURE;
            }
        }
        return (ShowActionBarResult) invokeZ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65542, this, z) == null) || this.a == null) {
            return;
        }
        com.kwad.sdk.core.d.a.a("ActionBarControl", "showNativeActionBar");
        this.a.a(z);
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            ShowActionBarResult a2 = a(false);
            com.kwad.sdk.core.d.a.a("ActionBarControl", "showActionBarOnVideoStart result: " + a2);
            if (a2 != ShowActionBarResult.SHOW_H5_FAILURE) {
                return;
            }
            this.f59790g.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RewardActionBarControl a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.f59792i = true;
                        com.kwad.sdk.core.d.a.a("ActionBarControl", "mHasOutTime");
                        if (this.a.f59785b != null && this.a.f59785b.a()) {
                            com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success on " + this.a.f59791h);
                            return;
                        }
                        com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar out " + this.a.f59791h);
                        com.kwad.sdk.core.report.d.c(this.a.f59788e, this.a.f59791h);
                        this.a.b(true);
                    }
                }
            }, this.f59791h);
        }
    }

    @MainThread
    public void a(@Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f59786c = aVar;
        }
    }

    @MainThread
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.a = bVar;
        }
    }

    @MainThread
    public void a(@Nullable c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f59787d = cVar;
        }
    }

    @MainThread
    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.f59785b = dVar;
        }
    }

    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            if (this.f59792i) {
                com.kwad.sdk.core.d.a.c("ActionBarControl", "showWebActionBar time out on pageStatus");
                return;
            }
            this.f59790g.removeCallbacksAndMessages(null);
            a(true);
        }
    }
}
