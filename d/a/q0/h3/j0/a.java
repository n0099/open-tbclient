package d.a.q0.h3.j0;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.h3.j0.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C1456a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f58617a;

        /* renamed from: b  reason: collision with root package name */
        public final String f58618b;

        /* renamed from: c  reason: collision with root package name */
        public final String f58619c;

        /* renamed from: d  reason: collision with root package name */
        public final String f58620d;

        /* renamed from: e  reason: collision with root package name */
        public final String f58621e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f58622f;

        /* renamed from: g  reason: collision with root package name */
        public final StatisticItem f58623g;

        public /* synthetic */ b(String str, String str2, String str3, String str4, String str5, C1456a c1456a) {
            this(str, str2, str3, str4, str5);
        }

        public final StatisticItem b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                StatisticItem statisticItem = new StatisticItem(this.f58617a);
                if (!StringUtils.isNull(this.f58618b)) {
                    statisticItem = statisticItem.param("line", this.f58618b);
                }
                if (!StringUtils.isNull(this.f58619c)) {
                    statisticItem = statisticItem.param("page", this.f58619c);
                }
                if (!StringUtils.isNull(this.f58620d)) {
                    statisticItem = statisticItem.param("locate", this.f58620d);
                }
                return !StringUtils.isNull(this.f58621e) ? statisticItem.param("task", this.f58621e) : statisticItem;
            }
            return (StatisticItem) invokeV.objValue;
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f58623g.delete(str);
            }
        }

        public final StatisticItem d(String str, String str2, String str3, String str4, String str5) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3, str4, str5)) == null) {
                if (!StringUtils.isNull(str)) {
                    this.f58623g.param(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
                }
                if (!StringUtils.isNull(str2)) {
                    this.f58623g.param("obj_id", str2);
                }
                if (!StringUtils.isNull(str3)) {
                    this.f58623g.param("fid", str3);
                }
                if (!StringUtils.isNull(str4)) {
                    this.f58623g.param("fname", str4);
                }
                if (!StringUtils.isNull(str5)) {
                    this.f58623g.param("tid", str5);
                }
                this.f58623g.param("obj_cpid", 0).param("obj_good_id", 0).param("obj_throw_type", "BY_POST").param("client_type", "MOBILE_APP").param("user_timestamp", String.valueOf(System.currentTimeMillis())).param(IAdRequestParam.OS, "android").param(HttpConstants.OS_VERSION, Build.VERSION.RELEASE).param("log_ver", "1.1");
                return this.f58623g;
            }
            return (StatisticItem) invokeLLLLL.objValue;
        }

        public b e(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
                if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                    this.f58623g.param(str, str2);
                }
                return this;
            }
            return (b) invokeLL.objValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                TiebaStatic.log(this.f58623g);
                if (this.f58622f) {
                    return;
                }
                if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    BdLog.e("Invalid parameter.");
                    return;
                }
                throw new IllegalArgumentException();
            }
        }

        public b(String str, String str2, String str3, String str4, String str5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, str4, str5};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58617a = str;
            this.f58618b = str2;
            this.f58619c = str3;
            this.f58620d = str4;
            this.f58621e = str5;
            this.f58622f = !(StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5));
            this.f58623g = b();
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f58624a;

        /* renamed from: b  reason: collision with root package name */
        public String f58625b;

        /* renamed from: c  reason: collision with root package name */
        public int f58626c;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public static b a(String str, String str2, String str3, String str4, String str5, String str6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, str2, str3, str4, str5, str6})) == null) {
            b bVar = new b("ad_tpoint", "PT", str, str2, "tpoint", null);
            bVar.d(null, null, str3, str4, str5);
            if (!k.isEmpty(str6)) {
                bVar.e("obj_ref", str6);
            }
            return bVar;
        }
        return (b) invokeCommon.objValue;
    }

    public static b b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9, str10})) == null) {
            b bVar = new b(str, str2, str3, str4, str5, null);
            bVar.d(str6, str7, str8, str9, str10);
            return bVar;
        }
        return (b) invokeCommon.objValue;
    }

    @Deprecated
    public static void c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, str2, str3, str4, str5, str6, str7}) == null) {
            b bVar = new b("ad_tpoint", "PT", str, "c0122", "ad_plat", null);
            bVar.d(str2, str7, str3, str4, str5);
            bVar.e(TiebaStatic.Params.OBJ_URL, str6);
            bVar.f();
        }
    }

    @Deprecated
    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) || k.isEmpty(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        if (str2 != null) {
            statisticItem = statisticItem.param("obj_type", str2);
        }
        TiebaStatic.log(statisticItem);
    }
}
