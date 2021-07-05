package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class av {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static av f43587a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public List<a> f901a;

    /* renamed from: a  reason: collision with other field name */
    public ConcurrentHashMap<String, HashMap<String, b>> f902a;

    /* loaded from: classes8.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f43588a;

        /* renamed from: a  reason: collision with other field name */
        public Context f903a;

        /* renamed from: a  reason: collision with other field name */
        public IBinder.DeathRecipient f904a;

        /* renamed from: a  reason: collision with other field name */
        public Messenger f905a;

        /* renamed from: a  reason: collision with other field name */
        public XMPushService.b f906a;

        /* renamed from: a  reason: collision with other field name */
        public XMPushService f907a;

        /* renamed from: a  reason: collision with other field name */
        public final C0570b f908a;

        /* renamed from: a  reason: collision with other field name */
        public c f909a;

        /* renamed from: a  reason: collision with other field name */
        public e f910a;

        /* renamed from: a  reason: collision with other field name */
        public String f911a;

        /* renamed from: a  reason: collision with other field name */
        public List<a> f912a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f913a;

        /* renamed from: b  reason: collision with root package name */
        public c f43589b;

        /* renamed from: b  reason: collision with other field name */
        public String f914b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f915b;

        /* renamed from: c  reason: collision with root package name */
        public String f43590c;

        /* renamed from: d  reason: collision with root package name */
        public String f43591d;

        /* renamed from: e  reason: collision with root package name */
        public String f43592e;

        /* renamed from: f  reason: collision with root package name */
        public String f43593f;

        /* renamed from: g  reason: collision with root package name */
        public String f43594g;

        /* renamed from: h  reason: collision with root package name */
        public String f43595h;

        /* renamed from: i  reason: collision with root package name */
        public String f43596i;

        /* loaded from: classes8.dex */
        public interface a {
            void a(c cVar, c cVar2, int i2);
        }

        /* renamed from: com.xiaomi.push.service.av$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0570b extends XMPushService.i {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f43597a;

            /* renamed from: a  reason: collision with other field name */
            public String f916a;

            /* renamed from: b  reason: collision with root package name */
            public int f43598b;

            /* renamed from: b  reason: collision with other field name */
            public String f917b;

            /* renamed from: c  reason: collision with root package name */
            public int f43599c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0570b(b bVar) {
                super(0);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f43597a = bVar;
            }

            public XMPushService.i a(int i2, int i3, String str, String str2) {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2})) == null) {
                    this.f43598b = i2;
                    this.f43599c = i3;
                    this.f917b = str2;
                    this.f916a = str;
                    return this;
                }
                return (XMPushService.i) invokeCommon.objValue;
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public String a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "notify job" : (String) invokeV.objValue;
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    if (this.f43597a.a(this.f43598b, this.f43599c, this.f917b)) {
                        this.f43597a.a(this.f43598b, this.f43599c, this.f916a, this.f917b);
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + this.f43597a.f43594g);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements IBinder.DeathRecipient {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final Messenger f43600a;

            /* renamed from: a  reason: collision with other field name */
            public final b f918a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f43601b;

            public c(b bVar, b bVar2, Messenger messenger) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, bVar2, messenger};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f43601b = bVar;
                this.f918a = bVar2;
                this.f43600a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f918a.f43594g);
                    this.f43601b.f907a.a(new ax(this, 0), 0L);
                    if ("9".equals(this.f918a.f43594g) && "com.xiaomi.xmsf".equals(this.f43601b.f907a.getPackageName())) {
                        this.f43601b.f907a.a(new ay(this, 0), 60000L);
                    }
                }
            }
        }

        public b() {
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
            this.f909a = c.f43602a;
            this.f43588a = 0;
            this.f912a = new ArrayList();
            this.f43589b = null;
            this.f915b = false;
            this.f906a = new XMPushService.b(this);
            this.f904a = null;
            this.f908a = new C0570b(this);
        }

        public b(XMPushService xMPushService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f909a = c.f43602a;
            this.f43588a = 0;
            this.f912a = new ArrayList();
            this.f43589b = null;
            this.f915b = false;
            this.f906a = new XMPushService.b(this);
            this.f904a = null;
            this.f908a = new C0570b(this);
            this.f907a = xMPushService;
            a(new aw(this));
        }

        public static String a(String str) {
            InterceptResult invokeL;
            int lastIndexOf;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) ? (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(lastIndexOf + 1) : (String) invokeL.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, int i3, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2}) == null) {
                c cVar = this.f909a;
                this.f43589b = cVar;
                if (i2 == 2) {
                    this.f910a.a(this.f903a, this, i3);
                } else if (i2 == 3) {
                    this.f910a.a(this.f903a, this, str2, str);
                } else if (i2 == 1) {
                    boolean z = cVar == c.f43604c;
                    if (!z && "wait".equals(str2)) {
                        this.f43588a++;
                    } else if (z) {
                        this.f43588a = 0;
                        if (this.f905a != null) {
                            try {
                                this.f905a.send(Message.obtain(null, 16, this.f907a.f841a));
                            } catch (RemoteException unused) {
                            }
                        }
                    }
                    this.f910a.a(this.f907a, this, z, i3, str);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(int i2, int i3, String str) {
            InterceptResult invokeIIL;
            boolean z;
            StringBuilder sb;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65543, this, i2, i3, str)) == null) {
                c cVar = this.f43589b;
                if (cVar == null || !(z = this.f915b)) {
                    return true;
                }
                if (cVar == this.f909a) {
                    sb = new StringBuilder();
                    str2 = " status recovered, don't notify client:";
                } else if (this.f905a != null && z) {
                    com.xiaomi.channel.commonutils.logger.b.b("Peer alive notify status to client:" + this.f43594g);
                    return true;
                } else {
                    sb = new StringBuilder();
                    str2 = "peer died, ignore notify ";
                }
                sb.append(str2);
                sb.append(this.f43594g);
                com.xiaomi.channel.commonutils.logger.b.b(sb.toString());
                return false;
            }
            return invokeIIL.booleanValue;
        }

        private boolean b(int i2, int i3, String str) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65545, this, i2, i3, str)) == null) {
                if (i2 == 1) {
                    return (this.f909a == c.f43604c || !this.f907a.m567c() || i3 == 21 || (i3 == 7 && "wait".equals(str))) ? false : true;
                } else if (i2 != 2) {
                    if (i2 != 3) {
                        return false;
                    }
                    return !"wait".equals(str);
                } else {
                    return this.f907a.m567c();
                }
            }
            return invokeIIL.booleanValue;
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.f43588a + 1) * 15)) * 1000 : invokeV.longValue;
        }

        public String a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN" : (String) invokeI.objValue;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m607a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    Messenger messenger = this.f905a;
                    if (messenger != null && this.f904a != null) {
                        messenger.getBinder().unlinkToDeath(this.f904a, 0);
                    }
                } catch (Exception unused) {
                }
                this.f43589b = null;
            }
        }

        public void a(Messenger messenger) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, messenger) == null) {
                m607a();
                try {
                    if (messenger != null) {
                        this.f905a = messenger;
                        this.f915b = true;
                        this.f904a = new c(this, this, messenger);
                        messenger.getBinder().linkToDeath(this.f904a, 0);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.f43594g);
                    }
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e2.getMessage());
                    this.f905a = null;
                    this.f915b = false;
                }
            }
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                synchronized (this.f912a) {
                    this.f912a.add(aVar);
                }
            }
        }

        public void a(c cVar, int i2, int i3, String str, String str2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{cVar, Integer.valueOf(i2), Integer.valueOf(i3), str, str2}) == null) {
                synchronized (this.f912a) {
                    for (a aVar : this.f912a) {
                        aVar.a(this.f909a, cVar, i3);
                    }
                }
                c cVar2 = this.f909a;
                int i4 = 0;
                if (cVar2 != cVar) {
                    com.xiaomi.channel.commonutils.logger.b.m70a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, a(i2), az.a(i3), str, str2, this.f43594g));
                    this.f909a = cVar;
                }
                if (this.f910a == null) {
                    com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
                } else if (cVar != c.f43603b) {
                    if (this.f43589b != null && (z = this.f915b)) {
                        i4 = (this.f905a == null || !z) ? 10100 : 1000;
                    }
                    this.f907a.b(this.f908a);
                    if (b(i2, i3, str2)) {
                        a(i2, i3, str, str2);
                    } else {
                        this.f907a.a(this.f908a.a(i2, i3, str, str2), i4);
                    }
                }
            }
        }

        public void b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
                synchronized (this.f912a) {
                    this.f912a.remove(aVar);
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f43602a;

        /* renamed from: a  reason: collision with other field name */
        public static final /* synthetic */ c[] f919a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f43603b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f43604c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1404810510, "Lcom/xiaomi/push/service/av$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1404810510, "Lcom/xiaomi/push/service/av$c;");
                    return;
                }
            }
            f43602a = new c("unbind", 0);
            f43603b = new c("binding", 1);
            c cVar = new c("binded", 2);
            f43604c = cVar;
            f919a = new c[]{f43602a, f43603b, cVar};
        }

        public c(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static c valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (c) Enum.valueOf(c.class, str) : (c) invokeL.objValue;
        }

        public static c[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (c[]) f919a.clone() : (c[]) invokeV.objValue;
        }
    }

    public av() {
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
        this.f902a = new ConcurrentHashMap<>();
        this.f901a = new ArrayList();
    }

    public static synchronized av a() {
        InterceptResult invokeV;
        av avVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (av.class) {
                if (f43587a == null) {
                    f43587a = new av();
                }
                avVar = f43587a;
            }
            return avVar;
        }
        return (av) invokeV.objValue;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int indexOf = str.indexOf(TNCManager.TNC_PROBE_HEADER_SECEPTOR);
            return indexOf > 0 ? str.substring(0, indexOf) : str;
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m599a() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                size = this.f902a.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public synchronized b a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            synchronized (this) {
                HashMap<String, b> hashMap = this.f902a.get(str);
                if (hashMap == null) {
                    return null;
                }
                return hashMap.get(a(str2));
            }
        }
        return (b) invokeLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<b> m600a() {
        InterceptResult invokeV;
        ArrayList<b> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList<>();
                for (HashMap<String, b> hashMap : this.f902a.values()) {
                    arrayList.addAll(hashMap.values());
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<b> m601a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                return !this.f902a.containsKey(str) ? new ArrayList() : ((HashMap) this.f902a.get(str).clone()).values();
            }
        }
        return (Collection) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<String> m602a(String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (HashMap<String, b> hashMap : this.f902a.values()) {
                    for (b bVar : hashMap.values()) {
                        if (str.equals(bVar.f911a)) {
                            arrayList.add(bVar.f43594g);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m603a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                Iterator<b> it = m600a().iterator();
                while (it.hasNext()) {
                    it.next().m607a();
                }
                this.f902a.clear();
            }
        }
    }

    public synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            synchronized (this) {
                for (HashMap<String, b> hashMap : this.f902a.values()) {
                    for (b bVar : hashMap.values()) {
                        bVar.a(c.f43602a, 1, 3, (String) null, (String) null);
                    }
                }
            }
        }
    }

    public synchronized void a(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, context, i2) == null) {
            synchronized (this) {
                for (HashMap<String, b> hashMap : this.f902a.values()) {
                    for (b bVar : hashMap.values()) {
                        bVar.a(c.f43602a, 2, i2, (String) null, (String) null);
                    }
                }
            }
        }
    }

    public synchronized void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            synchronized (this) {
                this.f901a.add(aVar);
            }
        }
    }

    public synchronized void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            synchronized (this) {
                HashMap<String, b> hashMap = this.f902a.get(bVar.f43594g);
                if (hashMap == null) {
                    hashMap = new HashMap<>();
                    this.f902a.put(bVar.f43594g, hashMap);
                }
                hashMap.put(a(bVar.f914b), bVar);
                for (a aVar : this.f901a) {
                    aVar.a();
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m604a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            synchronized (this) {
                HashMap<String, b> hashMap = this.f902a.get(str);
                if (hashMap != null) {
                    for (b bVar : hashMap.values()) {
                        bVar.m607a();
                    }
                    hashMap.clear();
                    this.f902a.remove(str);
                }
                for (a aVar : this.f901a) {
                    aVar.a();
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m605a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            synchronized (this) {
                HashMap<String, b> hashMap = this.f902a.get(str);
                if (hashMap != null) {
                    b bVar = hashMap.get(a(str2));
                    if (bVar != null) {
                        bVar.m607a();
                    }
                    hashMap.remove(a(str2));
                    if (hashMap.isEmpty()) {
                        this.f902a.remove(str);
                    }
                }
                for (a aVar : this.f901a) {
                    aVar.a();
                }
            }
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                this.f901a.clear();
            }
        }
    }
}
