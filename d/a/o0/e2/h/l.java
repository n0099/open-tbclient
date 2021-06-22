package d.a.o0.e2.h;

import androidx.annotation.DrawableRes;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes5.dex */
public class l extends PostData {
    public static final BdUniqueId I0 = BdUniqueId.gen();
    @DrawableRes
    public int C0;
    public String D0;
    public int E0;
    public int F0;
    public int G0;
    public int H0 = 0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, d.a.c.k.e.n
    public BdUniqueId getType() {
        return I0;
    }
}
