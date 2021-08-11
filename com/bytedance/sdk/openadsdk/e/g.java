package com.bytedance.sdk.openadsdk.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.task.item.StrictModeTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.e.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class g<T extends i> extends HandlerThread implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f67398a = "AdEventThread";

    /* renamed from: b  reason: collision with root package name */
    public static String f67399b = "ttad_bk";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final e<T> f67400c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.p<T> f67401d;

    /* renamed from: e  reason: collision with root package name */
    public final List<T> f67402e;

    /* renamed from: f  reason: collision with root package name */
    public long f67403f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67404g;

    /* renamed from: h  reason: collision with root package name */
    public int f67405h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f67406i;

    /* renamed from: j  reason: collision with root package name */
    public final a f67407j;
    public final b k;
    public boolean l;

    /* loaded from: classes9.dex */
    public interface a {
        boolean a();
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f67408a;

        /* renamed from: b  reason: collision with root package name */
        public final long f67409b;

        /* renamed from: c  reason: collision with root package name */
        public final long f67410c;

        /* renamed from: d  reason: collision with root package name */
        public final int f67411d;

        /* renamed from: e  reason: collision with root package name */
        public final long f67412e;

        /* renamed from: f  reason: collision with root package name */
        public final long f67413f;

        public b(int i2, long j2, long j3, int i3, long j4, long j5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j4), Long.valueOf(j5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67408a = i2;
            this.f67409b = j2;
            this.f67410c = j3;
            this.f67411d = i3;
            this.f67412e = j4;
            this.f67413f = j5;
        }

        public static b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new b(1, AppConfig.TIMESTAMP_AVAILABLE_DURATION, 15000L, 5, StrictModeTask.CLEAN_FILE_INTERVAL, 300000L) : (b) invokeV.objValue;
        }

        public static b b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new b(3, AppConfig.TIMESTAMP_AVAILABLE_DURATION, 15000L, 5, StrictModeTask.CLEAN_FILE_INTERVAL, 300000L) : (b) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(97751987, "Lcom/bytedance/sdk/openadsdk/e/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(97751987, "Lcom/bytedance/sdk/openadsdk/e/g;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e<T> eVar, com.bytedance.sdk.openadsdk.core.p<T> pVar, b bVar, a aVar) {
        super("tt_pangle_thread__" + f67399b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, pVar, bVar, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = bVar;
        this.f67407j = aVar;
        this.f67400c = eVar;
        this.f67401d = pVar;
        this.f67402e = Collections.synchronizedList(new LinkedList());
        this.l = false;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            e<T> eVar = this.f67400c;
            b bVar = this.k;
            eVar.a(bVar.f67411d, bVar.f67412e);
            this.f67404g = this.f67400c.a();
            this.f67405h = this.f67400c.b();
            if (this.f67404g) {
                a("onHandleInitEvent serverBusy, retryCount = " + this.f67405h);
                h();
                return;
            }
            b(this.f67400c.a(100, "_id"));
            a("onHandleInitEvent,mCloseSaveAndRetry is false, read db event data");
            a("onHandleInitEvent cacheData count = " + this.f67402e.size());
            e();
        }
    }

    private void b(List<T> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, list) == null) {
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        HashSet hashSet = new HashSet();
                        for (T t : this.f67402e) {
                            hashSet.add(t.b());
                        }
                        for (T t2 : list) {
                            if (!hashSet.contains(t2.b())) {
                                this.f67402e.add(t2);
                            }
                        }
                        return;
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            a("reloadCacheList adEventList is empty======");
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.f67404g) {
            return;
        }
        a("onHandleRoutineRetryEvent");
        e();
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || this.f67404g) {
            return;
        }
        a("onHandleRoutineUploadEvent");
        e();
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.f67406i.removeMessages(3);
            this.f67406i.removeMessages(2);
            if (com.bytedance.sdk.component.utils.i.a(this.f67402e)) {
                this.f67403f = System.currentTimeMillis();
                j();
            } else if (!this.f67407j.a()) {
                a("doRoutineUpload no net, wait retry");
                i();
            } else {
                h a2 = a(this.f67402e);
                if (a2 != null) {
                    if (a2.f67414a) {
                        a("doRoutineUpload success");
                        g();
                        f();
                    } else if (a(a2)) {
                        a("doRoutineUpload serverbusy");
                        k();
                    } else if (b(a2)) {
                        g();
                        f();
                    } else if (this.f67404g) {
                    } else {
                        if (!this.l) {
                            i();
                            a("doRoutineUpload net fail retry");
                            return;
                        }
                        l();
                    }
                }
            }
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.f67403f = System.currentTimeMillis();
            o();
            j();
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            a("clearCacheList, delete event from cache and db");
            this.f67400c.a(this.f67402e);
            this.f67402e.clear();
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            a(4, m());
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            a(3, this.k.f67410c);
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            a(2, this.k.f67409b);
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            this.f67404g = true;
            this.f67400c.a(true);
            this.f67402e.clear();
            this.f67406i.removeMessages(3);
            this.f67406i.removeMessages(2);
            h();
        }
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            this.f67404g = true;
            this.f67400c.a(true);
            this.f67402e.clear();
            this.f67406i.removeMessages(3);
            this.f67406i.removeMessages(2);
            h();
        }
    }

    private long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) ? ((this.f67405h % 3) + 1) * this.k.f67413f : invokeV.longValue;
    }

    private boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) ? !this.f67404g && (this.f67402e.size() >= this.k.f67408a || System.currentTimeMillis() - this.f67403f >= this.k.f67409b) : invokeV.booleanValue;
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            this.f67404g = false;
            this.f67400c.a(false);
            this.f67405h = 0;
            this.f67400c.a(0);
            this.f67406i.removeMessages(4);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.bytedance.sdk.openadsdk.e.g<T extends com.bytedance.sdk.openadsdk.e.i> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message)) == null) {
            int i2 = message.what;
            if (i2 == 1) {
                a((g<T>) ((i) message.obj));
            } else if (i2 == 2) {
                d();
            } else if (i2 == 3) {
                c();
            } else if (i2 == 4) {
                b();
            } else if (i2 == 5) {
                a();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f67403f = System.currentTimeMillis();
            this.f67406i = new Handler(getLooper(), this);
        }
    }

    private void c(List<T> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, this, list) == null) && this.l && list != null) {
            if (list.size() <= 100) {
                a("start and return, checkAndDeleteEvent local size:" + list.size() + "小于:100");
                return;
            }
            int size = (int) (list.size() - 75.0f);
            a("start checkAndDeleteEvent local size,deleteCnt:" + list.size() + "," + size);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(list.get(i2));
            }
            list.removeAll(arrayList);
            this.f67400c.a(arrayList);
            a("end checkAndDeleteEvent local size:" + list.size());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(String str, String str2, e<T> eVar, com.bytedance.sdk.openadsdk.core.p<T> pVar, b bVar, a aVar) {
        super("tt_pangle_thread__" + str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, eVar, pVar, bVar, aVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        f67398a = str2;
        this.k = bVar;
        this.f67407j = aVar;
        this.f67400c = eVar;
        this.f67401d = pVar;
        this.f67402e = Collections.synchronizedList(new LinkedList());
        this.l = false;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            if (!this.f67407j.a()) {
                a(4, this.k.f67410c);
                a("onHandleServerBusyRetryEvent, no net");
                return;
            }
            List<T> a2 = this.f67400c.a(100, "_id");
            c(a2);
            if (com.bytedance.sdk.component.utils.i.a(a2)) {
                a("onHandleServerBusyRetryEvent, empty list start routine");
                o();
                j();
                return;
            }
            h a3 = a(a2);
            if (a3 != null) {
                if (a3.f67414a) {
                    a("onHandleServerBusyRetryEvent, success");
                    g();
                    f();
                } else if (a(a3)) {
                    int i2 = this.f67405h + 1;
                    this.f67405h = i2;
                    this.f67400c.a(i2);
                    e<T> eVar = this.f67400c;
                    b bVar = this.k;
                    eVar.a(a2, bVar.f67411d, bVar.f67412e);
                    h();
                    a("onHandleServerBusyRetryEvent, serverbusy, count = " + this.f67405h);
                } else if (b(a3)) {
                    g();
                    f();
                } else if (!this.l) {
                    i();
                    a("onHandleServerBusyRetryEvent, net fail");
                } else {
                    int i3 = this.f67405h + 1;
                    this.f67405h = i3;
                    this.f67400c.a(i3);
                    e<T> eVar2 = this.f67400c;
                    b bVar2 = this.k;
                    eVar2.a(a2, bVar2.f67411d, bVar2.f67412e);
                    l();
                }
            }
        }
    }

    public h a(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (this.f67401d == null) {
                com.bytedance.sdk.openadsdk.core.o.f();
            }
            com.bytedance.sdk.openadsdk.core.p<T> pVar = this.f67401d;
            if (pVar == null) {
                return null;
            }
            return pVar.a(list);
        }
        return (h) invokeL.objValue;
    }

    private void a(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, t) == null) {
            c(this.f67402e);
            this.f67400c.a((e<T>) t);
            a("onHandleReceivedAdEvent mCloseSaveAndRetry is false, save event into db");
            if (this.f67404g) {
                return;
            }
            a("onHandleReceivedAdEvent");
            this.f67402e.add(t);
            if (n()) {
                a("onHandleReceivedAdEvent upload");
                e();
            }
        }
    }

    private void a(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            Message obtainMessage = this.f67406i.obtainMessage();
            obtainMessage.what = i2;
            this.f67406i.sendMessageDelayed(obtainMessage, j2);
        }
    }

    public static boolean a(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, hVar)) == null) ? hVar.f67415b == 509 : invokeL.booleanValue;
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str) == null) {
            com.bytedance.sdk.component.utils.k.b(f67398a, str);
        }
    }

    public static boolean b(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, hVar)) == null) ? hVar.f67417d : invokeL.booleanValue;
    }
}
