package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@SuppressLint({"NewApi"})
/* loaded from: classes4.dex */
public class en extends Notification.Builder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public en(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public int a(Resources resources, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, resources, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return resources.getIdentifier(str, str2, str3);
        }
        return invokeLLLL.intValue;
    }

    public Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (Context) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public en addExtras(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
            if (Build.VERSION.SDK_INT >= 20) {
                super.addExtras(bundle);
            }
            return this;
        }
        return (en) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public en setCustomContentView(RemoteViews remoteViews) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, remoteViews)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                super.setCustomContentView(remoteViews);
            } else {
                super.setContent(remoteViews);
            }
            return this;
        }
        return (en) invokeL.objValue;
    }

    public en a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) ? this : (en) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m341a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // android.app.Notification.Builder
    public Notification build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            m341a();
            return super.build();
        }
        return (Notification) invokeV.objValue;
    }
}
