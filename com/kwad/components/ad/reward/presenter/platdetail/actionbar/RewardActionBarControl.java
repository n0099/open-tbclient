package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.l;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public final class RewardActionBarControl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l a;
    public c b;
    @Nullable
    public g c;
    @Nullable
    public a d;
    @Nullable
    public d e;
    @Nullable
    public e f;
    @Nullable
    public f g;
    @NonNull
    public b h;
    public AdTemplate i;
    public AdInfo j;
    public Handler k;
    public final long l;
    public boolean m;
    public Context n;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class ShowActionBarResult {
        public static final /* synthetic */ ShowActionBarResult[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ShowActionBarResult SHOW_FOLLOW;
        public static final ShowActionBarResult SHOW_H5_FAILURE;
        public static final ShowActionBarResult SHOW_H5_SUCCESS;
        public static final ShowActionBarResult SHOW_NATIVE_DEFAULT;
        public static final ShowActionBarResult SHOW_NATIVE_FOLLOW;
        public static final ShowActionBarResult SHOW_NATIVE_JINNIU;
        public static final ShowActionBarResult SHOW_NATIVE_LIVE_SUBSCRIBE;
        public static final ShowActionBarResult SHOW_NATIVE_ORDER;
        public static final ShowActionBarResult SHOW_NATIVE_PLAYABLE_PORTRAIT;
        public static final ShowActionBarResult SHOW_NEW_STYLE;
        public static final ShowActionBarResult SHOW_ORDER;
        public static final ShowActionBarResult TK;
        public static final ShowActionBarResult TK_NEW_STYLE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1500439904, "Lcom/kwad/components/ad/reward/presenter/platdetail/actionbar/RewardActionBarControl$ShowActionBarResult;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1500439904, "Lcom/kwad/components/ad/reward/presenter/platdetail/actionbar/RewardActionBarControl$ShowActionBarResult;");
                    return;
                }
            }
            SHOW_NEW_STYLE = new ShowActionBarResult("SHOW_NEW_STYLE", 0);
            SHOW_NATIVE_DEFAULT = new ShowActionBarResult("SHOW_NATIVE_DEFAULT", 1);
            SHOW_H5_SUCCESS = new ShowActionBarResult("SHOW_H5_SUCCESS", 2);
            SHOW_H5_FAILURE = new ShowActionBarResult("SHOW_H5_FAILURE", 3);
            SHOW_FOLLOW = new ShowActionBarResult("SHOW_FOLLOW", 4);
            SHOW_ORDER = new ShowActionBarResult("SHOW_ORDER", 5);
            TK = new ShowActionBarResult("TK", 6);
            TK_NEW_STYLE = new ShowActionBarResult("TK_NEW_STYLE", 7);
            SHOW_NATIVE_ORDER = new ShowActionBarResult("SHOW_NATIVE_ORDER", 8);
            SHOW_NATIVE_FOLLOW = new ShowActionBarResult("SHOW_NATIVE_FOLLOW", 9);
            SHOW_NATIVE_JINNIU = new ShowActionBarResult("SHOW_NATIVE_JINNIU", 10);
            SHOW_NATIVE_PLAYABLE_PORTRAIT = new ShowActionBarResult("SHOW_NATIVE_PLAYABLE_PORTRAIT", 11);
            ShowActionBarResult showActionBarResult = new ShowActionBarResult("SHOW_NATIVE_LIVE_SUBSCRIBE", 12);
            SHOW_NATIVE_LIVE_SUBSCRIBE = showActionBarResult;
            $VALUES = new ShowActionBarResult[]{SHOW_NEW_STYLE, SHOW_NATIVE_DEFAULT, SHOW_H5_SUCCESS, SHOW_H5_FAILURE, SHOW_FOLLOW, SHOW_ORDER, TK, TK_NEW_STYLE, SHOW_NATIVE_ORDER, SHOW_NATIVE_FOLLOW, SHOW_NATIVE_JINNIU, SHOW_NATIVE_PLAYABLE_PORTRAIT, showActionBarResult};
        }

        public ShowActionBarResult(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes5.dex */
    public interface a {
        void a(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    /* loaded from: classes5.dex */
    public static class b implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<com.kwad.components.ad.reward.presenter.platdetail.actionbar.a> a;
        public ShowActionBarResult b;

        public b() {
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
            this.a = new CopyOnWriteArrayList();
        }

        public /* synthetic */ b(byte b) {
            this();
        }

        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
        public final void a(ShowActionBarResult showActionBarResult, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, showActionBarResult, view2) == null) {
                com.kwad.sdk.core.d.b.a("ActionBarControl", "onActionBarShown result: " + showActionBarResult);
                this.b = showActionBarResult;
                for (com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar : this.a) {
                    aVar.a(showActionBarResult, view2);
                }
            }
        }

        public final void a(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.add(aVar);
            }
        }

        public final void b(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                this.a.remove(aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(boolean z, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    /* loaded from: classes5.dex */
    public interface f {
    }

    /* loaded from: classes5.dex */
    public interface g {
        boolean a(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    public RewardActionBarControl(l lVar, Context context, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, context, adTemplate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new b((byte) 0);
        this.a = lVar;
        this.n = context;
        this.i = adTemplate;
        this.j = com.kwad.sdk.core.response.a.d.i(adTemplate);
        this.k = new Handler(Looper.getMainLooper());
        this.m = false;
        long b2 = !com.kwad.sdk.core.response.a.a.aV(this.j) ? com.kwad.sdk.core.response.a.b.b(adTemplate) : 1000L;
        this.l = b2 > 0 ? b2 : 1000L;
    }

    public static void a(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar, View view2, ShowActionBarResult showActionBarResult) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, aVar, view2, showActionBarResult) == null) || aVar == null) {
            return;
        }
        view2.post(new Runnable(aVar, showActionBarResult, view2) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ com.kwad.components.ad.reward.presenter.platdetail.actionbar.a a;
            public final /* synthetic */ ShowActionBarResult b;
            public final /* synthetic */ View c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, showActionBarResult, view2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
                this.b = showActionBarResult;
                this.c = view2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.a(this.b, this.c);
                }
            }
        });
    }

    private ShowActionBarResult b(boolean z) {
        InterceptResult invokeZ;
        d dVar;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z)) == null) {
            if (l.c(this.a)) {
                if (com.kwad.sdk.core.response.a.b.a(this.n, this.i) && this.g != null) {
                    return ShowActionBarResult.TK_NEW_STYLE;
                }
                e eVar = this.f;
                if (eVar != null) {
                    eVar.a(this.h);
                    return ShowActionBarResult.TK;
                }
            }
            if (com.kwad.components.ad.reward.kwai.b.a(this.j) && (aVar = this.d) != null) {
                aVar.a(this.h);
                return ShowActionBarResult.SHOW_FOLLOW;
            } else if (com.kwad.components.ad.reward.kwai.b.b(this.j) && (dVar = this.e) != null) {
                dVar.a(this.h);
                return ShowActionBarResult.SHOW_ORDER;
            } else if (com.kwad.sdk.core.response.a.a.a(this.i, this.j)) {
                return ShowActionBarResult.SHOW_NEW_STYLE;
            } else {
                if (!com.kwad.sdk.core.response.a.b.c(this.i) || this.c == null) {
                    c(z);
                    return ShowActionBarResult.SHOW_NATIVE_DEFAULT;
                }
                com.kwad.sdk.core.d.b.a("ActionBarControl", "showWebActionBar success in " + this.l);
                return this.c.a(this.h) ? ShowActionBarResult.SHOW_H5_SUCCESS : ShowActionBarResult.SHOW_H5_FAILURE;
            }
        }
        return (ShowActionBarResult) invokeZ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65544, this, z) == null) || this.b == null) {
            return;
        }
        com.kwad.sdk.core.d.b.a("ActionBarControl", "showNativeActionBar");
        this.b.a(z, this.h);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.m) {
                com.kwad.sdk.core.d.b.c("ActionBarControl", "showWebActionBar time out on pageStatus");
                return;
            }
            this.k.removeCallbacksAndMessages(null);
            b(true);
        }
    }

    @MainThread
    public final void a(@Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.d = aVar;
        }
    }

    @MainThread
    public final void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.b = cVar;
        }
    }

    @MainThread
    public final void a(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.e = dVar;
        }
    }

    public final void a(@Nullable e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f = eVar;
        }
    }

    @MainThread
    public final void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.c = gVar;
        }
    }

    public final void a(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.h.a(aVar);
        }
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            ShowActionBarResult b2 = b(z);
            com.kwad.sdk.core.d.b.a("ActionBarControl", "showActionBarOnVideoStart result: " + b2);
            if (b2 != ShowActionBarResult.SHOW_H5_FAILURE) {
                return;
            }
            this.k.postDelayed(new Runnable(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.1
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.m = true;
                        com.kwad.sdk.core.d.b.a("ActionBarControl", "mHasOutTime");
                        if (this.a.c != null && this.a.c.a(this.a.h)) {
                            com.kwad.sdk.core.d.b.a("ActionBarControl", "showWebActionBar success on " + this.a.l);
                            return;
                        }
                        com.kwad.sdk.core.d.b.a("ActionBarControl", "showWebActionBar out " + this.a.l);
                        com.kwad.components.core.i.a.a().c(this.a.i, this.a.l);
                        this.a.c(true);
                    }
                }
            }, this.l);
        }
    }

    @Nullable
    public final ShowActionBarResult b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.h.b : (ShowActionBarResult) invokeV.objValue;
    }

    public final void b(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.h.b(aVar);
        }
    }
}
