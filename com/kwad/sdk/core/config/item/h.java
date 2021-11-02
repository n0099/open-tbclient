package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends b<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f64338a;

        /* renamed from: b  reason: collision with root package name */
        public String f64339b;

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
            this.f64338a = "";
            this.f64339b = "";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h() {
        super("idMapping", new a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(SharedPreferences.Editor editor) {
        String b2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editor) == null) {
            if (a() == null || a().toJson() == null) {
                b2 = b();
                str = "";
            } else {
                b2 = b();
                str = a().toJson().toString();
            }
            editor.putString(b2, str);
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sharedPreferences) == null) {
            a a2 = a();
            if (a2 == null) {
                a2 = new a();
            }
            String string = sharedPreferences.getString(b(), "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    a2.parseJson(new JSONObject(string));
                } catch (JSONException e2) {
                    com.kwad.sdk.core.d.a.b(e2);
                }
            }
            a((h) a2);
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || (optJSONObject = jSONObject.optJSONObject(b())) == null) {
            return;
        }
        a aVar = new a();
        aVar.parseJson(optJSONObject);
        a((h) aVar);
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            a a2 = a();
            return (a2 == null || TextUtils.isEmpty(a2.f64338a)) ? "" : a2.f64338a;
        }
        return (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            a a2 = a();
            return (a2 == null || TextUtils.isEmpty(a2.f64339b)) ? "" : a2.f64339b;
        }
        return (String) invokeV.objValue;
    }
}
