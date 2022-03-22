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
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public abstract class ep extends en {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public Bitmap f306a;

    /* renamed from: a  reason: collision with other field name */
    public RemoteViews f307a;

    /* renamed from: a  reason: collision with other field name */
    public CharSequence f308a;

    /* renamed from: a  reason: collision with other field name */
    public String f309a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f310a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f311a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f44214b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f312b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ep(Context context, int i, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f309a = str;
        this.a = i;
        m332c();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f309a = str;
        m332c();
    }

    private Bitmap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? com.xiaomi.push.service.ac.a(g.m379a(a(), this.f309a)) : (Bitmap) invokeV.objValue;
    }

    private String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            boolean e2 = e();
            this.f312b = e2;
            return e2 ? b() : a();
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    private void m332c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            int a = a(a().getResources(), c(), TtmlNode.TAG_LAYOUT, a().getPackageName());
            if (a == 0) {
                com.xiaomi.channel.commonutils.logger.b.m112a("create RemoteViews failed, no such layout resource was found");
                return;
            }
            this.f307a = new RemoteViews(a().getPackageName(), a);
            this.f311a = a();
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m333c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            Map<String, String> map = this.f310a;
            return map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"));
        }
        return invokeV.booleanValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || Build.VERSION.SDK_INT < 11) {
            return;
        }
        super.setContentTitle(this.f308a);
        super.setContentText(this.f44214b);
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m334d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? (TextUtils.isEmpty(b()) || TextUtils.isEmpty(this.f309a)) ? false : true : invokeV.booleanValue;
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? m334d() && f() : invokeV.booleanValue;
    }

    private boolean f() {
        InterceptResult invokeV;
        List<StatusBarNotification> m639b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (Build.VERSION.SDK_INT >= 20 && (m639b = com.xiaomi.push.service.ao.a(a(), this.f309a).m639b()) != null && !m639b.isEmpty()) {
                for (StatusBarNotification statusBarNotification : m639b) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f307a : (RemoteViews) invokeV.objValue;
    }

    @Override // com.xiaomi.push.en
    public en a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, map)) == null) {
            this.f310a = map;
            return this;
        }
        return (en) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public ep addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, charSequence, pendingIntent)) == null) ? this : (ep) invokeILL.objValue;
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
            this.f306a = bitmap;
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
            this.f308a = charSequence;
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
            super.m331a();
            Bundle bundle = new Bundle();
            if (m334d()) {
                bundle.putBoolean("mipush.customCopyLayout", this.f312b);
            } else {
                bundle.putBoolean("mipush.customCopyLayout", false);
            }
            bundle.putBoolean("miui.customHeight", false);
            addExtras(bundle);
            if (m333c() || !com.xiaomi.push.service.ap.m640a(a().getContentResolver())) {
                d();
            }
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            Bitmap a = a();
            if (a != null) {
                a().setImageViewBitmap(i, a);
                return;
            }
            int b2 = g.b(a(), this.f309a);
            if (b2 != 0) {
                a().setImageViewResource(i, b2);
            }
        }
    }

    @Override // com.xiaomi.push.en
    public abstract boolean a();

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m335a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) ? ((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d) < 192.0d : invokeI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: b */
    public ep setContentText(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, charSequence)) == null) {
            this.f44214b = charSequence;
            return this;
        }
        return (ep) invokeL.objValue;
    }

    public abstract String b();

    /* renamed from: b  reason: collision with other method in class */
    public final void m336b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || Build.VERSION.SDK_INT < 11) {
            return;
        }
        super.setContentTitle(this.f308a);
        super.setContentText(this.f44214b);
        Bitmap bitmap = this.f306a;
        if (bitmap != null) {
            super.setLargeIcon(bitmap);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public final boolean m337b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f311a : invokeV.booleanValue;
    }
}
