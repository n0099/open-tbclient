package com.repackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.StampShareDialogConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ch8 b;

    public bh8(Context context, ch8 ch8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, ch8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = ch8Var;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ShareItem shareItem = new ShareItem();
            Bundle e = shareItem.e();
            if (e == null) {
                e = new Bundle();
            }
            e.putInt("obj_locate", 20);
            shareItem.k(e);
            shareItem.p0 = true;
            shareItem.f0 = 1;
            StampShareDialogConfig stampShareDialogConfig = new StampShareDialogConfig(this.a, shareItem, true, this.b);
            stampShareDialogConfig.setIsCopyLink(false);
            stampShareDialogConfig.setHideMode(stampShareDialogConfig.hideMode | 32);
            this.b.e(b("https://tieba.baidu.com/mo/q/icon/home"));
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, stampShareDialogConfig));
        }
    }

    public final Bitmap b(String str) {
        InterceptResult invokeL;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
                return null;
            }
            return (Bitmap) runTask.getData();
        }
        return (Bitmap) invokeL.objValue;
    }
}
