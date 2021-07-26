package d.a.o0.a.y0;

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
import d.a.o0.a.k;
import d.a.o0.a.y0.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class b<W extends d> implements ZeusPlugin {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f48902g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c<W> f48903a;

    /* renamed from: b  reason: collision with root package name */
    public ZeusPlugin.Callback f48904b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public W f48905c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48906d;

    /* renamed from: e  reason: collision with root package name */
    public final List<ZeusPlugin.Command> f48907e;

    /* renamed from: f  reason: collision with root package name */
    public d.a f48908f;

    /* loaded from: classes7.dex */
    public class a implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f48909a;

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
            this.f48909a = bVar;
        }

        @Override // d.a.o0.a.y0.d.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                synchronized (this.f48909a) {
                    if (b.f48902g) {
                        Log.i("BaseInlineController", "组件初始化完成，开始flush挂起的指令=====");
                    }
                    this.f48909a.d();
                    this.f48909a.f48906d = true;
                    if (b.f48902g) {
                        Log.i("BaseInlineController", "指令flush完成=========================");
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(525661754, "Ld/a/o0/a/y0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(525661754, "Ld/a/o0/a/y0/b;");
                return;
            }
        }
        f48902g = k.f46335a;
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
        this.f48906d = false;
        this.f48907e = new ArrayList();
        this.f48908f = new a(this);
        this.f48903a = new c<>();
        this.f48905c = w;
        if (f48902g) {
            Log.i("BaseInlineController", "开始初始化组件");
        }
        this.f48905c.A(this.f48908f);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48907e.size() == 0) {
            return;
        }
        Iterator<ZeusPlugin.Command> it = this.f48907e.iterator();
        while (it.hasNext()) {
            ZeusPlugin.Command next = it.next();
            if (f48902g) {
                Log.i("BaseInlineController", "flush-尝试分发Command: + " + next.what);
            }
            this.f48903a.b(next, this.f48905c);
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
                if (this.f48906d) {
                    if (f48902g) {
                        Log.v("BaseInlineController", "组件已初始化，直接尝试分发Command: + " + command.what);
                    }
                    this.f48903a.b(command, this.f48905c);
                } else {
                    ZeusPlugin.Command command2 = new ZeusPlugin.Command();
                    command2.what = command.what;
                    command2.arg1 = command.arg1;
                    command2.arg2 = command.arg2;
                    command2.arg3 = command.arg3;
                    command2.arg4 = command.arg4;
                    command2.arg5 = command.arg5;
                    command2.obj = command.obj;
                    this.f48907e.add(command2);
                    if (f48902g) {
                        Log.i("BaseInlineController", "组件未初始化，加入Pending队列： " + command2.what);
                    }
                    this.f48903a.c(command);
                }
            }
        }
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void setCallback(ZeusPlugin.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, callback) == null) {
            this.f48904b = callback;
        }
    }
}
