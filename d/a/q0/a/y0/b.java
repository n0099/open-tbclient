package d.a.q0.a.y0;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.a.q0.a.k;
import d.a.q0.a.y0.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public abstract class b<W extends d> implements ZeusPlugin {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f51700g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c<W> f51701a;

    /* renamed from: b  reason: collision with root package name */
    public ZeusPlugin.Callback f51702b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public W f51703c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51704d;

    /* renamed from: e  reason: collision with root package name */
    public final List<ZeusPlugin.Command> f51705e;

    /* renamed from: f  reason: collision with root package name */
    public d.a f51706f;

    /* loaded from: classes8.dex */
    public class a implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f51707a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51707a = bVar;
        }

        @Override // d.a.q0.a.y0.d.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                synchronized (this.f51707a) {
                    if (b.f51700g) {
                        Log.i("BaseInlineController", "组件初始化完成，开始flush挂起的指令=====");
                    }
                    this.f51707a.d();
                    this.f51707a.f51704d = true;
                    if (b.f51700g) {
                        Log.i("BaseInlineController", "指令flush完成=========================");
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(132634744, "Ld/a/q0/a/y0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(132634744, "Ld/a/q0/a/y0/b;");
                return;
            }
        }
        f51700g = k.f49133a;
    }

    public b(@NonNull W w) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51704d = false;
        this.f51705e = new ArrayList();
        this.f51706f = new a(this);
        this.f51701a = new c<>();
        this.f51703c = w;
        if (f51700g) {
            Log.i("BaseInlineController", "开始初始化组件");
        }
        this.f51703c.A(this.f51706f);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f51705e.size() == 0) {
            return;
        }
        Iterator<ZeusPlugin.Command> it = this.f51705e.iterator();
        while (it.hasNext()) {
            ZeusPlugin.Command next = it.next();
            if (f51700g) {
                Log.i("BaseInlineController", "flush-尝试分发Command: + " + next.what);
            }
            this.f51701a.b(next, this.f51703c);
            it.remove();
        }
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, command) == null) {
            synchronized (this) {
                if (command == null) {
                    return;
                }
                if (this.f51704d) {
                    if (f51700g) {
                        Log.v("BaseInlineController", "组件已初始化，直接尝试分发Command: + " + command.what);
                    }
                    this.f51701a.b(command, this.f51703c);
                } else {
                    ZeusPlugin.Command command2 = new ZeusPlugin.Command();
                    command2.what = command.what;
                    command2.arg1 = command.arg1;
                    command2.arg2 = command.arg2;
                    command2.arg3 = command.arg3;
                    command2.arg4 = command.arg4;
                    command2.arg5 = command.arg5;
                    command2.obj = command.obj;
                    this.f51705e.add(command2);
                    if (f51700g) {
                        Log.i("BaseInlineController", "组件未初始化，加入Pending队列： " + command2.what);
                    }
                    this.f51701a.c(command);
                }
            }
        }
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void setCallback(ZeusPlugin.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, callback) == null) {
            this.f51702b = callback;
        }
    }
}
