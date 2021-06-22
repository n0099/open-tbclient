package d.a.o0.b1.f.a.e;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.k.e.n;
import d.a.n0.r.q.a2;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class e implements n {

    /* renamed from: e  reason: collision with root package name */
    public int f55387e;

    /* renamed from: f  reason: collision with root package name */
    public String f55388f;

    /* renamed from: g  reason: collision with root package name */
    public int f55389g;

    /* renamed from: h  reason: collision with root package name */
    public String f55390h;

    /* renamed from: i  reason: collision with root package name */
    public int f55391i;
    public a2 j;

    public e(@NonNull ThreadInfo threadInfo, int i2) {
        this.f55387e = i2 + 1;
        this.f55388f = threadInfo.title;
        this.f55389g = threadInfo.hot_num.intValue();
        if (!ListUtils.isEmpty(threadInfo.media)) {
            this.f55390h = threadInfo.media.get(0).src_pic;
            this.f55391i = threadInfo.media.get(0).during_time.intValue();
        }
        a2 a2Var = new a2();
        this.j = a2Var;
        a2Var.b2 = true;
        a2Var.V2(threadInfo);
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return a.f55378b;
    }
}
