package d.b.i0.f2.e;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes5.dex */
public class h extends BaseCardInfo {
    public static BdUniqueId p = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f54783e;

    /* renamed from: f  reason: collision with root package name */
    public int f54784f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54785g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f54786h;
    public String i;
    public boolean j = false;
    public String k;
    public UserData l;
    public j m;
    public Bundle n;
    public int o;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return p;
    }
}
