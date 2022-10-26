package com.heytap.openid.base;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.openid.sdk.m_h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class m_c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile IInterface m_a;
    public String m_b;
    public String m_c;
    public final Object m_d;
    public ServiceConnection m_e;
    public Handler m_f;
    public HandlerThread m_g;
    public Context m_h;
    public IBinder.DeathRecipient m_i;

    /* loaded from: classes7.dex */
    public class m_a implements IBinder.DeathRecipient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m_c m_a;

        public m_a(m_c m_cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m_cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m_a = m_cVar;
        }

        @Override // android.os.IBinder.DeathRecipient
        public native void binderDied();
    }

    /* loaded from: classes7.dex */
    public class m_b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m_c m_a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m_b(m_c m_cVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m_cVar, looper};
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
            this.m_a = m_cVar;
        }

        @Override // android.os.Handler
        public native void handleMessage(Message message);
    }

    public m_c() {
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
        this.m_a = null;
        this.m_b = null;
        this.m_c = null;
        this.m_d = new Object();
        this.m_e = null;
        this.m_i = new m_a(this);
        m_b();
    }

    public native Intent m_a();

    public native void m_a(Context context, String str, String str2);

    public synchronized void m_a(Context context, List list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, context, list, z) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (!(z ? m_b(str) : m_a(str))) {
                        arrayList.add(str);
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                if (this.m_a == null) {
                    m_h.m_a("2009");
                    try {
                        if (context.bindService(m_a(), this.m_e, 1)) {
                            m_h.m_a("2013");
                            if (this.m_a == null) {
                                synchronized (this.m_d) {
                                    try {
                                        if (this.m_a == null) {
                                            this.m_d.wait(10000L);
                                        }
                                    } catch (InterruptedException unused) {
                                        Log.e("IDHelper", "1006");
                                    }
                                }
                            }
                        } else {
                            Log.e("IDHelper", "1007");
                        }
                    } catch (Exception e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("1008 ");
                        sb.append(e.getMessage() != null ? e.getMessage() : e.getLocalizedMessage());
                        Log.e("IDHelper", sb.toString());
                    }
                }
                if (this.m_a == null) {
                    Log.e("IDHelper", DpStatConstants.FILECACHE_CLOSE_TYPE_OPT_DISABLE);
                    return;
                }
                m_h.m_a("2010");
                if (TextUtils.isEmpty(this.m_b)) {
                    this.m_b = context.getPackageName();
                }
                if (TextUtils.isEmpty(this.m_c)) {
                    this.m_c = com.heytap.openid.sdk.m_a.m_a(context, this.m_b, "SHA1");
                }
                this.m_f.removeMessages(2);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    String str2 = (String) it2.next();
                    synchronized (this.m_d) {
                        m_h.m_a(str2 + " 2023");
                        Message obtainMessage = this.m_f.obtainMessage();
                        if (str2.equals("RESET_OUID")) {
                            obtainMessage.what = 3;
                        } else {
                            obtainMessage.what = 1;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("IdType", str2);
                        obtainMessage.setData(bundle);
                        this.m_f.sendMessage(obtainMessage);
                        long uptimeMillis = SystemClock.uptimeMillis();
                        int i = str2.equals("DUID") ? 5000 : 2000;
                        try {
                            this.m_d.wait(i);
                        } catch (InterruptedException unused2) {
                            Log.e("IDHelper", "1022");
                        }
                        if (SystemClock.uptimeMillis() - uptimeMillis > i) {
                            Log.e("IDHelper", SmartLaunchStats.UBC_START_LAUNCH_ID);
                        }
                        m_h.m_a(str2 + " 2024");
                    }
                }
                Message obtainMessage2 = this.m_f.obtainMessage();
                obtainMessage2.what = 2;
                this.m_f.sendMessageDelayed(obtainMessage2, 300000L);
            }
        }
    }

    public native boolean m_a(String str);

    public final native void m_b();

    public native boolean m_b(String str);

    public native String m_c(String str);
}
