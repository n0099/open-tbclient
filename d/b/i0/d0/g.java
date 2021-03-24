package d.b.i0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes4.dex */
public class g extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f53635f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public ScoreCardInfo f53636e;

    public ScoreCardInfo g() {
        return this.f53636e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return f53635f;
    }

    public void j(ScoreCardInfo scoreCardInfo) {
        this.f53636e = scoreCardInfo;
    }
}
