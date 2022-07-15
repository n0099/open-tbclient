package com.repackage;

import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jt4 extends bt4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zs4 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jt4(zs4 zs4Var) {
        super(zs4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zs4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zs4) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = zs4Var;
    }

    @Override // com.repackage.bt4
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_SHOW_SHARE_DIALOG" : (String) invokeV.objValue;
    }

    @ct4(isAsync = false, value = "showShareDialog")
    public void showShareDialog(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString("content");
        String optString3 = jSONObject.optString("imgUrl");
        String optString4 = jSONObject.optString("shareUrl");
        ShareItem shareItem = new ShareItem();
        shareItem.u = optString;
        shareItem.v = optString2;
        if (optString3 == null) {
            shareItem.y = null;
        } else {
            shareItem.y = Uri.parse(optString3);
        }
        shareItem.w = optString4;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.c.getContext(), shareItem, true);
        shareDialogConfig.setIsSupportNightMode(true);
        shareDialogConfig.setIsCopyLink(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
