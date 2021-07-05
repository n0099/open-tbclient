package d.a.r0.z0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static y f57011g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f57012a;

    /* renamed from: b  reason: collision with root package name */
    public String f57013b;

    /* renamed from: c  reason: collision with root package name */
    public String f57014c;

    /* renamed from: d  reason: collision with root package name */
    public int f57015d;

    /* renamed from: e  reason: collision with root package name */
    public String f57016e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f57017f;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ y f57018e;

        public a(y yVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57018e = yVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("from", String.valueOf(this.f57018e.f57012a));
                hashMap.put("field_id", this.f57018e.f57013b);
                hashMap.put("type", Integer.valueOf(this.f57018e.f57015d));
                hashMap.put("type_name", this.f57018e.f57016e);
                if (this.f57018e.f57012a == 2) {
                    hashMap.put("fid", this.f57018e.f57014c);
                }
                hashMap.put("animated", Boolean.FALSE);
                hashMap.put(OpenFlutter.EXTRA_TRANSPARANT, Boolean.TRUE);
                hashMap.put("swipeback", Boolean.FALSE);
                if (PluginPackageManager.O().y("com.baidu.tieba.pluginFlutter")) {
                    if (MessageManager.getInstance().findTask(2002015) == null) {
                        d.a.c.e.m.e.a().postDelayed(this.f57018e.f57017f, 0L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.a.s0.h3.h0.m(TbadkApplication.getInst().getApplicationContext(), "GodDialog", hashMap)));
                    d.a.r0.r.d0.b.j().w("key_new_god_dialog_showed_time", System.currentTimeMillis());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1931360271, "Ld/a/r0/z0/y;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1931360271, "Ld/a/r0/z0/y;");
        }
    }

    public y() {
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
        this.f57017f = new a(this);
    }

    public static synchronized y g() {
        InterceptResult invokeV;
        y yVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            synchronized (y.class) {
                if (f57011g == null) {
                    f57011g = new y();
                }
                yVar = f57011g;
            }
            return yVar;
        }
        return (y) invokeV.objValue;
    }

    public final boolean h(int i2, NewGodData newGodData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, newGodData)) == null) {
            if (i2 != 5) {
                return (((((System.currentTimeMillis() - d.a.r0.r.d0.b.j().l("key_new_god_dialog_showed_time", 0L)) + 3000) > 259200000L ? 1 : (((System.currentTimeMillis() - d.a.r0.r.d0.b.j().l("key_new_god_dialog_showed_time", 0L)) + 3000) == 259200000L ? 0 : -1)) < 0) || newGodData == null || !newGodData.isNewGodInvited()) ? false : true;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.c.e.m.e.a().removeCallbacks(this.f57017f);
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f57014c = str;
        }
    }

    public void k(int i2, NewGodData newGodData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, newGodData) == null) {
            l(i2, newGodData, true);
        }
    }

    public void l(int i2, NewGodData newGodData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), newGodData, Boolean.valueOf(z)}) == null) && h(i2, newGodData)) {
            i();
            this.f57012a = i2;
            this.f57013b = newGodData.getFieldId();
            this.f57015d = newGodData.getType();
            this.f57016e = newGodData.getTypeName();
            d.a.c.e.m.e.a().postDelayed(this.f57017f, z ? 3000L : 0L);
        }
    }
}
