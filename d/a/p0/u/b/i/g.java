package d.a.p0.u.b.i;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.n0.a.c2.f.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d.a.n0.a.c2.e eVar) {
        super(eVar, "/swan/publishThread");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean j(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("path");
                if (StringUtils.isNull(optString)) {
                    String optString2 = jSONObject.optString("appid");
                    if (StringUtils.isNull(optString2)) {
                        return false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921361, d.a.p0.u.a.a(optString2, "", "", 0)));
                    return true;
                }
                String substring = optString.substring(39);
                if (StringUtils.isNull(substring)) {
                    return false;
                }
                JSONObject jSONObject2 = new JSONObject(k.getUrlDecode(substring));
                String optString3 = jSONObject2.optString("third_app_id");
                String optString4 = jSONObject2.optString("third_app_name");
                String optString5 = jSONObject2.optString("third_app_pic");
                String optString6 = jSONObject2.optString("third_app_link");
                SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(context, 10086);
                selectForumActivityConfig.setAiAppsParams(optString3, optString4, optString5, null, null, optString6);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, selectForumActivityConfig));
                return true;
            } catch (JSONException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // d.a.n0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.n0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            j(context, unitedSchemeEntity.getParam("params"));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
