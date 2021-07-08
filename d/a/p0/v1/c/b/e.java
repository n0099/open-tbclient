package d.a.p0.v1.c.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialItem;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes8.dex */
public class e implements d.a.c.k.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f65038g;

    /* renamed from: h  reason: collision with root package name */
    public static int f65039h;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f65040i;
    public static String j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f65041e;

    /* renamed from: f  reason: collision with root package name */
    public List<f> f65042f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1417981895, "Ld/a/p0/v1/c/b/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1417981895, "Ld/a/p0/v1/c/b/e;");
                return;
            }
        }
        f65038g = BdUniqueId.gen();
        f65039h = 3;
        f65040i = false;
    }

    public e(VipSpecialList vipSpecialList) {
        List<VipSpecialItem> list;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipSpecialList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (vipSpecialList == null || (list = vipSpecialList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipSpecialList.card_id;
        d dVar = new d();
        this.f65041e = dVar;
        dVar.e(4);
        this.f65041e.d(vipSpecialList.class_name);
        this.f65041e.f(vipSpecialList.class_url_name);
        this.f65041e.g(vipSpecialList.class_url);
        String currentAccount = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAccount() : SevenZipUtils.FILE_NAME_TEMP;
        if (StringUtils.isNull(j) || !j.equals(currentAccount)) {
            f65040i = false;
            j = currentAccount;
        }
        this.f65042f = new ArrayList();
        for (int i4 = 0; i4 < vipSpecialList.item.size(); i4++) {
            this.f65042f.add(new f(vipSpecialList.item.get(i4)));
            if (f65040i) {
                if (i4 == vipSpecialList.item.size() - 1 && vipSpecialList.item.size() > f65039h) {
                    this.f65042f.add(new f(true, true));
                }
            } else if (i4 == f65039h - 1 && vipSpecialList.item.size() > f65039h) {
                this.f65042f.add(new f(true, false));
                return;
            }
        }
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f65038g : (BdUniqueId) invokeV.objValue;
    }
}
