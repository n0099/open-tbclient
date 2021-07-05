package d.a.q0.h.d.d;

import android.webkit.JavascriptInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.l0.c;
import d.a.q0.h.d.b;
/* loaded from: classes8.dex */
public final class a extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    public final String domain;

    /* renamed from: e  reason: collision with root package name */
    public c f53206e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.h.z.c f53207f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.domain = "openData";
        this.f53206e = cVar;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) {
            if (this.f53207f == null) {
                this.f53207f = new d.a.q0.h.z.c(this.f53206e);
            }
            this.f53207f.getFriendCloudStorage(jsObject);
        }
    }

    @JavascriptInterface
    public a getOpenData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (a) invokeV.objValue;
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            if (this.f53207f == null) {
                this.f53207f = new d.a.q0.h.z.c(this.f53206e);
            }
            this.f53207f.getUserCloudStorage(jsObject);
        }
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            if (this.f53207f == null) {
                this.f53207f = new d.a.q0.h.z.c(this.f53206e);
            }
            this.f53207f.getUserInfo(jsObject);
        }
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) && (this.f53206e.p() instanceof b)) {
            ((b) this.f53206e.p()).A(jsObject);
        }
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jsObject) == null) {
            if (this.f53207f == null) {
                this.f53207f = new d.a.q0.h.z.c(this.f53206e);
            }
            this.f53207f.removeUserCloudStorage(jsObject);
        }
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) {
            if (this.f53207f == null) {
                this.f53207f = new d.a.q0.h.z.c(this.f53206e);
            }
            this.f53207f.setUserCloudStorage(jsObject);
        }
    }
}
