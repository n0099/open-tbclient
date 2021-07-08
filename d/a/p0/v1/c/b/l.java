package d.a.p0.v1.c.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.AutoPayInfo;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.VipInfo;
import tbclient.GetVipInfo.VipUpgrade;
import tbclient.GetVipInfo.VipUser;
/* loaded from: classes8.dex */
public class l implements d.a.c.k.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final BdUniqueId f65051e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1417981678, "Ld/a/p0/v1/c/b/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1417981678, "Ld/a/p0/v1/c/b/l;");
                return;
            }
        }
        f65051e = BdUniqueId.gen();
    }

    public l(DataRes dataRes) {
        VipUser vipUser;
        VipUpgrade vipUpgrade;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataRes};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (dataRes == null || (vipUser = dataRes.user) == null || (vipUpgrade = dataRes.upgrade) == null) {
            return;
        }
        String str = vipUser.card_id;
        String str2 = vipUser.total_scores_link;
        String str3 = vipUser.speed_link;
        String str4 = vipUser.task_scores_link;
        vipUser.task_scores.intValue();
        String str5 = vipUser.name;
        vipUser.id.longValue();
        String str6 = vipUser.portrait;
        String str7 = vipUser.name_show;
        String str8 = vipUser.vip_link;
        VipInfo vipInfo = vipUser.vipInfo;
        if (vipInfo != null) {
            String str9 = vipInfo.icon_url;
            vipInfo.s_time.intValue();
            vipUser.vipInfo.e_time.intValue();
            vipUser.now_time.intValue();
            vipUser.vipInfo.v_status.intValue();
            vipUser.vipInfo.v_level.intValue();
            vipUser.vipInfo.ext_score.intValue();
            vipUser.vipInfo.a_score.intValue();
            vipUser.vipInfo.n_score.intValue();
        }
        dataRes.today_get_score.intValue();
        dataRes.today_unget_score.intValue();
        vipUpgrade.normal.intValue();
        vipUpgrade.pay.intValue();
        AutoPayInfo autoPayInfo = dataRes.autopay_info;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f65051e : (BdUniqueId) invokeV.objValue;
    }
}
