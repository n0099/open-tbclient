package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final JSONObject f61468d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str, JSONObject jSONObject) {
        super(context, aVar, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, str, jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (com.ss.android.socialbase.downloader.g.a) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61468d = jSONObject;
    }

    public static void a(@NonNull Intent intent, JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> keys;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, intent, jSONObject, jSONObject2) == null) || jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length() || intent == null || (keys = jSONObject.keys()) == null) {
            return;
        }
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject2.optString(next);
            if (optString != null) {
                a(jSONObject, next, optString, intent);
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String optString = this.f61468d.optString("action");
            String optString2 = this.f61468d.optString("category");
            int optInt = this.f61468d.optInt("flags", 1342210048);
            String optString3 = this.f61468d.optString("path_extra_key");
            String optString4 = this.f61468d.optString("path_data_key");
            JSONObject optJSONObject = this.f61468d.optJSONObject("extra");
            JSONObject optJSONObject2 = this.f61468d.optJSONObject("extra_type");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            Intent intent = new Intent(optString);
            if (!TextUtils.isEmpty(optString2)) {
                intent.addCategory(optString2);
            }
            if (!TextUtils.isEmpty(optString4)) {
                try {
                    intent.setData(Uri.parse(String.format(optString4, this.f61467c)));
                } catch (Throwable unused) {
                }
            }
            intent.setFlags(optInt);
            if (!TextUtils.isEmpty(optString3)) {
                intent.putExtra(optString3, this.f61467c);
            }
            a(intent, optJSONObject, optJSONObject2);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(JSONObject jSONObject, String str, String str2, Intent intent) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, jSONObject, str, str2, intent) == null) {
            switch (str2.hashCode()) {
                case -1325958191:
                    if (str2.equals("double")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -891985903:
                    if (str2.equals("string")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 104431:
                    if (str2.equals("int")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3327612:
                    if (str2.equals("long")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 64711720:
                    if (str2.equals("boolean")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                intent.putExtra(str, jSONObject.optInt(str));
            } else if (c2 == 1) {
                intent.putExtra(str, jSONObject.optBoolean(str));
            } else if (c2 == 2) {
                intent.putExtra(str, jSONObject.optLong(str));
            } else if (c2 == 3) {
                intent.putExtra(str, jSONObject.optDouble(str));
            } else if (c2 != 4) {
            } else {
                intent.putExtra(str, jSONObject.optString(str));
            }
        }
    }
}
