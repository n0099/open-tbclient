package com.repackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class aa3 {
    public static /* synthetic */ Interceptable $ic;
    public static aa3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, b> a;
    public AudioManager b;
    public boolean c;
    public BroadcastReceiver d;

    /* loaded from: classes5.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa3 this$0;

        public a(aa3 aa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = aa3Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && "android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (this.this$0.b == null) {
                    this.this$0.b = (AudioManager) pj2.c().getSystemService("audio");
                }
                for (Map.Entry entry : this.this$0.a.entrySet()) {
                    ((b) entry.getValue()).a(this.this$0.b != null ? this.this$0.b.getStreamVolume(3) : 0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i);
    }

    public aa3() {
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
        this.a = new ConcurrentHashMap<>();
        this.d = new a(this);
    }

    public static aa3 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (aa3.class) {
                    if (e == null) {
                        e = new aa3();
                    }
                }
            }
            return e;
        }
        return (aa3) invokeV.objValue;
    }

    public static void h() {
        aa3 aa3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, null) == null) || (aa3Var = e) == null) {
            return;
        }
        aa3Var.g();
    }

    private void registerReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            pj2.c().registerReceiver(this.d, intentFilter);
            this.c = true;
        }
    }

    private void unregisterReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            try {
                pj2.c().unregisterReceiver(this.d);
                this.c = false;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d(@NonNull String str, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, bVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this) {
            this.a.put(str, bVar);
            if (!this.c) {
                registerReceiver();
            }
            if (sg1.a) {
                Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.a.size());
            }
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.b == null) {
                this.b = (AudioManager) pj2.c().getSystemService("audio");
            }
            AudioManager audioManager = this.b;
            if (audioManager != null) {
                return audioManager.getStreamMaxVolume(3);
            }
            return 100;
        }
        return invokeV.intValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a.clear();
                this.b = null;
                this.c = false;
            }
            e = null;
        }
    }

    public boolean i(@NonNull String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            synchronized (this) {
                b remove = this.a.remove(str);
                if (this.a.size() == 0 && this.c) {
                    unregisterReceiver();
                }
                if (sg1.a && remove != null) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.a.size());
                }
                z = remove != null;
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
