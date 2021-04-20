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
    public String f65778b;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f65777a = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f65779c = false;

    /* renamed from: d  reason: collision with root package name */
    public final Object f65780d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public IIdentifierListener f65781e = new C1812a(this);

    /* renamed from: d.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1812a implements IIdentifierListener {
        public C1812a(a aVar) {
        }
    }

    public final int a(Context context) {
        return MdidSdkHelper.InitSdk(context, true, this.f65781e);
    }

    public g1.a b(Context context) {
        synchronized (this.f65780d) {
            if (this.f65779c) {
                this.f65780d.wait(10000L);
            }
        }
        g1.a aVar = new g1.a();
        aVar.f65841a = this.f65778b;
        return aVar;
    }

    public void c(Context context) {
        synchronized (this.f65780d) {
            this.f65779c = true;
            int a2 = a(context);
            if (a2 == 1008612) {
                y0.e(f1.j, "OaidMiit#getDeviceIds 不支持的设备");
            } else if (a2 == 1008613) {
                y0.e(f1.j, "OaidMiit#getDeviceIds 加载配置文件出错");
            } else if (a2 == 1008611) {
                y0.e(f1.j, "OaidMiit#getDeviceIds 不支持的设备厂商");
            } else if (a2 == 1008614) {
                y0.e(f1.j, "OaidMiit#getDeviceIds 获取接口是异步的，结果会在回调中返回，回调执行的回调可能在工作线程");
                if (this.f65777a.compareAndSet(false, true)) {
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
