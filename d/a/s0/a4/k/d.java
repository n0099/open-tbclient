package d.a.s0.a4.k;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static d f57461g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f57462a;

    /* renamed from: b  reason: collision with root package name */
    public BroadcastReceiver f57463b;

    /* renamed from: c  reason: collision with root package name */
    public ContentObserver f57464c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<InterfaceC1314d> f57465d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f57466e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f57467f;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f57468e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57468e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57468e.h(false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d this$0;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                this.this$0.i(intent);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f57469a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d dVar, Handler handler) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57469a = dVar;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f57469a.f57466e.removeCallbacks(this.f57469a.f57467f);
                this.f57469a.f57466e.postDelayed(this.f57469a.f57467f, 2000L);
            }
        }
    }

    /* renamed from: d.a.s0.a4.k.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1314d {
        void q(boolean z);
    }

    public d() {
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
        this.f57462a = new Handler(Looper.getMainLooper());
        this.f57465d = new ArrayList<>();
        this.f57466e = new Handler();
        this.f57467f = new a(this);
    }

    public static d f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            if (f57461g == null) {
                synchronized (d.class) {
                    if (f57461g == null) {
                        d dVar = new d();
                        f57461g = dVar;
                        dVar.g(TbadkCoreApplication.getInst());
                    }
                }
            }
            return f57461g;
        }
        return (d) invokeV.objValue;
    }

    public void d(InterfaceC1314d interfaceC1314d) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, interfaceC1314d) == null) || interfaceC1314d == null || this.f57465d.contains(interfaceC1314d)) {
            return;
        }
        this.f57465d.add(interfaceC1314d);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            j();
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            inst.unregisterReceiver(this.f57463b);
            inst.getContentResolver().unregisterContentObserver(this.f57464c);
            this.f57466e.removeCallbacks(this.f57467f);
            f57461g = null;
        }
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.f57463b = new b(this);
            this.f57464c = new c(this, this.f57462a);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
            intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
            intentFilter.addAction("android.intent.action.MEDIA_EJECT");
            intentFilter.addDataScheme("file");
            context.registerReceiver(this.f57463b, intentFilter);
            context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f57464c);
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            Iterator<InterfaceC1314d> it = this.f57465d.iterator();
            while (it.hasNext()) {
                it.next().q(z);
            }
        }
    }

    public final void i(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
            if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
                h(true);
                return;
            }
            this.f57466e.removeCallbacks(this.f57467f);
            this.f57466e.postDelayed(this.f57467f, 2000L);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f57465d.clear();
        }
    }

    public void k(InterfaceC1314d interfaceC1314d) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, interfaceC1314d) == null) && this.f57465d.contains(interfaceC1314d)) {
            this.f57465d.remove(interfaceC1314d);
        }
    }
}
