package d.a.n0.e3;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.a.m0.r.q.n0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class v {
    public static boolean a() {
        d.a.m0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return !(adAdSense == null || adAdSense.d()) ? d.a.c.e.p.j.H() : (d.a.c.e.p.j.x() && TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) || (d.a.c.e.p.j.H() && TbadkCoreApplication.getInst().getVideoAutoPlay() != 1);
    }

    public static boolean b() {
        d.a.m0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return !(adAdSense != null && adAdSense.i()) ? d.a.c.e.p.j.H() : (d.a.c.e.p.j.x() && TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) || (d.a.c.e.p.j.H() && TbadkCoreApplication.getInst().getVideoAutoPlay() != 1);
    }

    public static int c(TbPageContext tbPageContext, String str) {
        if (tbPageContext == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        if (!str.startsWith("tieba://deeplink?")) {
            return d(tbPageContext, str) ? 3 : 0;
        }
        Uri parse = Uri.parse(str);
        if (d.a.n0.t2.y.s(tbPageContext.getPageActivity(), Uri.parse(parse.getQueryParameter(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT))) != 1000) {
            return d(tbPageContext, parse.getQueryParameter("wap")) ? 2 : 0;
        }
        return 1;
    }

    public static boolean d(TbPageContext tbPageContext, String str) {
        String[] strArr = {str};
        if (UrlManager.getInstance().UrlValidated(str)) {
            UrlManager.getInstance().dealOneLink((TbPageContext<?>) tbPageContext, strArr, true);
            return true;
        }
        return UrlManager.getInstance().dealOneLink(tbPageContext, strArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0077 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(List<Object> list, int i2) {
        int i3;
        boolean z;
        if (list == null || list.size() == 0) {
            return;
        }
        boolean z2 = MessageManager.getInstance().findTask(2016447) != null;
        int i4 = 0;
        while (i4 < list.size()) {
            if (list.get(i4) instanceof ICardInfo) {
                if (z2) {
                    ICardInfo iCardInfo = (ICardInfo) list.get(i4);
                    int viewCount = iCardInfo.getViewCount();
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < viewCount; i5++) {
                        ICardInfo viewItem = iCardInfo.getViewItem(i5, i2);
                        if (viewItem != null) {
                            viewItem.setBdUniqueId(d.a.n0.k1.o.e.f60328b.get(viewItem.getCardType()));
                            arrayList.add(viewItem);
                        }
                    }
                    if (arrayList.size() != 0) {
                        list.remove(i4);
                        list.addAll(i4, arrayList);
                        i3 = arrayList.size();
                        z = false;
                        if (!z) {
                            list.remove(i4);
                            i3 = 0;
                        }
                    }
                }
                i3 = 1;
                z = true;
                if (!z) {
                }
            } else {
                i3 = 1;
            }
            i4 += i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f(List<d.a.c.k.e.n> list, int i2) {
        int i3;
        boolean z;
        if (list == null || list.size() == 0) {
            return;
        }
        boolean z2 = MessageManager.getInstance().findTask(2016447) != null;
        int i4 = 0;
        while (i4 < list.size()) {
            if (list.get(i4) instanceof n0) {
                if (z2) {
                    if (!((n0) list.get(i4)).isValid()) {
                        ((n0) list.get(i4)).g();
                    }
                    if (((n0) list.get(i4)).isValid()) {
                        ICardInfo c2 = ((n0) list.get(i4)).c();
                        int viewCount = c2.getViewCount();
                        ArrayList arrayList = new ArrayList();
                        for (int i5 = 0; i5 < viewCount; i5++) {
                            ICardInfo viewItem = c2.getViewItem(i5, i2);
                            if (viewItem != null) {
                                viewItem.setBdUniqueId(d.a.n0.k1.o.e.f60328b.get(viewItem.getCardType()));
                                arrayList.add(viewItem);
                            }
                        }
                        if (arrayList.size() != 0) {
                            list.remove(i4);
                            list.addAll(i4, arrayList);
                            i3 = arrayList.size();
                            z = false;
                            if (!z) {
                                list.remove(i4);
                                i3 = 0;
                            }
                        }
                    }
                }
                i3 = 1;
                z = true;
                if (!z) {
                }
            } else {
                i3 = 1;
            }
            i4 += i3;
        }
    }

    public static ArrayList<BdUniqueId> g() {
        int size = d.a.n0.k1.o.e.f60328b.size();
        ArrayList<BdUniqueId> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(d.a.n0.k1.o.e.f60328b.valueAt(i2));
        }
        return arrayList;
    }
}
