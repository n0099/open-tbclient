package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.MultiForumPerm;
/* loaded from: classes7.dex */
public class tn4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;

    public tn4() {
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

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optInt("is_bawu") == 1;
        this.b = "manager".equals(jSONObject.optString("bawu_type")) ? 1 : PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(jSONObject.optString("bawu_type")) ? 2 : 0;
        this.c = jSONObject.optInt("is_deleted") == 1;
    }

    public void b(MultiForumPerm multiForumPerm) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, multiForumPerm) == null) || multiForumPerm == null) {
            return;
        }
        this.a = multiForumPerm.is_bawu.intValue() == 1;
        this.b = "manager".equals(multiForumPerm.bawu_type) ? 1 : PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(multiForumPerm.bawu_type) ? 2 : 0;
        this.c = multiForumPerm.is_deleted.intValue() == 1;
    }
}
