package d.b.i0.z0.e.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import d.b.b.e.p.k;
import d.b.b.j.e.n;
import d.b.h0.b.d;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
import d.b.i0.z0.e.a.e.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.HotThreadList.DataRes;
import tbclient.HotThreadList.HotThreadListResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class c {
    public static List<n> a(List<a2> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (a2 a2Var : list) {
            int[] p0 = a2Var.p0();
            if (a2Var.getType() == a2.H2) {
                a2Var.position = i;
                z1 z1Var = new z1();
                z1Var.w = a2Var;
                z1Var.position = i;
                z1Var.v = true;
                z1Var.setSupportType(BaseCardInfo.SupportType.TOP);
                arrayList.add(z1Var);
                z1 z1Var2 = new z1();
                z1Var2.w = a2Var;
                z1Var2.position = i;
                if (a2Var.P1()) {
                    z1Var2.j = true;
                } else if (a2Var.V2() == 1) {
                    z1Var2.f50956h = true;
                    z1Var2.x = p0[0];
                    z1Var2.y = p0[1];
                } else if (a2Var.V2() >= 2) {
                    z1Var2.i = true;
                } else {
                    z1Var2.f50954f = true;
                }
                z1Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                arrayList.add(z1Var2);
                z1 z1Var3 = new z1();
                z1Var3.k = true;
                z1Var3.w = a2Var;
                z1Var3.position = i;
                z1Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                arrayList.add(z1Var3);
            } else if (a2Var.getType() == a2.e3) {
                a2Var.position = i;
                z1 z1Var4 = new z1();
                z1Var4.w = a2Var;
                z1Var4.position = i;
                z1Var4.v = true;
                z1Var4.setSupportType(BaseCardInfo.SupportType.TOP);
                arrayList.add(z1Var4);
                z1 z1Var5 = new z1();
                z1Var5.w = a2Var;
                z1Var5.position = i;
                z1Var5.m = true;
                z1Var5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                arrayList.add(z1Var5);
                z1 z1Var6 = new z1();
                z1Var6.k = true;
                z1Var6.w = a2Var;
                z1Var6.position = i;
                z1Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                arrayList.add(z1Var6);
            } else {
                a2Var.setSupportType(BaseCardInfo.SupportType.TOP);
            }
            i++;
            a2Var.setSupportType(BaseCardInfo.SupportType.TOP);
        }
        return arrayList;
    }

    public static List<n> b(List<ThreadInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (ThreadInfo threadInfo : list) {
            a2 a2Var = new a2();
            a2Var.Y1 = true;
            a2Var.Q2(threadInfo);
            f(a2Var);
            arrayList.add(a2Var);
        }
        return a(arrayList);
    }

    public static List<n> c(List<ThreadInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ThreadInfo threadInfo = list.get(i2);
            if (threadInfo != null && !TextUtils.isEmpty(threadInfo.title)) {
                arrayList.add(new e(threadInfo, i));
                i++;
            }
        }
        return arrayList;
    }

    public static List<n> d(HotThreadListResIdl hotThreadListResIdl) {
        DataRes dataRes;
        if (hotThreadListResIdl == null || (dataRes = hotThreadListResIdl.data) == null || ListUtils.isEmpty(dataRes.thread_info)) {
            return null;
        }
        boolean t = d.t();
        List<ThreadInfo> list = hotThreadListResIdl.data.thread_info;
        if (t) {
            return b(list);
        }
        return c(list);
    }

    public static d.b.i0.z0.e.a.e.b e(List<FrsTabInfo> list) {
        FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
        ArrayList arrayList = new ArrayList();
        frsTabInfoData.tabList = arrayList;
        FrsTabItemData frsTabItemData = new FrsTabItemData();
        frsTabItemData.tabCode = "all";
        frsTabItemData.name = TbadkCoreApplication.getInst().getString(R.string.hot_topic_hot_all);
        int i = 0;
        frsTabItemData.tabId = 0;
        arrayList.add(frsTabItemData);
        if (!ListUtils.isEmpty(list)) {
            for (FrsTabInfo frsTabInfo : list) {
                if (frsTabInfo != null && !k.isEmpty(frsTabInfo.tab_code) && !k.isEmpty(frsTabInfo.tab_name)) {
                    i++;
                    FrsTabItemData frsTabItemData2 = new FrsTabItemData(frsTabInfo);
                    frsTabItemData2.tabId = i;
                    arrayList.add(frsTabItemData2);
                }
            }
        }
        return new d.b.i0.z0.e.a.e.b(frsTabInfoData);
    }

    public static void f(a2 a2Var) {
        String F0 = a2Var.F0();
        String formatTimeForHomeC = StringHelper.getFormatTimeForHomeC(a2Var.B0() * 1000);
        if (!TextUtils.isEmpty(F0) && !TextUtils.isEmpty(formatTimeForHomeC)) {
            F0 = F0 + "   " + formatTimeForHomeC;
        }
        a2Var.j4(F0);
    }
}
