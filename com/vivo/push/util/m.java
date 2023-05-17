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
import com.google.android.exoplayer2.text.ttml.TtmlNode;
/* loaded from: classes10.dex */
public final class m implements BaseNotifyLayoutAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Resources a;
    public String b;

    public m() {
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

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getNotificationLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a.getIdentifier("push_notify", TtmlNode.TAG_LAYOUT, this.b);
        }
        return invokeV.intValue;
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getSuitIconId() {
        InterceptResult invokeV;
        Resources resources;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (n.d) {
                resources = this.a;
                str = this.b;
                str2 = "notify_icon_rom30";
            } else if (n.c) {
                resources = this.a;
                str = this.b;
                str2 = "notify_icon_rom20";
            } else {
                resources = this.a;
                str = this.b;
                str2 = "notify_icon";
            }
            return resources.getIdentifier(str2, "id", str);
        }
        return invokeV.intValue;
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getTitleColor() {
        int i;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                i = ((Integer) ag.a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();
            } catch (Exception e) {
                e.printStackTrace();
                i = 0;
            }
            if (i > 0) {
                return this.a.getColor(i);
            }
            if (n.d) {
                return -1;
            }
            if (n.c) {
                if (!n.d) {
                    return -1;
                }
                return Color.parseColor("#ff999999");
            }
            return -16777216;
        }
        return invokeV.intValue;
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.b = context.getPackageName();
            this.a = context.getResources();
        }
    }
}
