package com.repackage;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.GameForumGuideTab.GameForumSubTab;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class jj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<qj6> a(List<GameForumSubTab> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (GameForumSubTab gameForumSubTab : list) {
                qj6 qj6Var = new qj6();
                if (gameForumSubTab != null) {
                    qj6Var.a = gameForumSubTab.id.intValue();
                    qj6Var.b = gameForumSubTab.sub_tab_name;
                    LabelDataList labelDataList = new LabelDataList();
                    labelDataList.parseProtu(gameForumSubTab.sub_label_list);
                    qj6Var.c = labelDataList;
                    arrayList.add(qj6Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<nn> b(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                hj6 hj6Var = new hj6();
                ThreadData threadData = new ThreadData();
                hj6Var.c(threadData);
                threadData.parserProtobuf(list.get(i));
                threadData.parser_title();
                if (!TextUtils.isEmpty(threadData.getLegoCard())) {
                    dp4 dp4Var = new dp4();
                    dp4Var.g(threadData.getLegoCard());
                    linkedList.add(dp4Var);
                } else {
                    linkedList.add(hj6Var);
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }
}
