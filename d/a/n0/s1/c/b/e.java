package d.a.n0.s1.c.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialItem;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes3.dex */
public class e implements d.a.c.k.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f64120g = BdUniqueId.gen();

    /* renamed from: h  reason: collision with root package name */
    public static int f64121h = 3;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f64122i = false;
    public static String j;

    /* renamed from: e  reason: collision with root package name */
    public d f64123e;

    /* renamed from: f  reason: collision with root package name */
    public List<f> f64124f;

    public e(VipSpecialList vipSpecialList) {
        List<VipSpecialItem> list;
        if (vipSpecialList == null || (list = vipSpecialList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipSpecialList.card_id;
        d dVar = new d();
        this.f64123e = dVar;
        dVar.e(4);
        this.f64123e.d(vipSpecialList.class_name);
        this.f64123e.f(vipSpecialList.class_url_name);
        this.f64123e.g(vipSpecialList.class_url);
        String currentAccount = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAccount() : SevenZipUtils.FILE_NAME_TEMP;
        if (StringUtils.isNull(j) || !j.equals(currentAccount)) {
            f64122i = false;
            j = currentAccount;
        }
        this.f64124f = new ArrayList();
        for (int i2 = 0; i2 < vipSpecialList.item.size(); i2++) {
            this.f64124f.add(new f(vipSpecialList.item.get(i2)));
            if (f64122i) {
                if (i2 == vipSpecialList.item.size() - 1 && vipSpecialList.item.size() > f64121h) {
                    this.f64124f.add(new f(true, true));
                }
            } else if (i2 == f64121h - 1 && vipSpecialList.item.size() > f64121h) {
                this.f64124f.add(new f(true, false));
                return;
            }
        }
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f64120g;
    }
}
