package d.b.i0.r2.x;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.INetWorkCore;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import com.baidu.tbadk.core.util.httpNet.NetWorkUtil;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public INetWorkCore f59897a = null;

    /* renamed from: b  reason: collision with root package name */
    public HttpNetContext f59898b = null;

    public c() {
        d();
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return b(str, handler, i, i2, i3, false);
    }

    public boolean b(String str, Handler handler, int i, int i2, int i3, boolean z) {
        c().getRequest().addBdussData(this.f59897a);
        return this.f59897a.downloadFile(str, handler, i, i2, i3, z);
    }

    public HttpNetContext c() {
        return this.f59898b;
    }

    public final void d() {
        this.f59898b = new HttpNetContext();
        this.f59897a = new d(this.f59898b);
        this.f59898b.getRequest().getNetWorkParam().mNetType = NetWorkUtil.getNetType();
        d.b.b.e.j.b.a.o(TbadkCoreApplication.getInst().getCuid());
        d.b.b.e.j.b.a.p(TbadkCoreApplication.getInst().getCuidGalaxy2());
        d.b.b.e.j.b.a.r(TbadkCoreApplication.getInst().getCuidGid());
    }

    public void e() {
        INetWorkCore iNetWorkCore = this.f59897a;
        if (iNetWorkCore != null) {
            iNetWorkCore.setCancel();
        }
    }

    public void f(String str) {
        this.f59898b.getRequest().getNetWorkParam().mUrl = str;
    }
}
