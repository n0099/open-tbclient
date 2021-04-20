package d.b.i0.a1.e.a.e;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.c.j.e.n;
import d.b.h0.r.q.a2;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class e implements n {

    /* renamed from: e  reason: collision with root package name */
    public int f52593e;

    /* renamed from: f  reason: collision with root package name */
    public String f52594f;

    /* renamed from: g  reason: collision with root package name */
    public int f52595g;

    /* renamed from: h  reason: collision with root package name */
    public String f52596h;
    public int i;
    public a2 j;

    public e(@NonNull ThreadInfo threadInfo, int i) {
        this.f52593e = i + 1;
        this.f52594f = threadInfo.title;
        this.f52595g = threadInfo.hot_num.intValue();
        if (!ListUtils.isEmpty(threadInfo.media)) {
            this.f52596h = threadInfo.media.get(0).src_pic;
            this.i = threadInfo.media.get(0).during_time.intValue();
        }
        a2 a2Var = new a2();
        this.j = a2Var;
        a2Var.Y1 = true;
        a2Var.R2(threadInfo);
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return a.f52584b;
    }
}
