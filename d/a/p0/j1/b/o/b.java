package d.a.p0.j1.b.o;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.imMessageCenter.mention.agree.message.AgreeMeHTTPResponseMessage;
import com.baidu.tieba.imMessageCenter.mention.agree.message.AgreeMeRequestMessage;
import com.baidu.tieba.imMessageCenter.mention.agree.message.AgreeMeSocketResponseMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import d.a.c.e.d.l;
import d.a.c.k.e.n;
import java.util.ArrayList;
import tbclient.AgreeList;
import tbclient.AgreeMe.AgreeMeResIdl;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f59058a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f59059b;

    /* renamed from: c  reason: collision with root package name */
    public long f59060c;

    /* renamed from: d  reason: collision with root package name */
    public c f59061d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f59062e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59063f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f59064g;

    /* loaded from: classes8.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59065a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f59065a = bVar;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.hasError()) {
                if (this.f59065a.f59061d != null) {
                    this.f59065a.f59061d.onFailed(responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            boolean z = false;
            if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof AgreeMeRequestMessage) && ((AgreeMeRequestMessage) responsedMessage.getOrginalMessage().getExtra()).id == 0) {
                z = true;
            }
            if (responsedMessage instanceof AgreeMeHTTPResponseMessage) {
                AgreeMeHTTPResponseMessage agreeMeHTTPResponseMessage = (AgreeMeHTTPResponseMessage) responsedMessage;
                this.f59065a.i(agreeMeHTTPResponseMessage.datas, z);
                this.f59065a.f59063f = agreeMeHTTPResponseMessage.hasMore;
            } else if (responsedMessage instanceof AgreeMeSocketResponseMessage) {
                AgreeMeSocketResponseMessage agreeMeSocketResponseMessage = (AgreeMeSocketResponseMessage) responsedMessage;
                this.f59065a.i(agreeMeSocketResponseMessage.datas, z);
                this.f59065a.f59063f = agreeMeSocketResponseMessage.hasMore;
            }
        }
    }

    /* renamed from: d.a.p0.j1.b.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1500b extends BdAsyncTask<Void, Void, ArrayList<d.a.p0.j1.b.p.a>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59066a;

        public C1500b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59066a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ArrayList<d.a.p0.j1.b.p.a> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                ArrayList<d.a.p0.j1.b.p.a> arrayList = new ArrayList<>();
                l<byte[]> e2 = d.a.o0.r.r.a.f().e("tb_user_agreeme", TbadkCoreApplication.getCurrentAccountName());
                if (e2 == null || (bArr = e2.get("agree_me_cache_key")) == null) {
                    return arrayList;
                }
                try {
                    AgreeMeResIdl agreeMeResIdl = (AgreeMeResIdl) new Wire(new Class[0]).parseFrom(bArr, AgreeMeResIdl.class);
                    if (agreeMeResIdl.data != null) {
                        this.f59066a.f59063f = agreeMeResIdl.data.has_more.intValue() == 1;
                        for (AgreeList agreeList : agreeMeResIdl.data.agree_list) {
                            if (agreeList != null) {
                                d.a.p0.j1.b.p.a aVar = new d.a.p0.j1.b.p.a();
                                aVar.E(agreeList);
                                arrayList.add(aVar);
                            }
                        }
                        return arrayList;
                    }
                    return arrayList;
                } catch (Exception unused) {
                    return null;
                }
            }
            return (ArrayList) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ArrayList<d.a.p0.j1.b.p.a> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
                super.onPostExecute(arrayList);
                if (arrayList != null) {
                    this.f59066a.h(arrayList);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(ArrayList<n> arrayList);

        void onFailed(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1231606780, "Ld/a/p0/j1/b/o/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1231606780, "Ld/a/p0/j1/b/o/b;");
                return;
            }
        }
        d.a.p0.h3.d0.a.h(309593, AgreeMeSocketResponseMessage.class, false, false);
        d.a.p0.h3.d0.a.c(309593, CmdConfigHttp.AGREE_ME_HTTP_CMD, "c/u/feed/agreeme", AgreeMeHTTPResponseMessage.class, false, false, false, false);
    }

    public b(TbPageContext tbPageContext, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f59058a = false;
        this.f59060c = 0L;
        this.f59064g = new a(this, CmdConfigHttp.AGREE_ME_HTTP_CMD, 309593);
        if (tbPageContext != null) {
            this.f59059b = tbPageContext.getUniqueId();
            tbPageContext.registerListener(this.f59064g);
            this.f59061d = cVar;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e();
            f();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            new C1500b(this).execute(new Void[0]);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AgreeMeRequestMessage agreeMeRequestMessage = new AgreeMeRequestMessage();
            agreeMeRequestMessage.id = this.f59060c;
            agreeMeRequestMessage.setTag(this.f59059b);
            MessageManager.getInstance().sendMessage(agreeMeRequestMessage);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f();
        }
    }

    public final void h(ArrayList<d.a.p0.j1.b.p.a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) || this.f59058a) {
            return;
        }
        if (ListUtils.isEmpty(this.f59062e)) {
            this.f59062e = new ArrayList<>();
        } else {
            this.f59062e.clear();
        }
        this.f59062e.addAll(arrayList);
        ArrayList<n> arrayList2 = this.f59062e;
        n nVar = (n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
        if (nVar instanceof d.a.p0.j1.b.p.a) {
            this.f59060c = ((d.a.p0.j1.b.p.a) nVar).e();
        }
        if (this.f59061d == null || ListUtils.isEmpty(this.f59062e)) {
            return;
        }
        this.f59061d.a(this.f59062e);
    }

    public final void i(ArrayList<d.a.p0.j1.b.p.a> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, arrayList, z) == null) {
            this.f59058a = true;
            if (ListUtils.isEmpty(this.f59062e)) {
                this.f59062e = new ArrayList<>();
            }
            if (!z) {
                this.f59062e.addAll(arrayList);
            } else {
                this.f59062e.clear();
                this.f59062e.addAll(0, arrayList);
            }
            ArrayList<n> arrayList2 = this.f59062e;
            n nVar = (n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
            if (nVar instanceof d.a.p0.j1.b.p.a) {
                this.f59060c = ((d.a.p0.j1.b.p.a) nVar).e();
            }
            c cVar = this.f59061d;
            if (cVar != null) {
                cVar.a(this.f59062e);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f59060c = 0L;
            f();
        }
    }
}
