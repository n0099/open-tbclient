package com.repackage;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class kj5 extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<AdDownloadData> a;
    public WeakReference<nj5> b;
    public int c;
    public int d;
    public long e;

    public kj5(nj5 nj5Var, AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nj5Var, adDownloadData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new WeakReference<>(adDownloadData);
        this.b = new WeakReference<>(nj5Var);
        this.d = rg5.h().b();
        this.c = rg5.h().c();
        this.e = rg5.h().a();
        d(adDownloadData.getContentLength());
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c();
            Message message = new Message();
            message.what = 1;
            sendMessageDelayed(message, 1000L);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            sendMessageDelayed(obtain, (this.c * 1000) / this.d);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            removeMessages(1);
        }
    }

    public void d(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048579, this, j) == null) || j <= 1) {
            return;
        }
        long j2 = this.e;
        if (j2 > 0) {
            this.c = (int) (((((float) j) * this.d) / 100.0f) / ((float) j2));
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, message) == null) {
            super.handleMessage(message);
            if (message.what != 1) {
                c();
                if (vm4.e()) {
                    Log.d("AdFakeProgressHandler", "fake stop is not WHAT_UPDATE_PROGRESS");
                    return;
                }
                return;
            }
            AdDownloadData adDownloadData = this.a.get();
            nj5 nj5Var = this.b.get();
            if (adDownloadData != null && nj5Var != null) {
                if (this.d <= 0) {
                    adDownloadData.setFakePercent(0);
                    c();
                    if (vm4.e()) {
                        Log.d("AdFakeProgressHandler", "fake stop ：开关关闭");
                        return;
                    }
                    return;
                } else if (!mi.z()) {
                    c();
                    if (vm4.e()) {
                        Log.d("AdFakeProgressHandler", "fake stop ：检测无网络");
                        return;
                    }
                    return;
                } else if (adDownloadData.getCurrentState() != DownloadStatus.STATUS_DOWNLOADING) {
                    c();
                    if (vm4.e()) {
                        Log.d("AdFakeProgressHandler", "fake stop ：非正在下载状态:" + adDownloadData.getCurrentState());
                        return;
                    }
                    return;
                } else {
                    int fakePercent = adDownloadData.getFakePercent();
                    if (fakePercent >= this.d) {
                        c();
                        if (vm4.e()) {
                            Log.d("AdFakeProgressHandler", "fake stop ：假进度达到最大值.");
                            return;
                        }
                        return;
                    }
                    int i = fakePercent + 1;
                    adDownloadData.setFakePercent(i);
                    if (i < adDownloadData.getPercent()) {
                        if (vm4.e()) {
                            Log.d("AdFakeProgressHandler", "fake log ：真实进度超过假进度.");
                        }
                    } else {
                        nj5Var.j(i);
                    }
                    b();
                    return;
                }
            }
            c();
            if (vm4.e()) {
                StringBuilder sb = new StringBuilder();
                sb.append("fake stop ：回收");
                sb.append(adDownloadData == null);
                sb.append(" ");
                sb.append(nj5Var == null);
                sb.append(" ");
                sb.append(nj5Var == null);
                Log.d("AdFakeProgressHandler", sb.toString());
            }
        }
    }
}
