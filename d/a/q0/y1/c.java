package d.a.q0.y1;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f67083a;

    /* renamed from: b  reason: collision with root package name */
    public Context f67084b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f67085c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f67086d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f67087e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f67088f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f67089g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f67090h;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f67091e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67091e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f67091e.f67087e == null) {
                return;
            }
            ((WindowManager) this.f67091e.f67084b.getSystemService("window")).removeViewImmediate(this.f67091e.f67087e);
            this.f67091e.e();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f67092e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67092e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f67092e;
                cVar.k(cVar.f67084b.getString(R.string.data_init));
            }
        }
    }

    /* renamed from: d.a.q0.y1.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1860c {
        c getSplash();
    }

    /* loaded from: classes8.dex */
    public class d extends TextView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public LinearGradient f67093e;

        /* renamed from: f  reason: collision with root package name */
        public Matrix f67094f;

        /* renamed from: g  reason: collision with root package name */
        public Paint f67095g;

        /* renamed from: h  reason: collision with root package name */
        public int f67096h;

        /* renamed from: i  reason: collision with root package name */
        public int f67097i;
        public boolean j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(c cVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context};
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
            this.f67096h = 0;
            this.f67097i = 0;
            this.j = true;
        }

        @Override // android.widget.TextView, android.view.View
        public void onDraw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
                super.onDraw(canvas);
                if (!this.j || this.f67094f == null) {
                    return;
                }
                int i2 = this.f67097i;
                int i3 = this.f67096h;
                int i4 = i2 + (i3 / 10);
                this.f67097i = i4;
                if (i4 > i3 * 2) {
                    this.f67097i = -i3;
                }
                this.f67094f.setTranslate(this.f67097i, 0.0f);
                this.f67093e.setLocalMatrix(this.f67094f);
                postInvalidateDelayed(50L);
            }
        }

        @Override // android.view.View
        public void onSizeChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
                super.onSizeChanged(i2, i3, i4, i5);
                if (this.f67096h == 0) {
                    int measuredWidth = getMeasuredWidth();
                    this.f67096h = measuredWidth;
                    if (measuredWidth > 0) {
                        this.f67095g = getPaint();
                        LinearGradient linearGradient = new LinearGradient(-this.f67096h, 0.0f, 0.0f, 0.0f, new int[]{1610612736, Integer.MAX_VALUE, 1610612736}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                        this.f67093e = linearGradient;
                        this.f67095g.setShader(linearGradient);
                        this.f67094f = new Matrix();
                    }
                }
            }
        }
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67084b = context;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Handler handler = this.f67086d;
            if (handler != null) {
                handler.removeCallbacks(this.f67089g);
                this.f67086d.removeCallbacks(this.f67090h);
                this.f67090h = null;
                this.f67089g = null;
                this.f67086d = null;
            }
            HandlerThread handlerThread = this.f67085c;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            if (this.f67088f != null) {
                this.f67088f = null;
            }
            if (this.f67087e != null) {
                this.f67087e = null;
            }
            this.f67083a = false;
        }
    }

    public final List<String> f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("com.baidu.tieba.SPLASH_PIPELINE_ACTION");
            intent.setPackage(context.getPackageName());
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 64);
            ArrayList arrayList = new ArrayList();
            if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                String packageName = context.getPackageName();
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    String str = resolveInfo.activityInfo.name;
                    arrayList.add(StringUtil.ARRAY_START + packageName + "/" + str + "}");
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f67087e == null || this.f67088f == null) {
            return;
        }
        this.f67086d.removeCallbacks(this.f67089g);
        this.f67086d.post(this.f67089g);
    }

    public final boolean h() {
        InterceptResult invokeV;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ActivityManager activityManager = (ActivityManager) this.f67084b.getSystemService("activity");
            if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            String packageName = this.f67084b.getPackageName();
            int myPid = Process.myPid();
            for (int i2 = 0; i2 < runningAppProcesses.size(); i2++) {
                if (runningAppProcesses.get(i2).pid == myPid && TextUtils.equals(runningAppProcesses.get(i2).processName, packageName)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<String> f2 = f(this.f67084b);
            if (f2 != null && f2.size() != 0) {
                ActivityManager.RunningTaskInfo runningTaskInfo = ((ActivityManager) this.f67084b.getSystemService("activity")).getRunningTasks(1).get(0);
                String shortString = runningTaskInfo.baseActivity.toShortString();
                String shortString2 = runningTaskInfo.topActivity.toShortString();
                for (String str : f2) {
                    if (shortString.equals(str) || shortString2.equals(str)) {
                        return true;
                    }
                    while (r0.hasNext()) {
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !this.f67083a && h() && i()) {
            if (this.f67085c == null) {
                HandlerThread handlerThread = new HandlerThread("splash-thread");
                this.f67085c = handlerThread;
                handlerThread.start();
            }
            if (this.f67086d == null) {
                this.f67086d = new Handler(this.f67085c.getLooper());
            }
            if (this.f67089g == null) {
                this.f67089g = new a(this);
            }
            if (this.f67090h == null) {
                this.f67090h = new b(this);
            }
            this.f67086d.removeCallbacks(this.f67090h);
            this.f67086d.postAtFrontOfQueue(this.f67090h);
            this.f67083a = true;
            this.f67086d.postDelayed(this.f67089g, 20000L);
        }
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (this.f67088f == null) {
                d dVar = new d(this, this.f67084b);
                this.f67088f = dVar;
                dVar.setTextSize(1, 18.0f);
            }
            this.f67088f.setText(str);
            RelativeLayout relativeLayout = new RelativeLayout(this.f67084b);
            this.f67087e = relativeLayout;
            relativeLayout.setBackgroundResource(R.drawable.pic_splash_logo);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(15);
            this.f67087e.addView(this.f67088f, layoutParams);
            WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
            layoutParams2.type = 2005;
            layoutParams2.format = 1;
            layoutParams2.gravity = 17;
            layoutParams2.x = 0;
            layoutParams2.y = 0;
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            layoutParams2.flags = 1280;
            ((WindowManager) this.f67084b.getSystemService("window")).addView(this.f67087e, layoutParams2);
        }
    }
}
