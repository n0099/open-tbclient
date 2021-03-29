package d.c.a;

import android.content.Context;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.supplier.IIdentifierListener;
import d.c.b.f1;
import d.c.b.g1;
import d.c.b.y0;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public String f64933b;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f64932a = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f64934c = false;

    /* renamed from: d  reason: collision with root package name */
    public final Object f64935d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public IIdentifierListener f64936e = new C1784a(this);

    /* renamed from: d.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1784a implements IIdentifierListener {
        public C1784a(a aVar) {
        }
    }

    public final int a(Context context) {
        return MdidSdkHelper.InitSdk(context, true, this.f64936e);
    }

    public g1.a b(Context context) {
        synchronized (this.f64935d) {
            if (this.f64934c) {
                this.f64935d.wait(10000L);
            }
        }
        g1.a aVar = new g1.a();
        aVar.f64996a = this.f64933b;
        return aVar;
    }

    public void c(Context context) {
        synchronized (this.f64935d) {
            this.f64934c = true;
            int a2 = a(context);
            if (a2 == 1008612) {
                y0.e(f1.j, "OaidMiit#getDeviceIds 不支持的设备");
            } else if (a2 == 1008613) {
                y0.e(f1.j, "OaidMiit#getDeviceIds 加载配置文件出错");
            } else if (a2 == 1008611) {
                y0.e(f1.j, "OaidMiit#getDeviceIds 不支持的设备厂商");
            } else if (a2 == 1008614) {
                y0.e(f1.j, "OaidMiit#getDeviceIds 获取接口是异步的，结果会在回调中返回，回调执行的回调可能在工作线程");
                if (this.f64932a.compareAndSet(false, true)) {
                    c(context);
                }
            } else if (a2 == 1008615) {
                y0.e(f1.j, "OaidMiit#getDeviceIds 反射调用出错");
            } else if (a2 == 0) {
                y0.e(f1.j, "OaidMiit#getDeviceIds 正确");
            } else {
                String str = "未知 resultCode=" + a2;
                y0.e(f1.j, "OaidMiit#getDeviceIds 未知 resultCode=" + a2);
            }
        }
    }
}
