package d.b.i0.c2.h;

import androidx.annotation.DrawableRes;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class l extends PostData {
    public static final BdUniqueId C0 = BdUniqueId.gen();
    public int A0;
    public int B0 = 0;
    @DrawableRes
    public int w0;
    public String x0;
    public int y0;
    public int z0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, d.b.b.j.e.n
    public BdUniqueId getType() {
        return C0;
    }
}
