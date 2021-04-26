package d.a.j0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes4.dex */
public class g extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f51870f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public ScoreCardInfo f51871e;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f51870f;
    }

    public ScoreCardInfo h() {
        return this.f51871e;
    }

    public void l(ScoreCardInfo scoreCardInfo) {
        this.f51871e = scoreCardInfo;
    }
}
