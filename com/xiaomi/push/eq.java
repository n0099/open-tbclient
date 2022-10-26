package com.xiaomi.push;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
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
/* loaded from: classes8.dex */
public class eq extends Notification.Builder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eq(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public final int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? a(a().getResources(), str, "id", a().getPackageName()) : invokeL.intValue;
    }

    public Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (Context) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public eq addExtras(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bundle)) == null) {
            if (Build.VERSION.SDK_INT >= 20) {
                super.addExtras(bundle);
            }
            return this;
        }
        return (eq) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public eq setCustomContentView(RemoteViews remoteViews) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, remoteViews)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                super.setCustomContentView(remoteViews);
            } else {
                super.setContent(remoteViews);
            }
            return this;
        }
        return (eq) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public eq m312a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    bk.a((Object) this, "setColor", Integer.valueOf(Color.parseColor(str)));
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.d("fail to set color. " + e);
                }
            }
            return this;
        }
        return (eq) invokeL.objValue;
    }

    public eq a(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, map)) == null) ? this : (eq) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m313a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // android.app.Notification.Builder
    public Notification build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            m313a();
            return super.build();
        }
        return (Notification) invokeV.objValue;
    }
}
