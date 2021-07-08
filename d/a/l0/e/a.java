package d.a.l0.e;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.mapapi.UIMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.l0.a;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.l0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class RunnableC0620a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0618a f42961e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f42962f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f42963g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ArrayList f42964h;

        /* renamed from: d.a.l0.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0621a extends d.a.l0.k.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a.InterfaceC0618a f42965f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ RunnableC0620a f42966g;

            public C0621a(RunnableC0620a runnableC0620a, a.InterfaceC0618a interfaceC0618a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0620a, interfaceC0618a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f42966g = runnableC0620a;
                this.f42965f = interfaceC0618a;
            }

            @Override // d.a.l0.k.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f42965f.onFinish(this.f42966g.f42962f);
                }
            }
        }

        public RunnableC0620a(a.InterfaceC0618a interfaceC0618a, String str, int i2, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0618a, str, Integer.valueOf(i2), arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42961e = interfaceC0618a;
            this.f42962f = str;
            this.f42963g = i2;
            this.f42964h = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f42961e.onFinish(this.f42962f);
                if (this.f42963g != 1 || this.f42964h == null) {
                    return;
                }
                for (int i2 = 0; i2 < this.f42964h.size(); i2++) {
                    a.InterfaceC0618a interfaceC0618a = (a.InterfaceC0618a) this.f42964h.get(i2);
                    if (interfaceC0618a != null) {
                        d.a.l0.k.e.c().b(new C0621a(this, interfaceC0618a));
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

    public static void b(a.InterfaceC0618a interfaceC0618a, h hVar, int i2, ArrayList<a.InterfaceC0618a> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{interfaceC0618a, hVar, Integer.valueOf(i2), arrayList, Boolean.valueOf(z)}) == null) || hVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", hVar.f43042a);
            jSONObject.put("1", hVar.f43043b);
            jSONObject.put("2", String.valueOf(hVar.f43044c));
            jSONObject.put("3", hVar.f43045d);
            String jSONObject2 = jSONObject.toString();
            if (interfaceC0618a != null) {
                if (i2 == 1) {
                    if (z) {
                        d.a.l0.c.a.c().f(false);
                    }
                } else if (i2 == 2) {
                    if (z) {
                        d.a.l0.c.a.c().d(false);
                    }
                } else if (i2 == 3) {
                    if (z) {
                        d.a.l0.c.a.c().j(false);
                    }
                } else if (z) {
                    d.a.l0.c.a.c().m(false);
                }
                new Thread(new RunnableC0620a(interfaceC0618a, jSONObject2, i2, arrayList)).start();
            }
        } catch (Throwable th) {
            d.a.l0.l.c.d(th);
        }
    }
}
