package d.a.s0.n1.m;

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
import d.a.r0.c.f;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes9.dex */
public class e extends d.a.r0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a extends BdAsyncTask<Object, Integer, f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f63775a;

        /* renamed from: b  reason: collision with root package name */
        public String f63776b;

        /* renamed from: c  reason: collision with root package name */
        public String f63777c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f63778d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.c.a.e f63779e;

        public a(e eVar, String str, String str2, HashMap<String, String> hashMap, d.a.c.a.e eVar2) {
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
            this.f63775a = null;
            this.f63776b = str;
            this.f63777c = str2;
            this.f63778d = hashMap;
            this.f63779e = eVar2;
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
                    this.f63775a = new NetWork(TbConfig.SERVER_ADDRESS + this.f63777c);
                    Set<String> keySet = this.f63778d.keySet();
                    if (keySet.size() > 0) {
                        for (String str : keySet) {
                            if (!"url".equalsIgnoreCase(str)) {
                                this.f63775a.addPostData(str, this.f63778d.get(str));
                            }
                        }
                    }
                    this.f63775a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                    this.f63775a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                    boolean z = true;
                    this.f63775a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.f63775a.postNetData();
                    if (!this.f63775a.getNetContext().getResponse().isNetSuccess()) {
                        fVar.f55132b = this.f63775a.getNetErrorCode();
                        fVar.f55133c = this.f63775a.getNetString();
                    } else {
                        fVar.f55132b = this.f63775a.getServerErrorCode();
                        fVar.f55133c = this.f63775a.getErrorString();
                    }
                    if (this.f63775a.getNetContext().getResponse().isRequestSuccess() && postNetData != null) {
                        if (fVar.f55132b != 0) {
                            z = false;
                        }
                        fVar.f55131a = z;
                        return fVar;
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                fVar.f55131a = false;
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
                d.a.c.a.e eVar = this.f63779e;
                if (eVar != null) {
                    eVar.c(fVar);
                }
                d.a.s0.n1.m.a.a().d(this.f63777c, this.f63778d, fVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f63775a != null) {
                    this.f63775a.cancelNetConnect();
                    this.f63775a = null;
                }
                super.cancel(true);
                d.a.c.a.e eVar = this.f63779e;
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

    @Override // d.a.r0.c.a, d.a.r0.c.d
    public void a(Object obj, HashMap<String, String> hashMap, String str, d.a.c.a.e eVar) {
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

    @Override // d.a.r0.c.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "post" : (String) invokeV.objValue;
    }
}
