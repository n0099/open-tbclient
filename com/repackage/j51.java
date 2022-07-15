package com.repackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class j51 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public long c;
    public long d;
    public long e;
    public Runnable f;
    public final Handler g;
    public final boolean h;
    public final int i;
    public boolean j;
    public boolean k;
    public PhoneStateListener l;
    public String m;
    public String n;

    /* loaded from: classes6.dex */
    public class a extends PhoneStateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public final /* synthetic */ TelephonyManager c;
        public final /* synthetic */ j51 d;

        public a(j51 j51Var, TelephonyManager telephonyManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j51Var, telephonyManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = j51Var;
            this.c = telephonyManager;
            this.a = 0;
            this.b = 0;
        }

        public final void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a = this.b;
                this.b = i;
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                if (i == 0) {
                    ci0.a("NadPSLogger", "监听到通话状态：IDLE");
                    a(i);
                    if (this.a == 2) {
                        this.d.c = System.currentTimeMillis();
                        this.d.h(this.c, this);
                    }
                } else if (i == 1) {
                    ci0.a("NadPSLogger", "监听到通话状态：RINGING");
                    a(i);
                    this.d.k = true;
                } else if (i != 2) {
                } else {
                    ci0.a("NadPSLogger", "监听到通话状态：OFFHOOK");
                    a(i);
                    if (this.a == 0) {
                        this.d.b = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TelephonyManager a;
        public final /* synthetic */ PhoneStateListener b;
        public final /* synthetic */ j51 c;

        public b(j51 j51Var, TelephonyManager telephonyManager, PhoneStateListener phoneStateListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j51Var, telephonyManager, phoneStateListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j51Var;
            this.a = telephonyManager;
            this.b = phoneStateListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.getCallState() != 0) {
                    this.c.i(this.a, this.b);
                    return;
                }
                this.a.listen(this.b, 0);
                this.c.e = System.currentTimeMillis();
                this.c.l();
            }
        }
    }

    public j51() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.g = new Handler(Looper.getMainLooper());
        this.h = tk0.b().a().a("psl_switch", 1) == 1;
        this.i = tk0.b().a().a("psl_time", 20);
        this.j = false;
        this.k = false;
    }

    public final void h(@NonNull TelephonyManager telephonyManager, @NonNull PhoneStateListener phoneStateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, telephonyManager, phoneStateListener) == null) {
            long j = this.b;
            if (j != 0) {
                long j2 = this.c;
                if (j2 != 0 && j2 > j) {
                    this.g.removeCallbacks(this.f);
                    telephonyManager.listen(phoneStateListener, 0);
                    this.e = System.currentTimeMillis();
                    l();
                    return;
                }
            }
            i(telephonyManager, phoneStateListener);
        }
    }

    public final void i(@NonNull TelephonyManager telephonyManager, @NonNull PhoneStateListener phoneStateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, telephonyManager, phoneStateListener) == null) {
            Runnable runnable = this.f;
            if (runnable != null) {
                this.g.removeCallbacks(runnable);
            } else {
                this.f = new b(this, telephonyManager, phoneStateListener);
            }
            telephonyManager.listen(phoneStateListener, 32);
            this.g.postDelayed(this.f, TimeUnit.SECONDS.toMillis(this.i));
        }
    }

    public final int j(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            if (j <= 0) {
                return 0;
            }
            return (int) TimeUnit.MILLISECONDS.toSeconds(j);
        }
        return invokeJ.intValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long j = this.c;
            if (j != 0) {
                long j2 = this.b;
                if (j2 != 0 && j > j2) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void l() {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.j) {
            return;
        }
        this.j = true;
        if (TextUtils.isEmpty(this.m)) {
            return;
        }
        String str2 = k() ? "1" : "0";
        String str3 = "-1";
        if (k()) {
            str = "" + j(this.c - this.b);
        } else {
            str = "-1";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(PreferencesUtil.LEFT_MOUNT);
        sb.append(this.i);
        sb.append(",");
        sb.append(j(this.e - this.d));
        sb.append(",");
        if (k()) {
            str3 = "" + j(this.b - this.a);
        }
        sb.append(str3);
        sb.append(",");
        sb.append(this.k ? "1" : "0");
        sb.append(PreferencesUtil.RIGHT_MOUNT);
        String sb2 = sb.toString();
        ClogBuilder m = new ClogBuilder().y(ClogBuilder.LogType.PHONE_STATE_LISTEN).p(this.m).k(str2).l(str).m(sb2);
        if (!TextUtils.isEmpty(this.n)) {
            m.n(this.n);
        } else {
            m.n("");
        }
        iy0.b(m);
        ci0.a("NadPSLogger", "==========结束监听并打点==========");
        ci0.a("NadPSLogger", "log_type：" + ClogBuilder.LogType.PHONE_STATE_LISTEN.type);
        ci0.a("NadPSLogger", "da_ext1 是否监听到主动呼出：" + str2);
        ci0.a("NadPSLogger", "da_ext2 主动呼出时长：" + str);
        ci0.a("NadPSLogger", "da_ext3 云控监听时长，实际监听时长，拨号前停留时长，期间有无呼入：" + sb2);
    }

    public void m(@NonNull Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048581, this, context, str, str2) == null) && this.h) {
            this.b = 0L;
            this.c = 0L;
            this.d = 0L;
            this.e = 0L;
            this.a = 0L;
            this.a = System.currentTimeMillis();
            this.j = false;
            this.k = false;
            this.m = str;
            this.n = str2;
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            a aVar = new a(this, telephonyManager);
            this.l = aVar;
            i(telephonyManager, aVar);
            this.d = System.currentTimeMillis();
            ci0.a("NadPSLogger", "==========开始监听==========");
        }
    }
}
