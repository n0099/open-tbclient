package d.a.r0.s.e;

import android.app.Activity;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56517a;

    /* renamed from: b  reason: collision with root package name */
    public b f56518b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.a.e f56519c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56520d;

    /* renamed from: d.a.r0.s.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class C1272a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<Integer, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f56521a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f56522b;

        /* renamed from: c  reason: collision with root package name */
        public String f56523c;

        /* renamed from: d  reason: collision with root package name */
        public String f56524d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f56525e;

        /* renamed from: f  reason: collision with root package name */
        public String f56526f;

        /* renamed from: g  reason: collision with root package name */
        public BdUniqueId f56527g;

        /* renamed from: h  reason: collision with root package name */
        public String f56528h;

        /* renamed from: i  reason: collision with root package name */
        public String f56529i;
        public boolean j;
        public String k;
        public final /* synthetic */ a l;

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
            this.l = aVar;
            this.f56521a = null;
            this.f56525e = false;
            this.f56526f = "0";
            this.f56528h = "0";
            this.f56529i = null;
            this.j = false;
        }

        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f56522b = z;
            }
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f56529i = str;
                if (str != null) {
                    this.j = true;
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.f56521a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.f56521a = null;
                }
                if (this.l.f56518b != null) {
                    this.l.f56518b.cancel();
                    this.l.f56518b = null;
                }
                if (this.l.f56519c != null) {
                    this.l.f56519c.c(Boolean.FALSE);
                }
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f56526f = str;
            }
        }

        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.f56528h = str;
            }
        }

        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
                this.f56525e = z;
            }
        }

        public void g(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
                this.f56527g = bdUniqueId;
            }
        }

        public void h(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                this.f56523c = str;
            }
        }

        public void i(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                this.f56524d = str;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, numArr)) == null) {
                try {
                    if (this.f56523c != null) {
                        NetWork netWork = new NetWork();
                        this.f56521a = netWork;
                        if (this.f56522b) {
                            netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.FOLLOW_ADDRESS);
                            this.f56521a.setNeedSig(true);
                        } else {
                            netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.UNFOLLOW_ADDRESS);
                        }
                        this.f56521a.addPostData("portrait", this.f56523c);
                        if (!StringUtils.isNull(this.f56526f)) {
                            this.f56521a.addPostData("from_type", this.f56526f);
                        }
                        if (!StringUtils.isNull(this.f56529i)) {
                            this.f56521a.addPostData("forum_id", this.f56529i);
                        }
                        this.f56521a.addPostData("in_live", this.f56528h);
                        this.f56521a.addPostData("authsid", this.k);
                        this.f56521a.getNetContext().getRequest().mIsNeedTbs = true;
                        String postNetData = this.f56521a.postNetData();
                        AuthTokenData.parse(postNetData);
                        return postNetData;
                    }
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
                super.onPostExecute((b) str);
                this.l.f56518b = null;
                if (this.f56521a != null) {
                    UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                    aVar.f12800a = this.f56521a.getNetContext().getResponse().isRequestSuccess();
                    aVar.f12801b = this.f56521a.getErrorString();
                    aVar.f12803d = this.f56522b;
                    aVar.f12802c = this.f56524d;
                    aVar.f12805f = this.f56525e;
                    aVar.j = this.l.f56520d;
                    aVar.b(str, this.j);
                    if (this.f56521a.getNetContext().getResponse().isRequestSuccess()) {
                        aVar.l = null;
                    }
                    int serverErrorCode = this.f56521a.getServerErrorCode();
                    if (AntiHelper.a(this.l.i(), serverErrorCode, aVar.k) || d.a.s0.r3.a.a(this.l.i(), serverErrorCode, this.f56521a.getErrorString())) {
                        return;
                    }
                    UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                    updateAttentionMessage.setOrginalMessage(new CustomMessage(2001000, this.f56527g));
                    MessageManager.getInstance().dispatchResponsedMessageToUI(updateAttentionMessage);
                    if (this.f56522b && serverErrorCode == 0) {
                        a aVar2 = this.l;
                        boolean[] h2 = aVar2.h(aVar2.f56517a);
                        if (h2 != null) {
                            if (h2[0] || h2[1]) {
                                d.a.r0.s.h.a.f(this.l.f56517a, h2, 1);
                            }
                        }
                    }
                }
            }
        }

        public /* synthetic */ b(a aVar, C1272a c1272a) {
            this(aVar);
        }
    }

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56517a = tbPageContext;
    }

    public void g() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f56518b) == null) {
            return;
        }
        bVar.cancel();
    }

    public final boolean[] h(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext)) == null) {
            boolean[] zArr = null;
            String localClassName = (tbPageContext == null || tbPageContext.getPageActivity() == null) ? null : tbPageContext.getPageActivity().getLocalClassName();
            if (("pb.pb.main.PbActivity".equals(localClassName) || "personPolymeric.PersonPolymericActivity".equals(localClassName) || "enterForum.hotuserrank.HotUserRankActivity".equals(localClassName)) && d.a.r0.r.d0.b.j().g("first_call_attention", true)) {
                d.a.r0.r.d0.b.j().t("first_call_attention", false);
                zArr = new boolean[]{!NotificationManagerCompat.from(this.f56517a.getPageActivity()).areNotificationsEnabled(), !d.a.r0.s.d.d.d().s()};
                if (!zArr[0] && !zArr[1] && tbPageContext != null && !this.f56520d) {
                    tbPageContext.showToast(R.string.attention_success);
                }
            } else if (tbPageContext != null && !this.f56520d) {
                tbPageContext.showToast(R.string.attention_success);
            }
            return zArr;
        }
        return (boolean[]) invokeL.objValue;
    }

    public Activity i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TbPageContext tbPageContext = this.f56517a;
            if (tbPageContext != null) {
                return tbPageContext.getPageActivity();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f56520d = z;
        }
    }

    public void k(d.a.c.a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f56519c = eVar;
        }
    }

    public void l(boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, str2, bdUniqueId}) == null) {
            m(z, str, str2, false, "0", bdUniqueId, null, "0");
        }
    }

    public void m(boolean z, String str, String str2, boolean z2, String str3, BdUniqueId bdUniqueId, String str4, String str5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), str, str2, Boolean.valueOf(z2), str3, bdUniqueId, str4, str5}) == null) && this.f56518b == null) {
            b bVar = new b(this, null);
            this.f56518b = bVar;
            bVar.setPriority(2);
            this.f56518b.b(z);
            this.f56518b.h(str);
            this.f56518b.i(str2);
            this.f56518b.f(z2);
            this.f56518b.d(str3);
            this.f56518b.g(bdUniqueId);
            this.f56518b.c(str4);
            this.f56518b.e(str5);
            this.f56518b.execute(new Integer[0]);
        }
    }
}
