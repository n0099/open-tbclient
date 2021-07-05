package d.a.s0.q.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class d extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<AdDownloadData> f64679a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<d.a.s0.q.d.g.a> f64680b;

    /* renamed from: c  reason: collision with root package name */
    public int f64681c;

    /* renamed from: d  reason: collision with root package name */
    public int f64682d;

    /* renamed from: e  reason: collision with root package name */
    public long f64683e;

    public d(d.a.s0.q.d.g.a aVar, AdDownloadData adDownloadData) {
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
        this.f64679a = new WeakReference<>(adDownloadData);
        this.f64680b = new WeakReference<>(aVar);
        this.f64682d = d.a.s0.a.h().b();
        this.f64681c = d.a.s0.a.h().c();
        this.f64683e = d.a.s0.a.h().a();
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
            sendMessageDelayed(obtain, (this.f64681c * 1000) / this.f64682d);
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
        long j2 = this.f64683e;
        if (j2 > 0) {
            this.f64681c = (int) (((((float) j) * this.f64682d) / 100.0f) / ((float) j2));
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
            AdDownloadData adDownloadData = this.f64679a.get();
            d.a.s0.q.d.g.a aVar = this.f64680b.get();
            if (adDownloadData != null && aVar != null) {
                if (this.f64682d <= 0) {
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
                    if (fakePercent >= this.f64682d) {
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
