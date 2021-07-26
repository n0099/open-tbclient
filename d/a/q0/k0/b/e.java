package d.a.q0.k0.b;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.x.p.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static e f59834c;

    /* renamed from: d  reason: collision with root package name */
    public static BdAsyncTaskParallel f59835d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.p0.x.p.c> f59836a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.p0.x.p.a> f59837b;

    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ArrayList<d.a.p0.x.p.c> f59838a;

        /* renamed from: b  reason: collision with root package name */
        public final a.InterfaceC1248a f59839b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f59840c;

        /* renamed from: d.a.q0.k0.b.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1509a implements a.InterfaceC1248a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f59841a;

            public C1509a(a aVar) {
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
                this.f59841a = aVar;
            }

            @Override // d.a.p0.x.p.a.InterfaceC1248a
            public void a(d.a.p0.x.p.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                    this.f59841a.f59838a.add(cVar);
                }
            }
        }

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59840c = eVar;
            this.f59838a = new ArrayList<>();
            this.f59839b = new C1509a(this);
            setPriority(4);
            setParallel(e.f59835d);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r5) == null) {
                super.onPostExecute(r5);
                this.f59840c.f59836a = this.f59838a;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001117));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voidArr)) == null) {
                for (int i2 = 0; i2 < this.f59840c.f59837b.size(); i2++) {
                    ((d.a.p0.x.p.a) this.f59840c.f59837b.get(i2)).b(this.f59839b);
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(379515202, "Ld/a/q0/k0/b/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(379515202, "Ld/a/q0/k0/b/e;");
                return;
            }
        }
        f59834c = new e();
        f59835d = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f59836a = new ArrayList<>();
        this.f59837b = new ArrayList();
    }

    public static e i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f59834c : (e) invokeV.objValue;
    }

    public void d(String str, d.a.d.k.d.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, str, aVar, z) == null) || aVar == null) {
            return;
        }
        if (z) {
            d.a.p0.b0.c.k().e(e(str, z), aVar, true);
            return;
        }
        d.a.p0.b0.c.k().e(str, aVar, false);
    }

    public String e(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            if (d.f().g()) {
                return str;
            }
            List<d.a.p0.x.p.c> e2 = d.f().e();
            if (z) {
                for (d.a.p0.x.p.c cVar : e2) {
                    if (cVar.m(str)) {
                        return str;
                    }
                }
                return "#@" + str;
            }
            return str;
        }
        return (String) invokeLZ.objValue;
    }

    public String f(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
            if (str == null) {
                return null;
            }
            if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                if (str.equals(d.a.p0.b0.d.f52028d)) {
                    return null;
                }
                String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
                String substring = replace.substring(0, replace.indexOf(","));
                if (substring.contains("collect_")) {
                    String str2 = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/.collect/" + d.a.p0.b0.d.b() + "/" + substring.replace("collect_", "");
                    if (z) {
                        return str2 + "_b.gif";
                    }
                    return str2 + "_s.jpg";
                }
                long hashCode = str.hashCode();
                if (hashCode < 0) {
                    hashCode *= -1;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(z ? "d_" : "s_");
                sb.append(hashCode);
                String sb2 = sb.toString();
                if (z) {
                    return sb2 + ".gif";
                }
                return sb2 + ".jpg";
            }
            long hashCode2 = str.hashCode();
            if (hashCode2 < 0) {
                hashCode2 *= -1;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(z ? "d_" : "s_");
            sb3.append(hashCode2);
            return sb3.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
                String substring = replace.substring(0, replace.indexOf(","));
                if (substring.contains("_")) {
                    return substring.substring(0, substring.indexOf("_"));
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public ArrayList<d.a.p0.x.p.c> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f59836a : (ArrayList) invokeV.objValue;
    }

    public boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Iterator<d.a.p0.x.p.c> it = this.f59836a.iterator();
            while (it.hasNext()) {
                if (it.next().m(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (str == null || !j(str)) {
                return false;
            }
            Iterator<d.a.p0.x.p.c> it = this.f59836a.iterator();
            while (it.hasNext()) {
                d.a.p0.x.p.c next = it.next();
                if (next.m(str)) {
                    return next.h() == EmotionGroupType.LOCAL;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (!d.a.p0.b0.d.f52028d.equals(str) && str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
                String substring = replace.substring(0, replace.indexOf(","));
                if (substring.contains("_") && !substring.contains("collect_")) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? d.a.p0.b0.d.f52028d.equals(str) || str.startsWith(d.a.p0.b0.d.f52029e) : invokeL.booleanValue;
    }

    public d.a.d.k.d.a n(String str, String str2) {
        InterceptResult invokeLL;
        Bitmap o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, str2)) == null) {
            d.a.d.k.d.a m = d.a.p0.b0.c.k().m(str2);
            if (m != null) {
                return m;
            }
            Iterator<d.a.p0.x.p.c> it = this.f59836a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d.a.p0.x.p.c next = it.next();
                if (next.m(str2)) {
                    m = next.o(str2);
                    break;
                }
            }
            if (m == null && str != null && (o = o(str, f(str2, false))) != null) {
                m = new d.a.d.k.d.a(o, false, str2);
            }
            d(str2, m, false);
            return m;
        }
        return (d.a.d.k.d.a) invokeLL.objValue;
    }

    public Bitmap o(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) {
            return FileHelper.getImage(".emotions/" + str, str2);
        }
        return (Bitmap) invokeLL.objValue;
    }

    public void p(d.a.p0.x.p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            synchronized (this.f59837b) {
                if (!this.f59837b.contains(aVar)) {
                    this.f59837b.add(aVar);
                    Collections.sort(this.f59837b);
                }
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            new a(this).execute(new Void[0]);
        }
    }
}
