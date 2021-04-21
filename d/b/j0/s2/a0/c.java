package d.b.j0.s2.a0;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.INetWorkCore;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import com.baidu.tbadk.core.util.httpNet.NetWorkUtil;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public INetWorkCore f61919a = null;

    /* renamed from: b  reason: collision with root package name */
    public HttpNetContext f61920b = null;

    public c() {
        d();
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return b(str, handler, i, i2, i3, false);
    }

    public boolean b(String str, Handler handler, int i, int i2, int i3, boolean z) {
        c().getRequest().addBdussData(this.f61919a);
        return this.f61919a.downloadFile(str, handler, i, i2, i3, z);
    }

    public HttpNetContext c() {
        return this.f61920b;
    }

    public final void d() {
        this.f61920b = new HttpNetContext();
        this.f61919a = new d(this.f61920b);
        this.f61920b.getRequest().getNetWorkParam().mNetType = NetWorkUtil.getNetType();
        d.b.c.e.j.b.a.o(TbadkCoreApplication.getInst().getCuid());
        d.b.c.e.j.b.a.p(TbadkCoreApplication.getInst().getCuidGalaxy2());
        d.b.c.e.j.b.a.r(TbadkCoreApplication.getInst().getCuidGid());
    }

    public void e() {
        INetWorkCore iNetWorkCore = this.f61919a;
        if (iNetWorkCore != null) {
            iNetWorkCore.setCancel();
        }
    }

    public void f(String str) {
        this.f61920b.getRequest().getNetWorkParam().mUrl = str;
    }
}
