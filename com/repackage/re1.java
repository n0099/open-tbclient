package com.repackage;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.mapapi.UIMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ge1;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class re1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge1.a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ArrayList d;

        /* renamed from: com.repackage.re1$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0721a extends nf1 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ge1.a b;
            public final /* synthetic */ a c;

            public C0721a(a aVar, ge1.a aVar2) {
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

            @Override // com.repackage.nf1
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.onFinish(this.c.b);
                }
            }
        }

        public a(ge1.a aVar, String str, int i, ArrayList arrayList) {
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
                    ge1.a aVar = (ge1.a) this.d.get(i);
                    if (aVar != null) {
                        pf1.c().b(new C0721a(this, aVar));
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
                return IMConstants.IM_MSG_TYPE_SHIELD;
            }
            if (i == 3) {
                return IMConstants.IM_MSG_TYPE_SHIELD_ME;
            }
            if (i == 4) {
                return IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME;
            }
            if (i == 5) {
                return IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME_SEND_FAIL;
            }
            if (i == 6) {
                return 2015;
            }
            return UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE;
        }
        return invokeI.intValue;
    }

    public static void b(ge1.a aVar, oe1 oe1Var, int i, ArrayList<ge1.a> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{aVar, oe1Var, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) || oe1Var == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", oe1Var.a);
            jSONObject.put("1", oe1Var.b);
            jSONObject.put("2", String.valueOf(oe1Var.c));
            jSONObject.put("3", oe1Var.d);
            String jSONObject2 = jSONObject.toString();
            if (aVar != null) {
                if (i == 1) {
                    if (z) {
                        le1.c().f(false);
                    }
                } else if (i == 2) {
                    if (z) {
                        le1.c().d(false);
                    }
                } else if (i == 3) {
                    if (z) {
                        le1.c().j(false);
                    }
                } else if (z) {
                    le1.c().n(false);
                }
                new Thread(new a(aVar, jSONObject2, i, arrayList)).start();
            }
        } catch (Throwable th) {
            sf1.d(th);
        }
    }
}
