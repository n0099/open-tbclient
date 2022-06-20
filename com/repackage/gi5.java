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
import com.repackage.ii5;
import com.repackage.li5;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class gi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements li5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ ji5 b;
        public final /* synthetic */ boolean c;

        public a(TbPageContext tbPageContext, ji5 ji5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, ji5Var, Boolean.valueOf(z)};
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
            this.b = ji5Var;
            this.c = z;
        }

        @Override // com.repackage.li5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (ni.A()) {
                    gi5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    pi.N(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c37);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements ii5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ ji5 b;
        public final /* synthetic */ boolean c;

        public b(TbPageContext tbPageContext, ji5 ji5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, ji5Var, Boolean.valueOf(z)};
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
            this.b = ji5Var;
            this.c = z;
        }

        @Override // com.repackage.ii5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (ni.A()) {
                    gi5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    pi.N(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c37);
                }
            }
        }
    }

    public static void b(TbPageContext tbPageContext, ji5 ji5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, tbPageContext, ji5Var) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        boolean z = ji5Var.getType() == 3;
        ii5 ii5Var = new ii5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
        if (ji5Var != null) {
            ii5Var.w(z);
        }
        AntiData c = wb6.f().c();
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
        List<ThreadData> g = wb6.f().g();
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
        vo4 vo4Var = new vo4();
        vo4Var.j(sparseArray);
        if (ji5Var != null) {
            vo4Var.i(ji5Var.getType());
        }
        vo4Var.p(jSONArray);
        vo4Var.m(jSONArray2);
        vo4Var.l(wb6.f().d());
        ii5Var.x(vo4Var);
        ii5Var.y(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04aa), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ab), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ac), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ad), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ae)});
        ii5Var.A("1");
        ii5Var.z(new b(tbPageContext, ji5Var, z));
    }

    public static void c(TbPageContext tbPageContext, ji5 ji5Var, ki5 ki5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, null, tbPageContext, ji5Var, ki5Var, userData) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        boolean z = ji5Var.getType() == 3;
        li5 li5Var = new li5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), ki5Var, userData);
        if (ji5Var != null) {
            li5Var.C(z);
        }
        AntiData c = wb6.f().c();
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
        List<ThreadData> g = wb6.f().g();
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
        vo4 vo4Var = new vo4();
        vo4Var.j(sparseArray);
        if (ji5Var != null) {
            vo4Var.i(ji5Var.getType());
        }
        vo4Var.p(jSONArray);
        vo4Var.m(jSONArray2);
        vo4Var.l(wb6.f().d());
        li5Var.D(vo4Var);
        li5Var.E(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a5), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a6), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a7), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a8), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a9)});
        li5Var.G("1");
        li5Var.F(new a(tbPageContext, ji5Var, z));
    }

    public static void d(int i, TbPageContext tbPageContext, ji5 ji5Var, ki5 ki5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), tbPageContext, ji5Var, ki5Var, userData}) == null) {
            if (1 == i) {
                c(tbPageContext, ji5Var, ki5Var, userData);
            } else {
                b(tbPageContext, ji5Var);
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
