package d.a.o0.e;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.mapapi.UIMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class RunnableC0670a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0668a f46261e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46262f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46263g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ArrayList f46264h;

        /* renamed from: d.a.o0.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0671a extends d.a.o0.k.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a.InterfaceC0668a f46265f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ RunnableC0670a f46266g;

            public C0671a(RunnableC0670a runnableC0670a, a.InterfaceC0668a interfaceC0668a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0670a, interfaceC0668a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46266g = runnableC0670a;
                this.f46265f = interfaceC0668a;
            }

            @Override // d.a.o0.k.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f46265f.onFinish(this.f46266g.f46262f);
                }
            }
        }

        public RunnableC0670a(a.InterfaceC0668a interfaceC0668a, String str, int i2, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0668a, str, Integer.valueOf(i2), arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46261e = interfaceC0668a;
            this.f46262f = str;
            this.f46263g = i2;
            this.f46264h = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46261e.onFinish(this.f46262f);
                if (this.f46263g != 1 || this.f46264h == null) {
                    return;
                }
                for (int i2 = 0; i2 < this.f46264h.size(); i2++) {
                    a.InterfaceC0668a interfaceC0668a = (a.InterfaceC0668a) this.f46264h.get(i2);
                    if (interfaceC0668a != null) {
                        d.a.o0.k.e.c().b(new C0671a(this, interfaceC0668a));
                    }
                }
            }
        }
    }

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            if (i2 == 1) {
                return 2010;
            }
            if (i2 == 2) {
                return IMConstants.IM_MSG_TYPE_SHIELD;
            }
            if (i2 == 3) {
                return IMConstants.IM_MSG_TYPE_SHIELD_ME;
            }
            if (i2 == 4) {
                return IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME;
            }
            if (i2 == 5) {
                return IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME_SEND_FAIL;
            }
            if (i2 == 6) {
                return 2015;
            }
            return UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE;
        }
        return invokeI.intValue;
    }

    public static void b(a.InterfaceC0668a interfaceC0668a, h hVar, int i2, ArrayList<a.InterfaceC0668a> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{interfaceC0668a, hVar, Integer.valueOf(i2), arrayList, Boolean.valueOf(z)}) == null) || hVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", hVar.f46342a);
            jSONObject.put("1", hVar.f46343b);
            jSONObject.put("2", String.valueOf(hVar.f46344c));
            jSONObject.put("3", hVar.f46345d);
            String jSONObject2 = jSONObject.toString();
            if (interfaceC0668a != null) {
                if (i2 == 1) {
                    if (z) {
                        d.a.o0.c.a.c().f(false);
                    }
                } else if (i2 == 2) {
                    if (z) {
                        d.a.o0.c.a.c().d(false);
                    }
                } else if (i2 == 3) {
                    if (z) {
                        d.a.o0.c.a.c().j(false);
                    }
                } else if (z) {
                    d.a.o0.c.a.c().m(false);
                }
                new Thread(new RunnableC0670a(interfaceC0668a, jSONObject2, i2, arrayList)).start();
            }
        } catch (Throwable th) {
            d.a.o0.l.c.d(th);
        }
    }
}
