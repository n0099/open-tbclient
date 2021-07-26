package d.a.d.e.n.n;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatisticsSwitchStatic;
import com.baidu.adp.lib.stats.upload.BdUploadingLogInfo;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.g;
import d.a.d.e.p.j;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static b f41880f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.d.e.n.d f41881a;

    /* renamed from: b  reason: collision with root package name */
    public String f41882b;

    /* renamed from: c  reason: collision with root package name */
    public String f41883c;

    /* renamed from: d  reason: collision with root package name */
    public C0562b f41884d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f41885e;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f41886a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41886a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                this.f41886a.f();
            }
        }
    }

    /* renamed from: d.a.d.e.n.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0562b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b this$0;

        public C0562b(b bVar) {
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
            this.this$0 = bVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
                return;
            }
            this.this$0.o(intent.getStringExtra("intent_data_userid"), intent.getStringExtra("intent_data_username"), intent.getStringExtra("intent_data_bduss"));
        }

        public /* synthetic */ C0562b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes7.dex */
    public class c extends BdAsyncTask<Object, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.d.e.n.j.a f41887a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f41888b;

        public c(@NonNull b bVar, d.a.d.e.n.j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41888b = bVar;
            this.f41887a = null;
            this.f41887a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                d(this.f41887a);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r5) == null) {
                this.f41887a.J(false);
            }
        }

        public final void d(d.a.d.e.n.j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                try {
                    BdUploadingLogInfo b2 = d.a.d.e.n.n.c.b(aVar);
                    int size = b2.size();
                    if (b2 == null || size <= 0) {
                        return;
                    }
                    for (int i2 = size - 1; i2 >= 0; i2--) {
                        ArrayList<String> trackLogStringByIndex = b2.getTrackLogStringByIndex(i2);
                        if (trackLogStringByIndex != null && trackLogStringByIndex.size() != 0) {
                            this.f41888b.i(aVar, trackLogStringByIndex, b2.get(i2));
                        }
                    }
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends BdAsyncTask<Object, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.d.e.n.j.a f41889a;

        /* renamed from: b  reason: collision with root package name */
        public String f41890b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f41891c;

        public d(b bVar, d.a.d.e.n.j.a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41891c = bVar;
            this.f41889a = aVar;
            this.f41890b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                String e2 = d.a.d.e.n.n.d.e(this.f41889a, this.f41891c.f41881a);
                String str = this.f41890b;
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                BdLog.i("commonHeader = " + e2);
                BdLog.i("cache = " + str);
                this.f41889a.d();
                this.f41891c.h(this.f41889a, e2, arrayList, null, true);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e extends BdAsyncTask<Object, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.d.e.n.j.a f41892a;

        /* renamed from: b  reason: collision with root package name */
        public String f41893b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f41894c;

        public e(b bVar, d.a.d.e.n.j.a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41894c = bVar;
            this.f41892a = aVar;
            this.f41893b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                String str = this.f41893b;
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                this.f41892a.f();
                this.f41894c.i(this.f41892a, arrayList, null);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f extends BdAsyncTask<Object, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.d.e.n.j.a f41895a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<String> f41896b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f41897c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f41898d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f41899e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f41900f;

        public f(b bVar, d.a.d.e.n.j.a aVar, ArrayList<String> arrayList, boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41900f = bVar;
            this.f41895a = null;
            this.f41896b = null;
            this.f41897c = false;
            this.f41898d = false;
            this.f41899e = false;
            this.f41895a = aVar;
            this.f41896b = arrayList;
            this.f41897c = z;
            this.f41898d = z2;
            this.f41899e = z3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                d(this.f41895a, this.f41897c, this.f41898d, this.f41899e);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r5) == null) {
                this.f41895a.K(false);
            }
        }

        public final void d(d.a.d.e.n.j.a aVar, boolean z, boolean z2, boolean z3) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{aVar, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
                try {
                    String e2 = d.a.d.e.n.n.d.e(aVar, this.f41900f.f41881a);
                    BdUploadingLogInfo b2 = d.a.d.e.n.n.a.b(aVar, z2);
                    int size = b2.size();
                    if (b2 == null || size <= 0) {
                        return;
                    }
                    if (!z) {
                        int i3 = 0;
                        while (i3 < size) {
                            ArrayList<String> logStringByIndex = b2.getLogStringByIndex(i3, this.f41896b);
                            if (logStringByIndex != null && logStringByIndex.size() != 0) {
                                if (!z2) {
                                    i2 = i3;
                                    this.f41900f.h(aVar, e2, logStringByIndex, b2.get(i2), z3);
                                } else {
                                    ArrayList<d.a.d.e.n.j.d> arrayList = b2.get(i3);
                                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                                        if (arrayList.get(i4).f41864b.contains("notUpload/")) {
                                            arrayList.get(i4).f41864b = arrayList.get(i4).f41864b.replace("notUpload/", "");
                                        }
                                    }
                                    i2 = i3;
                                    this.f41900f.h(aVar, e2, logStringByIndex, arrayList, z3);
                                }
                                i3 = i2 + 1;
                            }
                            i2 = i3;
                            i3 = i2 + 1;
                        }
                        return;
                    }
                    int i5 = 0;
                    for (int i6 = size - 1; i6 >= 0; i6--) {
                        ArrayList<String> logStringByIndex2 = b2.getLogStringByIndex(i6, this.f41896b);
                        if (logStringByIndex2 != null && logStringByIndex2.size() != 0) {
                            if (!j.H() && (i5 = i5 + logStringByIndex2.toString().length()) > 102400) {
                                return;
                            }
                            int i7 = i5;
                            if (!z2) {
                                this.f41900f.h(aVar, e2, logStringByIndex2, b2.get(i6), z3);
                            } else {
                                ArrayList<d.a.d.e.n.j.d> arrayList2 = b2.get(i6);
                                for (int i8 = 0; i8 < arrayList2.size(); i8++) {
                                    if (arrayList2.get(i8).f41864b.contains("notUpload/")) {
                                        arrayList2.get(i8).f41864b = arrayList2.get(i8).f41864b.replace("notUpload/", "");
                                    }
                                }
                                this.f41900f.h(aVar, e2, logStringByIndex2, arrayList2, z3);
                            }
                            i5 = i7;
                        }
                    }
                } catch (Exception e3) {
                    BdLog.e(e3);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(133906965, "Ld/a/d/e/n/n/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(133906965, "Ld/a/d/e/n/n/b;");
        }
    }

    public b() {
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
        this.f41885e = new a(this, 2000994);
    }

    public static b m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (f41880f == null) {
                synchronized (b.class) {
                    if (f41880f == null) {
                        f41880f = new b();
                    }
                }
            }
            return f41880f;
        }
        return (b) invokeV.objValue;
    }

    public final void e(ArrayList<String> arrayList, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, arrayList, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (arrayList.contains(str)) {
            return;
        }
        arrayList.add(str);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f41881a.o = d.a.d.e.n.e.a(BdBaseApplication.getInst());
            this.f41881a.p = String.valueOf(j.I());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String g(String str, d.a.d.e.n.j.a aVar, String str2, ArrayList<String> arrayList, ArrayList<d.a.d.e.n.j.d> arrayList2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        byte[] l;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, aVar, str2, arrayList, arrayList2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            String str3 = str;
            if (str3 != null && aVar != null && (l = l(str2, arrayList)) != null && l.length > 0) {
                ByteArrayOutputStream byteArrayOutputStream2 = null;
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(l.length / 2);
                    try {
                        try {
                            g.b(l, byteArrayOutputStream);
                            bArr = byteArrayOutputStream.toByteArray();
                            d.a.d.e.m.a.d(byteArrayOutputStream);
                        } catch (Exception e2) {
                            e = e2;
                            BdLog.e(e);
                            d.a.d.e.m.a.d(byteArrayOutputStream);
                            bArr = null;
                            if (bArr != null) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        d.a.d.e.m.a.d(byteArrayOutputStream2);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    d.a.d.e.m.a.d(byteArrayOutputStream2);
                    throw th;
                }
                if (bArr != null) {
                    return "";
                }
                HashMap hashMap = new HashMap();
                hashMap.put(aVar.p(), bArr);
                ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
                if (aVar != null) {
                    try {
                        if (aVar.o().equals("pfmonitor") && BdStatisticsSwitchStatic.isOn()) {
                            try {
                                d.a.d.e.j.a.e eVar = new d.a.d.e.j.a.e();
                                String str4 = this.f41882b;
                                if (z2 && str4.contains("c.tieba.baidu.com")) {
                                    str4 = str4.replace("c.tieba.baidu.com", "123.125.115.120");
                                    eVar.b().a("Host", "c.tieba.baidu.com");
                                }
                                eVar.b().s(str4);
                                eVar.b().q(HttpMessageTask.HTTP_METHOD.POST);
                                HashMap<String, Object> f2 = d.a.d.e.n.n.d.f(this.f41881a, z);
                                if (f2 != null) {
                                    eVar.b().r(new ArrayList(f2.entrySet()));
                                }
                                hashMap.clear();
                                hashMap.put("pf", bArr);
                                arrayList3.clear();
                                arrayList3.addAll(hashMap.entrySet());
                                eVar.b().r(arrayList3);
                                try {
                                    new d.a.d.e.j.a.c(eVar).n(3, -1, -1);
                                } catch (Exception e4) {
                                    BdLog.detailException(e4);
                                }
                                j(arrayList2, aVar.E());
                                return null;
                            } catch (Exception e5) {
                                BdLog.e(e5);
                                return e5.getMessage();
                            }
                        }
                    } catch (Exception e6) {
                        BdLog.e(e6);
                        return e6.getMessage();
                    }
                }
                d.a.d.e.j.a.e eVar2 = new d.a.d.e.j.a.e();
                if (z2 && str3.contains("c.tieba.baidu.com")) {
                    str3 = str3.replace("c.tieba.baidu.com", "123.125.115.120");
                    eVar2.b().a("Host", "c.tieba.baidu.com");
                }
                eVar2.b().s(str3);
                eVar2.b().q(HttpMessageTask.HTTP_METHOD.POST);
                HashMap<String, Object> f3 = d.a.d.e.n.n.d.f(this.f41881a, z);
                if (f3 != null) {
                    eVar2.b().r(new ArrayList(f3.entrySet()));
                }
                eVar2.b().r(arrayList3);
                try {
                    new d.a.d.e.j.a.c(eVar2).n(3, -1, -1);
                    int i2 = eVar2.c().f41727b;
                    byte[] bArr2 = eVar2.c().f41733h;
                    if (bArr2 != null && i2 == 200) {
                        try {
                            if (new JSONObject(new String(bArr2, "utf-8")).optInt("error_code", -1) == 0) {
                                j(arrayList2, aVar.E());
                                return null;
                            }
                        } catch (Exception e7) {
                            BdLog.e(e7);
                            return e7.getMessage();
                        }
                    }
                    List<d.a.d.e.j.a.d> d2 = eVar2.d();
                    if (d2 != null && d2.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (int i3 = 0; i3 < d2.size(); i3++) {
                            d.a.d.e.j.a.d dVar = d2.get(i3);
                            if (dVar != null && !TextUtils.isEmpty(dVar.f41713h)) {
                                if (sb.length() > 0) {
                                    sb.append(",");
                                }
                                sb.append(dVar.f41713h);
                            }
                        }
                        if (sb.length() > 0) {
                            return sb.toString();
                        }
                    }
                } catch (Exception e8) {
                    BdLog.detailException(e8);
                    return e8.getMessage();
                }
            }
            return "";
        }
        return (String) invokeCommon.objValue;
    }

    public final void h(d.a.d.e.n.j.a aVar, String str, ArrayList<String> arrayList, ArrayList<d.a.d.e.n.j.d> arrayList2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{aVar, str, arrayList, arrayList2, Boolean.valueOf(z)}) == null) && g(this.f41882b, aVar, str, arrayList, arrayList2, z, false) != null && j.z()) {
            String g2 = g(this.f41882b, aVar, str, arrayList, arrayList2, z, true);
            if (g2 == null) {
                d.a.d.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("issuc", "true");
                BdStatisticsManager.getInstance().debug("STAT_UPLOAD_USEIP", statsItem);
                return;
            }
            d.a.d.e.n.a statsItem2 = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem2.b("issuc", "false");
            statsItem2.b("reason", g2);
            BdStatisticsManager.getInstance().debug("STAT_UPLOAD_USEIP", statsItem2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean i(d.a.d.e.n.j.a aVar, ArrayList<String> arrayList, ArrayList<d.a.d.e.n.j.d> arrayList2) {
        InterceptResult invokeLLL;
        byte[] k;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, aVar, arrayList, arrayList2)) == null) {
            if (aVar == null || arrayList == null || arrayList.isEmpty() || (k = k(arrayList)) == null || k.length == 0) {
                return false;
            }
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            byte[] bArr = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(k.length / 2);
                try {
                    try {
                        g.b(k, byteArrayOutputStream);
                        bArr = byteArrayOutputStream.toByteArray();
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e);
                        d.a.d.e.m.a.d(byteArrayOutputStream);
                        if (bArr != null) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    d.a.d.e.m.a.d(byteArrayOutputStream2);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                d.a.d.e.m.a.d(byteArrayOutputStream2);
                throw th;
            }
            d.a.d.e.m.a.d(byteArrayOutputStream);
            if (bArr != null) {
                return false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(aVar.q(), bArr);
            ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
            d.a.d.e.j.a.e eVar = new d.a.d.e.j.a.e();
            eVar.b().a("Host", "c.tieba.baidu.com");
            eVar.b().s(this.f41883c);
            eVar.b().q(HttpMessageTask.HTTP_METHOD.POST);
            HashMap<String, Object> f2 = d.a.d.e.n.n.d.f(this.f41881a, false);
            if (f2 != null) {
                eVar.b().r(new ArrayList(f2.entrySet()));
            }
            eVar.b().r(arrayList3);
            try {
                new d.a.d.e.j.a.c(eVar).n(3, -1, -1);
                if (eVar.c().f41727b == 200) {
                    try {
                        if (new JSONObject(new String(eVar.c().f41733h, "utf-8")).optString("error_code").equals("0")) {
                            ArrayList arrayList4 = new ArrayList();
                            Iterator<d.a.d.e.n.j.d> it = arrayList2.iterator();
                            while (it.hasNext()) {
                                arrayList4.add(it.next().f41864b);
                            }
                            if (arrayList4.size() > 0) {
                                d.a.d.e.n.j.c.a(arrayList4, aVar.C());
                                return true;
                            }
                            return true;
                        }
                        return true;
                    } catch (Exception e4) {
                        BdLog.e(e4);
                        return false;
                    }
                }
                return true;
            } catch (Exception e5) {
                BdLog.detailException(e5);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final void j(ArrayList<d.a.d.e.n.j.d> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, arrayList, z) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<d.a.d.e.n.j.d> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().f41864b);
        }
        if (arrayList2.size() > 0) {
            d.a.d.e.n.j.b.a(arrayList2, z);
        }
    }

    public final byte[] k(ArrayList<String> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                try {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (i2 != 0) {
                            sb.append("&");
                        }
                        sb.append(URLEncoder.encode(arrayList.get(i2), "utf-8"));
                    }
                    return sb.toString().getBytes();
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public final byte[] l(String str, ArrayList<String> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append("&rec");
                        sb.append(i2);
                        sb.append(com.alipay.sdk.encrypt.a.f1923h);
                        try {
                            sb.append(URLEncoder.encode(arrayList.get(i2), "utf-8"));
                        } catch (UnsupportedEncodingException e2) {
                            BdLog.e(e2);
                        }
                    }
                    return sb.toString().getBytes();
                } catch (Exception e3) {
                    BdLog.e(e3);
                }
            }
            return null;
        }
        return (byte[]) invokeLL.objValue;
    }

    public void n(d.a.d.e.n.d dVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar, str, str2) == null) {
            this.f41882b = str;
            this.f41883c = str2;
            this.f41881a = dVar;
            if (dVar != null) {
                dVar.k = Build.MODEL;
                dVar.q = Build.VERSION.RELEASE;
                dVar.o = d.a.d.e.n.e.a(BdBaseApplication.getInst());
                this.f41881a.p = String.valueOf(j.I());
            }
            try {
                MessageManager.getInstance().registerListener(this.f41885e);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.f41884d == null) {
                this.f41884d = new C0562b(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.f41884d, intentFilter);
            }
        }
    }

    public void o(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, str, str2, str3) == null) {
            if (this.f41881a.l == null && str == null) {
                return;
            }
            String str4 = this.f41881a.l;
            if (str4 == null || !str4.equals(str)) {
                d.a.d.e.n.d dVar = this.f41881a;
                dVar.l = str;
                dVar.m = str2;
                dVar.n = str3;
            }
        }
    }

    public void p(d.a.d.e.n.j.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, aVar, str) == null) {
            new d(this, aVar, str).execute(new Object[0]);
        }
    }

    public void q(d.a.d.e.n.j.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, str) == null) {
            new e(this, aVar, str).execute(new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r(d.a.d.e.n.j.a aVar, boolean z, boolean z2, boolean z3) {
        ArrayList<String> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048588, this, new Object[]{aVar, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) != null) || !BdStatisticsManager.getInstance().isMainProcess() || aVar == null) {
            return;
        }
        ArrayList<String> n = d.a.d.e.n.m.a.o().n(aVar.o());
        ArrayList arrayList2 = null;
        if (!z) {
            boolean x = d.a.d.e.n.m.a.o().x(aVar.o(), null);
            boolean H = j.H();
            if (x && !H) {
                return;
            }
            if (n != null && n.size() > 0) {
                arrayList = new ArrayList<>();
                Iterator<String> it = n.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!d.a.d.e.n.m.a.o().u(aVar.o(), next)) {
                        e(arrayList, next);
                    } else if (!d.a.d.e.n.m.a.o().A(aVar.o(), next)) {
                        e(arrayList, next);
                    } else {
                        boolean x2 = d.a.d.e.n.m.a.o().x(aVar.o(), next);
                        boolean H2 = j.H();
                        if (x2 && !H2) {
                            e(arrayList, next);
                        }
                    }
                }
                if (aVar.D()) {
                    aVar.K(true);
                    if (arrayList != null && arrayList.size() > 0) {
                        arrayList2 = new ArrayList();
                        Iterator<String> it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            String next2 = it2.next();
                            try {
                                arrayList2.add("st=" + URLEncoder.encode(d.a.d.e.n.a.i(next2), "utf-8") + "&");
                            } catch (UnsupportedEncodingException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    new f(this, aVar, arrayList2, z, z2, z3).execute(new Object[0]);
                    return;
                }
                return;
            }
        }
        arrayList = null;
        if (aVar.D()) {
        }
    }

    public void s(d.a.d.e.n.j.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) || aVar.B()) {
            return;
        }
        aVar.J(true);
        new c(this, aVar).execute(new Object[0]);
    }
}
