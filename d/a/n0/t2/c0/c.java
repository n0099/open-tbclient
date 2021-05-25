package d.a.n0.t2.c0;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.INetWorkCore;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import com.baidu.tbadk.core.util.httpNet.NetWorkUtil;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public INetWorkCore f60932a = null;

    /* renamed from: b  reason: collision with root package name */
    public HttpNetContext f60933b = null;

    public c() {
        d();
    }

    public boolean a(String str, Handler handler, int i2, int i3, int i4) {
        return b(str, handler, i2, i3, i4, false);
    }

    public boolean b(String str, Handler handler, int i2, int i3, int i4, boolean z) {
        c().getRequest().addBdussData(this.f60932a);
        return this.f60932a.downloadFile(str, handler, i2, i3, i4, z);
    }

    public HttpNetContext c() {
        return this.f60933b;
    }

    public final void d() {
        this.f60933b = new HttpNetContext();
        this.f60932a = new d(this.f60933b);
        this.f60933b.getRequest().getNetWorkParam().mNetType = NetWorkUtil.getNetType();
        d.a.c.e.j.b.a.o(TbadkCoreApplication.getInst().getCuid());
        d.a.c.e.j.b.a.p(TbadkCoreApplication.getInst().getCuidGalaxy2());
        d.a.c.e.j.b.a.r(TbadkCoreApplication.getInst().getCuidGid());
    }

    public void e() {
        INetWorkCore iNetWorkCore = this.f60932a;
        if (iNetWorkCore != null) {
            iNetWorkCore.setCancel();
        }
    }

    public void f(String str) {
        this.f60933b.getRequest().getNetWorkParam().mUrl = str;
    }
}
