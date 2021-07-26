package d.a.q0.y3;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.j.a.e;
import d.a.d.e.p.k;
import d.a.d.e.p.q;
import java.io.File;
/* loaded from: classes8.dex */
public class b extends BdAsyncTask<Void, Void, String> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final String f67139d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f67140a;

    /* renamed from: b  reason: collision with root package name */
    public String f67141b;

    /* renamed from: c  reason: collision with root package name */
    public a f67142c;

    /* loaded from: classes8.dex */
    public interface a {
        void a(boolean z, String str, String str2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(187715075, "Ld/a/q0/y3/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(187715075, "Ld/a/q0/y3/b;");
                return;
            }
        }
        f67139d = File.separator;
    }

    public b(String str, String str2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f67140a = str;
        this.f67141b = str2;
        this.f67142c = aVar;
    }

    public final void b(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, file) == null) || k.isEmpty(this.f67140a)) {
            return;
        }
        File file2 = new File(this.f67140a);
        if (!file2.exists() || (listFiles = file2.listFiles()) == null) {
            return;
        }
        for (File file3 : listFiles) {
            if (file3 != null && !file3.equals(file)) {
                FileHelper.deleteFileOrDir(file3);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public String doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
            if (!k.isEmpty(this.f67140a) && !k.isEmpty(this.f67141b)) {
                new File(this.f67140a).mkdirs();
                String str = this.f67140a + f67139d + "videosplash.temp";
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                e eVar = new e();
                eVar.b().s(this.f67141b);
                if (new d.a.d.e.j.a.c(eVar).c(str, null, 3, 3000, -1, -1, true, true)) {
                    return d();
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            File file = new File(this.f67140a + f67139d + "videosplash.temp");
            StringBuilder sb = new StringBuilder();
            sb.append(q.c(this.f67141b));
            sb.append(".mp4");
            String sb2 = sb.toString();
            File file2 = new File(this.f67140a + f67139d + sb2);
            if (file2.exists()) {
                file2.delete();
            }
            if (file.renameTo(file2)) {
                b(file2);
                return file2.getAbsolutePath();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || this.f67142c == null) {
            return;
        }
        if (!k.isEmpty(str)) {
            this.f67142c.a(true, str, this.f67141b);
        } else {
            this.f67142c.a(false, null, null);
        }
    }
}
