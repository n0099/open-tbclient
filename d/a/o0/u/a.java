package d.a.o0.u;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.distribute.DistributeHttpResponse;
import com.baidu.tbadk.distribute.DistributeRequest;
import com.baidu.tbadk.distribute.DistributeSocketResponse;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.p0.w2.i0.e;
import d.a.p0.w2.i0.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.LogTogether.AdReq;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static String o;
    public static a p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f53450a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<AdReq> f53451b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53452c;

    /* renamed from: d  reason: collision with root package name */
    public long f53453d;

    /* renamed from: e  reason: collision with root package name */
    public int f53454e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f53455f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f53456g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f53457h;

    /* renamed from: i  reason: collision with root package name */
    public final CustomMessageListener f53458i;
    public ArrayList<AdvertAppInfo> j;
    public ArrayList<AdvertAppInfo> k;
    public HashMap<String, AdvertAppInfo> l;
    public HashMap<String, AdvertAppInfo> m;
    public HashMap<String, DownloadStaticsData> n;

    /* renamed from: d.a.o0.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class HandlerC1234a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f53459a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1234a(a aVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper};
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
            this.f53459a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                this.f53459a.i(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f53460a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53460a = aVar;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.hasError()) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof DistributeRequest) {
                    this.f53460a.g(((DistributeRequest) extra).getAdReqList());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f53461a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f53461a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.H() || j.x()) {
                    this.f53461a.t(true);
                } else {
                    this.f53461a.t(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f53462a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f53462a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) customResponsedMessage).getData()) == null || data.isEmpty()) {
                return;
            }
            for (int i2 = 0; i2 < data.size(); i2++) {
                DownloadData downloadData = data.get(i2);
                if (downloadData.getType() == 12) {
                    int status = downloadData.getStatus();
                    if (status != 0) {
                        if (status == 1) {
                            this.f53462a.q(downloadData.getId(), downloadData.getDownloadStaticsData());
                        } else if (status != 2 && status != 4) {
                            if (status == 5) {
                                this.f53462a.p(downloadData.getDownloadStaticsData());
                            }
                        }
                    }
                    this.f53462a.r(downloadData.getId(), downloadData.getStatus());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-799242211, "Ld/a/o0/u/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-799242211, "Ld/a/o0/u/a;");
                return;
            }
        }
        p = new a();
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
        this.f53455f = new HandlerC1234a(this, Looper.getMainLooper());
        this.f53456g = new b(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
        this.f53457h = new c(this, 2000994);
        this.f53458i = new d(this, 2001118);
        this.l = new HashMap<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.f53451b = new ArrayList<>();
        this.j = new ArrayList<>();
        this.k = new ArrayList<>();
        this.f53452c = true;
        this.f53453d = 60000L;
        this.f53454e = 10;
        this.f53450a = j.z();
    }

    public static a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? p : (a) invokeV.objValue;
    }

    public final synchronized void g(List<AdReq> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            synchronized (this) {
                if (this.f53451b != null) {
                    this.f53451b.addAll(list);
                }
            }
        }
    }

    public void h(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertAppInfo) == null) {
            this.l.put(advertAppInfo.d4, advertAppInfo);
        }
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && this.f53450a && this.f53452c) {
            List<AdReq> l = l(z);
            if (z || !o()) {
                s();
            }
            if (l == null || l.size() == 0) {
                return;
            }
            if (!z) {
                s();
            }
            MessageManager.getInstance().sendMessage(new DistributeRequest(l));
        }
    }

    public final HttpMessageTask j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, TbConfig.SERVER_ADDRESS + TbConfig.LOG_TOGETHER + "?cmd=303101");
            httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
            return httpMessageTask;
        }
        return (HttpMessageTask) invokeV.objValue;
    }

    public final synchronized List<AdReq> l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            synchronized (this) {
                if (!z) {
                    if (this.f53451b.size() < this.f53454e) {
                        return null;
                    }
                }
                if (this.f53451b.size() <= 0) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f53451b);
                this.f53451b.clear();
                return arrayList;
            }
        }
        return (List) invokeZ.objValue;
    }

    public final SocketMessageTask m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
            socketMessageTask.g(true);
            socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
            return socketMessageTask;
        }
        return (SocketMessageTask) invokeV.objValue;
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            if (z) {
                messageManager.registerTask(m());
            }
            messageManager.registerTask(j());
            messageManager.registerListener(this.f53456g);
            messageManager.registerListener(this.f53457h);
            messageManager.registerListener(this.f53458i);
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f53455f.hasMessages(1) : invokeV.booleanValue;
    }

    public final void p(DownloadStaticsData downloadStaticsData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadStaticsData) == null) || downloadStaticsData == null) {
            return;
        }
        d.a.p0.w2.i0.c d2 = g.d(downloadStaticsData, 101, 0);
        d2.r(null);
        d2.a("dl", "delete");
        e.b().d(d2);
    }

    public final void q(String str, DownloadStaticsData downloadStaticsData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, downloadStaticsData) == null) {
            AdvertAppInfo remove = this.l.remove(str);
            if (remove != null) {
                this.m.put(str, remove);
            } else if (downloadStaticsData == null || !"1".equals(downloadStaticsData.getDa_range_nt())) {
                return;
            } else {
                this.n.put(str, downloadStaticsData);
                downloadStaticsData.setDa_page(null);
                downloadStaticsData.setFid(null);
            }
            d.a.p0.w2.i0.c d2 = g.d(downloadStaticsData, 101, 0);
            d2.a("dl", "start");
            e.b().d(d2);
            if (downloadStaticsData == null || !"1".equals(downloadStaticsData.getDa_range_nt())) {
                return;
            }
            downloadStaticsData.setDa_range_nt("0");
        }
    }

    public final void r(String str, int i2) {
        d.a.p0.w2.i0.c d2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, str, i2) == null) {
            AdvertAppInfo remove = this.m.remove(str);
            DownloadStaticsData remove2 = this.n.remove(str);
            if (remove != null) {
                d2 = g.b(remove, 101, 0);
            } else if (remove2 == null) {
                return;
            } else {
                d2 = g.d(remove2, 101, 0);
                d2.r(null);
            }
            if (remove == null && remove2 == null) {
                return;
            }
            if (i2 == 0) {
                str2 = "success";
            } else if (i2 == 2) {
                str2 = com.baidu.pass.biometrics.face.liveness.b.a.g0;
            } else if (i2 != 4) {
                return;
            } else {
                str2 = QueryResponse.Options.CANCEL;
            }
            d2.a("dl", str2);
            e.b().d(d2);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f53455f.removeMessages(1);
            this.f53455f.sendEmptyMessageDelayed(1, this.f53453d);
        }
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || this.f53450a == z) {
            return;
        }
        this.f53450a = z;
        if (z) {
            i(true);
        } else {
            x();
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            if (i2 > 3600) {
                this.f53453d = 300000L;
            } else if (i2 <= 0) {
                this.f53453d = 60000L;
            } else {
                this.f53453d = i2 * 1000;
            }
        }
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            if (i2 > 20) {
                this.f53454e = 10;
            } else if (i2 <= 0) {
                this.f53454e = 5;
            } else {
                this.f53454e = i2;
            }
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f53452c = z;
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f53455f.removeMessages(1);
        }
    }

    public void y(Context context, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{context, str, str2, Long.valueOf(j)}) == null) {
            if (TextUtils.equals(str, "frs")) {
                z(context, this.j, str, str2, j);
            } else if (TextUtils.equals(str, "pb")) {
                z(context, this.k, str, str2, j);
            }
        }
    }

    public final void z(Context context, ArrayList<AdvertAppInfo> arrayList, String str, String str2, long j) {
        ArrayList<AdvertAppInfo> arrayList2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{context, arrayList, str, str2, Long.valueOf(j)}) == null) || (arrayList2 = arrayList) == null || arrayList.size() <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        StringBuilder sb7 = new StringBuilder();
        StringBuilder sb8 = new StringBuilder();
        StringBuilder sb9 = new StringBuilder();
        StringBuilder sb10 = new StringBuilder();
        StringBuilder sb11 = new StringBuilder();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            AdvertAppInfo advertAppInfo = arrayList2.get(i2);
            if (advertAppInfo != null) {
                if (i2 == size - 1) {
                    sb2.append(advertAppInfo.R3);
                    sb3.append(advertAppInfo.L3);
                    sb5.append(advertAppInfo.S3);
                    sb7.append(advertAppInfo.Y3);
                } else {
                    sb2.append(advertAppInfo.R3);
                    sb2.append("|");
                    sb3.append(advertAppInfo.L3);
                    sb3.append("|");
                    sb5.append(advertAppInfo.S3);
                    sb5.append("|");
                    sb7.append(advertAppInfo.Y3);
                    sb7.append("|");
                }
            }
            i2++;
            arrayList2 = arrayList;
        }
        StringBuilder sb12 = new StringBuilder(15);
        sb12.append(String.valueOf(l.k(context)));
        sb12.append(",");
        sb12.append(String.valueOf(l.i(context)));
        TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, "fid", str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, "cuid", TbadkCoreApplication.getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
        arrayList.clear();
    }
}
