package d.b.j0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes4.dex */
public class g extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f54096f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public ScoreCardInfo f54097e;

    public ScoreCardInfo g() {
        return this.f54097e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f54096f;
    }

    public void j(ScoreCardInfo scoreCardInfo) {
        this.f54097e = scoreCardInfo;
    }
}
