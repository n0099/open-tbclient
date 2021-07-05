package d.a.s0.h3;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f61182a;

    /* renamed from: b  reason: collision with root package name */
    public a f61183b;

    /* loaded from: classes9.dex */
    public interface a {
        void a(String str, long j);

        void b(String str, long j);
    }

    /* loaded from: classes9.dex */
    public static class b extends BdAsyncTask<Integer, Integer, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f61184a;

        /* renamed from: b  reason: collision with root package name */
        public String f61185b;

        /* renamed from: c  reason: collision with root package name */
        public long f61186c;

        /* renamed from: d  reason: collision with root package name */
        public String f61187d;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f61188e;

        /* renamed from: f  reason: collision with root package name */
        public int f61189f;

        /* renamed from: g  reason: collision with root package name */
        public String f61190g;

        public b(String str, long j, String str2, a aVar, f0 f0Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j), str2, aVar, f0Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61184a = null;
            this.f61185b = null;
            this.f61186c = 0L;
            this.f61188e = null;
            new WeakReference(f0Var);
            this.f61185b = str;
            this.f61186c = j;
            this.f61188e = new WeakReference<>(aVar);
            this.f61187d = str2;
            this.f61190g = str3;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Integer doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                try {
                    if (this.f61186c != 0 && this.f61185b != null) {
                        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
                        this.f61184a = netWork;
                        netWork.addPostData("fid", String.valueOf(this.f61186c));
                        this.f61184a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f61185b);
                        this.f61184a.addPostData("favo_type", "1");
                        this.f61184a.addPostData("st_type", this.f61187d);
                        this.f61184a.addPostData("authsid", this.f61190g);
                        this.f61184a.getNetContext().getRequest().mIsNeedTbs = true;
                        String postNetData = this.f61184a.postNetData();
                        if (!d.a.c.e.p.k.isEmpty(postNetData)) {
                            JSONObject jSONObject = new JSONObject(postNetData);
                            this.f61189f = jSONObject.optInt("error_code");
                            jSONObject.optString("error_msg");
                            AuthTokenData.parse(jSONObject);
                        }
                        if (this.f61184a.getNetContext().getResponse().isRequestSuccess()) {
                            return 1;
                        }
                    }
                    return 0;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return 0;
                }
            }
            return (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            NetWork netWork;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, num) == null) {
                super.onPostExecute((b) num);
                if (this.f61188e != null) {
                    d.a.s0.h3.q0.e eVar = new d.a.s0.h3.q0.e();
                    eVar.f61442a = this.f61186c;
                    a aVar = this.f61188e.get();
                    if (aVar == null) {
                        return;
                    }
                    if (num.intValue() == 1 && (netWork = this.f61184a) != null && netWork.getNetContext().getResponse().isRequestSuccess()) {
                        TbadkCoreApplication.getInst().delLikeForum(this.f61185b);
                        aVar.b(this.f61185b, this.f61186c);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(this.f61186c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.f61185b));
                        eVar.f61443b = true;
                    } else {
                        eVar.f61443b = false;
                        NetWork netWork2 = this.f61184a;
                        if (netWork2 != null) {
                            String errorString = netWork2.isNetSuccess() ? this.f61184a.getErrorString() : this.f61184a.getNetException();
                            eVar.f61444c = errorString;
                            aVar.a(errorString, this.f61189f);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001438, eVar));
                }
            }
        }
    }

    public f0() {
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
        this.f61182a = BarDetailForDirSwitch.BAR_DETAIL_DIR;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f61182a = str;
        }
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f61183b = aVar;
        }
    }

    public void c(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j) == null) {
            new b(str, j, this.f61182a, this.f61183b, this, null).execute(new Integer[0]);
        }
    }
}
