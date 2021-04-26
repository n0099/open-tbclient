package d.a.j0.a1.e.a.e;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import d.a.i0.r.q.a2;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class e implements n {

    /* renamed from: e  reason: collision with root package name */
    public int f50717e;

    /* renamed from: f  reason: collision with root package name */
    public String f50718f;

    /* renamed from: g  reason: collision with root package name */
    public int f50719g;

    /* renamed from: h  reason: collision with root package name */
    public String f50720h;

    /* renamed from: i  reason: collision with root package name */
    public int f50721i;
    public a2 j;

    public e(@NonNull ThreadInfo threadInfo, int i2) {
        this.f50717e = i2 + 1;
        this.f50718f = threadInfo.title;
        this.f50719g = threadInfo.hot_num.intValue();
        if (!ListUtils.isEmpty(threadInfo.media)) {
            this.f50720h = threadInfo.media.get(0).src_pic;
            this.f50721i = threadInfo.media.get(0).during_time.intValue();
        }
        a2 a2Var = new a2();
        this.j = a2Var;
        a2Var.Y1 = true;
        a2Var.R2(threadInfo);
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return a.f50708b;
    }
}
