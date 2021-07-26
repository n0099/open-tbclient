package d.a.q0.n1.m;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.c.f;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes8.dex */
public class e extends d.a.p0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<Object, Integer, f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f61155a;

        /* renamed from: b  reason: collision with root package name */
        public String f61156b;

        /* renamed from: c  reason: collision with root package name */
        public String f61157c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f61158d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.d.a.e f61159e;

        public a(e eVar, String str, String str2, HashMap<String, String> hashMap, d.a.d.a.e eVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, hashMap, eVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61155a = null;
            this.f61156b = str;
            this.f61157c = str2;
            this.f61158d = hashMap;
            this.f61159e = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                f fVar = new f();
                try {
                    this.f61155a = new NetWork(TbConfig.SERVER_ADDRESS + this.f61157c);
                    Set<String> keySet = this.f61158d.keySet();
                    if (keySet.size() > 0) {
                        for (String str : keySet) {
                            if (!"url".equalsIgnoreCase(str)) {
                                this.f61155a.addPostData(str, this.f61158d.get(str));
                            }
                        }
                    }
                    this.f61155a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                    this.f61155a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                    boolean z = true;
                    this.f61155a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.f61155a.postNetData();
                    if (!this.f61155a.getNetContext().getResponse().isNetSuccess()) {
                        fVar.f52159b = this.f61155a.getNetErrorCode();
                        fVar.f52160c = this.f61155a.getNetString();
                    } else {
                        fVar.f52159b = this.f61155a.getServerErrorCode();
                        fVar.f52160c = this.f61155a.getErrorString();
                    }
                    if (this.f61155a.getNetContext().getResponse().isRequestSuccess() && postNetData != null) {
                        if (fVar.f52159b != 0) {
                            z = false;
                        }
                        fVar.f52158a = z;
                        return fVar;
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                fVar.f52158a = false;
                return fVar;
            }
            return (f) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
                d.a.d.a.e eVar = this.f61159e;
                if (eVar != null) {
                    eVar.c(fVar);
                }
                d.a.q0.n1.m.a.a().d(this.f61157c, this.f61158d, fVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f61155a != null) {
                    this.f61155a.cancelNetConnect();
                    this.f61155a = null;
                }
                super.cancel(true);
                d.a.d.a.e eVar = this.f61159e;
                if (eVar != null) {
                    eVar.c(null);
                }
            }
        }
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
            }
        }
    }

    @Override // d.a.p0.c.a, d.a.p0.c.d
    public void a(Object obj, HashMap<String, String> hashMap, String str, d.a.d.a.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, obj, hashMap, str, eVar) == null) || hashMap == null || hashMap.isEmpty() || !hashMap.containsKey("url")) {
            return;
        }
        String str2 = hashMap.get("url");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a aVar = new a(this, str, str2, hashMap, eVar);
        aVar.setPriority(2);
        aVar.execute(new Object[0]);
    }

    @Override // d.a.p0.c.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "post" : (String) invokeV.objValue;
    }
}
