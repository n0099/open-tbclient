package com.xiaomi.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public abstract class ep extends en {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public Bitmap f330a;

    /* renamed from: a  reason: collision with other field name */
    public RemoteViews f331a;

    /* renamed from: a  reason: collision with other field name */
    public CharSequence f332a;

    /* renamed from: a  reason: collision with other field name */
    public String f333a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f334a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f335a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f59602b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f336b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ep(Context context, int i2, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f333a = str;
        this.a = i2;
        m353c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ep(Context context, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f333a = str;
        m353c();
    }

    private Bitmap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? com.xiaomi.push.service.ac.a(g.m400a(a(), this.f333a)) : (Bitmap) invokeV.objValue;
    }

    private String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            boolean e2 = e();
            this.f336b = e2;
            return e2 ? b() : a();
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    private void m353c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            int a = a(a().getResources(), c(), "layout", a().getPackageName());
            if (a == 0) {
                com.xiaomi.channel.commonutils.logger.b.m133a("create RemoteViews failed, no such layout resource was found");
                return;
            }
            this.f331a = new RemoteViews(a().getPackageName(), a);
            this.f335a = a();
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m354c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            Map<String, String> map = this.f334a;
            return map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"));
        }
        return invokeV.booleanValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || Build.VERSION.SDK_INT < 11) {
            return;
        }
        super.setContentTitle(this.f332a);
        super.setContentText(this.f59602b);
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m355d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? (TextUtils.isEmpty(b()) || TextUtils.isEmpty(this.f333a)) ? false : true : invokeV.booleanValue;
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? m355d() && f() : invokeV.booleanValue;
    }

    private boolean f() {
        InterceptResult invokeV;
        List<StatusBarNotification> m660b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (Build.VERSION.SDK_INT >= 20 && (m660b = com.xiaomi.push.service.ao.a(a(), this.f333a).m660b()) != null && !m660b.isEmpty()) {
                for (StatusBarNotification statusBarNotification : m660b) {
                    if (statusBarNotification.getId() == this.a) {
                        Notification notification = statusBarNotification.getNotification();
                        if (notification == null) {
                            return false;
                        }
                        return !notification.extras.getBoolean("mipush.customCopyLayout", true);
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? (int) ((f2 * a().getResources().getDisplayMetrics().density) + 0.5f) : invokeF.intValue;
    }

    public Bitmap a(Bitmap bitmap, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, f2)) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawRoundRect(new RectF(rect), f2, f2, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return (Bitmap) invokeLF.objValue;
    }

    @Override // com.xiaomi.push.en
    public final RemoteViews a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f331a : (RemoteViews) invokeV.objValue;
    }

    @Override // com.xiaomi.push.en
    public en a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, map)) == null) {
            this.f334a = map;
            return this;
        }
        return (en) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public ep addAction(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, charSequence, pendingIntent)) == null) ? this : (ep) invokeILL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public ep addAction(Notification.Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, action)) == null) ? this : (ep) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public ep setLargeIcon(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bitmap)) == null) {
            this.f330a = bitmap;
            return this;
        }
        return (ep) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public ep setContentTitle(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, charSequence)) == null) {
            this.f332a = charSequence;
            return this;
        }
        return (ep) invokeL.objValue;
    }

    @Override // com.xiaomi.push.en
    public abstract String a();

    @Override // com.xiaomi.push.en
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.m352a();
            Bundle bundle = new Bundle();
            if (m355d()) {
                bundle.putBoolean("mipush.customCopyLayout", this.f336b);
            } else {
                bundle.putBoolean("mipush.customCopyLayout", false);
            }
            bundle.putBoolean("miui.customHeight", false);
            addExtras(bundle);
            if (m354c() || !com.xiaomi.push.service.ap.m661a(a().getContentResolver())) {
                d();
            }
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            Bitmap a = a();
            if (a != null) {
                a().setImageViewBitmap(i2, a);
                return;
            }
            int b2 = g.b(a(), this.f333a);
            if (b2 != 0) {
                a().setImageViewResource(i2, b2);
            }
        }
    }

    @Override // com.xiaomi.push.en
    public abstract boolean a();

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m356a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? ((((double) Color.red(i2)) * 0.299d) + (((double) Color.green(i2)) * 0.587d)) + (((double) Color.blue(i2)) * 0.114d) < 192.0d : invokeI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: b */
    public ep setContentText(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, charSequence)) == null) {
            this.f59602b = charSequence;
            return this;
        }
        return (ep) invokeL.objValue;
    }

    public abstract String b();

    /* renamed from: b  reason: collision with other method in class */
    public final void m357b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || Build.VERSION.SDK_INT < 11) {
            return;
        }
        super.setContentTitle(this.f332a);
        super.setContentText(this.f59602b);
        Bitmap bitmap = this.f330a;
        if (bitmap != null) {
            super.setLargeIcon(bitmap);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public final boolean m358b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f335a : invokeV.booleanValue;
    }
}
