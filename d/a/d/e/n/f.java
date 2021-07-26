package d.a.d.e.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static f f41829d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, b> f41830a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, c> f41831b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f41832c;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 5) {
                Object obj = message.obj;
                if (!(obj instanceof b) || (bVar = (b) obj) == null) {
                    return;
                }
                bVar.i(false);
                bVar.h(false);
                bVar.g(0);
                bVar.j(System.currentTimeMillis());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f41838a;

        /* renamed from: b  reason: collision with root package name */
        public int f41839b;

        /* renamed from: c  reason: collision with root package name */
        public int f41840c;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f41838a : invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f41839b : invokeV.intValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f41840c : invokeV.intValue;
        }

        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                this.f41838a = i2;
            }
        }

        public void e(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                this.f41839b = i2;
            }
        }

        public void f(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
                this.f41840c = i2;
            }
        }

        public /* synthetic */ c(f fVar, a aVar) {
            this(fVar);
        }
    }

    public f() {
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
        this.f41830a = new HashMap<>();
        this.f41831b = new HashMap<>();
        this.f41832c = new a(this, Looper.getMainLooper());
        c cVar = new c(this, null);
        cVar.d(3000);
        cVar.e(120000);
        cVar.f(500);
        this.f41831b.put("net", cVar);
        this.f41831b.put("op", cVar);
        this.f41831b.put("stat", cVar);
        this.f41831b.put("crash", cVar);
        this.f41831b.put("pfmonitor", cVar);
        c cVar2 = new c(this, null);
        cVar2.d(3000);
        cVar2.e(120000);
        cVar2.f(1500);
        this.f41831b.put("file", cVar2);
        this.f41831b.put(IMTrackDatabase.DbEnum.TABLE_NAME, cVar2);
        this.f41831b.put("img", cVar2);
        this.f41831b.put("voice", cVar2);
        this.f41831b.put("error", cVar2);
        c cVar3 = new c(this, null);
        cVar3.d(3000);
        cVar3.e(120000);
        cVar3.f(1500);
        this.f41831b.put("dbg", cVar3);
    }

    public static f c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f41829d == null) {
                synchronized (f.class) {
                    if (f41829d == null) {
                        f41829d = new f();
                    }
                }
            }
            return f41829d;
        }
        return (f) invokeV.objValue;
    }

    public synchronized boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                c cVar = this.f41831b.get(str);
                if (cVar == null) {
                    return false;
                }
                b bVar = this.f41830a.get(str);
                long currentTimeMillis = System.currentTimeMillis();
                if (bVar == null) {
                    bVar = new b(this, null);
                    bVar.h(false);
                    bVar.i(false);
                    bVar.j(currentTimeMillis);
                    this.f41830a.put(str, bVar);
                }
                b bVar2 = bVar;
                if (bVar2.e()) {
                    return true;
                }
                if (bVar2.d()) {
                    bVar2.g(bVar2.b() + 1);
                    if (currentTimeMillis - bVar2.a() < cVar.b()) {
                        if (bVar2.b() >= cVar.c()) {
                            bVar2.i(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, VideoItemModel.TYPE_LOADING, str, new Object[0]);
                            b(bVar2);
                            return true;
                        }
                    } else {
                        bVar2.h(false);
                        bVar2.g(0);
                        bVar2.j(currentTimeMillis);
                    }
                } else if (currentTimeMillis - bVar2.c() < cVar.a()) {
                    bVar2.h(true);
                    bVar2.f(currentTimeMillis);
                } else {
                    bVar2.j(currentTimeMillis);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            Message obtainMessage = this.f41832c.obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.obj = bVar;
            this.f41832c.removeMessages(5);
            this.f41832c.sendMessageDelayed(obtainMessage, 300000L);
        }
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f41833a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f41834b;

        /* renamed from: c  reason: collision with root package name */
        public int f41835c;

        /* renamed from: d  reason: collision with root package name */
        public long f41836d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f41837e;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41834b = false;
            this.f41835c = 0;
            this.f41837e = false;
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f41836d : invokeV.longValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f41835c : invokeV.intValue;
        }

        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f41833a : invokeV.longValue;
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41834b : invokeV.booleanValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f41837e : invokeV.booleanValue;
        }

        public void f(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
                this.f41836d = j;
            }
        }

        public void g(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                this.f41835c = i2;
            }
        }

        public void h(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
                this.f41834b = z;
            }
        }

        public void i(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
                this.f41837e = z;
            }
        }

        public void j(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
                this.f41833a = j;
            }
        }

        public /* synthetic */ b(f fVar, a aVar) {
            this(fVar);
        }
    }
}
