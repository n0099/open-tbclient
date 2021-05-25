package d.a.n0.b1.e.a.e;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import d.a.m0.r.q.a2;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class e implements n {

    /* renamed from: e  reason: collision with root package name */
    public int f51579e;

    /* renamed from: f  reason: collision with root package name */
    public String f51580f;

    /* renamed from: g  reason: collision with root package name */
    public int f51581g;

    /* renamed from: h  reason: collision with root package name */
    public String f51582h;

    /* renamed from: i  reason: collision with root package name */
    public int f51583i;
    public a2 j;

    public e(@NonNull ThreadInfo threadInfo, int i2) {
        this.f51579e = i2 + 1;
        this.f51580f = threadInfo.title;
        this.f51581g = threadInfo.hot_num.intValue();
        if (!ListUtils.isEmpty(threadInfo.media)) {
            this.f51582h = threadInfo.media.get(0).src_pic;
            this.f51583i = threadInfo.media.get(0).during_time.intValue();
        }
        a2 a2Var = new a2();
        this.j = a2Var;
        a2Var.Z1 = true;
        a2Var.U2(threadInfo);
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return a.f51570b;
    }
}
