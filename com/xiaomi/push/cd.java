package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.push.cg;
/* loaded from: classes8.dex */
public class cd extends cg.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cd(String str, ContentValues contentValues, String str2) {
        super(str, contentValues);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, contentValues, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (ContentValues) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "MessageInsertJob";
        this.a = str2;
    }

    public static cd a(Context context, String str, hj hjVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, hjVar)) == null) {
            byte[] a = ip.a(hjVar);
            if (a == null || a.length <= 0) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) 0);
            contentValues.put(MiPushMessage.KEY_MESSAGE_ID, "");
            contentValues.put("messageItemId", hjVar.d());
            contentValues.put("messageItem", a);
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, bu.a(context).b());
            contentValues.put("packageName", bu.a(context).m255a());
            contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("uploadTimestamp", (Integer) 0);
            return new cd(str, contentValues, "a job build to insert message to db");
        }
        return (cd) invokeLLL.objValue;
    }
}
