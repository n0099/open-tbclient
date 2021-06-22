package d.a.o0.b3.g;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
import d.a.n0.r.d;
/* loaded from: classes5.dex */
public class a extends d {

    /* renamed from: c  reason: collision with root package name */
    public static final String f55943c = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public long g() {
        NetWork netWork = this.f53450a;
        if (netWork != null) {
            return netWork.getNetContext().getStat().stat.f42379c;
        }
        return 0L;
    }

    public long h() {
        NetWork netWork = this.f53450a;
        if (netWork != null) {
            return netWork.getNetContext().getStat().stat.f42380d;
        }
        return 0L;
    }

    public String i() {
        f(f55943c);
        return d();
    }
}
