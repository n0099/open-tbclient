package com.kwad.sdk.api.proxy.app;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.proxy.BaseProxyFragmentActivity;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;
@Keep
/* loaded from: classes6.dex */
public abstract class BaseFragmentActivity extends BaseProxyFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    /* loaded from: classes6.dex */
    public static class DeveloperConfigActivity extends BaseFragmentActivity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DeveloperConfigActivity() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.proxy.BaseProxyFragmentActivity
        @NonNull
        public IFragmentActivityProxy getDelegate(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? (IFragmentActivityProxy) Loader.get().newComponentProxy(context, DeveloperConfigActivity.class, this) : (IFragmentActivityProxy) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class EpisodeDetailActivity extends BaseFragmentActivity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public EpisodeDetailActivity() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.proxy.BaseProxyFragmentActivity
        @NonNull
        public IFragmentActivityProxy getDelegate(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? (IFragmentActivityProxy) Loader.get().newComponentProxy(context, EpisodeDetailActivity.class, this) : (IFragmentActivityProxy) invokeL.objValue;
        }
    }

    @Keep
    /* loaded from: classes6.dex */
    public static class FragmentActivity1 extends BaseFragmentActivity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public FragmentActivity1() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.proxy.BaseProxyFragmentActivity
        @NonNull
        public IFragmentActivityProxy getDelegate(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? (IFragmentActivityProxy) Loader.get().newComponentProxy(context, FragmentActivity1.class, this) : (IFragmentActivityProxy) invokeL.objValue;
        }
    }

    @Keep
    /* loaded from: classes6.dex */
    public static class FragmentActivity10 extends BaseFragmentActivity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public FragmentActivity10() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.proxy.BaseProxyFragmentActivity
        @NonNull
        public IFragmentActivityProxy getDelegate(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? (IFragmentActivityProxy) Loader.get().newComponentProxy(context, FragmentActivity10.class, this) : (IFragmentActivityProxy) invokeL.objValue;
        }
    }

    @Keep
    /* loaded from: classes6.dex */
    public static class FragmentActivity2 extends BaseFragmentActivity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public FragmentActivity2() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.proxy.BaseProxyFragmentActivity
        @NonNull
        public IFragmentActivityProxy getDelegate(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? (IFragmentActivityProxy) Loader.get().newComponentProxy(context, FragmentActivity2.class, this) : (IFragmentActivityProxy) invokeL.objValue;
        }
    }

    @Keep
    /* loaded from: classes6.dex */
    public static class FragmentActivity3 extends BaseFragmentActivity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public FragmentActivity3() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.proxy.BaseProxyFragmentActivity
        @NonNull
        public IFragmentActivityProxy getDelegate(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? (IFragmentActivityProxy) Loader.get().newComponentProxy(context, FragmentActivity3.class, this) : (IFragmentActivityProxy) invokeL.objValue;
        }
    }

    @Keep
    /* loaded from: classes6.dex */
    public static class FragmentActivity4 extends BaseFragmentActivity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public FragmentActivity4() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.proxy.BaseProxyFragmentActivity
        @NonNull
        public IFragmentActivityProxy getDelegate(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? (IFragmentActivityProxy) Loader.get().newComponentProxy(context, FragmentActivity4.class, this) : (IFragmentActivityProxy) invokeL.objValue;
        }
    }

    @Keep
    /* loaded from: classes6.dex */
    public static class FragmentActivity5 extends BaseFragmentActivity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public FragmentActivity5() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.proxy.BaseProxyFragmentActivity
        @NonNull
        public IFragmentActivityProxy getDelegate(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? (IFragmentActivityProxy) Loader.get().newComponentProxy(context, FragmentActivity5.class, this) : (IFragmentActivityProxy) invokeL.objValue;
        }
    }

    @Keep
    /* loaded from: classes6.dex */
    public static class FragmentActivity6 extends BaseFragmentActivity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public FragmentActivity6() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.proxy.BaseProxyFragmentActivity
        @NonNull
        public IFragmentActivityProxy getDelegate(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? (IFragmentActivityProxy) Loader.get().newComponentProxy(context, FragmentActivity6.class, this) : (IFragmentActivityProxy) invokeL.objValue;
        }
    }

    @Keep
    /* loaded from: classes6.dex */
    public static class FragmentActivity7 extends BaseFragmentActivity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public FragmentActivity7() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.proxy.BaseProxyFragmentActivity
        @NonNull
        public IFragmentActivityProxy getDelegate(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? (IFragmentActivityProxy) Loader.get().newComponentProxy(context, FragmentActivity7.class, this) : (IFragmentActivityProxy) invokeL.objValue;
        }
    }

    @Keep
    /* loaded from: classes6.dex */
    public static class FragmentActivity8 extends BaseFragmentActivity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public FragmentActivity8() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.proxy.BaseProxyFragmentActivity
        @NonNull
        public IFragmentActivityProxy getDelegate(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? (IFragmentActivityProxy) Loader.get().newComponentProxy(context, FragmentActivity8.class, this) : (IFragmentActivityProxy) invokeL.objValue;
        }
    }

    @Keep
    /* loaded from: classes6.dex */
    public static class FragmentActivity9 extends BaseFragmentActivity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public FragmentActivity9() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.proxy.BaseProxyFragmentActivity
        @NonNull
        public IFragmentActivityProxy getDelegate(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? (IFragmentActivityProxy) Loader.get().newComponentProxy(context, FragmentActivity9.class, this) : (IFragmentActivityProxy) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class FragmentActivitySingleInstance1 extends BaseFragmentActivity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public FragmentActivitySingleInstance1() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.proxy.BaseProxyFragmentActivity
        @NonNull
        public IFragmentActivityProxy getDelegate(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? (IFragmentActivityProxy) Loader.get().newComponentProxy(context, FragmentActivitySingleInstance1.class, this) : (IFragmentActivityProxy) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class FragmentActivitySingleInstance2 extends BaseFragmentActivity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public FragmentActivitySingleInstance2() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.proxy.BaseProxyFragmentActivity
        @NonNull
        public IFragmentActivityProxy getDelegate(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? (IFragmentActivityProxy) Loader.get().newComponentProxy(context, FragmentActivitySingleInstance2.class, this) : (IFragmentActivityProxy) invokeL.objValue;
        }
    }

    @Keep
    /* loaded from: classes6.dex */
    public static class FragmentActivitySingleTop1 extends BaseFragmentActivity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public FragmentActivitySingleTop1() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.proxy.BaseProxyFragmentActivity
        @NonNull
        public IFragmentActivityProxy getDelegate(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? (IFragmentActivityProxy) Loader.get().newComponentProxy(context, FragmentActivitySingleTop1.class, this) : (IFragmentActivityProxy) invokeL.objValue;
        }
    }

    @Keep
    /* loaded from: classes6.dex */
    public static class FragmentActivitySingleTop2 extends BaseFragmentActivity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public FragmentActivitySingleTop2() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.proxy.BaseProxyFragmentActivity
        @NonNull
        public IFragmentActivityProxy getDelegate(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? (IFragmentActivityProxy) Loader.get().newComponentProxy(context, FragmentActivitySingleTop2.class, this) : (IFragmentActivityProxy) invokeL.objValue;
        }
    }

    @Keep
    /* loaded from: classes6.dex */
    public static class KsTrendsActivity extends BaseFragmentActivity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public KsTrendsActivity() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.proxy.BaseProxyFragmentActivity
        @NonNull
        public IFragmentActivityProxy getDelegate(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? (IFragmentActivityProxy) Loader.get().newComponentProxy(context, KsTrendsActivity.class, this) : (IFragmentActivityProxy) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class ProfileHomeActivity extends BaseFragmentActivity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ProfileHomeActivity() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.proxy.BaseProxyFragmentActivity
        @NonNull
        public IFragmentActivityProxy getDelegate(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? (IFragmentActivityProxy) Loader.get().newComponentProxy(context, ProfileHomeActivity.class, this) : (IFragmentActivityProxy) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class ProfileVideoDetailActivity extends BaseFragmentActivity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ProfileVideoDetailActivity() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.proxy.BaseProxyFragmentActivity
        @NonNull
        public IFragmentActivityProxy getDelegate(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? (IFragmentActivityProxy) Loader.get().newComponentProxy(context, ProfileVideoDetailActivity.class, this) : (IFragmentActivityProxy) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class TubeDetailActivity extends BaseFragmentActivity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public TubeDetailActivity() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.proxy.BaseProxyFragmentActivity
        @NonNull
        public IFragmentActivityProxy getDelegate(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? (IFragmentActivityProxy) Loader.get().newComponentProxy(context, TubeDetailActivity.class, this) : (IFragmentActivityProxy) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class TubeProfileActivity extends BaseFragmentActivity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public TubeProfileActivity() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.proxy.BaseProxyFragmentActivity
        @NonNull
        public IFragmentActivityProxy getDelegate(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? (IFragmentActivityProxy) Loader.get().newComponentProxy(context, TubeProfileActivity.class, this) : (IFragmentActivityProxy) invokeL.objValue;
        }
    }

    public BaseFragmentActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
