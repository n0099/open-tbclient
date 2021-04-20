package d.b.i0.a3.g;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
import d.b.h0.r.d;
/* loaded from: classes4.dex */
public class a extends d {

    /* renamed from: c  reason: collision with root package name */
    public static final String f53109c = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public long g() {
        NetWork netWork = this.f50852a;
        if (netWork != null) {
            return netWork.getNetContext().getStat().stat.f42277c;
        }
        return 0L;
    }

    public long h() {
        NetWork netWork = this.f50852a;
        if (netWork != null) {
            return netWork.getNetContext().getStat().stat.f42278d;
        }
        return 0L;
    }

    public String i() {
        f(f53109c);
        return d();
    }
}
