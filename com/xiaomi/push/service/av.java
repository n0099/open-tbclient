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
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class av {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static av f72341a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public List<a> f906a;

    /* renamed from: a  reason: collision with other field name */
    public ConcurrentHashMap<String, HashMap<String, b>> f907a;

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f72342a;

        /* renamed from: a  reason: collision with other field name */
        public Context f908a;

        /* renamed from: a  reason: collision with other field name */
        public IBinder.DeathRecipient f909a;

        /* renamed from: a  reason: collision with other field name */
        public Messenger f910a;

        /* renamed from: a  reason: collision with other field name */
        public XMPushService.b f911a;

        /* renamed from: a  reason: collision with other field name */
        public XMPushService f912a;

        /* renamed from: a  reason: collision with other field name */
        public final C2068b f913a;

        /* renamed from: a  reason: collision with other field name */
        public c f914a;

        /* renamed from: a  reason: collision with other field name */
        public e f915a;

        /* renamed from: a  reason: collision with other field name */
        public String f916a;

        /* renamed from: a  reason: collision with other field name */
        public List<a> f917a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f918a;

        /* renamed from: b  reason: collision with root package name */
        public c f72343b;

        /* renamed from: b  reason: collision with other field name */
        public String f919b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f920b;

        /* renamed from: c  reason: collision with root package name */
        public String f72344c;

        /* renamed from: d  reason: collision with root package name */
        public String f72345d;

        /* renamed from: e  reason: collision with root package name */
        public String f72346e;

        /* renamed from: f  reason: collision with root package name */
        public String f72347f;

        /* renamed from: g  reason: collision with root package name */
        public String f72348g;

        /* renamed from: h  reason: collision with root package name */
        public String f72349h;

        /* renamed from: i  reason: collision with root package name */
        public String f72350i;

        /* loaded from: classes2.dex */
        public interface a {
            void a(c cVar, c cVar2, int i2);
        }

        /* renamed from: com.xiaomi.push.service.av$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C2068b extends XMPushService.i {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f72351a;

            /* renamed from: a  reason: collision with other field name */
            public String f921a;

            /* renamed from: b  reason: collision with root package name */
            public int f72352b;

            /* renamed from: b  reason: collision with other field name */
            public String f922b;

            /* renamed from: c  reason: collision with root package name */
            public int f72353c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C2068b(b bVar) {
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
                this.f72351a = bVar;
            }

            public XMPushService.i a(int i2, int i3, String str, String str2) {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2})) == null) {
                    this.f72352b = i2;
                    this.f72353c = i3;
                    this.f922b = str2;
                    this.f921a = str;
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
                    if (this.f72351a.a(this.f72352b, this.f72353c, this.f922b)) {
                        this.f72351a.a(this.f72352b, this.f72353c, this.f921a, this.f922b);
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + this.f72351a.f72348g);
                }
            }
        }

        /* loaded from: classes2.dex */
        public class c implements IBinder.DeathRecipient {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final Messenger f72354a;

            /* renamed from: a  reason: collision with other field name */
            public final b f923a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f72355b;

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
                this.f72355b = bVar;
                this.f923a = bVar2;
                this.f72354a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f923a.f72348g);
                    this.f72355b.f912a.a(new ax(this, 0), 0L);
                    if ("9".equals(this.f923a.f72348g) && "com.xiaomi.xmsf".equals(this.f72355b.f912a.getPackageName())) {
                        this.f72355b.f912a.a(new ay(this, 0), 60000L);
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
            this.f914a = c.f72356a;
            this.f72342a = 0;
            this.f917a = new ArrayList();
            this.f72343b = null;
            this.f920b = false;
            this.f911a = new XMPushService.b(this);
            this.f909a = null;
            this.f913a = new C2068b(this);
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
            this.f914a = c.f72356a;
            this.f72342a = 0;
            this.f917a = new ArrayList();
            this.f72343b = null;
            this.f920b = false;
            this.f911a = new XMPushService.b(this);
            this.f909a = null;
            this.f913a = new C2068b(this);
            this.f912a = xMPushService;
            a(new aw(this));
        }

        public static String a(String str) {
            InterceptResult invokeL;
            int lastIndexOf;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(lastIndexOf + 1) : (String) invokeL.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, int i3, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2}) == null) {
                c cVar = this.f914a;
                this.f72343b = cVar;
                if (i2 == 2) {
                    this.f915a.a(this.f908a, this, i3);
                } else if (i2 == 3) {
                    this.f915a.a(this.f908a, this, str2, str);
                } else if (i2 == 1) {
                    boolean z = cVar == c.f72358c;
                    if (!z && "wait".equals(str2)) {
                        this.f72342a++;
                    } else if (z) {
                        this.f72342a = 0;
                        if (this.f910a != null) {
                            try {
                                this.f910a.send(Message.obtain(null, 16, this.f912a.f846a));
                            } catch (RemoteException unused) {
                            }
                        }
                    }
                    this.f915a.a(this.f912a, this, z, i3, str);
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
                c cVar = this.f72343b;
                if (cVar == null || !(z = this.f920b)) {
                    return true;
                }
                if (cVar == this.f914a) {
                    sb = new StringBuilder();
                    str2 = " status recovered, don't notify client:";
                } else if (this.f910a != null && z) {
                    com.xiaomi.channel.commonutils.logger.b.b("Peer alive notify status to client:" + this.f72348g);
                    return true;
                } else {
                    sb = new StringBuilder();
                    str2 = "peer died, ignore notify ";
                }
                sb.append(str2);
                sb.append(this.f72348g);
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
                    return (this.f914a == c.f72358c || !this.f912a.m570c() || i3 == 21 || (i3 == 7 && "wait".equals(str))) ? false : true;
                } else if (i2 != 2) {
                    if (i2 != 3) {
                        return false;
                    }
                    return !"wait".equals(str);
                } else {
                    return this.f912a.m570c();
                }
            }
            return invokeIIL.booleanValue;
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.f72342a + 1) * 15)) * 1000 : invokeV.longValue;
        }

        public String a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN" : (String) invokeI.objValue;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m610a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    Messenger messenger = this.f910a;
                    if (messenger != null && this.f909a != null) {
                        messenger.getBinder().unlinkToDeath(this.f909a, 0);
                    }
                } catch (Exception unused) {
                }
                this.f72343b = null;
            }
        }

        public void a(Messenger messenger) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, messenger) == null) {
                m610a();
                try {
                    if (messenger != null) {
                        this.f910a = messenger;
                        this.f920b = true;
                        this.f909a = new c(this, this, messenger);
                        messenger.getBinder().linkToDeath(this.f909a, 0);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.f72348g);
                    }
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e2.getMessage());
                    this.f910a = null;
                    this.f920b = false;
                }
            }
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                synchronized (this.f917a) {
                    this.f917a.add(aVar);
                }
            }
        }

        public void a(c cVar, int i2, int i3, String str, String str2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{cVar, Integer.valueOf(i2), Integer.valueOf(i3), str, str2}) == null) {
                synchronized (this.f917a) {
                    for (a aVar : this.f917a) {
                        aVar.a(this.f914a, cVar, i3);
                    }
                }
                c cVar2 = this.f914a;
                int i4 = 0;
                if (cVar2 != cVar) {
                    com.xiaomi.channel.commonutils.logger.b.m73a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, a(i2), az.a(i3), str, str2, this.f72348g));
                    this.f914a = cVar;
                }
                if (this.f915a == null) {
                    com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
                } else if (cVar != c.f72357b) {
                    if (this.f72343b != null && (z = this.f920b)) {
                        i4 = (this.f910a == null || !z) ? 10100 : 1000;
                    }
                    this.f912a.b(this.f913a);
                    if (b(i2, i3, str2)) {
                        a(i2, i3, str, str2);
                    } else {
                        this.f912a.a(this.f913a.a(i2, i3, str, str2), i4);
                    }
                }
            }
        }

        public void b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
                synchronized (this.f917a) {
                    this.f917a.remove(aVar);
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f72356a;

        /* renamed from: a  reason: collision with other field name */
        public static final /* synthetic */ c[] f924a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f72357b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f72358c;
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
            f72356a = new c("unbind", 0);
            f72357b = new c("binding", 1);
            c cVar = new c("binded", 2);
            f72358c = cVar;
            f924a = new c[]{f72356a, f72357b, cVar};
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (c[]) f924a.clone() : (c[]) invokeV.objValue;
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
        this.f907a = new ConcurrentHashMap<>();
        this.f906a = new ArrayList();
    }

    public static synchronized av a() {
        InterceptResult invokeV;
        av avVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (av.class) {
                if (f72341a == null) {
                    f72341a = new av();
                }
                avVar = f72341a;
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
    public synchronized int m602a() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                size = this.f907a.size();
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
                HashMap<String, b> hashMap = this.f907a.get(str);
                if (hashMap == null) {
                    return null;
                }
                return hashMap.get(a(str2));
            }
        }
        return (b) invokeLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<b> m603a() {
        InterceptResult invokeV;
        ArrayList<b> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList<>();
                for (HashMap<String, b> hashMap : this.f907a.values()) {
                    arrayList.addAll(hashMap.values());
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<b> m604a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                return !this.f907a.containsKey(str) ? new ArrayList() : ((HashMap) this.f907a.get(str).clone()).values();
            }
        }
        return (Collection) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<String> m605a(String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (HashMap<String, b> hashMap : this.f907a.values()) {
                    for (b bVar : hashMap.values()) {
                        if (str.equals(bVar.f916a)) {
                            arrayList.add(bVar.f72348g);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m606a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                Iterator<b> it = m603a().iterator();
                while (it.hasNext()) {
                    it.next().m610a();
                }
                this.f907a.clear();
            }
        }
    }

    public synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            synchronized (this) {
                for (HashMap<String, b> hashMap : this.f907a.values()) {
                    for (b bVar : hashMap.values()) {
                        bVar.a(c.f72356a, 1, 3, (String) null, (String) null);
                    }
                }
            }
        }
    }

    public synchronized void a(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, context, i2) == null) {
            synchronized (this) {
                for (HashMap<String, b> hashMap : this.f907a.values()) {
                    for (b bVar : hashMap.values()) {
                        bVar.a(c.f72356a, 2, i2, (String) null, (String) null);
                    }
                }
            }
        }
    }

    public synchronized void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            synchronized (this) {
                this.f906a.add(aVar);
            }
        }
    }

    public synchronized void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            synchronized (this) {
                HashMap<String, b> hashMap = this.f907a.get(bVar.f72348g);
                if (hashMap == null) {
                    hashMap = new HashMap<>();
                    this.f907a.put(bVar.f72348g, hashMap);
                }
                hashMap.put(a(bVar.f919b), bVar);
                for (a aVar : this.f906a) {
                    aVar.a();
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m607a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            synchronized (this) {
                HashMap<String, b> hashMap = this.f907a.get(str);
                if (hashMap != null) {
                    for (b bVar : hashMap.values()) {
                        bVar.m610a();
                    }
                    hashMap.clear();
                    this.f907a.remove(str);
                }
                for (a aVar : this.f906a) {
                    aVar.a();
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m608a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            synchronized (this) {
                HashMap<String, b> hashMap = this.f907a.get(str);
                if (hashMap != null) {
                    b bVar = hashMap.get(a(str2));
                    if (bVar != null) {
                        bVar.m610a();
                    }
                    hashMap.remove(a(str2));
                    if (hashMap.isEmpty()) {
                        this.f907a.remove(str);
                    }
                }
                for (a aVar : this.f906a) {
                    aVar.a();
                }
            }
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                this.f906a.clear();
            }
        }
    }
}
