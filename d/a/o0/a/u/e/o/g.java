package d.a.o0.a.u.e.o;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g extends d.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NonNull d.a.o0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d.a.o0.a.u.h.b r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-PhoneCallApi", "start make phone call");
            }
            if (l()) {
                d.a.o0.a.e0.d.b("Api-PhoneCallApi", "Api-PhoneCallApi does not supported when app is invisible.");
                return new d.a.o0.a.u.h.b(1001, "Api-PhoneCallApi does not supported when app is invisible.");
            }
            Intent intent = new Intent("android.intent.action.DIAL");
            Pair<d.a.o0.a.u.h.b, JSONObject> b2 = d.a.o0.a.u.i.b.b("Api-PhoneCallApi", str);
            d.a.o0.a.u.h.b bVar = (d.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                d.a.o0.a.e0.d.b("Api-PhoneCallApi", "parse fail");
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            if (jSONObject != null) {
                String optString = jSONObject.optString("phoneNumber");
                if (!TextUtils.isEmpty(optString)) {
                    intent.setData(Uri.fromParts("tel", optString, null));
                }
            }
            if (d.a.o0.a.v2.f.g(i(), intent)) {
                return new d.a.o0.a.u.h.b(0);
            }
            return new d.a.o0.a.u.h.b(1001);
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }
}
