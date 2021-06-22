package d.a.o0.s1.c.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialItem;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes4.dex */
public class e implements d.a.c.k.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f64245g = BdUniqueId.gen();

    /* renamed from: h  reason: collision with root package name */
    public static int f64246h = 3;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f64247i = false;
    public static String j;

    /* renamed from: e  reason: collision with root package name */
    public d f64248e;

    /* renamed from: f  reason: collision with root package name */
    public List<f> f64249f;

    public e(VipSpecialList vipSpecialList) {
        List<VipSpecialItem> list;
        if (vipSpecialList == null || (list = vipSpecialList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipSpecialList.card_id;
        d dVar = new d();
        this.f64248e = dVar;
        dVar.e(4);
        this.f64248e.d(vipSpecialList.class_name);
        this.f64248e.f(vipSpecialList.class_url_name);
        this.f64248e.g(vipSpecialList.class_url);
        String currentAccount = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAccount() : SevenZipUtils.FILE_NAME_TEMP;
        if (StringUtils.isNull(j) || !j.equals(currentAccount)) {
            f64247i = false;
            j = currentAccount;
        }
        this.f64249f = new ArrayList();
        for (int i2 = 0; i2 < vipSpecialList.item.size(); i2++) {
            this.f64249f.add(new f(vipSpecialList.item.get(i2)));
            if (f64247i) {
                if (i2 == vipSpecialList.item.size() - 1 && vipSpecialList.item.size() > f64246h) {
                    this.f64249f.add(new f(true, true));
                }
            } else if (i2 == f64246h - 1 && vipSpecialList.item.size() > f64246h) {
                this.f64249f.add(new f(true, false));
                return;
            }
        }
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f64245g;
    }
}
