package com.kwad.sdk.contentalliance.trends;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.g.o;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.af;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends IFragmentActivityProxy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TrendInfo f35524a;

    /* renamed from: b  reason: collision with root package name */
    public KsFragment f35525b;

    /* renamed from: c  reason: collision with root package name */
    public SceneImpl f35526c;

    /* renamed from: d  reason: collision with root package name */
    public TrendsParams f35527d;

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
        this.f35524a = new TrendInfo();
    }

    public static c a(@NonNull KsScene ksScene, @NonNull List<TrendInfo> list, @NonNull TrendInfo trendInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, ksScene, list, trendInfo)) == null) {
            c cVar = new c(ksScene);
            cVar.a(list, trendInfo);
            return cVar;
        }
        return (c) invokeLLL.objValue;
    }

    public static void a(Context context, @NonNull TrendsParams trendsParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65540, null, context, trendsParams) == null) {
            Intent intent = new Intent(context, BaseFragmentActivity.KsTrendsActivity.class);
            intent.putExtra("KEY_TREND_PARAMS", trendsParams);
            context.startActivity(intent);
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, this, z) == null) {
            o.a(z, new o.d(this, R.id.ksad_content_trends_container) { // from class: com.kwad.sdk.contentalliance.trends.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f35528a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f35529b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r7)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35529b = this;
                    this.f35528a = r7;
                }

                @Override // com.kwad.sdk.core.g.o.d
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        c a2 = b.a(this.f35529b.f35526c, new ArrayList(), this.f35529b.f35524a);
                        this.f35529b.f35525b = a2.a();
                        if (this.f35529b.getActivity() == null || this.f35529b.getActivity().isFinishing()) {
                            return;
                        }
                        this.f35529b.getSupportFragmentManager().beginTransaction().replace(this.f35528a, this.f35529b.f35525b).commitAllowingStateLoss();
                    }
                }

                @Override // com.kwad.sdk.core.g.o.d
                public void a(@NonNull List<TrendInfo> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                        Collections.sort(list, TrendInfo.mTrendsComparator);
                        c a2 = b.a(this.f35529b.f35526c, list, this.f35529b.f35524a);
                        this.f35529b.f35525b = a2.a();
                        if (this.f35529b.getActivity() == null || this.f35529b.getActivity().isFinishing()) {
                            return;
                        }
                        this.f35529b.getSupportFragmentManager().beginTransaction().replace(this.f35528a, this.f35529b.f35525b).commitAllowingStateLoss();
                    }
                }
            });
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            Serializable serializableExtra = getIntent().getSerializableExtra("KEY_TREND_PARAMS");
            if (serializableExtra instanceof TrendsParams) {
                TrendsParams trendsParams = (TrendsParams) serializableExtra;
                this.f35527d = trendsParams;
                TrendInfo trendInfo = trendsParams.trendInfo;
                if (trendInfo != null) {
                    this.f35524a = trendInfo;
                }
                this.f35526c = new SceneImpl(this.f35527d.mEntryScene);
                URLPackage uRLPackage = new URLPackage(String.valueOf(hashCode()), 2);
                uRLPackage.putParams(URLPackage.KEY_TREND_ID, this.f35524a.trendId);
                this.f35526c.setUrlPackage(uRLPackage);
            }
            TrendsParams trendsParams2 = this.f35527d;
            return (trendsParams2 == null || trendsParams2.mEntryScene == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            af.a(getActivity());
            setContentView(R.layout.ksad_activity_trends_list);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ksad_trends_top_panel), new OnApplyWindowInsetsListener(this) { // from class: com.kwad.sdk.contentalliance.trends.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f35530a;

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
                    this.f35530a = this;
                }

                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, windowInsetsCompat)) == null) {
                        af.a(view, windowInsetsCompat.getSystemWindowInsetTop());
                        return windowInsetsCompat.consumeSystemWindowInsets();
                    }
                    return (WindowInsetsCompat) invokeLL.objValue;
                }
            });
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            if (a()) {
                b();
                a(true);
            }
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
        }
    }
}
