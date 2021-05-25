package d.a.n0.b3.g;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
import d.a.m0.r.d;
/* loaded from: classes5.dex */
public class a extends d {

    /* renamed from: c  reason: collision with root package name */
    public static final String f52129c = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public long g() {
        NetWork netWork = this.f49668a;
        if (netWork != null) {
            return netWork.getNetContext().getStat().stat.f38623c;
        }
        return 0L;
    }

    public long h() {
        NetWork netWork = this.f49668a;
        if (netWork != null) {
            return netWork.getNetContext().getStat().stat.f38624d;
        }
        return 0L;
    }

    public String i() {
        f(f52129c);
        return d();
    }
}
