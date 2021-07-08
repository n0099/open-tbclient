package d.a.o0.i0;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static e f52050c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<String> f52051a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f52052b;

    public e() {
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
        this.f52051a = i(d.a.o0.r.d0.b.j().p("key_need_add_source_stat_list", ""));
        this.f52052b = i("c12897,c12896,c12895,c12894,c12893,c12892,c12891,c12890,c13274,c12905,c12003,c13271,c12899,c11244,c11032,c12904,c13273,c13433,c10295,c12320,c12835,c10297,c13136,c12910,c10734,c10735,common_click,c10730,c10731,c11439,c10705,c13147,c13388,c13389,c10756,c10296,c10755,c13407,c13406,c12590,c10751,c12888,c12889,consume_33,c11824,c11823,consume_34,c12902,c12898,consume_24,c12887,c12909,c12908,c12942,c12901,c12900,c12903,c13008,c13146,common_exp,c12907,c12906,c10750,consume_3,c11887,c11438,c10704,c10484,c10709,c10708,c12386,c12384");
    }

    public static void b(Context context, StatisticItem statisticItem, d.a.o0.k0.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, context, statisticItem, dVar) == null) || dVar == null || statisticItem == null || TextUtils.isEmpty(statisticItem.getKey())) {
            return;
        }
        c k = dVar.k();
        if (k == null || k.e()) {
            k = TbPageExtraHelper.k(context);
        }
        if (k != null && !k.e()) {
            c(statisticItem, k);
        }
        TbPageExtraHelper.r(statisticItem.toString());
    }

    public static void c(StatisticItem statisticItem, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, statisticItem, cVar) == null) || statisticItem == null || cVar == null || TextUtils.isEmpty(statisticItem.getKey())) {
            return;
        }
        String a2 = cVar.a();
        if (!TextUtils.isEmpty(a2) && !statisticItem.hasParam("page_key")) {
            statisticItem.param("page_key", a2);
        }
        String a3 = d.a(cVar.c(), a2, 6);
        if (TextUtils.isEmpty(a3) || statisticItem.hasParam("page_source")) {
            return;
        }
        statisticItem.param("page_source", a3);
    }

    public static e f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f52050c == null) {
                synchronized (e.class) {
                    if (f52050c == null) {
                        f52050c = new e();
                    }
                }
            }
            return f52050c;
        }
        return (e) invokeV.objValue;
    }

    public final void a(StatisticItem statisticItem) {
        Activity currentActivity;
        c k;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, statisticItem) == null) || statisticItem == null || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (k = TbPageExtraHelper.k(currentActivity)) == null) {
            return;
        }
        String a2 = k.a();
        if (!TextUtils.isEmpty(a2) && !statisticItem.hasParam("page_key")) {
            statisticItem.param("page_key", a2);
        }
        ArrayList<String> c2 = k.c();
        String a3 = d.a(c2, a2, 6);
        if (statisticItem.getKey().equals("common_exp") && statisticItem.hasParam("common_exp_source_pb_comment") && c2.size() == 0 && (currentActivity instanceof d.a.o0.k0.a)) {
            List<String> currentPageSourceKeyList = ((d.a.o0.k0.a) currentActivity).getCurrentPageSourceKeyList();
            if (currentPageSourceKeyList instanceof ArrayList) {
                a3 = d.a((ArrayList) currentPageSourceKeyList, a2, 6);
                statisticItem.delete("common_exp_source_pb_comment");
            }
        }
        if (!TextUtils.isEmpty(a3) && !statisticItem.hasParam("page_source")) {
            statisticItem.param("page_source", a3);
        }
        TbPageExtraHelper.r(statisticItem.toString());
    }

    public final <T> List<T> d(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tArr)) == null) {
            if (tArr == null || tArr.length == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(tArr.length);
            for (T t : tArr) {
                if (t != null && !TextUtils.isEmpty(t.toString())) {
                    arrayList.add(t);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void e(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, statisticItem) == null) || statisticItem == null || statisticItem.hasParam("page_source")) {
            return;
        }
        if (h(statisticItem.getKey()) || g(statisticItem.getKey())) {
            a(statisticItem);
        }
    }

    public boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!ListUtils.isEmpty(this.f52052b) && !k.isEmpty(str)) {
                for (String str2 : this.f52052b) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (!ListUtils.isEmpty(this.f52051a) && !k.isEmpty(str)) {
                for (String str2 : this.f52051a) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final List<String> i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (k.isEmpty(str)) {
                return null;
            }
            return d(str.split(","));
        }
        return (List) invokeL.objValue;
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f52051a = i(str);
            if (str == null) {
                str = "";
            }
            d.a.o0.r.d0.b.j().x("key_need_add_source_stat_list", str);
        }
    }
}
