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
import com.repackage.lh5;
import com.repackage.oh5;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class jh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements oh5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ mh5 b;
        public final /* synthetic */ boolean c;

        public a(TbPageContext tbPageContext, mh5 mh5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, mh5Var, Boolean.valueOf(z)};
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
            this.b = mh5Var;
            this.c = z;
        }

        @Override // com.repackage.oh5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (ji.A()) {
                    jh5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    li.N(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c33);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements lh5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ mh5 b;
        public final /* synthetic */ boolean c;

        public b(TbPageContext tbPageContext, mh5 mh5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, mh5Var, Boolean.valueOf(z)};
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
            this.b = mh5Var;
            this.c = z;
        }

        @Override // com.repackage.lh5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (ji.A()) {
                    jh5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    li.N(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c33);
                }
            }
        }
    }

    public static void b(TbPageContext tbPageContext, mh5 mh5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, tbPageContext, mh5Var) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        boolean z = mh5Var.getType() == 3;
        lh5 lh5Var = new lh5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
        if (mh5Var != null) {
            lh5Var.w(z);
        }
        AntiData c = wa6.f().c();
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
        List<ThreadData> g = wa6.f().g();
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
        lo4 lo4Var = new lo4();
        lo4Var.j(sparseArray);
        if (mh5Var != null) {
            lo4Var.i(mh5Var.getType());
        }
        lo4Var.p(jSONArray);
        lo4Var.m(jSONArray2);
        lo4Var.l(wa6.f().d());
        lh5Var.x(lo4Var);
        lh5Var.y(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b8), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b9), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ba), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04bb), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04bc)});
        lh5Var.A("1");
        lh5Var.z(new b(tbPageContext, mh5Var, z));
    }

    public static void c(TbPageContext tbPageContext, mh5 mh5Var, nh5 nh5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, null, tbPageContext, mh5Var, nh5Var, userData) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        boolean z = mh5Var.getType() == 3;
        oh5 oh5Var = new oh5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), nh5Var, userData);
        if (mh5Var != null) {
            oh5Var.C(z);
        }
        AntiData c = wa6.f().c();
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
        List<ThreadData> g = wa6.f().g();
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
        lo4 lo4Var = new lo4();
        lo4Var.j(sparseArray);
        if (mh5Var != null) {
            lo4Var.i(mh5Var.getType());
        }
        lo4Var.p(jSONArray);
        lo4Var.m(jSONArray2);
        lo4Var.l(wa6.f().d());
        oh5Var.D(lo4Var);
        oh5Var.E(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b3), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b4), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b5), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b6), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b7)});
        oh5Var.G("1");
        oh5Var.F(new a(tbPageContext, mh5Var, z));
    }

    public static void d(int i, TbPageContext tbPageContext, mh5 mh5Var, nh5 nh5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), tbPageContext, mh5Var, nh5Var, userData}) == null) {
            if (1 == i) {
                c(tbPageContext, mh5Var, nh5Var, userData);
            } else {
                b(tbPageContext, mh5Var);
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
            forumManageModel.T(StringHelper.JsonArrayToString(jSONArray));
        }
        forumManageModel.U(valueOf, forum_name, id, null, 0, 1, isCurrentAccount, threadData.getBaijiahaoData(), z);
    }
}
