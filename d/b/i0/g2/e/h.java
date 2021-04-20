package d.b.i0.g2.e;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes3.dex */
public class h extends BaseCardInfo {
    public static BdUniqueId p = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f56253e;

    /* renamed from: f  reason: collision with root package name */
    public int f56254f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56255g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56256h;
    public String i;
    public boolean j = false;
    public String k;
    public UserData l;
    public j m;
    public Bundle n;
    public int o;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return p;
    }
}
