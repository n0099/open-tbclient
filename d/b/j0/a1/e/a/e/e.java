package d.b.j0.a1.e.a.e;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.c.j.e.n;
import d.b.i0.r.q.a2;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class e implements n {

    /* renamed from: e  reason: collision with root package name */
    public int f53014e;

    /* renamed from: f  reason: collision with root package name */
    public String f53015f;

    /* renamed from: g  reason: collision with root package name */
    public int f53016g;

    /* renamed from: h  reason: collision with root package name */
    public String f53017h;
    public int i;
    public a2 j;

    public e(@NonNull ThreadInfo threadInfo, int i) {
        this.f53014e = i + 1;
        this.f53015f = threadInfo.title;
        this.f53016g = threadInfo.hot_num.intValue();
        if (!ListUtils.isEmpty(threadInfo.media)) {
            this.f53017h = threadInfo.media.get(0).src_pic;
            this.i = threadInfo.media.get(0).during_time.intValue();
        }
        a2 a2Var = new a2();
        this.j = a2Var;
        a2Var.Y1 = true;
        a2Var.R2(threadInfo);
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return a.f53005b;
    }
}
