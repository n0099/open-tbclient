package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes2.dex */
public final class i implements BaseNotifyDataAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Resources f71299a;

    /* renamed from: b  reason: collision with root package name */
    public String f71300b;

    /* renamed from: c  reason: collision with root package name */
    public String f71301c;

    /* renamed from: d  reason: collision with root package name */
    public String f71302d;

    public i() {
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

    private int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            while (!TextUtils.isEmpty(str)) {
                Resources resources = this.f71299a;
                int identifier = resources.getIdentifier("vivo_push_rom" + str + "_notifyicon", "drawable", this.f71300b);
                if (identifier > 0) {
                    return identifier;
                }
                str = str.substring(0, str.length() - 1);
            }
            return this.f71299a.getIdentifier("vivo_push_notifyicon", "drawable", this.f71300b);
        }
        return invokeL.intValue;
    }

    private int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            while (!TextUtils.isEmpty(str)) {
                Resources resources = this.f71299a;
                int identifier = resources.getIdentifier("vivo_push_rom" + str + "_icon", "drawable", this.f71300b);
                if (identifier > 0) {
                    return identifier;
                }
                str = str.substring(0, str.length() - 1);
            }
            return this.f71299a.getIdentifier("vivo_push_icon", "drawable", this.f71300b);
        }
        return invokeL.intValue;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultNotifyIcon() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = this.f71302d;
            while (true) {
                if (Build.VERSION.SDK_INT < 26) {
                    break;
                } else if (TextUtils.isEmpty(str)) {
                    p.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
                    break;
                } else {
                    String str2 = "vivo_push_ard" + str + "_notifyicon";
                    i2 = this.f71299a.getIdentifier(str2, "drawable", this.f71300b);
                    if (i2 > 0) {
                        p.d("DefaultNotifyDataAdapter", "get notify icon : " + str2);
                        break;
                    }
                    p.d("DefaultNotifyDataAdapter", "get notify error icon : " + str2);
                    str = str.substring(0, str.length() + (-1));
                }
            }
            i2 = -1;
            return i2 != -1 ? i2 : a(this.f71301c);
        }
        return invokeV.intValue;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultSmallIconId() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = this.f71302d;
            while (true) {
                if (Build.VERSION.SDK_INT < 26) {
                    break;
                } else if (TextUtils.isEmpty(str)) {
                    p.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
                    break;
                } else {
                    String str2 = "vivo_push_ard" + str + "_icon";
                    i2 = this.f71299a.getIdentifier(str2, "drawable", this.f71300b);
                    if (i2 > 0) {
                        p.d("DefaultNotifyDataAdapter", "get small icon : " + str2);
                        break;
                    }
                    p.d("DefaultNotifyDataAdapter", "get small error icon : " + str2);
                    str = str.substring(0, str.length() + (-1));
                }
            }
            i2 = -1;
            return i2 != -1 ? i2 : b(this.f71301c);
        }
        return invokeV.intValue;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getNotifyMode(InsideNotificationItem insideNotificationItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, insideNotificationItem)) == null) ? Build.VERSION.SDK_INT >= 21 ? 2 : 1 : invokeL.intValue;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.f71300b = context.getPackageName();
            this.f71299a = context.getResources();
            this.f71301c = k.a();
            String str = Build.VERSION.RELEASE;
            this.f71302d = TextUtils.isEmpty(str) ? null : str.replace(".", "");
        }
    }
}
