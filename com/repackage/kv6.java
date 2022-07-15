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
public class kv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<nn> a(List<ThreadData> list) {
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
                    qq4 qq4Var = new qq4();
                    qq4Var.s = threadData;
                    qq4Var.position = i;
                    qq4Var.r = true;
                    qq4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(qq4Var);
                    qq4 qq4Var2 = new qq4();
                    qq4Var2.s = threadData;
                    qq4Var2.position = i;
                    if (threadData.isBJHNormalThreadType()) {
                        qq4Var2.f = true;
                    } else if (threadData.picCount() == 1) {
                        qq4Var2.d = true;
                        qq4Var2.t = imageWidthAndHeight[0];
                        qq4Var2.u = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        qq4Var2.e = true;
                    } else {
                        qq4Var2.b = true;
                    }
                    qq4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(qq4Var2);
                    qq4 qq4Var3 = new qq4();
                    qq4Var3.g = true;
                    qq4Var3.s = threadData;
                    qq4Var3.position = i;
                    qq4Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(qq4Var3);
                } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                    threadData.position = i;
                    qq4 qq4Var4 = new qq4();
                    qq4Var4.s = threadData;
                    qq4Var4.position = i;
                    qq4Var4.r = true;
                    qq4Var4.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(qq4Var4);
                    qq4 qq4Var5 = new qq4();
                    qq4Var5.s = threadData;
                    qq4Var5.position = i;
                    qq4Var5.i = true;
                    qq4Var5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(qq4Var5);
                    qq4 qq4Var6 = new qq4();
                    qq4Var6.g = true;
                    qq4Var6.s = threadData;
                    qq4Var6.position = i;
                    qq4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(qq4Var6);
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

    public static List<nn> b(List<ThreadInfo> list) {
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

    public static List<nn> c(HotThreadListResIdl hotThreadListResIdl) {
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

    public static xv6 d(List<FrsTabInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            ArrayList arrayList = new ArrayList();
            frsTabInfoData.tabList = arrayList;
            FrsTabItemData frsTabItemData = new FrsTabItemData();
            frsTabItemData.tabCode = "all";
            frsTabItemData.name = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0882);
            int i = 0;
            frsTabItemData.tabId = 0;
            arrayList.add(frsTabItemData);
            if (!ListUtils.isEmpty(list)) {
                for (FrsTabInfo frsTabInfo : list) {
                    if (frsTabInfo != null && !oi.isEmpty(frsTabInfo.tab_code) && !oi.isEmpty(frsTabInfo.tab_name)) {
                        i++;
                        FrsTabItemData frsTabItemData2 = new FrsTabItemData(frsTabInfo);
                        frsTabItemData2.tabId = i;
                        arrayList.add(frsTabItemData2);
                    }
                }
            }
            return new xv6(frsTabInfoData);
        }
        return (xv6) invokeL.objValue;
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
