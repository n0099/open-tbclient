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
import com.repackage.lj5;
import com.repackage.oj5;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class jj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements oj5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ mj5 b;
        public final /* synthetic */ boolean c;

        public a(TbPageContext tbPageContext, mj5 mj5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, mj5Var, Boolean.valueOf(z)};
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
            this.b = mj5Var;
            this.c = z;
        }

        @Override // com.repackage.oj5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (ni.A()) {
                    jj5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    pi.N(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c2b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements lj5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ mj5 b;
        public final /* synthetic */ boolean c;

        public b(TbPageContext tbPageContext, mj5 mj5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, mj5Var, Boolean.valueOf(z)};
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
            this.b = mj5Var;
            this.c = z;
        }

        @Override // com.repackage.lj5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (ni.A()) {
                    jj5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    pi.N(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c2b);
                }
            }
        }
    }

    public static void b(TbPageContext tbPageContext, mj5 mj5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, tbPageContext, mj5Var) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        boolean z = mj5Var.getType() == 3;
        lj5 lj5Var = new lj5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
        if (mj5Var != null) {
            lj5Var.w(z);
        }
        AntiData c = tc6.f().c();
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
        List<ThreadData> g = tc6.f().g();
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
        kp4 kp4Var = new kp4();
        kp4Var.j(sparseArray);
        if (mj5Var != null) {
            kp4Var.i(mj5Var.getType());
        }
        kp4Var.p(jSONArray);
        kp4Var.m(jSONArray2);
        kp4Var.l(tc6.f().d());
        lj5Var.x(kp4Var);
        lj5Var.y(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b3), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b4), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b5), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b6), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b7)});
        lj5Var.A("1");
        lj5Var.z(new b(tbPageContext, mj5Var, z));
    }

    public static void c(TbPageContext tbPageContext, mj5 mj5Var, nj5 nj5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, null, tbPageContext, mj5Var, nj5Var, userData) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        boolean z = mj5Var.getType() == 3;
        oj5 oj5Var = new oj5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), nj5Var, userData);
        if (mj5Var != null) {
            oj5Var.C(z);
        }
        AntiData c = tc6.f().c();
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
        List<ThreadData> g = tc6.f().g();
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
        kp4 kp4Var = new kp4();
        kp4Var.j(sparseArray);
        if (mj5Var != null) {
            kp4Var.i(mj5Var.getType());
        }
        kp4Var.p(jSONArray);
        kp4Var.m(jSONArray2);
        kp4Var.l(tc6.f().d());
        oj5Var.D(kp4Var);
        oj5Var.E(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ae), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04af), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b0), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b1), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b2)});
        oj5Var.G("1");
        oj5Var.F(new a(tbPageContext, mj5Var, z));
    }

    public static void d(int i, TbPageContext tbPageContext, mj5 mj5Var, nj5 nj5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), tbPageContext, mj5Var, nj5Var, userData}) == null) {
            if (1 == i) {
                c(tbPageContext, mj5Var, nj5Var, userData);
            } else {
                b(tbPageContext, mj5Var);
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
            forumManageModel.V(StringHelper.JsonArrayToString(jSONArray));
        }
        forumManageModel.W(valueOf, forum_name, id, null, 0, 1, isCurrentAccount, threadData.getBaijiahaoData(), z);
    }
}
