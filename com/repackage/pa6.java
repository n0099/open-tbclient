package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
/* loaded from: classes6.dex */
public class pa6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BawuTeam a;
    public boolean b;
    public ManagerApplyInfo c;
    public c d;
    public za e;
    public CustomMessageListener f;

    /* loaded from: classes6.dex */
    public class a extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pa6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(pa6 pa6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa6Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = pa6Var;
        }

        @Override // com.repackage.za
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
                jb6 jb6Var = new jb6();
                if (this.a.c != null) {
                    jb6Var.k(this.a.c.manager_left_num.intValue());
                    jb6Var.i(this.a.c.manager_apply_url);
                    pa6 pa6Var = this.a;
                    jb6Var.g(pa6Var.i(pa6Var.c, this.a.a));
                    jb6Var.d(this.a.c.assist_apply_url);
                }
                if (this.a.d != null) {
                    c cVar = this.a.d;
                    pa6 pa6Var2 = this.a;
                    cVar.a(pa6Var2.m(pa6Var2.a), jb6Var, true, responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pa6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(pa6 pa6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa6Var, Integer.valueOf(i)};
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
            this.a = pa6Var;
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
                jb6 jb6Var = new jb6();
                if (this.a.c != null) {
                    jb6Var.k(this.a.c.manager_left_num.intValue());
                    jb6Var.i(this.a.c.manager_apply_url);
                    pa6 pa6Var = this.a;
                    jb6Var.g(pa6Var.i(pa6Var.c, this.a.a));
                    jb6Var.d(this.a.c.assist_apply_url);
                }
                if (this.a.d != null) {
                    c cVar = this.a.d;
                    pa6 pa6Var2 = this.a;
                    cVar.a(pa6Var2.m(pa6Var2.a), jb6Var, false, customResponsedMessage.getError(), customResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(ArrayList<ta6> arrayList, jb6 jb6Var, boolean z, int i, String str);
    }

    public pa6() {
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, managerApplyInfo, bawuTeam)) == null) ? managerApplyInfo.assist_left_num.intValue() : invokeLL.intValue;
    }

    public final int j(@NonNull BawuRoleDes bawuRoleDes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bawuRoleDes)) == null) ? bawuRoleDes.role_info.size() : invokeL.intValue;
    }

    public void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            BawuTeamInfoReadCacheRequestMessage bawuTeamInfoReadCacheRequestMessage = new BawuTeamInfoReadCacheRequestMessage();
            bawuTeamInfoReadCacheRequestMessage.setCacheKey("" + j);
            MessageManager.getInstance().sendMessage(bawuTeamInfoReadCacheRequestMessage);
        }
    }

    public void l(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            BawuTeamRequestMessage bawuTeamRequestMessage = new BawuTeamRequestMessage();
            bawuTeamRequestMessage.setForumId(j);
            MessageManager.getInstance().sendMessage(bawuTeamRequestMessage);
        }
    }

    public ArrayList<ta6> m(BawuTeam bawuTeam) {
        InterceptResult invokeL;
        List<BawuRoleInfoPub> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bawuTeam)) == null) {
            ArrayList<ta6> arrayList = new ArrayList<>();
            if (bawuTeam == null || bawuTeam.bawu_team_list == null) {
                return null;
            }
            ArrayList<BawuRoleDes> o = o(bawuTeam);
            int size = o.size();
            for (int i = 0; i < size; i++) {
                BawuRoleDes bawuRoleDes = o.get(i);
                if (bawuRoleDes != null && !StringUtils.isNull(bawuRoleDes.role_name) && (list = bawuRoleDes.role_info) != null && list.size() > 0) {
                    na6 na6Var = new na6();
                    na6Var.c(bawuRoleDes.role_name + "(" + j(bawuRoleDes) + SmallTailInfo.EMOTION_SUFFIX);
                    arrayList.add(na6Var);
                    int size2 = bawuRoleDes.role_info.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        ma6 ma6Var = new ma6();
                        ma6Var.i(bawuRoleDes.role_name);
                        ArrayList<BawuRoleInfoPub> arrayList2 = new ArrayList<>();
                        arrayList2.add(bawuRoleDes.role_info.get(i2));
                        int i3 = i2 + 1;
                        if (i3 < size2) {
                            arrayList2.add(bawuRoleDes.role_info.get(i3));
                        }
                        i2 += 2;
                        if (i2 >= size2) {
                            if (this.b) {
                                ma6Var.f(false);
                            } else {
                                ma6Var.f(true);
                            }
                            ma6Var.g(true);
                        } else {
                            ma6Var.g(false);
                        }
                        ma6Var.h(arrayList2);
                        arrayList.add(ma6Var);
                    }
                    if (i <= size - 2) {
                        arrayList.add(new la6());
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void n(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.d = cVar;
        }
    }

    @NonNull
    public final ArrayList<BawuRoleDes> o(@NonNull BawuTeam bawuTeam) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bawuTeam)) == null) ? new ArrayList<>(bawuTeam.bawu_team_list) : (ArrayList) invokeL.objValue;
    }
}
