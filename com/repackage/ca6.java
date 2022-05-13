package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.bawu.BawuTeamHttpResponseMessage;
import com.baidu.tieba.forumMember.bawu.BawuTeamInfoReadCacheRequestMessage;
import com.baidu.tieba.forumMember.bawu.BawuTeamReadCacheResponseMessage;
import com.baidu.tieba.forumMember.bawu.BawuTeamRequestMessage;
import com.baidu.tieba.forumMember.bawu.BawuTeamSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.BawuRoleDes;
import tbclient.BawuRoleInfoPub;
import tbclient.BawuTeam;
import tbclient.GetBawuInfo.ManagerApplyInfo;
/* loaded from: classes5.dex */
public class ca6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BawuTeam a;
    public boolean b;
    public ManagerApplyInfo c;
    public c d;
    public wa e;
    public CustomMessageListener f;

    /* loaded from: classes5.dex */
    public class a extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ca6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ca6 ca6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ca6Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ca6Var;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof BawuTeamHttpResponseMessage;
            if (z || (responsedMessage instanceof BawuTeamSocketResponseMessage)) {
                if (z) {
                    BawuTeamHttpResponseMessage bawuTeamHttpResponseMessage = (BawuTeamHttpResponseMessage) responsedMessage;
                    this.a.a = bawuTeamHttpResponseMessage.getBawuTeamInfo();
                    this.a.b = bawuTeamHttpResponseMessage.isPrivateForum() != 0;
                    this.a.c = bawuTeamHttpResponseMessage.getManagerApplyInfo();
                } else if (responsedMessage instanceof BawuTeamSocketResponseMessage) {
                    BawuTeamSocketResponseMessage bawuTeamSocketResponseMessage = (BawuTeamSocketResponseMessage) responsedMessage;
                    this.a.a = bawuTeamSocketResponseMessage.getBawuTeamInfo();
                    this.a.b = bawuTeamSocketResponseMessage.isPrivateForum() != 0;
                    this.a.c = bawuTeamSocketResponseMessage.getManagerApplyInfo();
                }
                wa6 wa6Var = new wa6();
                if (this.a.c != null) {
                    wa6Var.k(this.a.c.manager_left_num.intValue());
                    wa6Var.j(this.a.c.manager_apply_url);
                    ca6 ca6Var = this.a;
                    wa6Var.g(ca6Var.i(ca6Var.c, this.a.a));
                    wa6Var.f(this.a.c.assist_apply_url);
                }
                if (this.a.d != null) {
                    c cVar = this.a.d;
                    ca6 ca6Var2 = this.a;
                    cVar.a(ca6Var2.n(ca6Var2.a), wa6Var, true, responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ca6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ca6 ca6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ca6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ca6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof BawuTeamReadCacheResponseMessage)) {
                BawuTeamReadCacheResponseMessage bawuTeamReadCacheResponseMessage = (BawuTeamReadCacheResponseMessage) customResponsedMessage;
                this.a.a = bawuTeamReadCacheResponseMessage.getBawuTeamInfo();
                this.a.b = bawuTeamReadCacheResponseMessage.isPrivateForum() != 0;
                this.a.c = bawuTeamReadCacheResponseMessage.getManagerApplyInfo();
                wa6 wa6Var = new wa6();
                if (this.a.c != null) {
                    wa6Var.k(this.a.c.manager_left_num.intValue());
                    wa6Var.j(this.a.c.manager_apply_url);
                    ca6 ca6Var = this.a;
                    wa6Var.g(ca6Var.i(ca6Var.c, this.a.a));
                    wa6Var.f(this.a.c.assist_apply_url);
                }
                if (this.a.d != null) {
                    c cVar = this.a.d;
                    ca6 ca6Var2 = this.a;
                    cVar.a(ca6Var2.n(ca6Var2.a), wa6Var, false, customResponsedMessage.getError(), customResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(ArrayList<ga6> arrayList, wa6 wa6Var, boolean z, int i, String str);
    }

    public ca6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = new a(this, CmdConfigHttp.BAWU_TEAM_INFO_CMD, 301007);
        this.f = new b(this, 2003005);
        MessageManager.getInstance().registerListener(this.f);
        MessageManager.getInstance().registerListener(this.e);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.e);
            MessageManager.getInstance().unRegisterListener(this.f);
        }
    }

    public final int i(@NonNull ManagerApplyInfo managerApplyInfo, @Nullable BawuTeam bawuTeam) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, managerApplyInfo, bawuTeam)) == null) {
            int intValue = managerApplyInfo.assist_left_num.intValue();
            if (k(bawuTeam) && UbsABTestHelper.isFrsModifyABTestA() && intValue == 0) {
                return 10;
            }
            return intValue;
        }
        return invokeLL.intValue;
    }

    public final int j(@NonNull BawuRoleDes bawuRoleDes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bawuRoleDes)) == null) {
            int size = bawuRoleDes.role_info.size();
            if (size == 1 && UbsABTestHelper.isFrsModifyABTestA() && BawuRoleInfoPub.DEFAULT_USER_ID.equals(bawuRoleDes.role_info.get(0).user_id)) {
                return 0;
            }
            return size;
        }
        return invokeL.intValue;
    }

    public final boolean k(@Nullable BawuTeam bawuTeam) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bawuTeam)) == null) {
            if (bawuTeam == null) {
                return false;
            }
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02f1);
            for (BawuRoleDes bawuRoleDes : bawuTeam.bawu_team_list) {
                if (TextUtils.equals(bawuRoleDes.role_name, string)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void l(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            BawuTeamInfoReadCacheRequestMessage bawuTeamInfoReadCacheRequestMessage = new BawuTeamInfoReadCacheRequestMessage();
            bawuTeamInfoReadCacheRequestMessage.setCacheKey("" + j);
            MessageManager.getInstance().sendMessage(bawuTeamInfoReadCacheRequestMessage);
        }
    }

    public void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            BawuTeamRequestMessage bawuTeamRequestMessage = new BawuTeamRequestMessage();
            bawuTeamRequestMessage.setForumId(j);
            MessageManager.getInstance().sendMessage(bawuTeamRequestMessage);
        }
    }

    public ArrayList<ga6> n(BawuTeam bawuTeam) {
        InterceptResult invokeL;
        List<BawuRoleInfoPub> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bawuTeam)) == null) {
            ArrayList<ga6> arrayList = new ArrayList<>();
            if (bawuTeam == null || bawuTeam.bawu_team_list == null) {
                return null;
            }
            ArrayList<BawuRoleDes> p = p(bawuTeam);
            int size = p.size();
            for (int i = 0; i < size; i++) {
                BawuRoleDes bawuRoleDes = p.get(i);
                if (bawuRoleDes != null && !StringUtils.isNull(bawuRoleDes.role_name) && (list = bawuRoleDes.role_info) != null && list.size() > 0) {
                    aa6 aa6Var = new aa6();
                    aa6Var.c(bawuRoleDes.role_name + "(" + j(bawuRoleDes) + SmallTailInfo.EMOTION_SUFFIX);
                    arrayList.add(aa6Var);
                    int size2 = bawuRoleDes.role_info.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        z96 z96Var = new z96();
                        z96Var.i(bawuRoleDes.role_name);
                        ArrayList<BawuRoleInfoPub> arrayList2 = new ArrayList<>();
                        arrayList2.add(bawuRoleDes.role_info.get(i2));
                        int i3 = i2 + 1;
                        if (i3 < size2) {
                            arrayList2.add(bawuRoleDes.role_info.get(i3));
                        }
                        i2 += 2;
                        if (i2 >= size2) {
                            if (this.b) {
                                z96Var.f(false);
                            } else {
                                z96Var.f(true);
                            }
                            z96Var.g(true);
                        } else {
                            z96Var.g(false);
                        }
                        z96Var.h(arrayList2);
                        arrayList.add(z96Var);
                    }
                    if (i <= size - 2) {
                        arrayList.add(new y96());
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void o(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            this.d = cVar;
        }
    }

    @NonNull
    public final ArrayList<BawuRoleDes> p(@NonNull BawuTeam bawuTeam) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bawuTeam)) == null) {
            ArrayList<BawuRoleDes> arrayList = new ArrayList<>(bawuTeam.bawu_team_list);
            if (UbsABTestHelper.isFrsModifyABTestA()) {
                String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02f1);
                if (k(bawuTeam)) {
                    BawuRoleInfoPub.Builder builder = new BawuRoleInfoPub.Builder();
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(builder.build(true));
                    BawuRoleDes.Builder builder2 = new BawuRoleDes.Builder();
                    builder2.role_name = string;
                    builder2.role_info = arrayList2;
                    arrayList.add(builder2.build(true));
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }
}
