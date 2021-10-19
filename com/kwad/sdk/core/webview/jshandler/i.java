package com.kwad.sdk.core.webview.jshandler;

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
/* loaded from: classes10.dex */
public class i implements com.kwad.sdk.core.webview.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f72886a;

    /* renamed from: b  reason: collision with root package name */
    public final WebView f72887b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f72888c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f72889d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f72890e;

    /* loaded from: classes10.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f72894a;

        /* renamed from: b  reason: collision with root package name */
        public int f72895b;

        /* renamed from: c  reason: collision with root package name */
        public int f72896c;

        /* renamed from: d  reason: collision with root package name */
        public int f72897d;

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
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f72894a = jSONObject.optInt("height");
            this.f72895b = jSONObject.optInt("leftMargin");
            this.f72896c = jSONObject.optInt("rightMargin");
            this.f72897d = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                com.kwad.sdk.utils.q.a(jSONObject, "height", this.f72894a);
                com.kwad.sdk.utils.q.a(jSONObject, "leftMargin", this.f72895b);
                com.kwad.sdk.utils.q.a(jSONObject, "rightMargin", this.f72896c);
                com.kwad.sdk.utils.q.a(jSONObject, "bottomMargin", this.f72897d);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        @MainThread
        void a(@NonNull a aVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(com.kwad.sdk.core.webview.a aVar, @Nullable b bVar) {
        this(aVar, bVar, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.kwad.sdk.core.webview.a) objArr2[0], (b) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public i(com.kwad.sdk.core.webview.a aVar, @Nullable b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f72890e = true;
        this.f72886a = new Handler(Looper.getMainLooper());
        this.f72887b = aVar.f72781f;
        this.f72889d = bVar;
        this.f72890e = z;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "initKsAdFrame" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            this.f72888c = cVar;
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a();
                aVar.parseJson(jSONObject);
                this.f72886a.post(new Runnable(this, aVar) { // from class: com.kwad.sdk.core.webview.jshandler.i.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f72891a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ i f72892b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, aVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f72892b = this;
                        this.f72891a = aVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (this.f72892b.f72887b != null && this.f72892b.f72890e) {
                                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f72892b.f72887b.getLayoutParams();
                                marginLayoutParams.width = -1;
                                a aVar2 = this.f72891a;
                                marginLayoutParams.height = aVar2.f72894a;
                                marginLayoutParams.leftMargin = aVar2.f72895b;
                                marginLayoutParams.rightMargin = aVar2.f72896c;
                                marginLayoutParams.bottomMargin = aVar2.f72897d;
                                this.f72892b.f72887b.setLayoutParams(marginLayoutParams);
                            }
                            if (this.f72892b.f72889d != null) {
                                this.f72892b.f72889d.a(this.f72891a);
                            }
                        }
                    }
                });
                this.f72886a.post(new Runnable(this) { // from class: com.kwad.sdk.core.webview.jshandler.i.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ i f72893a;

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
                        this.f72893a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f72893a.f72888c == null) {
                            return;
                        }
                        this.f72893a.f72888c.a(null);
                    }
                });
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
                cVar.a(-1, e2.getMessage());
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f72888c = null;
            this.f72889d = null;
            this.f72886a.removeCallbacksAndMessages(null);
        }
    }
}
