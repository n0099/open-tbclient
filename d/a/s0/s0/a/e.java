package d.a.s0.s0.a;

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
import d.a.s0.s0.c.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BawuRoleDes;
import tbclient.BawuRoleInfoPub;
import tbclient.BawuTeam;
import tbclient.GetBawuInfo.ManagerApplyInfo;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BawuTeam f65220a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f65221b;

    /* renamed from: c  reason: collision with root package name */
    public ManagerApplyInfo f65222c;

    /* renamed from: d  reason: collision with root package name */
    public c f65223d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.c.g.a f65224e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f65225f;

    /* loaded from: classes9.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f65226a;

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
            this.f65226a = eVar;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof BawuTeamHttpResponseMessage;
            if (z || (responsedMessage instanceof BawuTeamSocketResponseMessage)) {
                if (z) {
                    BawuTeamHttpResponseMessage bawuTeamHttpResponseMessage = (BawuTeamHttpResponseMessage) responsedMessage;
                    this.f65226a.f65220a = bawuTeamHttpResponseMessage.getBawuTeamInfo();
                    this.f65226a.f65221b = bawuTeamHttpResponseMessage.isPrivateForum() != 0;
                    this.f65226a.f65222c = bawuTeamHttpResponseMessage.getManagerApplyInfo();
                } else if (responsedMessage instanceof BawuTeamSocketResponseMessage) {
                    BawuTeamSocketResponseMessage bawuTeamSocketResponseMessage = (BawuTeamSocketResponseMessage) responsedMessage;
                    this.f65226a.f65220a = bawuTeamSocketResponseMessage.getBawuTeamInfo();
                    this.f65226a.f65221b = bawuTeamSocketResponseMessage.isPrivateForum() != 0;
                    this.f65226a.f65222c = bawuTeamSocketResponseMessage.getManagerApplyInfo();
                }
                l lVar = new l();
                if (this.f65226a.f65222c != null) {
                    lVar.l(this.f65226a.f65222c.manager_left_num.intValue());
                    lVar.j(this.f65226a.f65222c.manager_apply_url);
                    lVar.h(this.f65226a.f65222c.assist_left_num.intValue());
                    lVar.e(this.f65226a.f65222c.assist_apply_url);
                }
                if (this.f65226a.f65223d != null) {
                    c cVar = this.f65226a.f65223d;
                    e eVar = this.f65226a;
                    cVar.a(eVar.j(eVar.f65220a), lVar, true, responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f65227a;

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
            this.f65227a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof BawuTeamReadCacheResponseMessage)) {
                BawuTeamReadCacheResponseMessage bawuTeamReadCacheResponseMessage = (BawuTeamReadCacheResponseMessage) customResponsedMessage;
                this.f65227a.f65220a = bawuTeamReadCacheResponseMessage.getBawuTeamInfo();
                this.f65227a.f65221b = bawuTeamReadCacheResponseMessage.isPrivateForum() != 0;
                this.f65227a.f65222c = bawuTeamReadCacheResponseMessage.getManagerApplyInfo();
                l lVar = new l();
                if (this.f65227a.f65222c != null) {
                    lVar.l(this.f65227a.f65222c.manager_left_num.intValue());
                    lVar.j(this.f65227a.f65222c.manager_apply_url);
                    lVar.h(this.f65227a.f65222c.assist_left_num.intValue());
                    lVar.e(this.f65227a.f65222c.assist_apply_url);
                }
                if (this.f65227a.f65223d != null) {
                    c cVar = this.f65227a.f65223d;
                    e eVar = this.f65227a;
                    cVar.a(eVar.j(eVar.f65220a), lVar, false, customResponsedMessage.getError(), customResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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
        this.f65223d = null;
        this.f65224e = new a(this, CmdConfigHttp.BAWU_TEAM_INFO_CMD, 301007);
        this.f65225f = new b(this, 2003005);
        MessageManager.getInstance().registerListener(this.f65225f);
        MessageManager.getInstance().registerListener(this.f65224e);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f65224e);
            MessageManager.getInstance().unRegisterListener(this.f65225f);
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
                    d.a.s0.s0.a.c cVar = new d.a.s0.s0.a.c();
                    cVar.c(bawuRoleDes.role_name + "(" + bawuRoleDes.role_info.size() + SmallTailInfo.EMOTION_SUFFIX);
                    arrayList.add(cVar);
                    int size2 = bawuRoleDes.role_info.size();
                    int i3 = 0;
                    while (i3 < size2) {
                        d.a.s0.s0.a.b bVar = new d.a.s0.s0.a.b();
                        bVar.i(bawuRoleDes.role_name);
                        ArrayList<BawuRoleInfoPub> arrayList2 = new ArrayList<>();
                        arrayList2.add(bawuRoleDes.role_info.get(i3));
                        int i4 = i3 + 1;
                        if (i4 < size2) {
                            arrayList2.add(bawuRoleDes.role_info.get(i4));
                        }
                        i3 += 2;
                        if (i3 >= size2) {
                            if (this.f65221b) {
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
                        arrayList.add(new d.a.s0.s0.a.a());
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
            this.f65223d = cVar;
        }
    }
}
