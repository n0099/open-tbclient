package d.a.k0.a3.g;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
import d.a.j0.r.d;
/* loaded from: classes5.dex */
public class a extends d {

    /* renamed from: c  reason: collision with root package name */
    public static final String f51962c = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public long g() {
        NetWork netWork = this.f49624a;
        if (netWork != null) {
            return netWork.getNetContext().getStat().stat.f38959c;
        }
        return 0L;
    }

    public long h() {
        NetWork netWork = this.f49624a;
        if (netWork != null) {
            return netWork.getNetContext().getStat().stat.f38960d;
        }
        return 0L;
    }

    public String i() {
        f(f51962c);
        return d();
    }
}
