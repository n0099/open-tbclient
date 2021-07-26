package d.a.q0.s0.a;

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
import d.a.q0.s0.c.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BawuRoleDes;
import tbclient.BawuRoleInfoPub;
import tbclient.BawuTeam;
import tbclient.GetBawuInfo.ManagerApplyInfo;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BawuTeam f62612a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f62613b;

    /* renamed from: c  reason: collision with root package name */
    public ManagerApplyInfo f62614c;

    /* renamed from: d  reason: collision with root package name */
    public c f62615d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.d.c.g.a f62616e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f62617f;

    /* loaded from: classes8.dex */
    public class a extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f62618a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62618a = eVar;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof BawuTeamHttpResponseMessage;
            if (z || (responsedMessage instanceof BawuTeamSocketResponseMessage)) {
                if (z) {
                    BawuTeamHttpResponseMessage bawuTeamHttpResponseMessage = (BawuTeamHttpResponseMessage) responsedMessage;
                    this.f62618a.f62612a = bawuTeamHttpResponseMessage.getBawuTeamInfo();
                    this.f62618a.f62613b = bawuTeamHttpResponseMessage.isPrivateForum() != 0;
                    this.f62618a.f62614c = bawuTeamHttpResponseMessage.getManagerApplyInfo();
                } else if (responsedMessage instanceof BawuTeamSocketResponseMessage) {
                    BawuTeamSocketResponseMessage bawuTeamSocketResponseMessage = (BawuTeamSocketResponseMessage) responsedMessage;
                    this.f62618a.f62612a = bawuTeamSocketResponseMessage.getBawuTeamInfo();
                    this.f62618a.f62613b = bawuTeamSocketResponseMessage.isPrivateForum() != 0;
                    this.f62618a.f62614c = bawuTeamSocketResponseMessage.getManagerApplyInfo();
                }
                l lVar = new l();
                if (this.f62618a.f62614c != null) {
                    lVar.l(this.f62618a.f62614c.manager_left_num.intValue());
                    lVar.j(this.f62618a.f62614c.manager_apply_url);
                    lVar.h(this.f62618a.f62614c.assist_left_num.intValue());
                    lVar.e(this.f62618a.f62614c.assist_apply_url);
                }
                if (this.f62618a.f62615d != null) {
                    c cVar = this.f62618a.f62615d;
                    e eVar = this.f62618a;
                    cVar.a(eVar.j(eVar.f62612a), lVar, true, responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f62619a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62619a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof BawuTeamReadCacheResponseMessage)) {
                BawuTeamReadCacheResponseMessage bawuTeamReadCacheResponseMessage = (BawuTeamReadCacheResponseMessage) customResponsedMessage;
                this.f62619a.f62612a = bawuTeamReadCacheResponseMessage.getBawuTeamInfo();
                this.f62619a.f62613b = bawuTeamReadCacheResponseMessage.isPrivateForum() != 0;
                this.f62619a.f62614c = bawuTeamReadCacheResponseMessage.getManagerApplyInfo();
                l lVar = new l();
                if (this.f62619a.f62614c != null) {
                    lVar.l(this.f62619a.f62614c.manager_left_num.intValue());
                    lVar.j(this.f62619a.f62614c.manager_apply_url);
                    lVar.h(this.f62619a.f62614c.assist_left_num.intValue());
                    lVar.e(this.f62619a.f62614c.assist_apply_url);
                }
                if (this.f62619a.f62615d != null) {
                    c cVar = this.f62619a.f62615d;
                    e eVar = this.f62619a;
                    cVar.a(eVar.j(eVar.f62612a), lVar, false, customResponsedMessage.getError(), customResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(ArrayList<i> arrayList, l lVar, boolean z, int i2, String str);
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62615d = null;
        this.f62616e = new a(this, CmdConfigHttp.BAWU_TEAM_INFO_CMD, 301007);
        this.f62617f = new b(this, 2003005);
        MessageManager.getInstance().registerListener(this.f62617f);
        MessageManager.getInstance().registerListener(this.f62616e);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f62616e);
            MessageManager.getInstance().unRegisterListener(this.f62617f);
        }
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            BawuTeamInfoReadCacheRequestMessage bawuTeamInfoReadCacheRequestMessage = new BawuTeamInfoReadCacheRequestMessage();
            bawuTeamInfoReadCacheRequestMessage.setCacheKey("" + j);
            MessageManager.getInstance().sendMessage(bawuTeamInfoReadCacheRequestMessage);
        }
    }

    public void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            BawuTeamRequestMessage bawuTeamRequestMessage = new BawuTeamRequestMessage();
            bawuTeamRequestMessage.setForumId(j);
            MessageManager.getInstance().sendMessage(bawuTeamRequestMessage);
        }
    }

    public ArrayList<i> j(BawuTeam bawuTeam) {
        InterceptResult invokeL;
        List<BawuRoleDes> list;
        List<BawuRoleInfoPub> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bawuTeam)) == null) {
            ArrayList<i> arrayList = new ArrayList<>();
            if (bawuTeam == null || (list = bawuTeam.bawu_team_list) == null) {
                return null;
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                BawuRoleDes bawuRoleDes = bawuTeam.bawu_team_list.get(i2);
                if (bawuRoleDes != null && !StringUtils.isNull(bawuRoleDes.role_name) && (list2 = bawuRoleDes.role_info) != null && list2.size() > 0) {
                    d.a.q0.s0.a.c cVar = new d.a.q0.s0.a.c();
                    cVar.c(bawuRoleDes.role_name + "(" + bawuRoleDes.role_info.size() + SmallTailInfo.EMOTION_SUFFIX);
                    arrayList.add(cVar);
                    int size2 = bawuRoleDes.role_info.size();
                    int i3 = 0;
                    while (i3 < size2) {
                        d.a.q0.s0.a.b bVar = new d.a.q0.s0.a.b();
                        bVar.i(bawuRoleDes.role_name);
                        ArrayList<BawuRoleInfoPub> arrayList2 = new ArrayList<>();
                        arrayList2.add(bawuRoleDes.role_info.get(i3));
                        int i4 = i3 + 1;
                        if (i4 < size2) {
                            arrayList2.add(bawuRoleDes.role_info.get(i4));
                        }
                        i3 += 2;
                        if (i3 >= size2) {
                            if (this.f62613b) {
                                bVar.f(false);
                            } else {
                                bVar.f(true);
                            }
                            bVar.g(true);
                        } else {
                            bVar.g(false);
                        }
                        bVar.h(arrayList2);
                        arrayList.add(bVar);
                    }
                    if (i2 <= size - 2) {
                        arrayList.add(new d.a.q0.s0.a.a());
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void k(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f62615d = cVar;
        }
    }
}
