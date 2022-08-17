package com.repackage;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
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
import com.repackage.w25;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class i66 {
    public static /* synthetic */ Interceptable $ic;
    public static i66 c;
    public static BdAsyncTaskParallel d;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<z25> a;
    public final List<w25> b;

    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ArrayList<z25> a;
        public final w25.a b;
        public final /* synthetic */ i66 c;

        /* renamed from: com.repackage.i66$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0507a implements w25.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0507a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.repackage.w25.a
            public void a(z25 z25Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, z25Var) == null) {
                    this.a.a.add(z25Var);
                }
            }
        }

        public a(i66 i66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i66Var;
            this.a = new ArrayList<>();
            this.b = new C0507a(this);
            setPriority(4);
            setParallel(i66.d);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r5) == null) {
                super.onPostExecute(r5);
                this.c.a = this.a;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001117));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voidArr)) == null) {
                for (int i = 0; i < this.c.b.size(); i++) {
                    ((w25) this.c.b.get(i)).b(this.b);
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755666456, "Lcom/repackage/i66;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755666456, "Lcom/repackage/i66;");
                return;
            }
        }
        c = new i66();
        d = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    }

    public i66() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
        this.b = new ArrayList();
    }

    public static i66 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? c : (i66) invokeV.objValue;
    }

    public void d(String str, zm zmVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, str, zmVar, z) == null) || zmVar == null) {
            return;
        }
        if (z) {
            i55.k().e(f(str, z), zmVar, true);
            return;
        }
        i55.k().e(str, zmVar, false);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.b.isEmpty()) {
            try {
                Class.forName("com.baidu.tieba.faceshop.FaceshopStatic");
            } catch (Throwable th) {
                BdLog.e(th);
            }
            try {
                Class.forName("com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic");
            } catch (Throwable th2) {
                BdLog.e(th2);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004602, new ArrayList()));
        }
    }

    public String f(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
            if (h66.e().g()) {
                return str;
            }
            e();
            if (z && !h66.e().f(str)) {
                return "#@" + str;
            }
            return str;
        }
        return (String) invokeLZ.objValue;
    }

    public String g(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            if (str == null) {
                return null;
            }
            if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                if (p(str)) {
                    return null;
                }
                String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
                String substring = replace.substring(0, replace.indexOf(","));
                if (substring.contains("collect_")) {
                    if (substring.contains("_")) {
                        substring = substring.substring(substring.lastIndexOf("_") + 1);
                    }
                    String str2 = w65.b.c() + "/" + j55.d() + "/" + substring;
                    if (z) {
                        return str2 + "_b.gif";
                    }
                    return str2 + "_s.jpg";
                } else if (substring.contains("diy_")) {
                    if (substring.contains("_")) {
                        substring = substring.substring(substring.lastIndexOf("_") + 1);
                    }
                    String str3 = w65.b.c() + "/" + j55.c() + "/" + substring;
                    if (z) {
                        return str3 + "_b.gif";
                    }
                    return str3 + "_s.jpg";
                } else {
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

    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
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

    public ArrayList<z25> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            e();
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    @NonNull
    public String j(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
                String substring = replace.substring(0, replace.indexOf(","));
                if (substring.contains("_")) {
                    return substring.substring(substring.lastIndexOf("_") + 1);
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            e();
            Iterator<z25> it = this.a.iterator();
            while (it.hasNext()) {
                if (it.next().m(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean m(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (p(str)) {
                return false;
            }
            return str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX);
        }
        return invokeL.booleanValue;
    }

    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (str == null || !l(str)) {
                return false;
            }
            e();
            Iterator<z25> it = this.a.iterator();
            while (it.hasNext()) {
                z25 next = it.next();
                if (next.m(str)) {
                    return next.h() == EmotionGroupType.LOCAL;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (!p(str) && str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
                String substring = replace.substring(0, replace.indexOf(","));
                if (substring.contains("_") && !substring.contains("collect_") && !substring.contains("diy_")) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean p(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? j55.f.equals(str) || "#(meme,diysetting)".equals(str) : invokeL.booleanValue;
    }

    public boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? j55.f.equals(str) || str.startsWith(j55.g) : invokeL.booleanValue;
    }

    public boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? "#(meme,diysetting)".equals(str) || str.startsWith("#(meme,diy_") : invokeL.booleanValue;
    }

    public zm s(String str, String str2) {
        InterceptResult invokeLL;
        Bitmap t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, str2)) == null) {
            zm m = i55.k().m(str2);
            if (m != null) {
                return m;
            }
            e();
            Iterator<z25> it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                z25 next = it.next();
                if (next.m(str2)) {
                    m = next.o(str2);
                    break;
                }
            }
            if (m == null && str != null && (t = t(str, g(str2, false))) != null) {
                m = new zm(t, false, str2);
            }
            d(str2, m, false);
            return m;
        }
        return (zm) invokeLL.objValue;
    }

    public Bitmap t(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, str, str2)) == null) {
            return FileHelper.getImage(".emotions/" + str, str2);
        }
        return (Bitmap) invokeLL.objValue;
    }

    public void u(w25 w25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, w25Var) == null) {
            synchronized (this.b) {
                if (!this.b.contains(w25Var)) {
                    this.b.add(w25Var);
                    Collections.sort(this.b);
                }
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            new a(this).execute(new Void[0]);
        }
    }
}
