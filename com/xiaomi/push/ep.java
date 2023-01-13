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
/* loaded from: classes8.dex */
public class ep extends es {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public Bitmap b;
    public Bitmap c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ep(Context context, String str) {
        super(context, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 16777216;
    }

    @Override // com.xiaomi.push.es
    public ep a(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmap)) == null) {
            if (m387b() && bitmap != null) {
                if (bitmap.getWidth() != 984 || 184 > bitmap.getHeight() || bitmap.getHeight() > 1678) {
                    com.xiaomi.channel.commonutils.logger.b.m103a("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
                } else {
                    this.b = bitmap;
                }
            }
            return this;
        }
        return (ep) invokeL.objValue;
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.eq.a(Ljava/lang/String;)I */
    @Override // com.xiaomi.push.eq
    /* renamed from: a */
    public ep mo379a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (m387b() && !TextUtils.isEmpty(str)) {
                try {
                    this.a = Color.parseColor(str);
                } catch (Exception unused) {
                    com.xiaomi.channel.commonutils.logger.b.m103a("parse banner notification image text color error");
                }
            }
            return this;
        }
        return (ep) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.xiaomi.push.es, android.app.Notification.Builder
    /* renamed from: a */
    public es setLargeIcon(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap)) == null) ? this : (es) invokeL.objValue;
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.eq.a()Landroid/content/Context; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.eq.a()V */
    @Override // com.xiaomi.push.es
    /* renamed from: a */
    public String mo384a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "notification_banner" : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.es, com.xiaomi.push.eq
    /* renamed from: a  reason: collision with other method in class */
    public void mo377a() {
        RemoteViews m383a;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!m387b() || this.b == null) {
                m386b();
                return;
            }
            super.mo377a();
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            int a = a(resources, "bg", "id", packageName);
            if (m.a(a()) >= 10) {
                m383a = m383a();
                bitmap = a(this.b, 30.0f);
            } else {
                m383a = m383a();
                bitmap = this.b;
            }
            m383a.setImageViewBitmap(a, bitmap);
            int a2 = a(resources, "icon", "id", packageName);
            if (this.c != null) {
                m383a().setImageViewBitmap(a2, this.c);
            } else {
                a(a2);
            }
            int a3 = a(resources, "title", "id", packageName);
            m383a().setTextViewText(a3, ((es) this).f342a);
            Map<String, String> map = ((es) this).f345a;
            if (map != null && this.a == 16777216) {
                mo379a(map.get("notification_image_text_color"));
            }
            RemoteViews m383a2 = m383a();
            int i = this.a;
            m383a2.setTextColor(a3, (i == 16777216 || !m385a(i)) ? -1 : -16777216);
            setCustomContentView(m383a());
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
        }
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.eq.a()Landroid/content/Context; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.eq.a()V */
    @Override // com.xiaomi.push.es
    /* renamed from: a  reason: collision with other method in class */
    public boolean mo378a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (m.m634a()) {
                Resources resources = a().getResources();
                String packageName = a().getPackageName();
                return (a(a().getResources(), "bg", "id", a().getPackageName()) == 0 || a(resources, "icon", "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || m.a(a()) < 9) ? false : true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ep b(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bitmap)) == null) {
            if (m387b() && bitmap != null) {
                this.c = bitmap;
            }
            return this;
        }
        return (ep) invokeL.objValue;
    }

    @Override // com.xiaomi.push.es
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }
}
