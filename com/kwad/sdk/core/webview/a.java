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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f58536b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f58537c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f58538d;

    /* renamed from: e  reason: collision with root package name */
    public WebView f58539e;

    /* renamed from: f  reason: collision with root package name */
    public b f58540f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public ac f58541g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f58542h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f58543i;

    /* renamed from: j  reason: collision with root package name */
    public List<AdTemplate> f58544j;

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
        this.f58542h = true;
        this.f58543i = true;
        this.f58544j = null;
    }

    public AdTemplate a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<AdTemplate> list = this.f58544j;
            if (list == null || list.size() == 0) {
                return null;
            }
            return this.f58544j.get(0);
        }
        return (AdTemplate) invokeV.objValue;
    }

    @Nullable
    public AdTemplate a(long j2) {
        InterceptResult invokeJ;
        List<AdTemplate> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            if (j2 >= 0 && (list = this.f58544j) != null) {
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
            this.f58544j = arrayList;
            arrayList.add(adTemplate);
        }
    }

    public void a(List<AdTemplate> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f58544j = list;
        }
    }

    public List<AdTemplate> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f58544j : (List) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<AdTemplate> list = this.f58544j;
            return list == null || list.size() == 0;
        }
        return invokeV.booleanValue;
    }
}
