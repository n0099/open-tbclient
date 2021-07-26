package d.a.q0.h2.f.a;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.pb.account.forbid.ForbidTplData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f57341a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f57342a;

        /* renamed from: b  reason: collision with root package name */
        public String f57343b;

        /* renamed from: c  reason: collision with root package name */
        public InterfaceC1412b f57344c;

        public a(String str, String str2, InterfaceC1412b interfaceC1412b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, interfaceC1412b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57342a = str;
            this.f57343b = str2;
            this.f57344c = interfaceC1412b;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForbidTplData doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                NetWork netWork = new NetWork(b.f57341a);
                netWork.addPostData("forum_id", this.f57342a);
                netWork.addPostData("user_id", this.f57343b);
                String postNetData = netWork.postNetData();
                if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                    try {
                        return (ForbidTplData) OrmObject.objectWithJsonStr(postNetData, ForbidTplData.class);
                    } catch (Exception e2) {
                        BdLog.detailException(e2);
                        ForbidTplData forbidTplData = new ForbidTplData();
                        forbidTplData.error.errno = -1000;
                        return forbidTplData;
                    }
                }
                ForbidTplData forbidTplData2 = new ForbidTplData();
                forbidTplData2.error.errno = netWork.getServerErrorCode();
                forbidTplData2.error.errMsg = netWork.getErrorString();
                return forbidTplData2;
            }
            return (ForbidTplData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forbidTplData) == null) {
                super.onPostExecute(forbidTplData);
                if (this.f57344c != null) {
                    ForbidTplData.ErrorInfo errorInfo = forbidTplData.error;
                    if (errorInfo.errno == 0 && k.isEmpty(errorInfo.errMsg)) {
                        this.f57344c.b(forbidTplData);
                    } else {
                        this.f57344c.a(forbidTplData);
                    }
                }
            }
        }
    }

    /* renamed from: d.a.q0.h2.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1412b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(74327434, "Ld/a/q0/h2/f/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(74327434, "Ld/a/q0/h2/f/a/b;");
                return;
            }
        }
        f57341a = TbConfig.SERVER_ADDRESS + "c/u/bawu/listreason";
    }

    public static void b(String str, String str2, InterfaceC1412b interfaceC1412b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, interfaceC1412b) == null) {
            new a(str, str2, interfaceC1412b).execute(new String[0]);
        }
    }
}
