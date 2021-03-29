package d.b.i0.z2.g;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
import d.b.h0.r.d;
/* loaded from: classes5.dex */
public class a extends d {

    /* renamed from: c  reason: collision with root package name */
    public static final String f63490c = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public long g() {
        NetWork netWork = this.f50445a;
        if (netWork != null) {
            return netWork.getNetContext().getStat().stat.f41780c;
        }
        return 0L;
    }

    public long h() {
        NetWork netWork = this.f50445a;
        if (netWork != null) {
            return netWork.getNetContext().getStat().stat.f41781d;
        }
        return 0L;
    }

    public String i() {
        f(f63490c);
        return d();
    }
}
