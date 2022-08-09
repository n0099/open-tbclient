package com.repackage;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bl5;
import com.repackage.yk5;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class wk5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements bl5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ zk5 b;
        public final /* synthetic */ boolean c;

        public a(TbPageContext tbPageContext, zk5 zk5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, zk5Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.b = zk5Var;
            this.c = z;
        }

        @Override // com.repackage.bl5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (oi.A()) {
                    wk5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    qi.N(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c3c);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements yk5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ zk5 b;
        public final /* synthetic */ boolean c;

        public b(TbPageContext tbPageContext, zk5 zk5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, zk5Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.b = zk5Var;
            this.c = z;
        }

        @Override // com.repackage.yk5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (oi.A()) {
                    wk5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    qi.N(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c3c);
                }
            }
        }
    }

    public static void b(TbPageContext tbPageContext, zk5 zk5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, tbPageContext, zk5Var) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        boolean z = zk5Var.getType() == 3;
        yk5 yk5Var = new yk5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
        if (zk5Var != null) {
            yk5Var.w(z);
        }
        AntiData c = le6.f().c();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (c != null && c.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = c.getDelThreadInfoList();
            for (int i = 0; i < delThreadInfoList.size(); i++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                }
            }
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        List<ThreadData> g = le6.f().g();
        for (int i2 = 0; i2 < g.size(); i2++) {
            if (g.get(i2) != null) {
                jSONArray.put(g.get(i2).getTid());
                if (z) {
                    jSONArray2.put("1");
                } else if (!g.get(i2).isScoreThread() && !g.get(i2).isWorksInfo()) {
                    jSONArray2.put("0");
                } else {
                    jSONArray2.put("1");
                }
            }
        }
        cq4 cq4Var = new cq4();
        cq4Var.j(sparseArray);
        if (zk5Var != null) {
            cq4Var.i(zk5Var.getType());
        }
        cq4Var.p(jSONArray);
        cq4Var.m(jSONArray2);
        cq4Var.l(le6.f().d());
        yk5Var.x(cq4Var);
        yk5Var.y(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04bf), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c0), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c1), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c2), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c3)});
        yk5Var.A("1");
        yk5Var.z(new b(tbPageContext, zk5Var, z));
    }

    public static void c(TbPageContext tbPageContext, zk5 zk5Var, al5 al5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, null, tbPageContext, zk5Var, al5Var, userData) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        boolean z = zk5Var.getType() == 3;
        bl5 bl5Var = new bl5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), al5Var, userData);
        if (zk5Var != null) {
            bl5Var.C(z);
        }
        AntiData c = le6.f().c();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (c != null && c.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = c.getDelThreadInfoList();
            for (int i = 0; i < delThreadInfoList.size(); i++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                }
            }
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        List<ThreadData> g = le6.f().g();
        for (int i2 = 0; i2 < g.size(); i2++) {
            if (g.get(i2) != null) {
                jSONArray.put(g.get(i2).getTid());
                if (z) {
                    jSONArray2.put("1");
                } else if (!g.get(i2).isScoreThread() && !g.get(i2).isWorksInfo()) {
                    jSONArray2.put("0");
                } else {
                    jSONArray2.put("1");
                }
            }
        }
        cq4 cq4Var = new cq4();
        cq4Var.j(sparseArray);
        if (zk5Var != null) {
            cq4Var.i(zk5Var.getType());
        }
        cq4Var.p(jSONArray);
        cq4Var.m(jSONArray2);
        cq4Var.l(le6.f().d());
        bl5Var.D(cq4Var);
        bl5Var.E(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ba), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04bb), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04bc), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04bd), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04be)});
        bl5Var.G("1");
        bl5Var.F(new a(tbPageContext, zk5Var, z));
    }

    public static void d(int i, TbPageContext tbPageContext, zk5 zk5Var, al5 al5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), tbPageContext, zk5Var, al5Var, userData}) == null) {
            if (1 == i) {
                c(tbPageContext, zk5Var, al5Var, userData);
            } else {
                b(tbPageContext, zk5Var);
            }
        }
    }

    public static void e(JSONArray jSONArray, ForumManageModel forumManageModel, ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{jSONArray, forumManageModel, threadData, Boolean.valueOf(z)}) == null) || forumManageModel == null || threadData == null || threadData.getAuthor() == null) {
            return;
        }
        String userId = threadData.getAuthor().getUserId();
        String id = threadData.getId();
        String forum_name = threadData.getForum_name();
        String valueOf = String.valueOf(threadData.getFid());
        boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
        if (jSONArray != null) {
            forumManageModel.U(StringHelper.JsonArrayToString(jSONArray));
        }
        forumManageModel.V(valueOf, forum_name, id, null, 0, 1, isCurrentAccount, threadData.getBaijiahaoData(), z);
    }
}
