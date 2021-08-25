package com.kwad.sdk.core.webview;

import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.y;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f72242a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f72243b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f72244c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f72245d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f72246e;

    /* renamed from: f  reason: collision with root package name */
    public WebView f72247f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public y f72248g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f72249h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f72250i;

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
        this.f72249h = true;
        this.f72250i = true;
    }
}
