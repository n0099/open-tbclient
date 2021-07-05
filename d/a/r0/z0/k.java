package d.a.r0.z0;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static k f56964c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f56965a;

    /* renamed from: b  reason: collision with root package name */
    public b f56966b;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public interface b {
        void onResult(boolean z);
    }

    /* loaded from: classes9.dex */
    public class c extends BdAsyncTask<String, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f56967a;

        public c(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56967a = kVar;
        }

        public /* synthetic */ c(k kVar, a aVar) {
            this(kVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) ? Boolean.valueOf(this.f56967a.d()) : (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) || this.f56967a.f56966b == null || bool == null) {
                return;
            }
            this.f56967a.f56966b.onResult(bool.booleanValue());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1931359837, "Ld/a/r0/z0/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1931359837, "Ld/a/r0/z0/k;");
                return;
            }
        }
        f56964c = new k();
    }

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static k e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? f56964c : (k) invokeV.objValue;
    }

    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f56966b = bVar;
            c cVar = this.f56965a;
            if (cVar != null) {
                cVar.cancel();
            }
            c cVar2 = new c(this, null);
            this.f56965a = cVar2;
            cVar2.setPriority(4);
            this.f56965a.execute(new String[0]);
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        String[] split;
        int d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            byte[] GetFileData = FileHelper.GetFileData(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log");
            String str = GetFileData != null ? new String(GetFileData) : null;
            long j = StringUtils.getyyyyMMddHHTimeForNow();
            long j2 = 0;
            if (TextUtils.isEmpty(str) || (split = str.split(":")) == null || split.length != 2) {
                d2 = 0;
            } else {
                d2 = d.a.c.e.m.b.d(split[0], 0);
                j2 = d.a.c.e.m.b.f(split[1], j);
            }
            return j2 == j && d2 > 1;
        }
        return invokeV.booleanValue;
    }
}
