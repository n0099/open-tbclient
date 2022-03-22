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
/* loaded from: classes7.dex */
public class eo extends ep {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public PendingIntent f303a;

    /* renamed from: b  reason: collision with root package name */
    public int f44212b;

    /* renamed from: b  reason: collision with other field name */
    public Bitmap f304b;

    /* renamed from: c  reason: collision with root package name */
    public int f44213c;

    /* renamed from: c  reason: collision with other field name */
    public CharSequence f305c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eo(Context context, int i, String str) {
        super(context, i, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 16777216;
        this.f44212b = 16777216;
        this.f44213c = 16777216;
    }

    private Drawable a(int i, int i2, int i3, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)})) == null) {
            ShapeDrawable shapeDrawable = new ShapeDrawable();
            shapeDrawable.setShape(new RoundRectShape(new float[]{f2, f2, f2, f2, f2, f2, f2, f2}, null, null));
            shapeDrawable.getPaint().setColor(i);
            shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
            shapeDrawable.setIntrinsicWidth(i2);
            shapeDrawable.setIntrinsicHeight(i3);
            return shapeDrawable;
        }
        return (Drawable) invokeCommon.objValue;
    }

    private void a(RemoteViews remoteViews, int i, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{remoteViews, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                int a = a(6.0f);
                remoteViews.setViewPadding(i, a, 0, a, 0);
            }
            int i4 = z ? -1 : -16777216;
            remoteViews.setTextColor(i2, i4);
            remoteViews.setTextColor(i3, i4);
        }
    }

    @Override // com.xiaomi.push.ep
    public eo a(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmap)) == null) {
            if (m337b() && bitmap != null) {
                if (bitmap.getWidth() != 984 || bitmap.getHeight() < 177 || bitmap.getHeight() > 207) {
                    com.xiaomi.channel.commonutils.logger.b.m112a("colorful notification bg image resolution error, must [984*177, 984*207]");
                } else {
                    this.f304b = bitmap;
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
            if (m337b()) {
                this.f305c = charSequence;
                this.f303a = pendingIntent;
            }
            return this;
        }
        return (eo) invokeLL.objValue;
    }

    public eo a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (m337b() && !TextUtils.isEmpty(str)) {
                try {
                    this.f44212b = Color.parseColor(str);
                } catch (Exception unused) {
                    com.xiaomi.channel.commonutils.logger.b.m112a("parse colorful notification button bg color error");
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
        RemoteViews a;
        Bitmap bitmap;
        boolean z;
        RemoteViews a2;
        RemoteViews a3;
        Drawable a4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!m337b()) {
                m336b();
                return;
            }
            super.a();
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            int a5 = a(resources, "icon", "id", packageName);
            if (((ep) this).f306a == null) {
                a(a5);
            } else {
                a().setImageViewBitmap(a5, ((ep) this).f306a);
            }
            int a6 = a(resources, "title", "id", packageName);
            int a7 = a(resources, "content", "id", packageName);
            a().setTextViewText(a6, ((ep) this).f308a);
            a().setTextViewText(a7, ((ep) this).f44214b);
            if (!TextUtils.isEmpty(this.f305c)) {
                int a8 = a(resources, "buttonContainer", "id", packageName);
                int a9 = a(resources, "button", "id", packageName);
                int a10 = a(resources, "buttonBg", "id", packageName);
                a().setViewVisibility(a8, 0);
                a().setTextViewText(a9, this.f305c);
                a().setOnClickPendingIntent(a8, this.f303a);
                if (this.f44212b != 16777216) {
                    int a11 = a(70.0f);
                    int a12 = a(29.0f);
                    a().setImageViewBitmap(a10, com.xiaomi.push.service.ac.a(a(this.f44212b, a11, a12, a12 / 2.0f)));
                    a().setTextColor(a9, m335a(this.f44212b) ? -1 : -16777216);
                }
            }
            int a13 = a(resources, "bg", "id", packageName);
            int a14 = a(resources, "container", "id", packageName);
            if (this.a != 16777216) {
                if (l.a(a()) >= 10) {
                    a3 = a();
                    a4 = a(this.a, 984, 192, 30.0f);
                } else {
                    a3 = a();
                    a4 = a(this.a, 984, 192, 0.0f);
                }
                a3.setImageViewBitmap(a13, com.xiaomi.push.service.ac.a(a4));
                a2 = a();
                z = m335a(this.a);
            } else if (this.f304b == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    a().setViewVisibility(a5, 8);
                    a().setViewVisibility(a13, 8);
                    try {
                        bh.a((Object) this, "setStyle", t.a(a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception unused) {
                        com.xiaomi.channel.commonutils.logger.b.m112a("load class DecoratedCustomViewStyle failed");
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("miui.customHeight", true);
                addExtras(bundle);
                setCustomContentView(a());
            } else {
                if (l.a(a()) >= 10) {
                    a = a();
                    bitmap = a(this.f304b, 30.0f);
                } else {
                    a = a();
                    bitmap = this.f304b;
                }
                a.setImageViewBitmap(a13, bitmap);
                Map<String, String> map = ((ep) this).f310a;
                if (map != null && this.f44213c == 16777216) {
                    c(map.get("notification_image_text_color"));
                }
                int i = this.f44213c;
                z = i == 16777216 || !m335a(i);
                a2 = a();
            }
            a(a2, a14, a6, a7, z);
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
            if (l.m578a(a())) {
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
            if (m337b() && !TextUtils.isEmpty(str)) {
                try {
                    this.a = Color.parseColor(str);
                } catch (Exception unused) {
                    com.xiaomi.channel.commonutils.logger.b.m112a("parse colorful notification bg color error");
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
            if (m337b() && !TextUtils.isEmpty(str)) {
                try {
                    this.f44213c = Color.parseColor(str);
                } catch (Exception unused) {
                    com.xiaomi.channel.commonutils.logger.b.m112a("parse colorful notification image text color error");
                }
            }
            return this;
        }
        return (eo) invokeL.objValue;
    }
}
