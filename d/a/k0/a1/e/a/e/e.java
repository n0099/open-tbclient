package d.a.k0.a1.e.a.e;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import d.a.j0.r.q.a2;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class e implements n {

    /* renamed from: e  reason: collision with root package name */
    public int f51414e;

    /* renamed from: f  reason: collision with root package name */
    public String f51415f;

    /* renamed from: g  reason: collision with root package name */
    public int f51416g;

    /* renamed from: h  reason: collision with root package name */
    public String f51417h;

    /* renamed from: i  reason: collision with root package name */
    public int f51418i;
    public a2 j;

    public e(@NonNull ThreadInfo threadInfo, int i2) {
        this.f51414e = i2 + 1;
        this.f51415f = threadInfo.title;
        this.f51416g = threadInfo.hot_num.intValue();
        if (!ListUtils.isEmpty(threadInfo.media)) {
            this.f51417h = threadInfo.media.get(0).src_pic;
            this.f51418i = threadInfo.media.get(0).during_time.intValue();
        }
        a2 a2Var = new a2();
        this.j = a2Var;
        a2Var.Y1 = true;
        a2Var.T2(threadInfo);
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return a.f51405b;
    }
}
