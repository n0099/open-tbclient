package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.HotThreadList.DataRes;
import tbclient.HotThreadList.HotThreadListResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class pt6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<jn> a(List<ThreadData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (ThreadData threadData : list) {
                int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                    threadData.position = i;
                    rp4 rp4Var = new rp4();
                    rp4Var.s = threadData;
                    rp4Var.position = i;
                    rp4Var.r = true;
                    rp4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(rp4Var);
                    rp4 rp4Var2 = new rp4();
                    rp4Var2.s = threadData;
                    rp4Var2.position = i;
                    if (threadData.isBJHNormalThreadType()) {
                        rp4Var2.f = true;
                    } else if (threadData.picCount() == 1) {
                        rp4Var2.d = true;
                        rp4Var2.t = imageWidthAndHeight[0];
                        rp4Var2.u = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        rp4Var2.e = true;
                    } else {
                        rp4Var2.b = true;
                    }
                    rp4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(rp4Var2);
                    rp4 rp4Var3 = new rp4();
                    rp4Var3.g = true;
                    rp4Var3.s = threadData;
                    rp4Var3.position = i;
                    rp4Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(rp4Var3);
                } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                    threadData.position = i;
                    rp4 rp4Var4 = new rp4();
                    rp4Var4.s = threadData;
                    rp4Var4.position = i;
                    rp4Var4.r = true;
                    rp4Var4.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(rp4Var4);
                    rp4 rp4Var5 = new rp4();
                    rp4Var5.s = threadData;
                    rp4Var5.position = i;
                    rp4Var5.i = true;
                    rp4Var5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(rp4Var5);
                    rp4 rp4Var6 = new rp4();
                    rp4Var6.g = true;
                    rp4Var6.s = threadData;
                    rp4Var6.position = i;
                    rp4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(rp4Var6);
                } else {
                    threadData.setSupportType(BaseCardInfo.SupportType.TOP);
                }
                i++;
                threadData.setSupportType(BaseCardInfo.SupportType.TOP);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<jn> b(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                ThreadData threadData = new ThreadData();
                threadData.isFromHotRankTab = true;
                threadData.parserProtobuf(threadInfo);
                e(threadData);
                arrayList.add(threadData);
            }
            return a(arrayList);
        }
        return (List) invokeL.objValue;
    }

    public static List<jn> c(HotThreadListResIdl hotThreadListResIdl) {
        InterceptResult invokeL;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hotThreadListResIdl)) == null) {
            if (hotThreadListResIdl == null || (dataRes = hotThreadListResIdl.data) == null || ListUtils.isEmpty(dataRes.thread_info)) {
                return null;
            }
            return b(hotThreadListResIdl.data.thread_info);
        }
        return (List) invokeL.objValue;
    }

    public static cu6 d(List<FrsTabInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            ArrayList arrayList = new ArrayList();
            frsTabInfoData.tabList = arrayList;
            FrsTabItemData frsTabItemData = new FrsTabItemData();
            frsTabItemData.tabCode = "all";
            frsTabItemData.name = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f087a);
            int i = 0;
            frsTabItemData.tabId = 0;
            arrayList.add(frsTabItemData);
            if (!ListUtils.isEmpty(list)) {
                for (FrsTabInfo frsTabInfo : list) {
                    if (frsTabInfo != null && !ki.isEmpty(frsTabInfo.tab_code) && !ki.isEmpty(frsTabInfo.tab_name)) {
                        i++;
                        FrsTabItemData frsTabItemData2 = new FrsTabItemData(frsTabInfo);
                        frsTabItemData2.tabId = i;
                        arrayList.add(frsTabItemData2);
                    }
                }
            }
            return new cu6(frsTabInfoData);
        }
        return (cu6) invokeL.objValue;
    }

    public static void e(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData) == null) {
            String lengthLimitName = threadData.getLengthLimitName();
            String formatTimeForHomeC = StringHelper.getFormatTimeForHomeC(threadData.getLast_time_int() * 1000);
            if (!TextUtils.isEmpty(lengthLimitName) && !TextUtils.isEmpty(formatTimeForHomeC)) {
                lengthLimitName = lengthLimitName + "   " + formatTimeForHomeC;
            }
            threadData.setThreadExtendInfo(lengthLimitName);
        }
    }
}
