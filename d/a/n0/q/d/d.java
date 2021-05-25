package d.a.n0.q.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import d.a.c.e.p.j;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<AdDownloadData> f58201a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<d.a.n0.q.d.g.a> f58202b;

    /* renamed from: d  reason: collision with root package name */
    public int f58204d = d.a.n0.a.h().b();

    /* renamed from: c  reason: collision with root package name */
    public int f58203c = d.a.n0.a.h().c();

    /* renamed from: e  reason: collision with root package name */
    public long f58205e = d.a.n0.a.h().a();

    public d(d.a.n0.q.d.g.a aVar, AdDownloadData adDownloadData) {
        this.f58201a = new WeakReference<>(adDownloadData);
        this.f58202b = new WeakReference<>(aVar);
        d(adDownloadData.getContentLength());
    }

    public void a() {
        c();
        Message message = new Message();
        message.what = 1;
        sendMessageDelayed(message, 1000L);
    }

    public final void b() {
        Message obtain = Message.obtain();
        obtain.what = 1;
        sendMessageDelayed(obtain, (this.f58203c * 1000) / this.f58204d);
    }

    public void c() {
        removeMessages(1);
    }

    public void d(long j) {
        if (j > 1) {
            long j2 = this.f58205e;
            if (j2 > 0) {
                this.f58203c = (int) (((((float) j) * this.f58204d) / 100.0f) / ((float) j2));
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what != 1) {
            c();
            return;
        }
        AdDownloadData adDownloadData = this.f58201a.get();
        d.a.n0.q.d.g.a aVar = this.f58202b.get();
        if (adDownloadData != null && aVar != null) {
            if (this.f58204d <= 0) {
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
                if (fakePercent >= this.f58204d) {
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
