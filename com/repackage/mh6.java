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
public class mh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<th6> a(List<GameForumSubTab> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (GameForumSubTab gameForumSubTab : list) {
                th6 th6Var = new th6();
                if (gameForumSubTab != null) {
                    th6Var.a = gameForumSubTab.id.intValue();
                    th6Var.b = gameForumSubTab.sub_tab_name;
                    LabelDataList labelDataList = new LabelDataList();
                    labelDataList.parseProtu(gameForumSubTab.sub_label_list);
                    th6Var.c = labelDataList;
                    arrayList.add(th6Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<jn> b(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                kh6 kh6Var = new kh6();
                ThreadData threadData = new ThreadData();
                kh6Var.e(threadData);
                threadData.parserProtobuf(list.get(i));
                threadData.parser_title();
                if (!TextUtils.isEmpty(threadData.getLegoCard())) {
                    eo4 eo4Var = new eo4();
                    eo4Var.i(threadData.getLegoCard());
                    linkedList.add(eo4Var);
                } else {
                    linkedList.add(kh6Var);
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }
}
