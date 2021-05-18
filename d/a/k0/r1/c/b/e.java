package d.a.k0.r1.c.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialItem;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes3.dex */
public class e implements d.a.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f60306g = BdUniqueId.gen();

    /* renamed from: h  reason: collision with root package name */
    public static int f60307h = 3;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f60308i = false;
    public static String j;

    /* renamed from: e  reason: collision with root package name */
    public d f60309e;

    /* renamed from: f  reason: collision with root package name */
    public List<f> f60310f;

    public e(VipSpecialList vipSpecialList) {
        List<VipSpecialItem> list;
        if (vipSpecialList == null || (list = vipSpecialList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipSpecialList.card_id;
        d dVar = new d();
        this.f60309e = dVar;
        dVar.e(4);
        this.f60309e.d(vipSpecialList.class_name);
        this.f60309e.f(vipSpecialList.class_url_name);
        this.f60309e.g(vipSpecialList.class_url);
        String currentAccount = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAccount() : SevenZipUtils.FILE_NAME_TEMP;
        if (StringUtils.isNull(j) || !j.equals(currentAccount)) {
            f60308i = false;
            j = currentAccount;
        }
        this.f60310f = new ArrayList();
        for (int i2 = 0; i2 < vipSpecialList.item.size(); i2++) {
            this.f60310f.add(new f(vipSpecialList.item.get(i2)));
            if (f60308i) {
                if (i2 == vipSpecialList.item.size() - 1 && vipSpecialList.item.size() > f60307h) {
                    this.f60310f.add(new f(true, true));
                }
            } else if (i2 == f60307h - 1 && vipSpecialList.item.size() > f60307h) {
                this.f60310f.add(new f(true, false));
                return;
            }
        }
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f60306g;
    }
}
