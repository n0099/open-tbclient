package d.a.n0.a.n1;

import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.network.NetworkBroadcastReceiver;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class j extends d.a.n0.a.a2.f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f46347d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NetworkBroadcastReceiver f46348a;

    /* renamed from: b  reason: collision with root package name */
    public TelephonyManager f46349b;

    /* renamed from: c  reason: collision with root package name */
    public a f46350c;

    /* loaded from: classes7.dex */
    public class a extends PhoneStateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<CallbackHandler> f46351a;

        /* renamed from: b  reason: collision with root package name */
        public String f46352b;

        /* renamed from: c  reason: collision with root package name */
        public String f46353c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ j f46354d;

        public a(j jVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46354d = jVar;
            this.f46353c = "";
            this.f46351a = new WeakReference<>(callbackHandler);
            this.f46352b = str;
        }

        public void a(CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, callbackHandler, str) == null) {
                this.f46351a = new WeakReference<>(callbackHandler);
                this.f46352b = str;
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                if (j.f46347d) {
                    Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i2 + " networkType " + i3);
                }
                if (2 == i2) {
                    String d2 = SwanAppNetworkUtils.d(i3, null);
                    if (TextUtils.isEmpty(d2) || d2.equals(this.f46353c)) {
                        return;
                    }
                    this.f46353c = d2;
                    SwanAppNetworkUtils.k(this.f46354d, this.f46351a.get(), this.f46352b);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(712046567, "Ld/a/n0/a/n1/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(712046567, "Ld/a/n0/a/n1/j;");
                return;
            }
        }
        f46347d = d.a.n0.a.k.f45831a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(d.a.n0.a.a2.e eVar) {
        super(eVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.n0.a.a2.e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, callbackHandler, str) == null) {
            if (this.f46349b == null) {
                this.f46349b = (TelephonyManager) getSystemService("phone");
                a aVar = new a(this, callbackHandler, str);
                this.f46350c = aVar;
                this.f46349b.listen(aVar, 64);
                return;
            }
            a aVar2 = this.f46350c;
            if (aVar2 != null) {
                aVar2.a(callbackHandler, str);
            }
        }
    }

    public void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callbackHandler, str) == null) {
            NetworkBroadcastReceiver networkBroadcastReceiver = this.f46348a;
            if (networkBroadcastReceiver == null) {
                this.f46348a = new NetworkBroadcastReceiver(callbackHandler, str);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                registerReceiver(this.f46348a, intentFilter);
            } else if (networkBroadcastReceiver != null) {
                networkBroadcastReceiver.updateCallback(callbackHandler, str);
            }
            a(callbackHandler, str);
        }
    }
}
