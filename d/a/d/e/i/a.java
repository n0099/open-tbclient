package d.a.d.e.i;

import android.location.Address;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static a m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f41676a;

    /* renamed from: b  reason: collision with root package name */
    public long f41677b;

    /* renamed from: c  reason: collision with root package name */
    public long f41678c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f41679d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41680e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f41681f;

    /* renamed from: g  reason: collision with root package name */
    public int f41682g;

    /* renamed from: h  reason: collision with root package name */
    public Address f41683h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<SoftReference<c>> f41684i;
    public ArrayList<d.a.d.e.i.b> j;
    public Handler k;
    public d l;

    /* renamed from: d.a.d.e.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0558a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f41685a;

        public C0558a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41685a = aVar;
        }

        @Override // d.a.d.e.i.a.d
        public void a(int i2, String str, Address address, long j, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, address, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
                a aVar = this.f41685a;
                aVar.f41677b = j;
                aVar.f41683h = address;
                this.f41685a.f41679d = z;
                this.f41685a.f41682g = i2;
                this.f41685a.s();
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 == 4 && StringUtils.isNull(str)) {
                                str = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                            }
                        } else if (StringUtils.isNull(str)) {
                            str = BdBaseApplication.getInst().getResources().getString(R.string.location_all_offline);
                        }
                    } else if (StringUtils.isNull(str)) {
                        str = BdBaseApplication.getInst().getResources().getString(R.string.location_net_offline);
                    }
                } else if (StringUtils.isNull(str)) {
                    str = BdBaseApplication.getInst().getResources().getString(R.string.location_gps_offline);
                }
                this.f41685a.g(i2, str, address);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f41686e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41686e = aVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            String string;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what != 0) {
                    return false;
                }
                this.f41686e.s();
                int i2 = this.f41686e.f41682g;
                if (i2 == 1) {
                    string = BdBaseApplication.getInst().getResources().getString(R.string.location_gps_offline);
                } else if (i2 == 2) {
                    string = BdBaseApplication.getInst().getResources().getString(R.string.location_net_offline);
                } else if (i2 == 3) {
                    string = BdBaseApplication.getInst().getResources().getString(R.string.location_all_offline);
                } else if (i2 != 4) {
                    string = i2 != 6 ? "" : BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                } else {
                    string = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                }
                a aVar = this.f41686e;
                aVar.g(aVar.f41682g, string, null);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void onLocationGeted(int i2, String str, Address address);
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a(int i2, String str, Address address, long j, boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-402244198, "Ld/a/d/e/i/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-402244198, "Ld/a/d/e/i/a;");
        }
    }

    public a() {
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
        this.f41676a = 10000L;
        this.f41677b = 0L;
        this.f41678c = 300000L;
        this.f41679d = false;
        this.f41680e = false;
        this.f41681f = false;
        this.f41682g = 4;
        this.f41683h = null;
        this.f41684i = null;
        this.j = new ArrayList<>();
        this.k = null;
        this.l = new C0558a(this);
    }

    public static a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (m == null) {
                synchronized (a.class) {
                    if (m == null) {
                        m = new a();
                    }
                }
            }
            return m;
        }
        return (a) invokeV.objValue;
    }

    public final void g(int i2, String str, Address address) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, address) == null) {
            if (this.k.hasMessages(0)) {
                this.k.removeMessages(0);
            }
            ArrayList<SoftReference<c>> arrayList = this.f41684i;
            if (arrayList != null) {
                synchronized (arrayList) {
                    for (int i3 = 0; i3 < this.f41684i.size(); i3++) {
                        SoftReference<c> softReference = this.f41684i.get(i3);
                        if (softReference != null && (cVar = softReference.get()) != null) {
                            cVar.onLocationGeted(i2, str, address);
                        }
                    }
                    this.f41684i.clear();
                }
            }
        }
    }

    public Address h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? j(z, false) : (Address) invokeZ.objValue;
    }

    public Address i(boolean z, c cVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZL = interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, cVar)) == null) ? k(z, false, cVar) : (Address) invokeZL.objValue;
    }

    public Address j(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (System.currentTimeMillis() - this.f41677b > this.f41678c) {
                this.f41683h = null;
            }
            if (this.f41683h != null && !z && ((z2 && this.f41679d) || !z2)) {
                return this.f41683h;
            }
            this.f41683h = null;
            boolean z3 = this.f41681f;
            if (!z3) {
                r(z2);
                return null;
            }
            if (z3 && z2 && !this.f41680e) {
                s();
                r(z2);
            }
            return null;
        }
        return (Address) invokeCommon.objValue;
    }

    public Address k(boolean z, boolean z2, c cVar) {
        InterceptResult invokeCommon;
        boolean z3;
        c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), cVar})) == null) {
            if (System.currentTimeMillis() - this.f41677b > this.f41678c) {
                this.f41683h = null;
            }
            if (this.f41683h != null && !z && ((z2 && this.f41679d) || !z2)) {
                if (cVar != null) {
                    cVar.onLocationGeted(0, "", this.f41683h);
                }
                return this.f41683h;
            }
            if (cVar != null) {
                synchronized (this.f41684i) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.f41684i.size()) {
                            z3 = false;
                            break;
                        }
                        SoftReference<c> softReference = this.f41684i.get(i2);
                        if (softReference != null && (cVar2 = softReference.get()) != null && cVar2.equals(cVar)) {
                            z3 = true;
                            break;
                        }
                        i2++;
                    }
                    if (!z3) {
                        if (this.f41684i.size() >= 100) {
                            this.f41684i.remove(0);
                        }
                        this.f41684i.add(new SoftReference<>(cVar));
                    }
                }
                boolean z4 = this.f41681f;
                if (!z4) {
                    r(z2);
                    return null;
                } else if (z4 && z2 && !this.f41680e) {
                    s();
                    r(z2);
                    return null;
                }
            }
            return null;
        }
        return (Address) invokeCommon.objValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f41676a : invokeV.longValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.k = new Handler(Looper.getMainLooper(), new b(this));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f41684i = new ArrayList<>();
            n();
        }
    }

    public void p(d.a.d.e.i.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        synchronized (this.j) {
            if (!this.j.contains(bVar)) {
                bVar.b(this.l);
                this.j.add(bVar);
            }
        }
    }

    public void q(c cVar) {
        c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            synchronized (this.f41684i) {
                int i2 = 0;
                while (true) {
                    if (i2 < this.f41684i.size()) {
                        SoftReference<c> softReference = this.f41684i.get(i2);
                        if (softReference != null && (cVar2 = softReference.get()) != null && cVar2.equals(cVar)) {
                            this.f41684i.remove(softReference);
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public final void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (this.k.hasMessages(0)) {
                this.k.removeMessages(0);
            }
            this.f41682g = 4;
            this.f41680e = z;
            this.f41681f = true;
            ArrayList<d.a.d.e.i.b> arrayList = this.j;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<d.a.d.e.i.b> it = this.j.iterator();
                while (it.hasNext()) {
                    d.a.d.e.i.b next = it.next();
                    if (next != null) {
                        try {
                            next.a(z);
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                }
                Handler handler = this.k;
                handler.sendMessageDelayed(handler.obtainMessage(0), this.f41676a);
                return;
            }
            this.f41682g = 6;
            Handler handler2 = this.k;
            handler2.sendMessage(handler2.obtainMessage(0));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.k.hasMessages(0)) {
                this.k.removeMessages(0);
            }
            this.f41681f = false;
            Iterator<d.a.d.e.i.b> it = this.j.iterator();
            while (it.hasNext()) {
                d.a.d.e.i.b next = it.next();
                if (next != null) {
                    try {
                        next.c();
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        }
    }

    public void t(d.a.d.e.i.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) || bVar == null) {
            return;
        }
        synchronized (this.j) {
            bVar.destroy();
            this.j.remove(bVar);
        }
    }
}
