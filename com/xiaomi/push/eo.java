package com.xiaomi.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes10.dex */
public class eo extends ep {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f77192a;

    /* renamed from: a  reason: collision with other field name */
    public PendingIntent f326a;

    /* renamed from: b  reason: collision with root package name */
    public int f77193b;

    /* renamed from: b  reason: collision with other field name */
    public Bitmap f327b;

    /* renamed from: c  reason: collision with root package name */
    public int f77194c;

    /* renamed from: c  reason: collision with other field name */
    public CharSequence f328c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eo(Context context, int i2, String str) {
        super(context, i2, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77192a = 16777216;
        this.f77193b = 16777216;
        this.f77194c = 16777216;
    }

    private Drawable a(int i2, int i3, int i4, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)})) == null) {
            ShapeDrawable shapeDrawable = new ShapeDrawable();
            shapeDrawable.setShape(new RoundRectShape(new float[]{f2, f2, f2, f2, f2, f2, f2, f2}, null, null));
            shapeDrawable.getPaint().setColor(i2);
            shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
            shapeDrawable.setIntrinsicWidth(i3);
            shapeDrawable.setIntrinsicHeight(i4);
            return shapeDrawable;
        }
        return (Drawable) invokeCommon.objValue;
    }

    private void a(RemoteViews remoteViews, int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{remoteViews, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                int a2 = a(6.0f);
                remoteViews.setViewPadding(i2, a2, 0, a2, 0);
            }
            int i5 = z ? -1 : -16777216;
            remoteViews.setTextColor(i3, i5);
            remoteViews.setTextColor(i4, i5);
        }
    }

    @Override // com.xiaomi.push.ep
    public eo a(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmap)) == null) {
            if (m298b() && bitmap != null) {
                if (bitmap.getWidth() != 984 || bitmap.getHeight() < 177 || bitmap.getHeight() > 207) {
                    com.xiaomi.channel.commonutils.logger.b.m73a("colorful notification bg image resolution error, must [984*177, 984*207]");
                } else {
                    this.f327b = bitmap;
                }
            }
            return this;
        }
        return (eo) invokeL.objValue;
    }

    public eo a(CharSequence charSequence, PendingIntent pendingIntent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, pendingIntent)) == null) {
            if (m298b()) {
                this.f328c = charSequence;
                this.f326a = pendingIntent;
            }
            return this;
        }
        return (eo) invokeLL.objValue;
    }

    public eo a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (m298b() && !TextUtils.isEmpty(str)) {
                try {
                    this.f77193b = Color.parseColor(str);
                } catch (Exception unused) {
                    com.xiaomi.channel.commonutils.logger.b.m73a("parse colorful notification button bg color error");
                }
            }
            return this;
        }
        return (eo) invokeL.objValue;
    }

    @Override // com.xiaomi.push.en
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "notification_colorful" : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.en
    public void a() {
        RemoteViews a2;
        Bitmap bitmap;
        boolean z;
        RemoteViews a3;
        RemoteViews a4;
        Drawable a5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!m298b()) {
                m297b();
                return;
            }
            super.a();
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            int a6 = a(resources, "icon", "id", packageName);
            if (((ep) this).f329a == null) {
                a(a6);
            } else {
                a().setImageViewBitmap(a6, ((ep) this).f329a);
            }
            int a7 = a(resources, "title", "id", packageName);
            int a8 = a(resources, "content", "id", packageName);
            a().setTextViewText(a7, ((ep) this).f331a);
            a().setTextViewText(a8, ((ep) this).f77196b);
            if (!TextUtils.isEmpty(this.f328c)) {
                int a9 = a(resources, "buttonContainer", "id", packageName);
                int a10 = a(resources, "button", "id", packageName);
                int a11 = a(resources, "buttonBg", "id", packageName);
                a().setViewVisibility(a9, 0);
                a().setTextViewText(a10, this.f328c);
                a().setOnClickPendingIntent(a9, this.f326a);
                if (this.f77193b != 16777216) {
                    int a12 = a(70.0f);
                    int a13 = a(29.0f);
                    a().setImageViewBitmap(a11, com.xiaomi.push.service.ac.a(a(this.f77193b, a12, a13, a13 / 2.0f)));
                    a().setTextColor(a10, m296a(this.f77193b) ? -1 : -16777216);
                }
            }
            int a14 = a(resources, "bg", "id", packageName);
            int a15 = a(resources, "container", "id", packageName);
            if (this.f77192a != 16777216) {
                if (l.a(a()) >= 10) {
                    a4 = a();
                    a5 = a(this.f77192a, 984, 192, 30.0f);
                } else {
                    a4 = a();
                    a5 = a(this.f77192a, 984, 192, 0.0f);
                }
                a4.setImageViewBitmap(a14, com.xiaomi.push.service.ac.a(a5));
                a3 = a();
                z = m296a(this.f77192a);
            } else if (this.f327b == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    a().setViewVisibility(a6, 8);
                    a().setViewVisibility(a14, 8);
                    try {
                        bh.a((Object) this, "setStyle", t.a(a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception unused) {
                        com.xiaomi.channel.commonutils.logger.b.m73a("load class DecoratedCustomViewStyle failed");
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("miui.customHeight", true);
                addExtras(bundle);
                setCustomContentView(a());
            } else {
                if (l.a(a()) >= 10) {
                    a2 = a();
                    bitmap = a(this.f327b, 30.0f);
                } else {
                    a2 = a();
                    bitmap = this.f327b;
                }
                a2.setImageViewBitmap(a14, bitmap);
                Map<String, String> map = ((ep) this).f333a;
                if (map != null && this.f77194c == 16777216) {
                    c(map.get("notification_image_text_color"));
                }
                int i2 = this.f77194c;
                z = i2 == 16777216 || !m296a(i2);
                a3 = a();
            }
            a(a3, a15, a7, a8, z);
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("miui.customHeight", true);
            addExtras(bundle2);
            setCustomContentView(a());
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
                return (a(resources, "icon", "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || a(resources, "content", "id", packageName) == 0) ? false : true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public eo b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (m298b() && !TextUtils.isEmpty(str)) {
                try {
                    this.f77192a = Color.parseColor(str);
                } catch (Exception unused) {
                    com.xiaomi.channel.commonutils.logger.b.m73a("parse colorful notification bg color error");
                }
            }
            return this;
        }
        return (eo) invokeL.objValue;
    }

    @Override // com.xiaomi.push.ep
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "notification_colorful_copy" : (String) invokeV.objValue;
    }

    public eo c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (m298b() && !TextUtils.isEmpty(str)) {
                try {
                    this.f77194c = Color.parseColor(str);
                } catch (Exception unused) {
                    com.xiaomi.channel.commonutils.logger.b.m73a("parse colorful notification image text color error");
                }
            }
            return this;
        }
        return (eo) invokeL.objValue;
    }
}
