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
import com.repackage.ri5;
import com.repackage.ui5;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class pi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements ui5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ si5 b;
        public final /* synthetic */ boolean c;

        public a(TbPageContext tbPageContext, si5 si5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, si5Var, Boolean.valueOf(z)};
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
            this.b = si5Var;
            this.c = z;
        }

        @Override // com.repackage.ui5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (ki.A()) {
                    pi5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    mi.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c2d);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements ri5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ si5 b;
        public final /* synthetic */ boolean c;

        public b(TbPageContext tbPageContext, si5 si5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, si5Var, Boolean.valueOf(z)};
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
            this.b = si5Var;
            this.c = z;
        }

        @Override // com.repackage.ri5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (ki.A()) {
                    pi5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    mi.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c2d);
                }
            }
        }
    }

    public static void b(TbPageContext tbPageContext, si5 si5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, tbPageContext, si5Var) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        boolean z = si5Var.getType() == 3;
        ri5 ri5Var = new ri5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
        if (si5Var != null) {
            ri5Var.w(z);
        }
        AntiData c = gc6.f().c();
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
        List<ThreadData> g = gc6.f().g();
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
        wp4 wp4Var = new wp4();
        wp4Var.j(sparseArray);
        if (si5Var != null) {
            wp4Var.i(si5Var.getType());
        }
        wp4Var.p(jSONArray);
        wp4Var.m(jSONArray2);
        wp4Var.l(gc6.f().d());
        ri5Var.x(wp4Var);
        ri5Var.y(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b1), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b2), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b3), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b4), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b5)});
        ri5Var.A("1");
        ri5Var.z(new b(tbPageContext, si5Var, z));
    }

    public static void c(TbPageContext tbPageContext, si5 si5Var, ti5 ti5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, null, tbPageContext, si5Var, ti5Var, userData) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        boolean z = si5Var.getType() == 3;
        ui5 ui5Var = new ui5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), ti5Var, userData);
        if (si5Var != null) {
            ui5Var.C(z);
        }
        AntiData c = gc6.f().c();
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
        List<ThreadData> g = gc6.f().g();
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
        wp4 wp4Var = new wp4();
        wp4Var.j(sparseArray);
        if (si5Var != null) {
            wp4Var.i(si5Var.getType());
        }
        wp4Var.p(jSONArray);
        wp4Var.m(jSONArray2);
        wp4Var.l(gc6.f().d());
        ui5Var.D(wp4Var);
        ui5Var.E(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ac), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ad), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ae), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04af), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b0)});
        ui5Var.G("1");
        ui5Var.F(new a(tbPageContext, si5Var, z));
    }

    public static void d(int i, TbPageContext tbPageContext, si5 si5Var, ti5 ti5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), tbPageContext, si5Var, ti5Var, userData}) == null) {
            if (1 == i) {
                c(tbPageContext, si5Var, ti5Var, userData);
            } else {
                b(tbPageContext, si5Var);
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
