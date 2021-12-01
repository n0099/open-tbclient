package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class j implements BaseNotifyLayoutAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Resources a;

    /* renamed from: b  reason: collision with root package name */
    public String f62546b;

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getNotificationLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.getIdentifier("push_notify", "layout", this.f62546b) : invokeV.intValue;
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getSuitIconId() {
        InterceptResult invokeV;
        Resources resources;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (k.f62552g) {
                resources = this.a;
                str = this.f62546b;
                str2 = "notify_icon_rom30";
            } else if (k.f62551f) {
                resources = this.a;
                str = this.f62546b;
                str2 = "notify_icon_rom20";
            } else {
                resources = this.a;
                str = this.f62546b;
                str2 = "notify_icon";
            }
            return resources.getIdentifier(str2, "id", str);
        }
        return invokeV.intValue;
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getTitleColor() {
        int i2;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                i2 = ((Integer) z.a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();
            } catch (Exception e2) {
                e2.printStackTrace();
                i2 = 0;
            }
            if (i2 > 0) {
                return this.a.getColor(i2);
            }
            if (k.f62552g) {
                return -1;
            }
            if (k.f62551f) {
                if (k.f62552g) {
                    return Color.parseColor("#ff999999");
                }
                return -1;
            }
            return -16777216;
        }
        return invokeV.intValue;
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.f62546b = context.getPackageName();
            this.a = context.getResources();
        }
    }
}
