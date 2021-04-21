package d.b.j0.a3.g;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
import d.b.i0.r.d;
/* loaded from: classes4.dex */
public class a extends d {

    /* renamed from: c  reason: collision with root package name */
    public static final String f53530c = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public long g() {
        NetWork netWork = this.f51188a;
        if (netWork != null) {
            return netWork.getNetContext().getStat().stat.f42517c;
        }
        return 0L;
    }

    public long h() {
        NetWork netWork = this.f51188a;
        if (netWork != null) {
            return netWork.getNetContext().getStat().stat.f42518d;
        }
        return 0L;
    }

    public String i() {
        f(f53530c);
        return d();
    }
}
