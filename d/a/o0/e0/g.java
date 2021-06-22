package d.a.o0.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes4.dex */
public class g extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f56588f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public ScoreCardInfo f56589e;

    public ScoreCardInfo c() {
        return this.f56589e;
    }

    public void g(ScoreCardInfo scoreCardInfo) {
        this.f56589e = scoreCardInfo;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f56588f;
    }
}
