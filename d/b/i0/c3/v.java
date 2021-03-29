package d.b.i0.c3;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.b.h0.r.q.n0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class v {
    public static boolean a() {
        d.b.h0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return !(adAdSense == null || adAdSense.d()) ? d.b.b.e.p.j.H() : (d.b.b.e.p.j.x() && TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) || (d.b.b.e.p.j.H() && TbadkCoreApplication.getInst().getVideoAutoPlay() != 1);
    }

    public static boolean b() {
        d.b.h0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return !(adAdSense != null && adAdSense.i()) ? d.b.b.e.p.j.H() : (d.b.b.e.p.j.x() && TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) || (d.b.b.e.p.j.H() && TbadkCoreApplication.getInst().getVideoAutoPlay() != 1);
    }

    public static int c(TbPageContext tbPageContext, String str) {
        if (tbPageContext == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        if (!str.startsWith("tieba://deeplink?")) {
            return d(tbPageContext, str) ? 3 : 0;
        }
        Uri parse = Uri.parse(str);
        if (d.b.i0.r2.t.s(tbPageContext.getPageActivity(), Uri.parse(parse.getQueryParameter(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT))) != 1000) {
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
    public static void e(List<Object> list, int i) {
        int i2;
        boolean z;
        if (list == null || list.size() == 0) {
            return;
        }
        boolean z2 = MessageManager.getInstance().findTask(2016447) != null;
        int i3 = 0;
        while (i3 < list.size()) {
            if (list.get(i3) instanceof ICardInfo) {
                if (z2) {
                    ICardInfo iCardInfo = (ICardInfo) list.get(i3);
                    int viewCount = iCardInfo.getViewCount();
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < viewCount; i4++) {
                        ICardInfo viewItem = iCardInfo.getViewItem(i4, i);
                        if (viewItem != null) {
                            viewItem.setBdUniqueId(d.b.i0.i1.o.e.f55919b.get(viewItem.getCardType()));
                            arrayList.add(viewItem);
                        }
                    }
                    if (arrayList.size() != 0) {
                        list.remove(i3);
                        list.addAll(i3, arrayList);
                        i2 = arrayList.size();
                        z = false;
                        if (!z) {
                            list.remove(i3);
                            i2 = 0;
                        }
                    }
                }
                i2 = 1;
                z = true;
                if (!z) {
                }
            } else {
                i2 = 1;
            }
            i3 += i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f(List<d.b.b.j.e.n> list, int i) {
        int i2;
        boolean z;
        if (list == null || list.size() == 0) {
            return;
        }
        boolean z2 = MessageManager.getInstance().findTask(2016447) != null;
        int i3 = 0;
        while (i3 < list.size()) {
            if (list.get(i3) instanceof n0) {
                if (z2) {
                    if (!((n0) list.get(i3)).isValid()) {
                        ((n0) list.get(i3)).j();
                    }
                    if (((n0) list.get(i3)).isValid()) {
                        ICardInfo g2 = ((n0) list.get(i3)).g();
                        int viewCount = g2.getViewCount();
                        ArrayList arrayList = new ArrayList();
                        for (int i4 = 0; i4 < viewCount; i4++) {
                            ICardInfo viewItem = g2.getViewItem(i4, i);
                            if (viewItem != null) {
                                viewItem.setBdUniqueId(d.b.i0.i1.o.e.f55919b.get(viewItem.getCardType()));
                                arrayList.add(viewItem);
                            }
                        }
                        if (arrayList.size() != 0) {
                            list.remove(i3);
                            list.addAll(i3, arrayList);
                            i2 = arrayList.size();
                            z = false;
                            if (!z) {
                                list.remove(i3);
                                i2 = 0;
                            }
                        }
                    }
                }
                i2 = 1;
                z = true;
                if (!z) {
                }
            } else {
                i2 = 1;
            }
            i3 += i2;
        }
    }

    public static ArrayList<BdUniqueId> g() {
        int size = d.b.i0.i1.o.e.f55919b.size();
        ArrayList<BdUniqueId> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(d.b.i0.i1.o.e.f55919b.valueAt(i));
        }
        return arrayList;
    }

    public static boolean h(String str) {
        return str != null && str.startsWith("tieba://deeplink?");
    }
}
