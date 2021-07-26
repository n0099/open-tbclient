package d.a.q0.q.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class d extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<AdDownloadData> f62059a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<d.a.q0.q.d.g.a> f62060b;

    /* renamed from: c  reason: collision with root package name */
    public int f62061c;

    /* renamed from: d  reason: collision with root package name */
    public int f62062d;

    /* renamed from: e  reason: collision with root package name */
    public long f62063e;

    public d(d.a.q0.q.d.g.a aVar, AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, adDownloadData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62059a = new WeakReference<>(adDownloadData);
        this.f62060b = new WeakReference<>(aVar);
        this.f62062d = d.a.q0.a.h().b();
        this.f62061c = d.a.q0.a.h().c();
        this.f62063e = d.a.q0.a.h().a();
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
            sendMessageDelayed(obtain, (this.f62061c * 1000) / this.f62062d);
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
        long j2 = this.f62063e;
        if (j2 > 0) {
            this.f62061c = (int) (((((float) j) * this.f62062d) / 100.0f) / ((float) j2));
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, message) == null) {
            super.handleMessage(message);
            if (message.what != 1) {
                c();
                return;
            }
            AdDownloadData adDownloadData = this.f62059a.get();
            d.a.q0.q.d.g.a aVar = this.f62060b.get();
            if (adDownloadData != null && aVar != null) {
                if (this.f62062d <= 0) {
                    adDownloadData.setFakePercent(0);
                    c();
                    return;
                } else if (!j.z()) {
                    c();
                    return;
                } else if (adDownloadData.getCurrentState() != DownloadStatus.STATUS_DOWNLOADING) {
                    c();
                    return;
                } else {
                    int fakePercent = adDownloadData.getFakePercent();
                    if (fakePercent >= this.f62062d) {
                        c();
                        return;
                    }
                    int i2 = fakePercent + 1;
                    adDownloadData.setFakePercent(i2);
                    if (i2 >= adDownloadData.getPercent()) {
                        aVar.f(i2);
                    }
                    b();
                    return;
                }
            }
            c();
        }
    }
}
