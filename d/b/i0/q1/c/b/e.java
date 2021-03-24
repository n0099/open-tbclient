package d.b.i0.q1.c.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialItem;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes3.dex */
public class e implements d.b.b.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f59301g = BdUniqueId.gen();

    /* renamed from: h  reason: collision with root package name */
    public static int f59302h = 3;
    public static boolean i = false;
    public static String j;

    /* renamed from: e  reason: collision with root package name */
    public d f59303e;

    /* renamed from: f  reason: collision with root package name */
    public List<f> f59304f;

    public e(VipSpecialList vipSpecialList) {
        List<VipSpecialItem> list;
        if (vipSpecialList == null || (list = vipSpecialList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipSpecialList.card_id;
        d dVar = new d();
        this.f59303e = dVar;
        dVar.e(4);
        this.f59303e.d(vipSpecialList.class_name);
        this.f59303e.f(vipSpecialList.class_url_name);
        this.f59303e.g(vipSpecialList.class_url);
        String currentAccount = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAccount() : SevenZipUtils.FILE_NAME_TEMP;
        if (StringUtils.isNull(j) || !j.equals(currentAccount)) {
            i = false;
            j = currentAccount;
        }
        this.f59304f = new ArrayList();
        for (int i2 = 0; i2 < vipSpecialList.item.size(); i2++) {
            this.f59304f.add(new f(vipSpecialList.item.get(i2)));
            if (i) {
                if (i2 == vipSpecialList.item.size() - 1 && vipSpecialList.item.size() > f59302h) {
                    this.f59304f.add(new f(true, true));
                }
            } else if (i2 == f59302h - 1 && vipSpecialList.item.size() > f59302h) {
                this.f59304f.add(new f(true, false));
                return;
            }
        }
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f59301g;
    }
}
