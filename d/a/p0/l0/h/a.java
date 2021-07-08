package d.a.p0.l0.h;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.frs.FrsPrivateCommonDialogView;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.f0.f;
import d.a.o0.r.q.p0;
import d.a.o0.r.q.p1;
import d.a.o0.r.s.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a implements d.a.o0.a0.b, d.a.o0.g0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.c.a.e A;
    public final EnterForumModel.f B;
    public f.g C;

    /* renamed from: e  reason: collision with root package name */
    public EnterForumFragment f59584e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.l0.m.b f59585f;

    /* renamed from: g  reason: collision with root package name */
    public EnterForumModel f59586g;

    /* renamed from: h  reason: collision with root package name */
    public RecentlyVisitedForumModel f59587h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.p0.p3.d f59588i;
    public d.a.o0.r.s.a j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public BaseFragmentActivity o;
    public long p;
    public boolean q;
    public LikeModel r;
    public ViewEventCenter s;
    public d.a.o0.r.f0.a t;
    public int u;
    public d.a.p0.l0.m.d v;
    public boolean w;
    public View x;
    public CustomMessageListener y;
    public d.a.c.c.g.a z;

    /* renamed from: d.a.p0.l0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1519a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59589e;

        public C1519a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59589e = aVar;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f59589e.j = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59590e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59590e = aVar;
        }

        @Override // d.a.o0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                EnterForumDelegateStatic.f14669c.C();
                this.f59590e.f59586g.H(!StringUtils.isNull(this.f59590e.n));
                this.f59590e.f59587h.LoadData();
                this.f59590e.f59586g.U(true);
                TbadkCoreApplication.getInst().setLikeBarChanged(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f59591a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f59592b;

        public c(a aVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59591a = str;
            this.f59592b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                if (TextUtils.isEmpty(this.f59591a)) {
                    return null;
                }
                d.a.p0.i1.t.d.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f59591a), this.f59592b);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f59593a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f59593a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f59593a.m = true;
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f59594a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f59594a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f59594a.f59585f != null && this.f59594a.f59585f.F()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements CustomMessageTask.CustomRunnable<p0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59595e;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59595e = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<p0> run(CustomMessage<p0> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                p0 p0Var = new p0();
                ArrayList arrayList = new ArrayList();
                if (this.f59595e.f59586g != null && this.f59595e.f59586g.A() != null && this.f59595e.f59586g.A().e() != null && ListUtils.getCount(this.f59595e.f59586g.A().e().b()) > 0) {
                    Iterator<d.a.p0.l0.d.f> it = this.f59595e.f59586g.A().e().b().iterator();
                    while (it.hasNext()) {
                        d.a.p0.l0.d.f next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(d.a.c.e.m.b.f(next.j(), 0L));
                            hotTopicBussinessData.setForumName(next.q());
                            hotTopicBussinessData.setForumAvatar(next.e());
                            arrayList.add(hotTopicBussinessData);
                        }
                    }
                    p0Var.a(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, p0Var);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class g extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f59596a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(a aVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f59596a = aVar;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof forumRecommendSocketResponseMessage;
                if ((z || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && this.f59596a.f59586g.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                    this.f59596a.f59585f.G();
                    if (responsedMessage.hasError()) {
                        if (this.f59596a.f59585f.S()) {
                            this.f59596a.f59585f.w0(this.f59596a.x);
                            return;
                        }
                        return;
                    }
                    if (z) {
                        this.f59596a.f59586g.N((forumRecommendSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                        this.f59596a.f59586g.M((forumRecommendHttpResponseMessage) responsedMessage);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.l0.d.f f59597e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f59598f;

        public h(a aVar, d.a.p0.l0.d.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59598f = aVar;
            this.f59597e = fVar;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!d.a.c.e.p.l.D()) {
                    this.f59598f.o.showToast(R.string.delete_like_fail);
                } else {
                    new n(this.f59598f, this.f59597e).execute(new d.a.p0.l0.d.f[0]);
                }
                TiebaStatic.eventStat(this.f59598f.o.getPageContext().getPageActivity(), "recom_flist_unlike", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f59599a;

        public j(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59599a = aVar;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (AntiHelper.m(this.f59599a.r.getErrorCode(), this.f59599a.r.getErrorString())) {
                    AntiHelper.u(this.f59599a.o.getPageContext().getPageActivity(), this.f59599a.r.getErrorString());
                } else if (obj != null) {
                    this.f59599a.f59586g.H(!StringUtils.isNull(this.f59599a.n));
                } else if (StringUtils.isNull(this.f59599a.r.getErrorString())) {
                } else {
                    d.a.c.e.p.l.M(TbadkCoreApplication.getInst(), this.f59599a.r.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements EnterForumModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f59600a;

        public k(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59600a = aVar;
        }

        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.f
        public void a(EnterForumModel.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null || this.f59600a.f59584e == null) {
                return;
            }
            if (eVar.f14765c == 1) {
                this.f59600a.f59585f.G();
            }
            if (eVar.f14764b) {
                int i2 = eVar.f14765c;
                if (i2 == 1) {
                    this.f59600a.l = true;
                    d.a.p0.l0.d.d dVar = eVar.f14766d;
                    this.f59600a.M(dVar);
                    if (dVar.h() > 0) {
                        d.a.o0.r.d0.b.j().v("key_LIKE_forum_sort_state", dVar.h());
                    }
                } else if (i2 == 0 && !this.f59600a.l) {
                    d.a.p0.l0.d.d dVar2 = eVar.f14766d;
                    this.f59600a.f59586g.S(dVar2);
                    this.f59600a.M(dVar2);
                }
            } else {
                String str = eVar.f14763a;
                if (str != null && !str.equals("")) {
                    this.f59600a.o.showToast(eVar.f14763a);
                    this.f59600a.f59585f.a0(d.a.o0.r.d0.b.j().k("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
            }
            if (eVar.f14765c == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && this.f59600a.G()) {
                TbadkCoreApplication.getInst().setIsNewRegUser(false);
            }
            if (eVar.f14765c == 1 && this.f59600a.p > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                TiebaStatic.page(TiebaStatic.OpKey.OP_FORUM_ENTER, currentTimeMillis - this.f59600a.p, this.f59600a.f59586g.C() - this.f59600a.p, this.f59600a.f59586g.E(), this.f59600a.f59586g.D(), currentTimeMillis - this.f59600a.f59586g.B());
                this.f59600a.p = -1L;
            }
            String string = this.f59600a.o.getResources().getString(R.string.enter_forum_search_tip);
            d.a.p0.l0.d.d dVar3 = eVar.f14766d;
            if (dVar3 != null && dVar3.d() != null) {
                HotSearchInfoData d2 = eVar.f14766d.d();
                d.a.o0.r.d0.b.j().x("hot_search_info", OrmObject.jsonStrWithObject(d2));
                if (d2 != null && d2.w() != null) {
                    string = d2.w();
                }
            }
            this.f59600a.T(string);
            d.a.p0.l0.d.d dVar4 = eVar.f14766d;
            if (dVar4 == null || dVar4.c() == null) {
                return;
            }
            this.f59600a.f59585f.m0(eVar.f14766d.c());
        }
    }

    /* loaded from: classes8.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.l0.d.d f59601e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f59602f;

        public l(a aVar, d.a.p0.l0.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59602f = aVar;
            this.f59601e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f59602f.o.getPageContext(), new String[]{this.f59601e.f().z()});
                this.f59602f.j.dismiss();
                this.f59602f.j = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m extends BdAsyncTask<d.a.p0.l0.d.f, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f59603a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.p0.l0.d.f f59604b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f59605c;

        public m(a aVar, d.a.p0.l0.d.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59605c = aVar;
            this.f59603a = null;
            this.f59604b = null;
            this.f59604b = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(d.a.p0.l0.d.f... fVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVarArr)) == null) {
                d.a.p0.l0.d.f fVar = this.f59604b;
                if (fVar != null) {
                    try {
                        if (fVar.j() == null || fVar.q() == null) {
                            return null;
                        }
                        if (fVar.o() == 0) {
                            this.f59603a = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.f59603a = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.f59603a.addPostData("forum_id", fVar.j());
                        this.f59603a.getNetContext().getRequest().mIsNeedTbs = true;
                        this.f59603a.postNetData();
                        return null;
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                        return null;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                NetWork netWork = this.f59603a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.f59603a = null;
                }
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f59605c.U(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((m) str);
                this.f59605c.U(false);
                int o = this.f59604b.o();
                NetWork netWork = this.f59603a;
                if (netWork != null) {
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        this.f59605c.q = true;
                        if (this.f59605c.f59584e.isAdded() && this.f59605c.o != null) {
                            this.f59605c.o.showToast(this.f59605c.o.getActivity().getString(o > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                        }
                        this.f59605c.f59586g.H(true);
                    } else if (this.f59605c.o == null) {
                    } else {
                        if (!StringUtils.isNull(this.f59603a.getErrorString())) {
                            this.f59605c.o.showToast(this.f59603a.getErrorString());
                        } else if (this.f59605c.f59584e.isAdded()) {
                            this.f59605c.o.showToast(this.f59605c.o.getActivity().getString(o > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n extends BdAsyncTask<d.a.p0.l0.d.f, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f59606a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.p0.l0.d.f f59607b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f59608c;

        public n(a aVar, d.a.p0.l0.d.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59608c = aVar;
            this.f59606a = null;
            this.f59607b = null;
            this.f59607b = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(d.a.p0.l0.d.f... fVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVarArr)) == null) {
                d.a.p0.l0.d.f fVar = this.f59607b;
                if (fVar != null) {
                    try {
                        if (fVar.j() == null || fVar.q() == null) {
                            return null;
                        }
                        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.f59606a = netWork;
                        netWork.addPostData("fid", fVar.j());
                        this.f59606a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, fVar.q());
                        this.f59606a.getNetContext().getRequest().mIsNeedTbs = true;
                        this.f59606a.postNetData();
                        return null;
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                        return null;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                NetWork netWork = this.f59606a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.f59606a = null;
                }
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f59608c.U(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((n) str);
                this.f59608c.U(false);
                NetWork netWork = this.f59606a;
                if (netWork != null) {
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        this.f59608c.q = true;
                        if (this.f59608c.f59584e.isAdded() && this.f59608c.o != null) {
                            this.f59608c.o.showToast(this.f59608c.o.getActivity().getString(R.string.unlike_success));
                        }
                        TbadkCoreApplication.getInst().setLikeBarChanged(true);
                        this.f59608c.Q(false, this.f59607b.j());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.f59607b.j()));
                        long f2 = d.a.c.e.m.b.f(this.f59607b.j(), 0L);
                        if (f2 > 0) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(f2)));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.f59607b.q()));
                        }
                        this.f59608c.f59585f.g0(this.f59607b, this.f59608c.f59586g.F());
                        this.f59608c.f59586g.K(this.f59607b);
                    } else if (this.f59608c.o == null) {
                    } else {
                        if (!StringUtils.isNull(this.f59606a.getErrorString())) {
                            this.f59608c.o.showToast(this.f59606a.getErrorString());
                        } else if (this.f59608c.f59584e.isAdded()) {
                            this.f59608c.o.showToast(this.f59608c.o.getActivity().getString(R.string.delete_like_fail));
                        }
                    }
                }
            }
        }
    }

    public a(EnterForumFragment enterForumFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59585f = null;
        this.f59586g = null;
        this.j = null;
        this.k = true;
        this.l = false;
        this.p = -1L;
        this.u = 1;
        this.y = new d(this, 2921032);
        this.z = new g(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
        this.A = new j(this);
        this.B = new k(this);
        this.C = new b(this);
        this.f59584e = enterForumFragment;
        this.o = enterForumFragment.getBaseFragmentActivity();
        ViewEventCenter viewEventCenter = new ViewEventCenter();
        this.s = viewEventCenter;
        viewEventCenter.addEventDelegate(this);
        d.a.p0.u0.m2.d.d();
        this.p = System.currentTimeMillis();
        this.k = true;
        this.l = false;
        this.n = "";
        this.f59586g = new EnterForumModel(this.o.getPageContext());
        this.f59587h = new RecentlyVisitedForumModel();
        this.r = new LikeModel(this.o.getPageContext());
        this.f59588i = new d.a.p0.p3.d(this.o.getPageContext());
        this.r.setLoadDataCallBack(this.A);
        this.f59586g.T(this.B);
        d.a.o0.r.d0.b.j().t("enter_forum_edit_mode", false);
        d.a.p0.l0.j.a.b().c(this.f59584e.getFragmentActivity(), d.a.c.e.p.l.r(this.f59584e.getFragmentActivity()));
        E();
        D();
        O();
    }

    public View A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.x : (View) invokeV.objValue;
    }

    public final void B() {
        d.a.o0.r.s.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.j) == null) {
            return;
        }
        aVar.dismiss();
        this.j = null;
    }

    public void C() {
        d.a.p0.l0.m.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.f59585f) == null) {
            return;
        }
        bVar.Q(this.x);
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            P();
            this.f59584e.registerListener(this.z);
            this.f59584e.registerListener(this.y);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.x = LayoutInflater.from(this.o.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
            d.a.p0.l0.m.b bVar = new d.a.p0.l0.m.b(this.f59584e, this.x, this.s, this.f59587h, this.f59586g);
            this.f59585f = bVar;
            bVar.o0(this.C);
            I(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.t = new d.a.o0.r.f0.a(this.o.getPageContext());
        }
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !this.f59584e.isHidden() : invokeV.booleanValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f59585f == null) {
            return;
        }
        x(false);
    }

    public void I(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            d.a.p0.l0.m.b bVar = this.f59585f;
            if (bVar != null) {
                bVar.W(i2);
            }
            d.a.p0.l0.m.d dVar = this.v;
            if (dVar != null) {
                dVar.r();
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            u();
            d.a.p0.l0.j.a.b().a();
            d.a.p0.l0.m.b bVar = this.f59585f;
            if (bVar != null) {
                bVar.X();
            }
            MessageManager.getInstance().unRegisterTask(2016527);
            RecentlyVisitedForumModel recentlyVisitedForumModel = this.f59587h;
            if (recentlyVisitedForumModel != null) {
                recentlyVisitedForumModel.onDestroy();
            }
            EnterForumModel enterForumModel = this.f59586g;
            if (enterForumModel != null) {
                enterForumModel.onDestroy();
            }
            ViewEventCenter viewEventCenter = this.s;
            if (viewEventCenter != null) {
                viewEventCenter.removeEventDelegate(this);
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            d.a.p0.l0.m.b bVar = this.f59585f;
            if (bVar != null && bVar.K() != null) {
                this.f59585f.K().z();
            }
            RecentlyVisitedForumModel recentlyVisitedForumModel = this.f59587h;
            if (recentlyVisitedForumModel != null) {
                recentlyVisitedForumModel.onPause();
            }
            EnterForumModel enterForumModel = this.f59586g;
            if (enterForumModel != null) {
                enterForumModel.onPause();
            }
            d.a.p0.l0.m.b bVar2 = this.f59585f;
            if (bVar2 != null) {
                bVar2.Y();
            }
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.f59584e.isAdded() && this.f59584e.isPrimary()) {
                RecentlyVisitedForumModel recentlyVisitedForumModel = this.f59587h;
                if (recentlyVisitedForumModel != null) {
                    recentlyVisitedForumModel.x();
                }
            } else {
                B();
            }
            d.a.p0.l0.m.b bVar = this.f59585f;
            if (bVar != null) {
                bVar.Z();
            }
        }
    }

    public void M(d.a.p0.l0.d.d dVar) {
        d.a.p0.l0.m.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) || (bVar = this.f59585f) == null) {
            return;
        }
        if (dVar == null) {
            bVar.w0(this.x);
            return;
        }
        d.a.p0.l0.d.g e2 = dVar.e();
        ArrayList<d.a.p0.l0.d.f> arrayList = new ArrayList<>();
        if (e2 != null) {
            arrayList = e2.b();
        }
        v(arrayList, dVar.g());
        W(dVar);
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(d.a.o0.r.d0.b.j().p("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.w() != null) {
            T(hotSearchInfoData.w());
        }
        this.f59585f.b0();
        this.f59585f.a0(dVar.h());
    }

    public void N(boolean z) {
        d.a.p0.l0.m.b bVar;
        EnterForumFragment enterForumFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (bVar = this.f59585f) == null || (enterForumFragment = this.f59584e) == null) {
            return;
        }
        if (z) {
            if (enterForumFragment.isPrimary() && this.f59584e.isResumed()) {
                this.f59585f.x0();
            } else {
                this.f59585f.G();
            }
        } else {
            bVar.G();
        }
        this.f59585f.n0(z);
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new f(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f59584e.registerListener(new e(this, 2007010));
        }
    }

    public final void Q(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048592, this, z, str) == null) {
            new c(this, str, z).execute(new Void[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void R(d.a.p0.l0.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, cVar) == null) {
            this.f59585f.j0(cVar);
            this.f59584e.O0(cVar);
        }
    }

    public void S(BdUniqueId bdUniqueId) {
        d.a.p0.l0.m.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, bdUniqueId) == null) || (bVar = this.f59585f) == null) {
            return;
        }
        bVar.q0(bdUniqueId);
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || this.f59584e.L0() == null) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f59584e.L0().U(str.trim());
        } else {
            this.f59584e.L0().U(this.o.getActivity().getString(R.string.enter_forum_search_tip));
        }
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            if (this.t == null) {
                F();
            }
            this.t.h(z);
        }
    }

    public void V(d.a.p0.l0.d.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, fVar) == null) || fVar == null) {
            return;
        }
        d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.o.getPageContext().getPageActivity());
        aVar.setMessage(String.format(this.o.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.q()));
        aVar.setPositiveButton(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new h(this, fVar));
        aVar.setNegativeButton(TbadkCoreApplication.getInst().getString(R.string.cancel), new i(this));
        aVar.setButtonTextColor(R.color.CAM_X0105);
        aVar.create(this.o.getPageContext());
        aVar.show();
    }

    public final void W(d.a.p0.l0.d.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, dVar) == null) && dVar != null && dVar.f() != null && this.f59584e.isPrimary() && this.j == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.o.getActivity());
            if (frsPrivateCommonDialogView.a(dVar.f())) {
                d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.o.getActivity());
                this.j = aVar;
                aVar.setContentViewSize(2);
                this.j.setContentView(frsPrivateCommonDialogView);
                this.j.setCanceledOnTouchOutside(false);
                frsPrivateCommonDialogView.setConfirmButton(new l(this, dVar));
                this.j.setCloseButton(new C1519a(this));
                this.j.create(this.o.getPageContext()).show();
            }
        }
    }

    @Override // d.a.o0.a0.b
    public void a(d.a.c.k.d.a aVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048599, this, aVar, str, z) != null) || aVar == null) {
        }
    }

    @Override // d.a.o0.g0.c.a
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.o.getUniqueId() : (BdUniqueId) invokeV.objValue;
    }

    @Override // d.a.o0.g0.c.a
    public boolean isEventMustSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.o0.g0.c.a
    public boolean onEventDispatch(d.a.o0.g0.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, bVar)) == null) {
            int b2 = bVar.b();
            d.a.o0.g0.b.a a2 = bVar.a();
            switch (b2) {
                case 1:
                    if (this.u == 2 || !(a2 instanceof d.a.p0.l0.d.f)) {
                        return false;
                    }
                    d.a.p0.l0.d.f fVar = (d.a.p0.l0.d.f) a2;
                    String q = fVar.q();
                    if (d.a.c.e.p.k.isForumName(q)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.o.getPageContext().getPageActivity()).createNormalCfg(q, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object c2 = bVar.c();
                        if (c2 instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (fVar.t() && TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 2);
                                Bundle bundle = (Bundle) c2;
                                intent.putExtra("info_forum_image_rect", bundle.getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", fVar.e());
                                intent.putExtra("info_forum_name_rect", bundle.getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", q);
                                intent.putExtra("info_forum_head_background_color", fVar.x());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (fVar.z().night != null && fVar.z().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", fVar.z().night.pattern_image);
                                    }
                                } else if (fVar.z().day != null && fVar.z().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", fVar.z().day.pattern_image);
                                }
                            } else {
                                intent.putExtra("transition_type", 0);
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, fVar.h());
                            fVar.I(0L);
                        }
                        this.o.sendMessage(new CustomMessage(2003000, callFrom));
                        if (this.o.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(q)) {
                            StatisticItem statisticItem = new StatisticItem("c12888");
                            TiebaStaticHelper.addYYParam(statisticItem);
                            TiebaStatic.log(statisticItem);
                        }
                        TiebaStatic.log(new StatisticItem("c13368").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", this.f59586g.A().h() != 1 ? 1 : 2).param("fid", fVar.j()));
                        return true;
                    }
                    break;
                case 2:
                    if (this.u == 2) {
                        return false;
                    }
                    if (d.a.o0.r.d0.b.j().g("enter_forum_edit_mode", false)) {
                        return true;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                    d.a.o0.r.d0.b.j().t("enter_forum_edit_mode", true);
                    if (this.f59584e.getView() != null && this.f59584e.getView().getParent() != null) {
                        this.f59584e.getView().getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                case 3:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                    d.a.o0.r.d0.b.j().t("enter_forum_edit_mode", false);
                    return true;
                case 4:
                    if (a2 instanceof d.a.p0.l0.d.f) {
                        V((d.a.p0.l0.d.f) a2);
                        return true;
                    }
                    return false;
                case 6:
                    if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity(this.o.getActivity());
                        return true;
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        TiebaStatic.eventStat(this.o.getPageContext().getPageActivity(), "notlogin_6", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    }
                    TiebaStatic.log(new StatisticItem("find_more_text_click"));
                    return true;
                case 7:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(this.o.getPageContext().getPageActivity())));
                    if (!TbadkCoreApplication.isLogin()) {
                        TiebaStatic.eventStat(this.o.getPageContext().getPageActivity(), "notlogin_8", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    }
                    TiebaStatic.log(new StatisticItem("c13367").param("obj_location", "1"));
                    return true;
                case 8:
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).param("obj_type", "2").param("obj_locate", 1));
                    this.o.finish();
                    return true;
                case 9:
                    d.a.p0.l0.m.b bVar2 = this.f59585f;
                    if (bVar2 != null) {
                        bVar2.x0();
                    }
                    return true;
                case 10:
                    this.u = 2;
                    return true;
                case 11:
                    this.u = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                    return true;
                case 12:
                    if (this.u == 2) {
                        return true;
                    }
                    if (this.v == null) {
                        this.v = new d.a.p0.l0.m.d(this.o.getPageContext(), this.s);
                    }
                    if (a2 instanceof d.a.p0.l0.d.f) {
                        this.v.s((d.a.p0.l0.d.f) a2);
                        this.v.l();
                    }
                    return true;
                case 13:
                    if (a2 instanceof d.a.p0.l0.d.f) {
                        d.a.p0.l0.d.f fVar2 = (d.a.p0.l0.d.f) a2;
                        new m(this, fVar2).execute(new d.a.p0.l0.d.f[0]);
                        TiebaStatic.log(new StatisticItem("c13370").param("obj_type", fVar2.o() <= 0 ? 1 : 2).param("fid", fVar2.j()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                        return true;
                    }
                    return false;
                case 14:
                    UrlManager.getInstance().dealOneLink(this.o.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                    return true;
                case 15:
                    if (!this.f59588i.d() && (a2 instanceof d.a.p0.l0.d.f)) {
                        UrlManager.getInstance().dealOneLink(this.o.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((d.a.p0.l0.d.f) a2).j() + "&nomenu=1"});
                    }
                    return true;
                case 16:
                    R((d.a.p0.l0.d.c) bVar.d());
                    break;
                case 17:
                    R((d.a.p0.l0.d.c) bVar.d());
                    break;
                case 18:
                    R((d.a.p0.l0.d.c) bVar.d());
                    break;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void u() {
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (enterForumModel = this.f59586g) == null) {
            return;
        }
        enterForumModel.cancelLoadData();
    }

    public final void v(List<d.a.p0.l0.d.f> list, p1 p1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048604, this, list, p1Var) == null) || list == null) {
            return;
        }
        if (list.size() > 500) {
            list = list.subList(0, 500);
        }
        this.f59585f.e0(this.f59586g.V(list, d.a.o0.z0.f.a()), p1Var, this.f59586g.F());
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048605, this, z) == null) || this.f59585f == null || this.f59584e == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(z ? 1 : 0)));
    }

    public void x(boolean z) {
        boolean z2;
        boolean z3;
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || this.w || this.f59586g == null || this.f59585f == null) {
            return;
        }
        String str = this.n;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.n = currentAccount;
        if (this.k) {
            this.k = false;
            z2 = false;
            z3 = true;
        } else {
            z2 = (currentAccount == null || currentAccount.equals(str)) ? false : true;
            z3 = false;
        }
        if (TbadkCoreApplication.getInst().getLikeBarChanged()) {
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
            z2 = true;
        }
        if (z) {
            z2 = true;
        }
        if (TbadkCoreApplication.getInst().signedForumCount() > 0) {
            EnterForumModel enterForumModel2 = this.f59586g;
            if (enterForumModel2 != null && enterForumModel2.A() != null && this.f59586g.A().e() != null) {
                Iterator<d.a.p0.l0.d.f> it = this.f59586g.A().e().b().iterator();
                while (it.hasNext()) {
                    d.a.p0.l0.d.f next = it.next();
                    if (TbadkCoreApplication.getInst().hasSignedForum(next.q())) {
                        next.J(1);
                        int signLevelUpValue = TbadkCoreApplication.getInst().getSignLevelUpValue(next.q());
                        if (signLevelUpValue > 0) {
                            next.K(signLevelUpValue);
                        }
                    }
                }
            }
            TbadkCoreApplication.getInst().clearSignedForum();
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount2 != null && currentAccount2.length() > 0) {
                d.a.p0.h3.n0.a.g(currentAccount2);
            }
            this.f59585f.V(this.f59586g.F());
        }
        if (z3 || z2) {
            u();
            if (z2) {
                EnterForumModel enterForumModel3 = this.f59586g;
                if (enterForumModel3 != null) {
                    enterForumModel3.G(!StringUtils.isNull(this.n));
                }
                this.f59587h.LoadData();
            } else if (!z3 || (enterForumModel = this.f59586g) == null) {
            } else {
                enterForumModel.G(!StringUtils.isNull(this.n));
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || this.f59585f == null) {
            return;
        }
        x(true);
    }

    public d.a.p0.l0.m.b z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f59585f : (d.a.p0.l0.m.b) invokeV.objValue;
    }
}
