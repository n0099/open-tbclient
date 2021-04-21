package d.b.j0.d2.h;

import androidx.annotation.DrawableRes;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes3.dex */
public class l extends PostData {
    public static final BdUniqueId D0 = BdUniqueId.gen();
    public int A0;
    public int B0;
    public int C0 = 0;
    @DrawableRes
    public int x0;
    public String y0;
    public int z0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, d.b.c.j.e.n
    public BdUniqueId getType() {
        return D0;
    }
}
