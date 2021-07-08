package d.a.p0.w2.z;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.e;
import d.a.o0.c.f;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d.a.o0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f66067a;

    /* renamed from: d.a.p0.w2.z.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1835a extends BdAsyncTask<Object, Integer, f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f66068a;

        /* renamed from: b  reason: collision with root package name */
        public String f66069b;

        /* renamed from: c  reason: collision with root package name */
        public String f66070c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f66071d;

        /* renamed from: e  reason: collision with root package name */
        public e f66072e;

        public C1835a(a aVar, String str, String str2, HashMap<String, String> hashMap, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2, hashMap, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66068a = null;
            this.f66069b = str;
            this.f66070c = str2;
            this.f66071d = hashMap;
            this.f66072e = eVar;
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
                    this.f66068a = new NetWork(this.f66070c);
                    Set<String> keySet = this.f66071d.keySet();
                    if (keySet.size() > 0) {
                        for (String str : keySet) {
                            if (!"url".equalsIgnoreCase(str)) {
                                this.f66068a.addPostData(str, this.f66071d.get(str));
                            }
                        }
                    }
                    this.f66068a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                    this.f66068a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                    this.f66068a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.f66068a.postNetData();
                    if (!this.f66068a.getNetContext().getResponse().isNetSuccess()) {
                        fVar.f51837b = this.f66068a.getNetErrorCode();
                        fVar.f51838c = this.f66068a.getNetString();
                    } else {
                        fVar.f51837b = this.f66068a.getServerErrorCode();
                        fVar.f51838c = this.f66068a.getErrorString();
                    }
                    if (this.f66068a.getNetContext().getResponse().isRequestSuccess() && !TextUtils.isEmpty(postNetData)) {
                        JSONObject jSONObject = new JSONObject(postNetData);
                        if (jSONObject.has("code")) {
                            if (jSONObject.optInt("code", -1) == 0) {
                                fVar.f51836a = true;
                                return fVar;
                            }
                            String optString = jSONObject.has("msg") ? jSONObject.optString("msg", "") : "";
                            fVar.f51836a = false;
                            fVar.f51838c = optString;
                            return fVar;
                        }
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                fVar.f51836a = false;
                return fVar;
            }
            return (f) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(f fVar) {
            e eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) || (eVar = this.f66072e) == null) {
                return;
            }
            eVar.c(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f66068a != null) {
                    this.f66068a.cancelNetConnect();
                    this.f66068a = null;
                }
                super.cancel(true);
                e eVar = this.f66072e;
                if (eVar != null) {
                    eVar.c(null);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onCancelled();
                e eVar = this.f66072e;
                if (eVar != null) {
                    eVar.c(null);
                }
            }
        }
    }

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66067a = str;
    }

    @Override // d.a.o0.c.a, d.a.o0.c.d
    public void a(Object obj, HashMap<String, String> hashMap, String str, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, obj, hashMap, str, eVar) == null) || hashMap == null || hashMap.isEmpty() || !hashMap.containsKey("url")) {
            return;
        }
        String str2 = hashMap.get("url");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        C1835a c1835a = new C1835a(this, str, str2, hashMap, eVar);
        c1835a.setPriority(2);
        c1835a.execute(new Object[0]);
    }

    @Override // d.a.o0.c.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Uri parse = Uri.parse(this.f66067a);
            if (parse != null) {
                return parse.getAuthority() + parse.getPath();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }
}
