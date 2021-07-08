package d.a.p0.e1.f.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.c.e.p.k;
import d.a.c.k.e.n;
import d.a.o0.b.d;
import d.a.o0.r.q.a2;
import d.a.o0.r.q.b2;
import d.a.p0.e1.f.a.e.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.HotThreadList.DataRes;
import tbclient.HotThreadList.HotThreadListResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<n> a(List<b2> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (b2 b2Var : list) {
                int[] d0 = b2Var.d0();
                if (b2Var.getType() == b2.O2) {
                    b2Var.position = i2;
                    a2 a2Var = new a2();
                    a2Var.w = b2Var;
                    a2Var.position = i2;
                    a2Var.v = true;
                    a2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(a2Var);
                    a2 a2Var2 = new a2();
                    a2Var2.w = b2Var;
                    a2Var2.position = i2;
                    if (b2Var.F1()) {
                        a2Var2.j = true;
                    } else if (b2Var.N2() == 1) {
                        a2Var2.f52566h = true;
                        a2Var2.x = d0[0];
                        a2Var2.y = d0[1];
                    } else if (b2Var.N2() >= 2) {
                        a2Var2.f52567i = true;
                    } else {
                        a2Var2.f52564f = true;
                    }
                    a2Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(a2Var2);
                    a2 a2Var3 = new a2();
                    a2Var3.k = true;
                    a2Var3.w = b2Var;
                    a2Var3.position = i2;
                    a2Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(a2Var3);
                } else if (b2Var.getType() == b2.l3) {
                    b2Var.position = i2;
                    a2 a2Var4 = new a2();
                    a2Var4.w = b2Var;
                    a2Var4.position = i2;
                    a2Var4.v = true;
                    a2Var4.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(a2Var4);
                    a2 a2Var5 = new a2();
                    a2Var5.w = b2Var;
                    a2Var5.position = i2;
                    a2Var5.m = true;
                    a2Var5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(a2Var5);
                    a2 a2Var6 = new a2();
                    a2Var6.k = true;
                    a2Var6.w = b2Var;
                    a2Var6.position = i2;
                    a2Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(a2Var6);
                } else {
                    b2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                }
                i2++;
                b2Var.setSupportType(BaseCardInfo.SupportType.TOP);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<n> b(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                b2 b2Var = new b2();
                b2Var.c2 = true;
                b2Var.I2(threadInfo);
                f(b2Var);
                arrayList.add(b2Var);
            }
            return a(arrayList);
        }
        return (List) invokeL.objValue;
    }

    public static List<n> c(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                ThreadInfo threadInfo = list.get(i3);
                if (threadInfo != null && !TextUtils.isEmpty(threadInfo.title)) {
                    arrayList.add(new e(threadInfo, i2));
                    i2++;
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<n> d(HotThreadListResIdl hotThreadListResIdl) {
        InterceptResult invokeL;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, hotThreadListResIdl)) == null) {
            if (hotThreadListResIdl == null || (dataRes = hotThreadListResIdl.data) == null || ListUtils.isEmpty(dataRes.thread_info)) {
                return null;
            }
            boolean E = d.E();
            List<ThreadInfo> list = hotThreadListResIdl.data.thread_info;
            if (E) {
                return b(list);
            }
            return c(list);
        }
        return (List) invokeL.objValue;
    }

    public static d.a.p0.e1.f.a.e.b e(List<FrsTabInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            ArrayList arrayList = new ArrayList();
            frsTabInfoData.tabList = arrayList;
            FrsTabItemData frsTabItemData = new FrsTabItemData();
            frsTabItemData.tabCode = "all";
            frsTabItemData.name = TbadkCoreApplication.getInst().getString(R.string.hot_topic_hot_all);
            int i2 = 0;
            frsTabItemData.tabId = 0;
            arrayList.add(frsTabItemData);
            if (!ListUtils.isEmpty(list)) {
                for (FrsTabInfo frsTabInfo : list) {
                    if (frsTabInfo != null && !k.isEmpty(frsTabInfo.tab_code) && !k.isEmpty(frsTabInfo.tab_name)) {
                        i2++;
                        FrsTabItemData frsTabItemData2 = new FrsTabItemData(frsTabInfo);
                        frsTabItemData2.tabId = i2;
                        arrayList.add(frsTabItemData2);
                    }
                }
            }
            return new d.a.p0.e1.f.a.e.b(frsTabInfoData);
        }
        return (d.a.p0.e1.f.a.e.b) invokeL.objValue;
    }

    public static void f(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, b2Var) == null) {
            String u0 = b2Var.u0();
            String formatTimeForHomeC = StringHelper.getFormatTimeForHomeC(b2Var.q0() * 1000);
            if (!TextUtils.isEmpty(u0) && !TextUtils.isEmpty(formatTimeForHomeC)) {
                u0 = u0 + "   " + formatTimeForHomeC;
            }
            b2Var.c4(u0);
        }
    }
}
