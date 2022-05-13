package com.repackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.br;
/* loaded from: classes5.dex */
public class cr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public final long b;
    public long c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public br h;
    public long i;
    public Handler j;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(cr crVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {crVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = crVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                synchronized (this.a) {
                    if (!this.a.d && !this.a.f) {
                        long j2 = this.a.i;
                        long elapsedRealtime = this.a.c - SystemClock.elapsedRealtime();
                        long j3 = 0;
                        if (elapsedRealtime <= 0) {
                            this.a.g = true;
                            this.a.i = this.a.a;
                            this.a.h.a(0L, Math.max(this.a.i - j2, 0L));
                            this.a.h.onFinish();
                        } else {
                            long elapsedRealtime2 = SystemClock.elapsedRealtime();
                            this.a.i = this.a.a - elapsedRealtime;
                            this.a.h.a(elapsedRealtime, Math.max(this.a.i - j2, 0L));
                            long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                            if (elapsedRealtime < this.a.b) {
                                j = elapsedRealtime - elapsedRealtime3;
                                if (j < 0) {
                                    sendMessageDelayed(obtainMessage(1), j3);
                                }
                            } else {
                                j = this.a.b - elapsedRealtime3;
                                while (j < 0) {
                                    j += this.a.b;
                                }
                            }
                            j3 = j;
                            sendMessageDelayed(obtainMessage(1), j3);
                        }
                    }
                }
            }
        }
    }

    public cr(long j, long j2, br brVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), brVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.i = 0L;
        this.j = new a(this, Looper.getMainLooper());
        this.a = j;
        this.b = j2;
        this.i = 0L;
        this.h = brVar;
    }

    public final synchronized cr b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                this.d = false;
                this.g = false;
                this.f = false;
                this.e = false;
                if (this.a <= 0) {
                    this.g = true;
                    this.h.onFinish();
                    return this;
                }
                this.c = SystemClock.elapsedRealtime() + this.a;
                this.j.sendMessage(this.j.obtainMessage(1));
                this.h.onStart();
                this.e = true;
                return this;
            }
        }
        return (cr) invokeV.objValue;
    }

    public final synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (!this.f && !this.d && !this.g && this.e) {
                    SystemClock.elapsedRealtime();
                    this.f = true;
                    this.d = false;
                    this.g = false;
                    this.h.onPause();
                    this.j.removeMessages(1);
                }
            }
        }
    }

    public final synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.d = true;
                this.f = false;
                this.g = false;
                this.e = false;
                this.j.removeMessages(1);
                this.h.onCancel();
            }
        }
    }

    public final synchronized void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.h = new br.a();
                h();
            }
        }
    }
}
