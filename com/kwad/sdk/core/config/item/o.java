package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class o extends b<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f64340a;

    /* loaded from: classes2.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public Map<Integer, String> f64341a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public List<String> f64342b;

        /* renamed from: c  reason: collision with root package name */
        public List<String> f64343c;

        /* renamed from: d  reason: collision with root package name */
        public int f64344d;

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f64345e;

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
            this.f64341a = new HashMap();
            this.f64342b = new ArrayList();
            this.f64343c = new ArrayList();
        }

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f64345e = jSONObject;
            JSONObject optJSONObject = jSONObject.optJSONObject("platformInfo");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.f64341a.put(Integer.valueOf(next), optJSONObject.optString(next));
                }
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("keyStacks");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.f64342b.add(optJSONArray.optString(i2));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("keyNames");
            if (optJSONArray2 != null) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    this.f64343c.add(optJSONArray2.optString(i3));
                }
            }
            this.f64344d = jSONObject.optInt("handleType");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64345e : (JSONObject) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o() {
        super("sdkPackInfo", null);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editor) == null) {
            editor.putString("sdkPackInfo", this.f64340a);
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sharedPreferences) == null) {
            String string = sharedPreferences.getString("sdkPackInfo", null);
            this.f64340a = string;
            try {
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(this.f64340a);
                a aVar = new a();
                aVar.parseJson(jSONObject);
                a((o) aVar);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || (optJSONObject = jSONObject.optJSONObject("sdkPackInfo")) == null) {
            return;
        }
        this.f64340a = optJSONObject.toString();
        a aVar = new a();
        aVar.parseJson(optJSONObject);
        a((o) aVar);
    }
}
