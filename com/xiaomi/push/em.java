package com.xiaomi.push;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
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
/* loaded from: classes10.dex */
public class em extends ep {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f77389a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f77390b;

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f77391c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public em(Context context, String str) {
        super(context, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77389a = 16777216;
    }

    @Override // com.xiaomi.push.ep
    public em a(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmap)) == null) {
            if (m298b() && bitmap != null) {
                if (bitmap.getWidth() != 984 || 184 > bitmap.getHeight() || bitmap.getHeight() > 1678) {
                    com.xiaomi.channel.commonutils.logger.b.m73a("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
                } else {
                    this.f77390b = bitmap;
                }
            }
            return this;
        }
        return (em) invokeL.objValue;
    }

    public em a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (m298b() && !TextUtils.isEmpty(str)) {
                try {
                    this.f77389a = Color.parseColor(str);
                } catch (Exception unused) {
                    com.xiaomi.channel.commonutils.logger.b.m73a("parse banner notification image text color error");
                }
            }
            return this;
        }
        return (em) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.xiaomi.push.ep, android.app.Notification.Builder
    /* renamed from: a */
    public ep setLargeIcon(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap)) == null) ? this : (ep) invokeL.objValue;
    }

    @Override // com.xiaomi.push.en
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "notification_banner" : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.en
    public void a() {
        RemoteViews a2;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!m298b() || this.f77390b == null) {
                m297b();
                return;
            }
            super.a();
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            int a3 = a(resources, "bg", "id", packageName);
            if (l.a(a()) >= 10) {
                a2 = a();
                bitmap = a(this.f77390b, 30.0f);
            } else {
                a2 = a();
                bitmap = this.f77390b;
            }
            a2.setImageViewBitmap(a3, bitmap);
            int a4 = a(resources, "icon", "id", packageName);
            if (this.f77391c != null) {
                a().setImageViewBitmap(a4, this.f77391c);
            } else {
                a(a4);
            }
            int a5 = a(resources, "title", "id", packageName);
            a().setTextViewText(a5, ((ep) this).f331a);
            Map<String, String> map = ((ep) this).f333a;
            if (map != null && this.f77389a == 16777216) {
                a(map.get("notification_image_text_color"));
            }
            RemoteViews a6 = a();
            int i2 = this.f77389a;
            a6.setTextColor(a5, (i2 == 16777216 || !m296a(i2)) ? -1 : -16777216);
            setCustomContentView(a());
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
        }
    }

    @Override // com.xiaomi.push.en
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (l.m539a(a())) {
                Resources resources = a().getResources();
                String packageName = a().getPackageName();
                return (a(a().getResources(), "bg", "id", a().getPackageName()) == 0 || a(resources, "icon", "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || l.a(a()) < 9) ? false : true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public em b(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bitmap)) == null) {
            if (m298b() && bitmap != null) {
                this.f77391c = bitmap;
            }
            return this;
        }
        return (em) invokeL.objValue;
    }

    @Override // com.xiaomi.push.ep
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }
}
