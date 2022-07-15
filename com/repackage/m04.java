package com.repackage;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.i04;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class m04 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<i04> a;
    public String b;
    public String c;
    public int d;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k04 a;
        public final /* synthetic */ m04 b;

        public a(m04 m04Var, k04 k04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m04Var, k04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m04Var;
            this.a = k04Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList<long[]> e = this.b.e();
                l04 l04Var = new l04();
                l04Var.a = this.b.b;
                l04Var.b = e;
                l04Var.c = this.b.c;
                xw3.i().b(l04Var, this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755553120, "Lcom/repackage/m04;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755553120, "Lcom/repackage/m04;");
                return;
            }
        }
        e = rg1.a;
    }

    public m04(ArrayList<j04> arrayList, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (e) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        ArrayList<i04> d = d(arrayList);
        this.a = d;
        this.b = str;
        this.c = str2;
        this.d = d.size();
    }

    public void c(k04 k04Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, k04Var) == null) || k04Var == null) {
            return;
        }
        bd3.l(new a(this, k04Var), "clipVideo");
    }

    public final ArrayList<i04> d(ArrayList<j04> arrayList) {
        InterceptResult invokeL;
        i04 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList)) == null) {
            ArrayList<i04> arrayList2 = new ArrayList<>();
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<j04> it = arrayList.iterator();
                while (it.hasNext()) {
                    j04 next = it.next();
                    if (next != null && (a2 = next.a()) != null) {
                        arrayList2.add(a2);
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public ArrayList<long[]> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList<long[]> arrayList = new ArrayList<>();
            if (this.d == 0) {
                return arrayList;
            }
            if (e) {
                Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.a);
            }
            Collections.sort(this.a, new i04.a());
            i04 i04Var = this.a.get(0);
            for (int i = 1; i < this.d; i++) {
                i04 i04Var2 = this.a.get(i);
                if (!i04Var.b(i04Var2)) {
                    arrayList.add(i04.a(i04Var));
                    i04Var = i04Var2;
                }
            }
            arrayList.add(i04.a(i04Var));
            if (e) {
                Log.d("ClipVideoTask", "mergeRange mergeList = " + arrayList);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }
}
