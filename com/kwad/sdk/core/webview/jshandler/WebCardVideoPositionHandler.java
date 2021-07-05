package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class WebCardVideoPositionHandler implements com.kwad.sdk.core.webview.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f36810a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPosition f36811b;

    /* renamed from: c  reason: collision with root package name */
    public a f36812c;

    /* loaded from: classes7.dex */
    public static final class VideoPosition extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3445790097441569428L;
        public transient /* synthetic */ FieldHolder $fh;
        public double heightWidthRation;
        public double leftMarginRation;
        public double topMarginRation;
        public double widthRation;

        public VideoPosition() {
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

    /* loaded from: classes7.dex */
    public interface a {
        void a(VideoPosition videoPosition);
    }

    public WebCardVideoPositionHandler(com.kwad.sdk.core.webview.a aVar, a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, aVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36811b = new VideoPosition();
        this.f36810a = aVar;
        this.f36812c = aVar2;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "videoPosition" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            try {
                this.f36811b.parseJson(new JSONObject(str));
                if (this.f36812c != null) {
                    this.f36812c.a(this.f36811b);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
