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
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes8.dex */
public class er extends es {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public PendingIntent f306a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public Bitmap f307b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public CharSequence f308c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public er(Context context, int i, String str) {
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
        this.b = 16777216;
        this.c = 16777216;
    }

    private Drawable a(int i, int i2, int i3, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f)})) == null) {
            ShapeDrawable shapeDrawable = new ShapeDrawable();
            shapeDrawable.setShape(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
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
            int a = a(6.0f);
            remoteViews.setViewPadding(i, a, 0, a, 0);
            int i4 = z ? -1 : -16777216;
            remoteViews.setTextColor(i2, i4);
            remoteViews.setTextColor(i3, i4);
        }
    }

    @Override // com.xiaomi.push.es
    public er a(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmap)) == null) {
            if (m314b() && bitmap != null) {
                if (bitmap.getWidth() != 984 || bitmap.getHeight() < 177 || bitmap.getHeight() > 207) {
                    com.xiaomi.channel.commonutils.logger.b.m84a("colorful notification bg image resolution error, must [984*177, 984*207]");
                } else {
                    this.f307b = bitmap;
                }
            }
            return this;
        }
        return (er) invokeL.objValue;
    }

    public er a(CharSequence charSequence, PendingIntent pendingIntent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, pendingIntent)) == null) {
            if (m314b()) {
                super.addAction(0, charSequence, pendingIntent);
                this.f308c = charSequence;
                this.f306a = pendingIntent;
            }
            return this;
        }
        return (er) invokeLL.objValue;
    }

    @Override // com.xiaomi.push.eq
    public er a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (m314b() && !TextUtils.isEmpty(str)) {
                try {
                    this.b = Color.parseColor(str);
                } catch (Exception unused) {
                    com.xiaomi.channel.commonutils.logger.b.m84a("parse colorful notification button bg color error");
                }
            }
            return this;
        }
        return (er) invokeL.objValue;
    }

    @Override // com.xiaomi.push.eq
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "notification_colorful" : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.eq
    public void a() {
        RemoteViews a;
        Bitmap bitmap;
        boolean z;
        RemoteViews a2;
        RemoteViews a3;
        Drawable a4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!m314b()) {
                m313b();
                return;
            }
            super.a();
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            int a5 = a(resources, "icon", "id", packageName);
            if (((es) this).f309a == null) {
                a(a5);
            } else {
                a().setImageViewBitmap(a5, ((es) this).f309a);
            }
            int a6 = a(resources, "title", "id", packageName);
            int a7 = a(resources, "content", "id", packageName);
            a().setTextViewText(a6, ((es) this).f311a);
            a().setTextViewText(a7, ((es) this).f316b);
            if (!TextUtils.isEmpty(this.f308c)) {
                int a8 = a(resources, "buttonContainer", "id", packageName);
                int a9 = a(resources, NativeConstants.ID_BUTTON, "id", packageName);
                int a10 = a(resources, "buttonBg", "id", packageName);
                a().setViewVisibility(a8, 0);
                a().setTextViewText(a9, this.f308c);
                a().setOnClickPendingIntent(a8, this.f306a);
                if (this.b != 16777216) {
                    int a11 = a(70.0f);
                    int a12 = a(29.0f);
                    a().setImageViewBitmap(a10, com.xiaomi.push.service.al.a(a(this.b, a11, a12, a12 / 2.0f)));
                    a().setTextColor(a9, m312a(this.b) ? -1 : -16777216);
                }
            }
            int a13 = a(resources, "bg", "id", packageName);
            int a14 = a(resources, "container", "id", packageName);
            if (this.a != 16777216) {
                if (m.a(a()) >= 10) {
                    a3 = a();
                    a4 = a(this.a, 984, 192, 30.0f);
                } else {
                    a3 = a();
                    a4 = a(this.a, 984, 192, 0.0f);
                }
                a3.setImageViewBitmap(a13, com.xiaomi.push.service.al.a(a4));
                a2 = a();
                z = m312a(this.a);
            } else if (this.f307b == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    a().setViewVisibility(a5, 8);
                    a().setViewVisibility(a13, 8);
                    try {
                        bk.a((Object) this, "setStyle", v.a(a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception unused) {
                        com.xiaomi.channel.commonutils.logger.b.m84a("load class DecoratedCustomViewStyle failed");
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("miui.customHeight", true);
                addExtras(bundle);
                setCustomContentView(a());
            } else {
                if (m.a(a()) >= 10) {
                    a = a();
                    bitmap = a(this.f307b, 30.0f);
                } else {
                    a = a();
                    bitmap = this.f307b;
                }
                a.setImageViewBitmap(a13, bitmap);
                Map<String, String> map = ((es) this).f314a;
                if (map != null && this.c == 16777216) {
                    c(map.get("notification_image_text_color"));
                }
                int i = this.c;
                z = i == 16777216 || !m312a(i);
                a2 = a();
            }
            a(a2, a14, a6, a7, z);
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("miui.customHeight", true);
            addExtras(bundle2);
            setCustomContentView(a());
        }
    }

    @Override // com.xiaomi.push.eq
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (m.m555a()) {
                Resources resources = a().getResources();
                String packageName = a().getPackageName();
                return (a(resources, "icon", "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || a(resources, "content", "id", packageName) == 0) ? false : true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public er b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (m314b() && !TextUtils.isEmpty(str)) {
                try {
                    this.a = Color.parseColor(str);
                } catch (Exception unused) {
                    com.xiaomi.channel.commonutils.logger.b.m84a("parse colorful notification bg color error");
                }
            }
            return this;
        }
        return (er) invokeL.objValue;
    }

    @Override // com.xiaomi.push.es
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "notification_colorful_copy" : (String) invokeV.objValue;
    }

    public er c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (m314b() && !TextUtils.isEmpty(str)) {
                try {
                    this.c = Color.parseColor(str);
                } catch (Exception unused) {
                    com.xiaomi.channel.commonutils.logger.b.m84a("parse colorful notification image text color error");
                }
            }
            return this;
        }
        return (er) invokeL.objValue;
    }
}
