package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class o implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;
    public final WebView b;
    @Nullable
    public com.kwad.sdk.core.webview.kwai.c c;
    @Nullable
    public b d;
    public boolean e;

    /* loaded from: classes5.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.a = jSONObject.optInt("height");
            this.b = jSONObject.optInt("leftMargin");
            this.c = jSONObject.optInt("rightMargin");
            this.d = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                com.kwad.sdk.utils.r.a(jSONObject, "height", this.a);
                com.kwad.sdk.utils.r.a(jSONObject, "leftMargin", this.b);
                com.kwad.sdk.utils.r.a(jSONObject, "rightMargin", this.c);
                com.kwad.sdk.utils.r.a(jSONObject, "bottomMargin", this.d);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        @MainThread
        void a(@NonNull a aVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(com.kwad.sdk.core.webview.b bVar, @Nullable b bVar2) {
        this(bVar, bVar2, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.kwad.sdk.core.webview.b) objArr2[0], (b) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public o(com.kwad.sdk.core.webview.b bVar, @Nullable b bVar2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bVar2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = true;
        this.a = new Handler(Looper.getMainLooper());
        this.b = bVar.e;
        this.d = bVar2;
        this.e = true;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "initKsAdFrame" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            this.c = cVar;
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a();
                aVar.parseJson(jSONObject);
                this.a.post(new Runnable(this, aVar) { // from class: com.kwad.components.core.webview.jshandler.o.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a a;
                    public final /* synthetic */ o b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, aVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = this;
                        this.a = aVar;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (this.b.b != null && this.b.e) {
                                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.b.b.getLayoutParams();
                                marginLayoutParams.width = -1;
                                a aVar2 = this.a;
                                marginLayoutParams.height = aVar2.a;
                                marginLayoutParams.leftMargin = aVar2.b;
                                marginLayoutParams.rightMargin = aVar2.c;
                                marginLayoutParams.bottomMargin = aVar2.d;
                                this.b.b.setLayoutParams(marginLayoutParams);
                            }
                            if (this.b.d != null) {
                                this.b.d.a(this.a);
                            }
                        }
                    }
                });
                this.a.post(new Runnable(this) { // from class: com.kwad.components.core.webview.jshandler.o.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ o a;

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
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.c == null) {
                            return;
                        }
                        this.a.c.a(null);
                    }
                });
            } catch (JSONException e) {
                com.kwad.sdk.core.d.b.a(e);
                cVar.a(-1, e.getMessage());
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c = null;
            this.d = null;
            this.a.removeCallbacksAndMessages(null);
        }
    }
}
