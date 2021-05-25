package d.a.n0.z.f0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f63495g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f63496e = R.color.CAM_X0204;

    /* renamed from: f  reason: collision with root package name */
    public int f63497f = UtilHelper.getDimenPixelSize(R.dimen.tbds16);

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f63495g;
    }
}
