package d.a.q0.i1.t;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import d.a.d.e.d.l;
import d.a.d.e.p.p;
import d.a.p0.b1.f0;
import d.a.p0.b1.i0;
import d.a.p0.b1.n;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, ChatSetting> f59275a;

    /* renamed from: d.a.q0.i1.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1483a extends f0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f59276a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f59277b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f59278c;

        public C1483a(a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59278c = aVar;
            this.f59276a = str;
            this.f59277b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.p0.b1.f0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ChatSetting a2 = this.f59278c.a(this.f59276a, this.f59277b);
                if (a2 == null) {
                    return Boolean.FALSE;
                }
                return Boolean.valueOf(a2.isAcceptNotify());
            }
            return (Boolean) invokeV.objValue;
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59275a = new HashMap<>();
    }

    public abstract ChatSetting a(String str, String str2);

    public abstract l<String> b();

    public boolean c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            ChatSetting a2 = a(str, str2);
            if (a2 == null) {
                return false;
            }
            return a2.isAcceptNotify();
        }
        return invokeLL.booleanValue;
    }

    public void d(String str, String str2, n<Boolean> nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, nVar) == null) {
            i0.c(new C1483a(this, str, str2), nVar);
        }
    }

    public void e(Class<? extends ChatSetting> cls) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cls) == null) {
            synchronized (this.f59275a) {
                this.f59275a.clear();
            }
            String id = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "";
            if (id == null || id.length() == 0) {
                return;
            }
            String str2 = id + TNCManager.TNC_PROBE_HEADER_SECEPTOR;
            synchronized (this.f59275a) {
                l<String> b2 = b();
                List<l.b<String>> b3 = p.b(b2);
                if (b3 != null) {
                    for (l.b<String> bVar : b3) {
                        String str3 = bVar.f41626a;
                        if (str3 != null && str3.startsWith(str2) && (str = b2.get(str3)) != null) {
                            this.f59275a.put(str3, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void f(String str, String str2, boolean z) {
        ChatSetting a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048581, this, str, str2, z) == null) || (a2 = a(str, str2)) == null) {
            return;
        }
        a2.setAcceptNotify(z);
        h(a2);
    }

    public void g(String str, String str2, boolean z, n<Void> nVar) {
        ChatSetting a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Boolean.valueOf(z), nVar}) == null) || (a2 = a(str, str2)) == null) {
            return;
        }
        a2.setAcceptNotify(z);
        i(a2, nVar);
    }

    public abstract void h(ChatSetting chatSetting);

    public abstract void i(ChatSetting chatSetting, n<Void> nVar);
}
