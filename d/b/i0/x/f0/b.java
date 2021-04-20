package d.b.i0.x.f0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f63804g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f63805e = R.color.CAM_X0204;

    /* renamed from: f  reason: collision with root package name */
    public int f63806f = UtilHelper.getDimenPixelSize(R.dimen.tbds16);

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f63804g;
    }
}
