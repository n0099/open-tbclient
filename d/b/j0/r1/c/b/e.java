package d.b.j0.r1.c.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialItem;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes3.dex */
public class e implements d.b.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f61417g = BdUniqueId.gen();

    /* renamed from: h  reason: collision with root package name */
    public static int f61418h = 3;
    public static boolean i = false;
    public static String j;

    /* renamed from: e  reason: collision with root package name */
    public d f61419e;

    /* renamed from: f  reason: collision with root package name */
    public List<f> f61420f;

    public e(VipSpecialList vipSpecialList) {
        List<VipSpecialItem> list;
        if (vipSpecialList == null || (list = vipSpecialList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipSpecialList.card_id;
        d dVar = new d();
        this.f61419e = dVar;
        dVar.e(4);
        this.f61419e.d(vipSpecialList.class_name);
        this.f61419e.f(vipSpecialList.class_url_name);
        this.f61419e.g(vipSpecialList.class_url);
        String currentAccount = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAccount() : SevenZipUtils.FILE_NAME_TEMP;
        if (StringUtils.isNull(j) || !j.equals(currentAccount)) {
            i = false;
            j = currentAccount;
        }
        this.f61420f = new ArrayList();
        for (int i2 = 0; i2 < vipSpecialList.item.size(); i2++) {
            this.f61420f.add(new f(vipSpecialList.item.get(i2)));
            if (i) {
                if (i2 == vipSpecialList.item.size() - 1 && vipSpecialList.item.size() > f61418h) {
                    this.f61420f.add(new f(true, true));
                }
            } else if (i2 == f61418h - 1 && vipSpecialList.item.size() > f61418h) {
                this.f61420f.add(new f(true, false));
                return;
            }
        }
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f61417g;
    }
}
