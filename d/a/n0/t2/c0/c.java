package d.a.n0.t2.c0;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.INetWorkCore;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import com.baidu.tbadk.core.util.httpNet.NetWorkUtil;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public INetWorkCore f64624a = null;

    /* renamed from: b  reason: collision with root package name */
    public HttpNetContext f64625b = null;

    public c() {
        d();
    }

    public boolean a(String str, Handler handler, int i2, int i3, int i4) {
        return b(str, handler, i2, i3, i4, false);
    }

    public boolean b(String str, Handler handler, int i2, int i3, int i4, boolean z) {
        c().getRequest().addBdussData(this.f64624a);
        return this.f64624a.downloadFile(str, handler, i2, i3, i4, z);
    }

    public HttpNetContext c() {
        return this.f64625b;
    }

    public final void d() {
        this.f64625b = new HttpNetContext();
        this.f64624a = new d(this.f64625b);
        this.f64625b.getRequest().getNetWorkParam().mNetType = NetWorkUtil.getNetType();
        d.a.c.e.j.b.a.o(TbadkCoreApplication.getInst().getCuid());
        d.a.c.e.j.b.a.p(TbadkCoreApplication.getInst().getCuidGalaxy2());
        d.a.c.e.j.b.a.r(TbadkCoreApplication.getInst().getCuidGid());
    }

    public void e() {
        INetWorkCore iNetWorkCore = this.f64624a;
        if (iNetWorkCore != null) {
            iNetWorkCore.setCancel();
        }
    }

    public void f(String str) {
        this.f64625b.getRequest().getNetWorkParam().mUrl = str;
    }
}
