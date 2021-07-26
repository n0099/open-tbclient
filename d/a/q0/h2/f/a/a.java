package d.a.q0.h2.f.a;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.pb.account.forbid.ForbidResultData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f57331a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.h2.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1411a extends BdAsyncTask<String, Object, ForbidResultData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f57332a;

        /* renamed from: b  reason: collision with root package name */
        public String f57333b;

        /* renamed from: c  reason: collision with root package name */
        public String f57334c;

        /* renamed from: d  reason: collision with root package name */
        public String f57335d;

        /* renamed from: e  reason: collision with root package name */
        public String f57336e;

        /* renamed from: f  reason: collision with root package name */
        public String f57337f;

        /* renamed from: g  reason: collision with root package name */
        public String f57338g;

        /* renamed from: h  reason: collision with root package name */
        public String f57339h;

        /* renamed from: i  reason: collision with root package name */
        public String f57340i;
        public WeakReference<b> j;

        public C1411a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, str4, str5, str6, str7, str8, str9, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57332a = str;
            this.f57333b = str2;
            this.f57334c = str3;
            this.f57335d = str4;
            this.f57338g = str6;
            this.f57336e = str8;
            this.f57337f = str9;
            this.f57339h = str7;
            this.f57340i = str5;
            this.j = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForbidResultData doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                NetWork netWork = new NetWork(a.f57331a);
                netWork.addPostData(Config.TRACE_VISIT_RECENT_DAY, this.f57338g);
                netWork.addPostData("un", this.f57335d);
                netWork.addPostData("fid", this.f57332a);
                netWork.addPostData("word", this.f57333b);
                netWork.addPostData("z", this.f57334c);
                netWork.addPostData("reason", this.f57339h);
                netWork.addPostData("ntn", "banid");
                netWork.addPostData("post_id", this.f57340i);
                netWork.addPostData("nick_name", this.f57336e);
                netWork.addPostData("portrait", this.f57337f);
                netWork.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = netWork.postNetData();
                if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                    try {
                        return (ForbidResultData) OrmObject.objectWithJsonStr(postNetData, ForbidResultData.class);
                    } catch (Exception e2) {
                        BdLog.detailException(e2);
                        ForbidResultData forbidResultData = new ForbidResultData();
                        forbidResultData.error_code = -1000;
                        return forbidResultData;
                    }
                }
                ForbidResultData forbidResultData2 = new ForbidResultData();
                forbidResultData2.error_code = netWork.getServerErrorCode();
                forbidResultData2.error_msg = netWork.getErrorString();
                return forbidResultData2;
            }
            return (ForbidResultData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidResultData forbidResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forbidResultData) == null) {
                super.onPostExecute(forbidResultData);
                b bVar = this.j.get();
                if (bVar != null) {
                    if (forbidResultData.error_code == 0 && k.isEmpty(forbidResultData.error_msg)) {
                        bVar.a(forbidResultData);
                    } else {
                        bVar.b(forbidResultData);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(ForbidResultData forbidResultData);

        void b(ForbidResultData forbidResultData);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(74327403, "Ld/a/q0/h2/f/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(74327403, "Ld/a/q0/h2/f/a/a;");
                return;
            }
        }
        f57331a = TbConfig.SERVER_ADDRESS + TbConfig.FORBID_USER_ADDRESS;
    }

    public static void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9, bVar}) == null) {
            new C1411a(str, str2, str3, str4, str5, str6, str7, str8, str9, bVar).execute(new String[0]);
        }
    }
}
