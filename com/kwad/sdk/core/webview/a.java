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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f35098a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f35099b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f35100c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f35101d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f35102e;

    /* renamed from: f  reason: collision with root package name */
    public WebView f35103f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public y f35104g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f35105h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f35106i;

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
        this.f35105h = true;
        this.f35106i = true;
    }
}
