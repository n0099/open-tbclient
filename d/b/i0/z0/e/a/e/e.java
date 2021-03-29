package d.b.i0.z0.e.a.e;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class e implements n {

    /* renamed from: e  reason: collision with root package name */
    public int f62974e;

    /* renamed from: f  reason: collision with root package name */
    public String f62975f;

    /* renamed from: g  reason: collision with root package name */
    public int f62976g;

    /* renamed from: h  reason: collision with root package name */
    public String f62977h;
    public int i;
    public a2 j;

    public e(@NonNull ThreadInfo threadInfo, int i) {
        this.f62974e = i + 1;
        this.f62975f = threadInfo.title;
        this.f62976g = threadInfo.hot_num.intValue();
        if (!ListUtils.isEmpty(threadInfo.media)) {
            this.f62977h = threadInfo.media.get(0).src_pic;
            this.i = threadInfo.media.get(0).during_time.intValue();
        }
        a2 a2Var = new a2();
        this.j = a2Var;
        a2Var.Y1 = true;
        a2Var.Q2(threadInfo);
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return a.f62965b;
    }
}
