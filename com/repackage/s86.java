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
/* loaded from: classes7.dex */
public class s86 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BawuTeam a;
    public boolean b;
    public ManagerApplyInfo c;
    public c d;
    public wa e;
    public CustomMessageListener f;

    /* loaded from: classes7.dex */
    public class a extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s86 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(s86 s86Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s86Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = s86Var;
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
                m96 m96Var = new m96();
                if (this.a.c != null) {
                    m96Var.k(this.a.c.manager_left_num.intValue());
                    m96Var.j(this.a.c.manager_apply_url);
                    s86 s86Var = this.a;
                    m96Var.g(s86Var.i(s86Var.c, this.a.a));
                    m96Var.f(this.a.c.assist_apply_url);
                }
                if (this.a.d != null) {
                    c cVar = this.a.d;
                    s86 s86Var2 = this.a;
                    cVar.a(s86Var2.n(s86Var2.a), m96Var, true, responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s86 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(s86 s86Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s86Var, Integer.valueOf(i)};
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
            this.a = s86Var;
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
                m96 m96Var = new m96();
                if (this.a.c != null) {
                    m96Var.k(this.a.c.manager_left_num.intValue());
                    m96Var.j(this.a.c.manager_apply_url);
                    s86 s86Var = this.a;
                    m96Var.g(s86Var.i(s86Var.c, this.a.a));
                    m96Var.f(this.a.c.assist_apply_url);
                }
                if (this.a.d != null) {
                    c cVar = this.a.d;
                    s86 s86Var2 = this.a;
                    cVar.a(s86Var2.n(s86Var2.a), m96Var, false, customResponsedMessage.getError(), customResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(ArrayList<w86> arrayList, m96 m96Var, boolean z, int i, String str);
    }

    public s86() {
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
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02f3);
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

    public ArrayList<w86> n(BawuTeam bawuTeam) {
        InterceptResult invokeL;
        List<BawuRoleInfoPub> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bawuTeam)) == null) {
            ArrayList<w86> arrayList = new ArrayList<>();
            if (bawuTeam == null || bawuTeam.bawu_team_list == null) {
                return null;
            }
            ArrayList<BawuRoleDes> p = p(bawuTeam);
            int size = p.size();
            for (int i = 0; i < size; i++) {
                BawuRoleDes bawuRoleDes = p.get(i);
                if (bawuRoleDes != null && !StringUtils.isNull(bawuRoleDes.role_name) && (list = bawuRoleDes.role_info) != null && list.size() > 0) {
                    q86 q86Var = new q86();
                    q86Var.c(bawuRoleDes.role_name + "(" + j(bawuRoleDes) + SmallTailInfo.EMOTION_SUFFIX);
                    arrayList.add(q86Var);
                    int size2 = bawuRoleDes.role_info.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        p86 p86Var = new p86();
                        p86Var.i(bawuRoleDes.role_name);
                        ArrayList<BawuRoleInfoPub> arrayList2 = new ArrayList<>();
                        arrayList2.add(bawuRoleDes.role_info.get(i2));
                        int i3 = i2 + 1;
                        if (i3 < size2) {
                            arrayList2.add(bawuRoleDes.role_info.get(i3));
                        }
                        i2 += 2;
                        if (i2 >= size2) {
                            if (this.b) {
                                p86Var.f(false);
                            } else {
                                p86Var.f(true);
                            }
                            p86Var.g(true);
                        } else {
                            p86Var.g(false);
                        }
                        p86Var.h(arrayList2);
                        arrayList.add(p86Var);
                    }
                    if (i <= size - 2) {
                        arrayList.add(new o86());
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
                String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02f3);
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
