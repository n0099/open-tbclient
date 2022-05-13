package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static av a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public List<a> f882a;

    /* renamed from: a  reason: collision with other field name */
    public ConcurrentHashMap<String, HashMap<String, b>> f883a;

    /* loaded from: classes8.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public Context f884a;

        /* renamed from: a  reason: collision with other field name */
        public IBinder.DeathRecipient f885a;

        /* renamed from: a  reason: collision with other field name */
        public Messenger f886a;

        /* renamed from: a  reason: collision with other field name */
        public XMPushService.b f887a;

        /* renamed from: a  reason: collision with other field name */
        public XMPushService f888a;

        /* renamed from: a  reason: collision with other field name */
        public final C0658b f889a;

        /* renamed from: a  reason: collision with other field name */
        public c f890a;

        /* renamed from: a  reason: collision with other field name */
        public e f891a;

        /* renamed from: a  reason: collision with other field name */
        public String f892a;

        /* renamed from: a  reason: collision with other field name */
        public List<a> f893a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f894a;
        public c b;

        /* renamed from: b  reason: collision with other field name */
        public String f895b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f896b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;

        /* loaded from: classes8.dex */
        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        /* renamed from: com.xiaomi.push.service.av$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0658b extends XMPushService.i {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            /* renamed from: a  reason: collision with other field name */
            public String f897a;
            public int b;

            /* renamed from: b  reason: collision with other field name */
            public String f898b;
            public int c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0658b(b bVar) {
                super(0);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            public XMPushService.i a(int i, int i2, String str, String str2) {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2})) == null) {
                    this.b = i;
                    this.c = i2;
                    this.f898b = str2;
                    this.f897a = str;
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
                    if (this.a.a(this.b, this.c, this.f898b)) {
                        this.a.a(this.b, this.c, this.f897a, this.f898b);
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + this.a.g);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements IBinder.DeathRecipient {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final Messenger a;

            /* renamed from: a  reason: collision with other field name */
            public final b f899a;
            public final /* synthetic */ b b;

            public c(b bVar, b bVar2, Messenger messenger) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, bVar2, messenger};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.f899a = bVar2;
                this.a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f899a.g);
                    this.b.f888a.a(new ax(this, 0), 0L);
                    if ("9".equals(this.f899a.g) && "com.xiaomi.xmsf".equals(this.b.f888a.getPackageName())) {
                        this.b.f888a.a(new ay(this, 0), 60000L);
                    }
                }
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f890a = c.a;
            this.a = 0;
            this.f893a = new ArrayList();
            this.b = null;
            this.f896b = false;
            this.f887a = new XMPushService.b(this);
            this.f885a = null;
            this.f889a = new C0658b(this);
        }

        public b(XMPushService xMPushService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f890a = c.a;
            this.a = 0;
            this.f893a = new ArrayList();
            this.b = null;
            this.f896b = false;
            this.f887a = new XMPushService.b(this);
            this.f885a = null;
            this.f889a = new C0658b(this);
            this.f888a = xMPushService;
            a(new aw(this));
        }

        public static String a(String str) {
            InterceptResult invokeL;
            int lastIndexOf;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(lastIndexOf + 1) : (String) invokeL.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2}) == null) {
                c cVar = this.f890a;
                this.b = cVar;
                if (i == 2) {
                    this.f891a.a(this.f884a, this, i2);
                } else if (i == 3) {
                    this.f891a.a(this.f884a, this, str2, str);
                } else if (i == 1) {
                    boolean z = cVar == c.c;
                    if (!z && "wait".equals(str2)) {
                        this.a++;
                    } else if (z) {
                        this.a = 0;
                        if (this.f886a != null) {
                            try {
                                this.f886a.send(Message.obtain(null, 16, this.f888a.f822a));
                            } catch (RemoteException unused) {
                            }
                        }
                    }
                    this.f891a.a(this.f888a, this, z, i2, str);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(int i, int i2, String str) {
            InterceptResult invokeIIL;
            boolean z;
            StringBuilder sb;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65543, this, i, i2, str)) == null) {
                c cVar = this.b;
                if (cVar == null || !(z = this.f896b)) {
                    return true;
                }
                if (cVar == this.f890a) {
                    sb = new StringBuilder();
                    str2 = " status recovered, don't notify client:";
                } else if (this.f886a != null && z) {
                    com.xiaomi.channel.commonutils.logger.b.b("Peer alive notify status to client:" + this.g);
                    return true;
                } else {
                    sb = new StringBuilder();
                    str2 = "peer died, ignore notify ";
                }
                sb.append(str2);
                sb.append(this.g);
                com.xiaomi.channel.commonutils.logger.b.b(sb.toString());
                return false;
            }
            return invokeIIL.booleanValue;
        }

        private boolean b(int i, int i2, String str) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65545, this, i, i2, str)) == null) {
                if (i == 1) {
                    return (this.f890a == c.c || !this.f888a.m606c() || i2 == 21 || (i2 == 7 && "wait".equals(str))) ? false : true;
                } else if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    return !"wait".equals(str);
                } else {
                    return this.f888a.m606c();
                }
            }
            return invokeIIL.booleanValue;
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.a + 1) * 15)) * 1000 : invokeV.longValue;
        }

        public String a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? i != 1 ? i != 2 ? i != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN" : (String) invokeI.objValue;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m646a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    Messenger messenger = this.f886a;
                    if (messenger != null && this.f885a != null) {
                        messenger.getBinder().unlinkToDeath(this.f885a, 0);
                    }
                } catch (Exception unused) {
                }
                this.b = null;
            }
        }

        public void a(Messenger messenger) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, messenger) == null) {
                m646a();
                try {
                    if (messenger != null) {
                        this.f886a = messenger;
                        this.f896b = true;
                        this.f885a = new c(this, this, messenger);
                        messenger.getBinder().linkToDeath(this.f885a, 0);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.g);
                    }
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e.getMessage());
                    this.f886a = null;
                    this.f896b = false;
                }
            }
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                synchronized (this.f893a) {
                    this.f893a.add(aVar);
                }
            }
        }

        public void a(c cVar, int i, int i2, String str, String str2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{cVar, Integer.valueOf(i), Integer.valueOf(i2), str, str2}) == null) {
                synchronized (this.f893a) {
                    for (a aVar : this.f893a) {
                        aVar.a(this.f890a, cVar, i2);
                    }
                }
                c cVar2 = this.f890a;
                int i3 = 0;
                if (cVar2 != cVar) {
                    com.xiaomi.channel.commonutils.logger.b.m109a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, a(i), az.a(i2), str, str2, this.g));
                    this.f890a = cVar;
                }
                if (this.f891a == null) {
                    com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
                } else if (cVar != c.b) {
                    if (this.b != null && (z = this.f896b)) {
                        i3 = (this.f886a == null || !z) ? 10100 : 1000;
                    }
                    this.f888a.b(this.f889a);
                    if (b(i, i2, str2)) {
                        a(i, i2, str, str2);
                    } else {
                        this.f888a.a(this.f889a.a(i, i2, str, str2), i3);
                    }
                }
            }
        }

        public void b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
                synchronized (this.f893a) {
                    this.f893a.remove(aVar);
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;

        /* renamed from: a  reason: collision with other field name */
        public static final /* synthetic */ c[] f900a;
        public static final c b;
        public static final c c;
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
            a = new c("unbind", 0);
            b = new c("binding", 1);
            c cVar = new c("binded", 2);
            c = cVar;
            f900a = new c[]{a, b, cVar};
        }

        public c(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (c[]) f900a.clone() : (c[]) invokeV.objValue;
        }
    }

    public av() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f883a = new ConcurrentHashMap<>();
        this.f882a = new ArrayList();
    }

    public static synchronized av a() {
        InterceptResult invokeV;
        av avVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (av.class) {
                if (a == null) {
                    a = new av();
                }
                avVar = a;
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
            int indexOf = str.indexOf("@");
            return indexOf > 0 ? str.substring(0, indexOf) : str;
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m638a() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                size = this.f883a.size();
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
                HashMap<String, b> hashMap = this.f883a.get(str);
                if (hashMap == null) {
                    return null;
                }
                return hashMap.get(a(str2));
            }
        }
        return (b) invokeLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<b> m639a() {
        InterceptResult invokeV;
        ArrayList<b> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList<>();
                for (HashMap<String, b> hashMap : this.f883a.values()) {
                    arrayList.addAll(hashMap.values());
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<b> m640a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                return !this.f883a.containsKey(str) ? new ArrayList() : ((HashMap) this.f883a.get(str).clone()).values();
            }
        }
        return (Collection) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<String> m641a(String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (HashMap<String, b> hashMap : this.f883a.values()) {
                    for (b bVar : hashMap.values()) {
                        if (str.equals(bVar.f892a)) {
                            arrayList.add(bVar.g);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m642a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                Iterator<b> it = m639a().iterator();
                while (it.hasNext()) {
                    it.next().m646a();
                }
                this.f883a.clear();
            }
        }
    }

    public synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            synchronized (this) {
                for (HashMap<String, b> hashMap : this.f883a.values()) {
                    for (b bVar : hashMap.values()) {
                        bVar.a(c.a, 1, 3, (String) null, (String) null);
                    }
                }
            }
        }
    }

    public synchronized void a(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, context, i) == null) {
            synchronized (this) {
                for (HashMap<String, b> hashMap : this.f883a.values()) {
                    for (b bVar : hashMap.values()) {
                        bVar.a(c.a, 2, i, (String) null, (String) null);
                    }
                }
            }
        }
    }

    public synchronized void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            synchronized (this) {
                this.f882a.add(aVar);
            }
        }
    }

    public synchronized void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            synchronized (this) {
                HashMap<String, b> hashMap = this.f883a.get(bVar.g);
                if (hashMap == null) {
                    hashMap = new HashMap<>();
                    this.f883a.put(bVar.g, hashMap);
                }
                hashMap.put(a(bVar.f895b), bVar);
                for (a aVar : this.f882a) {
                    aVar.a();
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m643a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            synchronized (this) {
                HashMap<String, b> hashMap = this.f883a.get(str);
                if (hashMap != null) {
                    for (b bVar : hashMap.values()) {
                        bVar.m646a();
                    }
                    hashMap.clear();
                    this.f883a.remove(str);
                }
                for (a aVar : this.f882a) {
                    aVar.a();
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m644a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            synchronized (this) {
                HashMap<String, b> hashMap = this.f883a.get(str);
                if (hashMap != null) {
                    b bVar = hashMap.get(a(str2));
                    if (bVar != null) {
                        bVar.m646a();
                    }
                    hashMap.remove(a(str2));
                    if (hashMap.isEmpty()) {
                        this.f883a.remove(str);
                    }
                }
                for (a aVar : this.f882a) {
                    aVar.a();
                }
            }
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                this.f882a.clear();
            }
        }
    }
}
