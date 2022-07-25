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
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public abstract class es extends eq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public Bitmap f316a;

    /* renamed from: a  reason: collision with other field name */
    public RemoteViews f317a;

    /* renamed from: a  reason: collision with other field name */
    public CharSequence f318a;

    /* renamed from: a  reason: collision with other field name */
    public String f319a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<Notification.Action> f320a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f321a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f322a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public CharSequence f323b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f324b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public es(Context context, int i, String str) {
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
        this.f320a = new ArrayList<>();
        this.b = 0;
        this.f319a = str;
        this.a = i;
        m314c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public es(Context context, String str) {
        this(context, 0, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private Bitmap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? com.xiaomi.push.service.al.a(h.m383a(a(), this.f319a)) : (Bitmap) invokeV.objValue;
    }

    private String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            boolean e = e();
            this.f324b = e;
            return e ? b() : a();
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    private void m314c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            int a = a(a().getResources(), c(), TtmlNode.TAG_LAYOUT, a().getPackageName());
            if (a == 0) {
                com.xiaomi.channel.commonutils.logger.b.m89a("create RemoteViews failed, no such layout resource was found");
                return;
            }
            this.f317a = new RemoteViews(a().getPackageName(), a);
            this.f322a = a();
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m315c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            Map<String, String> map = this.f321a;
            return map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"));
        }
        return invokeV.booleanValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            super.setContentTitle(this.f318a);
            super.setContentText(this.f323b);
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m316d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? (TextUtils.isEmpty(b()) || TextUtils.isEmpty(this.f319a)) ? false : true : invokeV.booleanValue;
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? m316d() && f() : invokeV.booleanValue;
    }

    private boolean f() {
        InterceptResult invokeV;
        List<StatusBarNotification> m631b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (Build.VERSION.SDK_INT >= 20 && (m631b = com.xiaomi.push.service.ax.a(a(), this.f319a).m631b()) != null && !m631b.isEmpty()) {
                for (StatusBarNotification statusBarNotification : m631b) {
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

    public int a(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) ? (int) ((f * a().getResources().getDisplayMetrics().density) + 0.5f) : invokeF.intValue;
    }

    public Bitmap a(Bitmap bitmap, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, f)) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawRoundRect(new RectF(rect), f, f, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return (Bitmap) invokeLF.objValue;
    }

    @Override // com.xiaomi.push.eq
    public final RemoteViews a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f317a : (RemoteViews) invokeV.objValue;
    }

    @Override // com.xiaomi.push.eq
    public eq a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, map)) == null) {
            this.f321a = map;
            return this;
        }
        return (eq) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public es addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, charSequence, pendingIntent)) == null) {
            addAction(new Notification.Action(i, charSequence, pendingIntent));
            return this;
        }
        return (es) invokeILL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public es addAction(Notification.Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, action)) == null) {
            if (action != null) {
                this.f320a.add(action);
            }
            int i = this.b;
            this.b = i + 1;
            a(i, action);
            return this;
        }
        return (es) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public es setLargeIcon(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bitmap)) == null) {
            this.f316a = bitmap;
            return this;
        }
        return (es) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public es setContentTitle(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, charSequence)) == null) {
            this.f318a = charSequence;
            return this;
        }
        return (es) invokeL.objValue;
    }

    @Override // com.xiaomi.push.eq
    public abstract String a();

    @Override // com.xiaomi.push.eq
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.m313a();
            Bundle bundle = new Bundle();
            if (m316d()) {
                bundle.putBoolean("mipush.customCopyLayout", this.f324b);
            } else {
                bundle.putBoolean("mipush.customCopyLayout", false);
            }
            bundle.putBoolean("miui.customHeight", false);
            bundle.putBoolean("mipush.customNotification", true);
            bundle.putInt("mipush.customLargeIconId", a(NotificationCompat.CarExtender.EXTRA_LARGE_ICON));
            if (this.f320a.size() > 0) {
                Notification.Action[] actionArr = new Notification.Action[this.f320a.size()];
                this.f320a.toArray(actionArr);
                bundle.putParcelableArray("mipush.customActions", actionArr);
            }
            if (m315c() || !com.xiaomi.push.service.ay.m633a(a().getContentResolver())) {
                d();
            } else {
                bundle.putCharSequence("mipush.customTitle", this.f318a);
                bundle.putCharSequence("mipush.customContent", this.f323b);
            }
            addExtras(bundle);
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
            int b = h.b(a(), this.f319a);
            if (b != 0) {
                a().setImageViewResource(i, b);
            }
        }
    }

    public void a(int i, Notification.Action action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i, action) == null) {
        }
    }

    @Override // com.xiaomi.push.eq
    public abstract boolean a();

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m317a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) ? ((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d) < 192.0d : invokeI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: b */
    public es setContentText(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, charSequence)) == null) {
            this.f323b = charSequence;
            return this;
        }
        return (es) invokeL.objValue;
    }

    public abstract String b();

    /* renamed from: b  reason: collision with other method in class */
    public final void m318b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.setContentTitle(this.f318a);
            super.setContentText(this.f323b);
            Bitmap bitmap = this.f316a;
            if (bitmap != null) {
                super.setLargeIcon(bitmap);
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public final boolean m319b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f322a : invokeV.booleanValue;
    }
}
