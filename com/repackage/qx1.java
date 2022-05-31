package com.repackage;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class qx1 extends e13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qx1(e03 e03Var) {
        super(e03Var, "/swanAPI/setPhoneContact");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e03Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"BDOfflineUrl"})
    private void insert(Context context, px1 px1Var, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, context, px1Var, callbackHandler) == null) {
            Intent intent = new Intent("android.intent.action.INSERT", Uri.withAppendedPath(Uri.parse("content://com.android.contacts"), "contacts"));
            intent.putExtra("name", px1Var.d());
            intent.putExtra("email", px1Var.r);
            intent.putParcelableArrayListExtra("data", k(px1Var));
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            l(context, intent, callbackHandler);
        }
    }

    @Override // com.repackage.e13
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hz2Var)) == null) {
            if (context != null && callbackHandler != null && hz2Var != null) {
                if (hz2Var.m0()) {
                    if (e13.b) {
                        Log.d("SetPhoneContactAction", "SetPhoneContactAction does not supported when app is invisible.");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                    return false;
                }
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                if (e13.b) {
                    Log.d("SetPhoneContactAction", "handle params:" + optParamsAsJo);
                }
                String optString = optParamsAsJo.optString("action");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                px1 a = px1.a(optParamsAsJo);
                if (!a.t()) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                this.c = optParamsAsJo.optString("cb");
                char c = 65535;
                int hashCode = optString.hashCode();
                if (hashCode != -1183792455) {
                    if (hashCode == 3108362 && optString.equals("edit")) {
                        c = 1;
                    }
                } else if (optString.equals("insert")) {
                    c = 0;
                }
                if (c == 0) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    insert(context, a, callbackHandler);
                    return true;
                } else if (c != 1) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                } else {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    j(context, a, callbackHandler);
                    return true;
                }
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void j(Context context, px1 px1Var, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, px1Var, callbackHandler) == null) {
            Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT");
            intent.setType("vnd.android.cursor.item/contact");
            intent.putExtra("name", px1Var.d());
            intent.putExtra("email", px1Var.r);
            intent.putParcelableArrayListExtra("data", k(px1Var));
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            l(context, intent, callbackHandler);
        }
    }

    public final ArrayList<ContentValues> k(px1 px1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, px1Var)) == null) {
            ArrayList<ContentValues> arrayList = new ArrayList<>(16);
            arrayList.add(px1Var.j());
            arrayList.add(px1Var.h());
            arrayList.add(px1Var.s());
            arrayList.add(px1Var.i());
            arrayList.add(px1Var.g());
            arrayList.add(px1Var.r());
            arrayList.add(px1Var.k());
            arrayList.add(px1Var.o());
            arrayList.add(px1Var.n());
            arrayList.add(px1Var.m());
            arrayList.add(px1Var.l());
            arrayList.add(px1Var.b());
            arrayList.add(px1Var.p());
            arrayList.add(px1Var.e());
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void l(Context context, Intent intent, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, intent, callbackHandler) == null) {
            try {
                context.startActivity(intent);
                if (TextUtils.isEmpty(this.c)) {
                    return;
                }
                callbackHandler.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(0, "ok").toString());
            } catch (Exception e) {
                if (e13.b) {
                    Log.d("SetPhoneContactAction", "startContactActivity:" + e.toString());
                }
                if (TextUtils.isEmpty(this.c)) {
                    return;
                }
                callbackHandler.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(201, "fail startactivity exception").toString());
            }
        }
    }
}
