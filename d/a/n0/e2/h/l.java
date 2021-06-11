package d.a.n0.e2.h;

import androidx.annotation.DrawableRes;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes5.dex */
public class l extends PostData {
    public static final BdUniqueId D0 = BdUniqueId.gen();
    public int A0;
    public int B0;
    public int C0 = 0;
    @DrawableRes
    public int x0;
    public String y0;
    public int z0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, d.a.c.k.e.n
    public BdUniqueId getType() {
        return D0;
    }
}
