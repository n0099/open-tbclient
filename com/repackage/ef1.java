package com.repackage;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.te1;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ef1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ te1.a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ArrayList d;

        /* renamed from: com.repackage.ef1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0407a extends ag1 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ te1.a b;
            public final /* synthetic */ a c;

            public C0407a(a aVar, te1.a aVar2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, aVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.b = aVar2;
            }

            @Override // com.repackage.ag1
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.onFinish(this.c.b);
                }
            }
        }

        public a(te1.a aVar, String str, int i, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Integer.valueOf(i), arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.b = str;
            this.c = i;
            this.d = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.onFinish(this.b);
                if (this.c != 1 || this.d == null) {
                    return;
                }
                for (int i = 0; i < this.d.size(); i++) {
                    te1.a aVar = (te1.a) this.d.get(i);
                    if (aVar != null) {
                        cg1.c().b(new C0407a(this, aVar));
                    }
                }
            }
        }
    }

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            if (i == 1) {
                return 2010;
            }
            if (i == 2) {
                return 2011;
            }
            return i == 3 ? IMConstants.IM_MSG_TYPE_SHIELD_ME : i == 4 ? IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME : i == 5 ? IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME_SEND_FAIL : i == 6 ? 2015 : 2009;
        }
        return invokeI.intValue;
    }

    public static void b(te1.a aVar, bf1 bf1Var, int i, ArrayList<te1.a> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{aVar, bf1Var, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) || bf1Var == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", bf1Var.a);
            jSONObject.put("1", bf1Var.b);
            jSONObject.put("2", String.valueOf(bf1Var.c));
            jSONObject.put("3", bf1Var.d);
            String jSONObject2 = jSONObject.toString();
            if (aVar != null) {
                if (i == 1) {
                    if (z) {
                        ye1.c().f(false);
                    }
                } else if (i == 2) {
                    if (z) {
                        ye1.c().d(false);
                    }
                } else if (i == 3) {
                    if (z) {
                        ye1.c().j(false);
                    }
                } else if (z) {
                    ye1.c().n(false);
                }
                new Thread(new a(aVar, jSONObject2, i, arrayList)).start();
            }
        } catch (Throwable th) {
            fg1.d(th);
        }
    }
}
