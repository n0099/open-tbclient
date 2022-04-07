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
import com.repackage.bi5;
import com.repackage.yh5;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class wh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements bi5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ zh5 b;
        public final /* synthetic */ boolean c;

        public a(TbPageContext tbPageContext, zh5 zh5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, zh5Var, Boolean.valueOf(z)};
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
            this.b = zh5Var;
            this.c = z;
        }

        @Override // com.repackage.bi5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (mi.A()) {
                    wh5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    oi.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c18);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements yh5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ zh5 b;
        public final /* synthetic */ boolean c;

        public b(TbPageContext tbPageContext, zh5 zh5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, zh5Var, Boolean.valueOf(z)};
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
            this.b = zh5Var;
            this.c = z;
        }

        @Override // com.repackage.yh5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (mi.A()) {
                    wh5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    oi.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c18);
                }
            }
        }
    }

    public static void b(TbPageContext tbPageContext, zh5 zh5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, tbPageContext, zh5Var) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        boolean z = zh5Var.getType() == 3;
        yh5 yh5Var = new yh5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
        if (zh5Var != null) {
            yh5Var.w(z);
        }
        AntiData c = zc6.f().c();
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
        List<ThreadData> g = zc6.f().g();
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
        mp4 mp4Var = new mp4();
        mp4Var.j(sparseArray);
        if (zh5Var != null) {
            mp4Var.i(zh5Var.getType());
        }
        mp4Var.p(jSONArray);
        mp4Var.m(jSONArray2);
        mp4Var.l(zc6.f().d());
        yh5Var.x(mp4Var);
        yh5Var.y(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a9), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04aa), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ab), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ac), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ad)});
        yh5Var.A("1");
        yh5Var.z(new b(tbPageContext, zh5Var, z));
    }

    public static void c(TbPageContext tbPageContext, zh5 zh5Var, ai5 ai5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, null, tbPageContext, zh5Var, ai5Var, userData) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        boolean z = zh5Var.getType() == 3;
        bi5 bi5Var = new bi5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), ai5Var, userData);
        if (zh5Var != null) {
            bi5Var.C(z);
        }
        AntiData c = zc6.f().c();
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
        List<ThreadData> g = zc6.f().g();
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
        mp4 mp4Var = new mp4();
        mp4Var.j(sparseArray);
        if (zh5Var != null) {
            mp4Var.i(zh5Var.getType());
        }
        mp4Var.p(jSONArray);
        mp4Var.m(jSONArray2);
        mp4Var.l(zc6.f().d());
        bi5Var.D(mp4Var);
        bi5Var.E(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a4), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a5), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a6), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a7), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a8)});
        bi5Var.G("1");
        bi5Var.F(new a(tbPageContext, zh5Var, z));
    }

    public static void d(int i, TbPageContext tbPageContext, zh5 zh5Var, ai5 ai5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), tbPageContext, zh5Var, ai5Var, userData}) == null) {
            if (1 == i) {
                c(tbPageContext, zh5Var, ai5Var, userData);
            } else {
                b(tbPageContext, zh5Var);
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
