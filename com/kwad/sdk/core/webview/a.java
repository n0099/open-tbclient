package com.kwad.sdk.core.webview;

import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ac;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f57955b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f57956c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f57957d;

    /* renamed from: e  reason: collision with root package name */
    public WebView f57958e;

    /* renamed from: f  reason: collision with root package name */
    public b f57959f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public ac f57960g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57961h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57962i;

    /* renamed from: j  reason: collision with root package name */
    public List<AdTemplate> f57963j;

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
        this.f57961h = true;
        this.f57962i = true;
        this.f57963j = null;
    }

    public AdTemplate a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<AdTemplate> list = this.f57963j;
            if (list == null || list.size() == 0) {
                return null;
            }
            return this.f57963j.get(0);
        }
        return (AdTemplate) invokeV.objValue;
    }

    @Nullable
    public AdTemplate a(long j2) {
        InterceptResult invokeJ;
        List<AdTemplate> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            if (j2 >= 0 && (list = this.f57963j) != null) {
                for (AdTemplate adTemplate : list) {
                    if (d.y(adTemplate) == j2) {
                        return adTemplate;
                    }
                }
            }
            return null;
        }
        return (AdTemplate) invokeJ.objValue;
    }

    public void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adTemplate) == null) {
            ArrayList arrayList = new ArrayList();
            this.f57963j = arrayList;
            arrayList.add(adTemplate);
        }
    }

    public void a(List<AdTemplate> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f57963j = list;
        }
    }

    public List<AdTemplate> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f57963j : (List) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<AdTemplate> list = this.f57963j;
            return list == null || list.size() == 0;
        }
        return invokeV.booleanValue;
    }
}
