package d.a.m0.e;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.mapapi.UIMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.m0.a;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.m0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class RunnableC0629a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0627a f43465e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43466f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43467g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ArrayList f43468h;

        /* renamed from: d.a.m0.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0630a extends d.a.m0.k.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a.InterfaceC0627a f43469f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ RunnableC0629a f43470g;

            public C0630a(RunnableC0629a runnableC0629a, a.InterfaceC0627a interfaceC0627a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0629a, interfaceC0627a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f43470g = runnableC0629a;
                this.f43469f = interfaceC0627a;
            }

            @Override // d.a.m0.k.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f43469f.onFinish(this.f43470g.f43466f);
                }
            }
        }

        public RunnableC0629a(a.InterfaceC0627a interfaceC0627a, String str, int i2, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0627a, str, Integer.valueOf(i2), arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43465e = interfaceC0627a;
            this.f43466f = str;
            this.f43467g = i2;
            this.f43468h = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f43465e.onFinish(this.f43466f);
                if (this.f43467g != 1 || this.f43468h == null) {
                    return;
                }
                for (int i2 = 0; i2 < this.f43468h.size(); i2++) {
                    a.InterfaceC0627a interfaceC0627a = (a.InterfaceC0627a) this.f43468h.get(i2);
                    if (interfaceC0627a != null) {
                        d.a.m0.k.e.c().b(new C0630a(this, interfaceC0627a));
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

    public static void b(a.InterfaceC0627a interfaceC0627a, h hVar, int i2, ArrayList<a.InterfaceC0627a> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{interfaceC0627a, hVar, Integer.valueOf(i2), arrayList, Boolean.valueOf(z)}) == null) || hVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", hVar.f43546a);
            jSONObject.put("1", hVar.f43547b);
            jSONObject.put("2", String.valueOf(hVar.f43548c));
            jSONObject.put("3", hVar.f43549d);
            String jSONObject2 = jSONObject.toString();
            if (interfaceC0627a != null) {
                if (i2 == 1) {
                    if (z) {
                        d.a.m0.c.a.c().f(false);
                    }
                } else if (i2 == 2) {
                    if (z) {
                        d.a.m0.c.a.c().d(false);
                    }
                } else if (i2 == 3) {
                    if (z) {
                        d.a.m0.c.a.c().j(false);
                    }
                } else if (z) {
                    d.a.m0.c.a.c().m(false);
                }
                new Thread(new RunnableC0629a(interfaceC0627a, jSONObject2, i2, arrayList)).start();
            }
        } catch (Throwable th) {
            d.a.m0.l.c.d(th);
        }
    }
}
