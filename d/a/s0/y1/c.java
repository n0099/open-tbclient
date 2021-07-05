package d.a.s0.y1;

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
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f69602a;

    /* renamed from: b  reason: collision with root package name */
    public Context f69603b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f69604c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f69605d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f69606e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f69607f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f69608g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f69609h;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f69610e;

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
            this.f69610e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f69610e.f69606e == null) {
                return;
            }
            ((WindowManager) this.f69610e.f69603b.getSystemService("window")).removeViewImmediate(this.f69610e.f69606e);
            this.f69610e.e();
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f69611e;

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
            this.f69611e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f69611e;
                cVar.k(cVar.f69603b.getString(R.string.data_init));
            }
        }
    }

    /* renamed from: d.a.s0.y1.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1896c {
        c getSplash();
    }

    /* loaded from: classes9.dex */
    public class d extends TextView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public LinearGradient f69612e;

        /* renamed from: f  reason: collision with root package name */
        public Matrix f69613f;

        /* renamed from: g  reason: collision with root package name */
        public Paint f69614g;

        /* renamed from: h  reason: collision with root package name */
        public int f69615h;

        /* renamed from: i  reason: collision with root package name */
        public int f69616i;
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
            this.f69615h = 0;
            this.f69616i = 0;
            this.j = true;
        }

        @Override // android.widget.TextView, android.view.View
        public void onDraw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
                super.onDraw(canvas);
                if (!this.j || this.f69613f == null) {
                    return;
                }
                int i2 = this.f69616i;
                int i3 = this.f69615h;
                int i4 = i2 + (i3 / 10);
                this.f69616i = i4;
                if (i4 > i3 * 2) {
                    this.f69616i = -i3;
                }
                this.f69613f.setTranslate(this.f69616i, 0.0f);
                this.f69612e.setLocalMatrix(this.f69613f);
                postInvalidateDelayed(50L);
            }
        }

        @Override // android.view.View
        public void onSizeChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
                super.onSizeChanged(i2, i3, i4, i5);
                if (this.f69615h == 0) {
                    int measuredWidth = getMeasuredWidth();
                    this.f69615h = measuredWidth;
                    if (measuredWidth > 0) {
                        this.f69614g = getPaint();
                        LinearGradient linearGradient = new LinearGradient(-this.f69615h, 0.0f, 0.0f, 0.0f, new int[]{1610612736, Integer.MAX_VALUE, 1610612736}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                        this.f69612e = linearGradient;
                        this.f69614g.setShader(linearGradient);
                        this.f69613f = new Matrix();
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
        this.f69603b = context;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Handler handler = this.f69605d;
            if (handler != null) {
                handler.removeCallbacks(this.f69608g);
                this.f69605d.removeCallbacks(this.f69609h);
                this.f69609h = null;
                this.f69608g = null;
                this.f69605d = null;
            }
            HandlerThread handlerThread = this.f69604c;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            if (this.f69607f != null) {
                this.f69607f = null;
            }
            if (this.f69606e != null) {
                this.f69606e = null;
            }
            this.f69602a = false;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f69606e == null || this.f69607f == null) {
            return;
        }
        this.f69605d.removeCallbacks(this.f69608g);
        this.f69605d.post(this.f69608g);
    }

    public final boolean h() {
        InterceptResult invokeV;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ActivityManager activityManager = (ActivityManager) this.f69603b.getSystemService("activity");
            if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            String packageName = this.f69603b.getPackageName();
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
            List<String> f2 = f(this.f69603b);
            if (f2 != null && f2.size() != 0) {
                ActivityManager.RunningTaskInfo runningTaskInfo = ((ActivityManager) this.f69603b.getSystemService("activity")).getRunningTasks(1).get(0);
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
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !this.f69602a && h() && i()) {
            if (this.f69604c == null) {
                HandlerThread handlerThread = new HandlerThread("splash-thread");
                this.f69604c = handlerThread;
                handlerThread.start();
            }
            if (this.f69605d == null) {
                this.f69605d = new Handler(this.f69604c.getLooper());
            }
            if (this.f69608g == null) {
                this.f69608g = new a(this);
            }
            if (this.f69609h == null) {
                this.f69609h = new b(this);
            }
            this.f69605d.removeCallbacks(this.f69609h);
            this.f69605d.postAtFrontOfQueue(this.f69609h);
            this.f69602a = true;
            this.f69605d.postDelayed(this.f69608g, 20000L);
        }
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (this.f69607f == null) {
                d dVar = new d(this, this.f69603b);
                this.f69607f = dVar;
                dVar.setTextSize(1, 18.0f);
            }
            this.f69607f.setText(str);
            RelativeLayout relativeLayout = new RelativeLayout(this.f69603b);
            this.f69606e = relativeLayout;
            relativeLayout.setBackgroundResource(R.drawable.pic_splash_logo);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(15);
            this.f69606e.addView(this.f69607f, layoutParams);
            WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
            layoutParams2.type = 2005;
            layoutParams2.format = 1;
            layoutParams2.gravity = 17;
            layoutParams2.x = 0;
            layoutParams2.y = 0;
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            layoutParams2.flags = 1280;
            ((WindowManager) this.f69603b.getSystemService("window")).addView(this.f69606e, layoutParams2);
        }
    }
}
