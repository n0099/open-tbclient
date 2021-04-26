package d.b.a;

import android.content.Context;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.supplier.IIdentifierListener;
import d.b.b.f1;
import d.b.b.g1;
import d.b.b.y0;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public String f64228b;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f64227a = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f64229c = false;

    /* renamed from: d  reason: collision with root package name */
    public final Object f64230d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public IIdentifierListener f64231e = new C1755a(this);

    /* renamed from: d.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1755a implements IIdentifierListener {
        public C1755a(a aVar) {
        }
    }

    public final int a(Context context) {
        return MdidSdkHelper.InitSdk(context, true, this.f64231e);
    }

    public g1.a b(Context context) {
        synchronized (this.f64230d) {
            if (this.f64229c) {
                this.f64230d.wait(10000L);
            }
        }
        g1.a aVar = new g1.a();
        aVar.f64294a = this.f64228b;
        return aVar;
    }

    public void c(Context context) {
        synchronized (this.f64230d) {
            this.f64229c = true;
            int a2 = a(context);
            if (a2 == 1008612) {
                y0.e(f1.j, "OaidMiit#getDeviceIds 不支持的设备");
            } else if (a2 == 1008613) {
                y0.e(f1.j, "OaidMiit#getDeviceIds 加载配置文件出错");
            } else if (a2 == 1008611) {
                y0.e(f1.j, "OaidMiit#getDeviceIds 不支持的设备厂商");
            } else if (a2 == 1008614) {
                y0.e(f1.j, "OaidMiit#getDeviceIds 获取接口是异步的，结果会在回调中返回，回调执行的回调可能在工作线程");
                if (this.f64227a.compareAndSet(false, true)) {
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
