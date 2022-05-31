package com.repackage;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.TouchDelegate;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.print.PrintHelper;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class li {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static float b;
    public static int c;
    public static int d;
    public static Toast e;
    public static c f;
    public static String g;
    public static Handler h;
    public static Runnable i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || li.e == null) {
                return;
            }
            li.e.cancel();
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ View f;

        public b(View view2, int i, int i2, int i3, int i4, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), view3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = view3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.a.getHitRect(rect);
                rect.right += this.b;
                rect.left -= this.c;
                rect.bottom += this.d;
                rect.top -= this.e;
                this.f.setTouchDelegate(new TouchDelegate(rect, this.a));
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void createToastView();

        View getToastContentView();

        void setToastString(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964034520, "Lcom/repackage/li;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964034520, "Lcom/repackage/li;");
                return;
            }
        }
        h = new Handler(Looper.getMainLooper());
        i = new a();
    }

    public static boolean A() {
        InterceptResult invokeV;
        String p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String str = Build.DISPLAY;
            if (str != null && str.contains("Flyme") && (p = p(str)) != null && p.length() >= 3) {
                int e2 = jg.e(p(p.substring(0, 1)), 0);
                int e3 = jg.e(p(p.substring(1, 2)), 0);
                if (e2 > 3 || (e2 == 3 && e3 >= 5)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean B(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) ? bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70 : invokeL.booleanValue;
    }

    public static boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Looper.getMainLooper() == Looper.myLooper() && Looper.getMainLooper().getThread() == Thread.currentThread() : invokeV.booleanValue;
    }

    public static boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? ji.z() : invokeV.booleanValue;
    }

    public static Rect E(Paint paint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, paint, str)) == null) {
            Rect rect = new Rect();
            paint.getTextBounds(str, 0, str.length(), rect);
            return rect;
        }
        return (Rect) invokeLL.objValue;
    }

    public static float F(Paint paint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, paint, str)) == null) {
            if (paint == null || str == null) {
                return 0.0f;
            }
            return paint.measureText(str);
        }
        return invokeLL.floatValue;
    }

    public static double G(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Double.valueOf(d2)})) == null) ? (d2 * 3.141592653589793d) / 180.0d : invokeCommon.doubleValue;
    }

    public static void H(Context context) {
        Intent launchIntentForPackage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            try {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    if (packageManager != null && (launchIntentForPackage = packageManager.getLaunchIntentForPackage(context.getPackageName())) != null) {
                        launchIntentForPackage.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + 100, PendingIntent.getActivity(context, 950731, launchIntentForPackage, LaunchTaskConstants.OTHER_PROCESS));
                    }
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            } finally {
                System.exit(0);
            }
        }
    }

    public static void I(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, cVar) == null) {
            f = cVar;
        }
    }

    public static void J(Context context, String str, SpannableString spannableString, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65546, null, context, str, spannableString, i2) == null) || TextUtils.isEmpty(spannableString) || TextUtils.isEmpty(spannableString)) {
            return;
        }
        h.removeCallbacks(i);
        if (e != null && Build.VERSION.SDK_INT < 28) {
            c cVar = f;
            if (cVar != null) {
                cVar.createToastView();
            }
            if (!spannableString.equals(g)) {
                c cVar2 = f;
                if (cVar2 != null && cVar2.getToastContentView() != null) {
                    f.setToastString(str);
                    e.setView(f.getToastContentView());
                } else {
                    e.setText(spannableString);
                }
            }
            int d2 = d(BdBaseApplication.getInst().getApp(), 100.0f);
            if (BdBaseApplication.getInst().getApp().getResources().getConfiguration().orientation == 2) {
                d2 = 0;
            }
            if (i2 == 3500) {
                e.setDuration(1);
            } else {
                e.setDuration(0);
            }
            e.setGravity(17, 0, d2);
        } else {
            Toast toast = e;
            if (toast != null) {
                toast.cancel();
            }
            c cVar3 = f;
            if (cVar3 != null) {
                cVar3.createToastView();
            }
            c cVar4 = f;
            if (cVar4 != null && cVar4.getToastContentView() != null) {
                Toast toast2 = new Toast(BdBaseApplication.getInst().getApp());
                e = toast2;
                ui.a(toast2);
                if (i2 == 3500) {
                    e.setDuration(1);
                } else {
                    e.setDuration(0);
                }
                f.setToastString(str);
                e.setView(f.getToastContentView());
            } else {
                if (i2 == 3500) {
                    Toast makeText = Toast.makeText(BdBaseApplication.getInst().getApp(), spannableString, 1);
                    e = makeText;
                    ui.a(makeText);
                } else {
                    Toast makeText2 = Toast.makeText(BdBaseApplication.getInst().getApp(), spannableString, 0);
                    e = makeText2;
                    ui.a(makeText2);
                }
                e.setText(spannableString);
            }
            e.setGravity(17, 0, d(BdBaseApplication.getInst().getApp(), 100.0f));
        }
        c cVar5 = f;
        if (cVar5 != null && (cVar5.getToastContentView() instanceof TextView)) {
            ((TextView) f.getToastContentView()).setText(spannableString);
        }
        g = str;
        h.postDelayed(i, i2);
        e.show();
    }

    public static void K(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, null, context, i2) == null) {
            L(context, context.getResources().getString(i2));
        }
    }

    public static void L(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, str) == null) {
            P(context, str, PrintHelper.MAX_PRINT_SIZE);
        }
    }

    public static void M(Context context, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, view2) == null) {
            try {
                ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view2, 0);
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    public static void N(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, context, i2) == null) {
            O(context, context.getResources().getString(i2));
        }
    }

    public static void O(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, context, str) == null) {
            P(context, str, 2000);
        }
    }

    public static void P(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65552, null, context, str, i2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str)) {
            return;
        }
        h.removeCallbacks(i);
        if (e != null && Build.VERSION.SDK_INT < 28) {
            c cVar = f;
            if (cVar != null) {
                cVar.createToastView();
            }
            if (!str.equals(g)) {
                c cVar2 = f;
                if (cVar2 != null && cVar2.getToastContentView() != null) {
                    f.setToastString(str);
                    e.setView(f.getToastContentView());
                } else {
                    e.setText(str);
                }
            }
            int d2 = d(BdBaseApplication.getInst().getApp(), 100.0f);
            if (BdBaseApplication.getInst().getApp().getResources().getConfiguration().orientation == 2) {
                d2 = 0;
            }
            if (i2 == 3500) {
                e.setDuration(1);
            } else {
                e.setDuration(0);
            }
            e.setGravity(17, 0, d2);
        } else {
            Toast toast = e;
            if (toast != null) {
                toast.cancel();
            }
            c cVar3 = f;
            if (cVar3 != null) {
                cVar3.createToastView();
            }
            c cVar4 = f;
            if (cVar4 != null && cVar4.getToastContentView() != null) {
                Toast toast2 = new Toast(BdBaseApplication.getInst().getApp());
                e = toast2;
                ui.a(toast2);
                if (i2 == 3500) {
                    e.setDuration(1);
                } else {
                    e.setDuration(0);
                }
                f.setToastString(str);
                e.setView(f.getToastContentView());
            } else {
                if (i2 == 3500) {
                    Toast makeText = Toast.makeText(BdBaseApplication.getInst().getApp(), str, 1);
                    e = makeText;
                    ui.a(makeText);
                } else {
                    Toast makeText2 = Toast.makeText(BdBaseApplication.getInst().getApp(), str, 0);
                    e = makeText2;
                    ui.a(makeText2);
                }
                e.setText(str);
            }
            e.setGravity(17, 0, d(BdBaseApplication.getInst().getApp(), 100.0f));
        }
        g = str;
        h.postDelayed(i, i2);
        e.show();
    }

    public static void b(Context context, View view2, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{context, view2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int d2 = d(context, i2);
            int d3 = d(context, i3);
            int d4 = d(context, i4);
            int d5 = d(context, i5);
            View view3 = (View) view2.getParent();
            view3.post(new b(view2, d4, d2, d5, d3, view3));
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, null) == null) && BdBaseApplication.getInst().isDebugMode()) {
            if (!C()) {
                StringBuilder sb = new StringBuilder(100);
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                for (int i2 = 1; i2 < stackTrace.length; i2++) {
                    sb.append(stackTrace[i2].getClassName());
                    sb.append(".");
                    sb.append(stackTrace[i2].getMethodName());
                    sb.append("  lines = ");
                    sb.append(stackTrace[i2].getLineNumber());
                    sb.append("\n");
                }
                BdLog.e("can not be call not thread! trace = \n" + sb.toString());
                throw new Error("can not be call not thread! trace = " + sb.toString());
            }
        }
    }

    public static int d(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65556, null, context, f2)) == null) {
            if (!a) {
                y(context);
            }
            return (int) ((f2 * b) + 0.5f);
        }
        return invokeLF.intValue;
    }

    public static Field e(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, obj, str)) == null) {
            for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
                try {
                    Field declaredField = cls.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    return declaredField;
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            return null;
        }
        return (Field) invokeLL.objValue;
    }

    public static int f(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65558, null, context, i2)) == null) ? context.getResources().getDimensionPixelSize(i2) : invokeLI.intValue;
    }

    public static double g(double d2, double d3, double d4, double d5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)})) == null) {
            double G = G(d2);
            double G2 = G(d4);
            return Math.round(((Math.asin(Math.sqrt(Math.pow(Math.sin((G - G2) / 2.0d), 2.0d) + ((Math.cos(G) * Math.cos(G2)) * Math.pow(Math.sin((G(d3) - G(d5)) / 2.0d), 2.0d)))) * 2.0d) * 6378.137d) * 10000.0d) / 10000.0d;
        }
        return invokeCommon.doubleValue;
    }

    public static float h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            if (!a) {
                y(context);
            }
            return b;
        }
        return invokeL.floatValue;
    }

    public static int i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
            if (!a) {
                y(context);
            }
            return d;
        }
        return invokeL.intValue;
    }

    public static int j(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65562, null, context, z)) == null) {
            if (!a || z) {
                y(context);
            }
            return d;
        }
        return invokeLZ.intValue;
    }

    public static int k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            if (!a) {
                y(context);
            }
            return c;
        }
        return invokeL.intValue;
    }

    public static int[] l(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65564, null, i2, i3, i4, i5)) == null) {
            if (i2 <= 0 || i3 <= 0 || i4 <= 0 || i5 <= 0) {
                return null;
            }
            int[] iArr = new int[2];
            if (i3 > i5) {
                i2 = (i2 * i5) / i3;
                i3 = i5;
            }
            if (i2 > i4) {
                i3 = (i3 * i4) / i2;
            } else {
                i4 = i2;
            }
            iArr[0] = i4;
            iArr[1] = i3;
            return iArr;
        }
        return (int[]) invokeIIII.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0038 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Reader] */
    public static String m() {
        ?? r2;
        Throwable th;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r2 = 65565;
            InterceptResult invokeV = interceptable.invokeV(65565, null);
            if (invokeV != null) {
                return (String) invokeV.objValue;
            }
        }
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop net.dns1").getInputStream()));
                try {
                    String readLine = bufferedReader.readLine();
                    mi.g(bufferedReader);
                    return readLine;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    mi.g(bufferedReader);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                mi.g(r2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
        } catch (Throwable th3) {
            r2 = 0;
            th = th3;
            mi.g(r2);
            throw th;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0038 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Reader] */
    public static String n() {
        ?? r2;
        Throwable th;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r2 = 65566;
            InterceptResult invokeV = interceptable.invokeV(65566, null);
            if (invokeV != null) {
                return (String) invokeV.objValue;
            }
        }
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop net.dns2").getInputStream()));
                try {
                    String readLine = bufferedReader.readLine();
                    mi.g(bufferedReader);
                    return readLine;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    mi.g(bufferedReader);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                mi.g(r2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
        } catch (Throwable th3) {
            r2 = 0;
            th = th3;
            mi.g(r2);
            throw th;
        }
    }

    public static int o() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            try {
                if (BdBaseApplication.getInst() == null || (activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity")) == null || (runningTasks = activityManager.getRunningTasks(1)) == null || runningTasks.size() <= 0) {
                    return 0;
                }
                for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                    if (runningTaskInfo != null && runningTaskInfo.topActivity != null) {
                        return runningTaskInfo.numActivities;
                    }
                }
                return 0;
            } catch (Exception e2) {
                BdLog.e(e2);
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static String p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
        }
        return (String) invokeL.objValue;
    }

    public static int[] q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            int[] iArr = new int[2];
            if (context == null) {
                return iArr;
            }
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static DisplayMetrics r(Activity activity) {
        InterceptResult invokeL;
        DisplayMetrics displayMetrics;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, activity)) == null) {
            DisplayMetrics displayMetrics2 = null;
            try {
                displayMetrics = new DisplayMetrics();
            } catch (Exception e2) {
                e = e2;
            }
            try {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics;
            } catch (Exception e3) {
                e = e3;
                displayMetrics2 = displayMetrics;
                BdLog.e(e.toString());
                return displayMetrics2;
            }
        }
        return (DisplayMetrics) invokeL.objValue;
    }

    public static int s(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, activity)) == null) {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int i2 = rect.top;
            if (i2 == 0) {
                try {
                    Class<?> cls = Class.forName("com.android.internal.R$dimen");
                    return activity.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField(SapiSystemBarTintManager.SystemBarConfig.g).get(cls.newInstance()).toString()));
                } catch (ClassNotFoundException e2) {
                    e2.printStackTrace();
                    return i2;
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                    return i2;
                } catch (IllegalArgumentException e4) {
                    e4.printStackTrace();
                    return i2;
                } catch (InstantiationException e5) {
                    e5.printStackTrace();
                    return i2;
                } catch (NoSuchFieldException e6) {
                    e6.printStackTrace();
                    return i2;
                } catch (NumberFormatException e7) {
                    e7.printStackTrace();
                    return i2;
                } catch (SecurityException e8) {
                    e8.printStackTrace();
                    return i2;
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static String t(TextPaint textPaint, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65572, null, textPaint, str, i2)) == null) {
            CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, i2, TextUtils.TruncateAt.END);
            if (ellipsize != null) {
                return ellipsize.toString();
            }
            return null;
        }
        return (String) invokeLLI.objValue;
    }

    public static int u(Paint paint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65573, null, paint, str)) == null) {
            if (str == null || str.length() <= 0) {
                return 0;
            }
            int length = str.length();
            float[] fArr = new float[length];
            paint.getTextWidths(str, fArr);
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                i2 += (int) Math.ceil(fArr[i3]);
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    public static c v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) ? f : (c) invokeV.objValue;
    }

    public static String w() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            try {
                if (BdBaseApplication.getInst() == null || (activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity")) == null || (runningTasks = activityManager.getRunningTasks(1)) == null || runningTasks.size() <= 0) {
                    return null;
                }
                for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                    if (runningTaskInfo != null && runningTaskInfo.topActivity != null) {
                        return runningTaskInfo.topActivity.getClassName();
                    }
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static void x(Context context, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65576, null, context, view2) == null) || view2 == null) {
            return;
        }
        try {
            if (view2.getWindowToken() == null) {
                return;
            }
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view2.getWindowToken(), 2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static void y(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65577, null, context) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int orientation = windowManager.getDefaultDisplay().getOrientation();
            if (orientation != 1 && orientation != 3) {
                c = displayMetrics.widthPixels;
                d = displayMetrics.heightPixels;
            } else {
                c = displayMetrics.heightPixels;
                d = displayMetrics.widthPixels;
            }
            b = displayMetrics.density;
            a = true;
        }
    }

    public static boolean z(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, bArr)) == null) {
            if (bArr == null) {
                return false;
            }
            try {
                String str = new String(bArr, 0, 16, "UTF-8");
                if (str.indexOf("RIFF") == 0) {
                    return 8 == str.indexOf("WEBPVP8 ");
                }
                return false;
            } catch (Exception e2) {
                BdLog.e(e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
