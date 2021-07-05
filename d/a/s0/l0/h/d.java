package d.a.s0.l0.h;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.e0.c;
import d.a.s0.l0.d.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class d implements d.a.s0.e0.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public EnterForumModel f62868a;

    /* renamed from: b  reason: collision with root package name */
    public c.a f62869b;

    /* renamed from: c  reason: collision with root package name */
    public final EnterForumModel.f f62870c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.c.c.g.a f62871d;

    /* loaded from: classes9.dex */
    public class a implements EnterForumModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f62872a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62872a = dVar;
        }

        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.f
        public void a(EnterForumModel.e eVar) {
            d.a.s0.l0.d.d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || this.f62872a.f62869b == null) {
                return;
            }
            if (eVar == null || !eVar.f14725b || (dVar = eVar.f14727d) == null || dVar.e() == null) {
                this.f62872a.f62869b.a(null, false, 1, 0);
                return;
            }
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            ArrayList<f> b2 = eVar.f14727d.e().b();
            if (ListUtils.getCount(b2) > 0) {
                Iterator<f> it = b2.iterator();
                while (it.hasNext()) {
                    f next = it.next();
                    if (next != null && !StringUtils.isNull(next.j()) && !StringUtils.isNull(next.q())) {
                        TransmitForumData transmitForumData = new TransmitForumData(Long.valueOf(next.j()).longValue(), next.q(), false, 1, next.e());
                        transmitForumData.tabItemDatas = next.w();
                        arrayList.add(transmitForumData);
                    }
                }
            }
            this.f62872a.f62869b.a(arrayList, true, 1, 0);
        }
    }

    /* loaded from: classes9.dex */
    public class b extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f62873a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f62873a = dVar;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof forumRecommendSocketResponseMessage;
                if ((z || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && this.f62873a.f62868a.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                    if (z) {
                        this.f62873a.f62868a.N((forumRecommendSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                        this.f62873a.f62868a.M((forumRecommendHttpResponseMessage) responsedMessage);
                    }
                }
            }
        }
    }

    public d() {
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
        this.f62868a = null;
        this.f62870c = new a(this);
        this.f62871d = new b(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
        EnterForumModel enterForumModel = new EnterForumModel(null);
        this.f62868a = enterForumModel;
        enterForumModel.T(this.f62870c);
        MessageManager.getInstance().registerListener(this.f62871d);
    }

    @Override // d.a.s0.e0.c
    public void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f62869b = aVar;
        }
    }

    @Override // d.a.s0.e0.c
    public void b() {
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f62869b == null || (enterForumModel = this.f62868a) == null) {
            return;
        }
        enterForumModel.H(true);
    }
}
