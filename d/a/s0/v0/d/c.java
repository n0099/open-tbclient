package d.a.s0.v0.d;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.tieba.funAd.strategy.FunAdHistoryData;
import com.baidu.tieba.funAd.strategy.FunAdSidConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.b.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f68215b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<String> f68216a;

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
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        this.f68216a = arrayList;
        arrayList.add("pb_banner");
        this.f68216a.add("frs_feed");
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            SharedPreferences.Editor edit = g().edit();
            edit.clear();
            return edit.commit();
        }
        return invokeV.booleanValue;
    }

    public static c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f68215b == null) {
                synchronized (b.class) {
                    if (f68215b == null) {
                        f68215b = new c();
                    }
                }
            }
            return f68215b;
        }
        return (c) invokeV.objValue;
    }

    public static SharedPreferences g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("fun_ad_sid_strategy_shaedpref_name", 0) : (SharedPreferences) invokeV.objValue;
    }

    public void a(String str) {
        FunAdSidConfigData b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            ArrayList<FunAdHistoryData> c2 = a.f().c(str);
            if (ListUtils.isEmpty(c2) || (b2 = b.e().b(str)) == null) {
                return;
            }
            List<FunAdHistoryData> h2 = h(c2, b2.getRecordNum(), b2.getExpiryTime());
            SharedPreferences g2 = g();
            if (i(h2, b2.getThreshold(), b2.getSpace(), g2.getLong(str + "_fun_ad_last_change_sid_time", 0L))) {
                j(str, b2);
            }
        }
    }

    public List<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f68216a : (List) invokeV.objValue;
    }

    public String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!d.i()) {
                return f(str);
            }
            FunAdSidConfigData b2 = b.e().b(str);
            if (b2 == null) {
                return f(str);
            }
            if (ListUtils.isEmpty(b2.getBearSidList())) {
                return f(str);
            }
            SharedPreferences g2 = g();
            return g2.getString(str + "_fun_ad_current_sid_suffix", f(str));
        }
        return (String) invokeL.objValue;
    }

    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? "pb_banner".equals(str) ? "6051001308-627527144" : "frs_feed".equals(str) ? "6051001001-2043781376" : "pic".equals(str) ? "6051001643-679358748" : "" : (String) invokeL.objValue;
    }

    public final List<FunAdHistoryData> h(List<FunAdHistoryData> list, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{list, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            int size = list.size();
            if (size > i2) {
                list = ListUtils.subList(list, size - i2, size);
            }
            int size2 = list.size();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            int i3 = 0;
            Iterator<FunAdHistoryData> it = list.iterator();
            while (it.hasNext() && currentTimeMillis - it.next().getShowTime() > j) {
                i3++;
            }
            return ListUtils.subList(list, i3, size2);
        }
        return (List) invokeCommon.objValue;
    }

    public final boolean i(List<FunAdHistoryData> list, int i2, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{list, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if ((System.currentTimeMillis() / 1000) - j2 <= j) {
                return false;
            }
            HashMap hashMap = new HashMap();
            for (FunAdHistoryData funAdHistoryData : list) {
                if (funAdHistoryData != null) {
                    String funAdKey = funAdHistoryData.getFunAdKey();
                    if (TextUtils.isEmpty(funAdKey)) {
                        continue;
                    } else {
                        Integer num = (Integer) hashMap.get(funAdKey);
                        if (num == null) {
                            num = 0;
                        }
                        if (num.intValue() + 1 >= i2) {
                            return true;
                        }
                        hashMap.put(funAdKey, Integer.valueOf(num.intValue() + 1));
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void j(String str, FunAdSidConfigData funAdSidConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, funAdSidConfigData) == null) {
            SharedPreferences g2 = g();
            int i2 = g2.getInt(str + "_fun_ad_current_sid_index_suffix", -1);
            List<String> bearSidList = funAdSidConfigData.getBearSidList();
            if (ListUtils.isEmpty(bearSidList)) {
                return;
            }
            int size = (i2 + 1) % bearSidList.size();
            String str2 = (String) ListUtils.getItem(bearSidList, size);
            SharedPreferences g3 = g();
            EditorHelper.putInt(g3, str + "_fun_ad_current_sid_index_suffix", size);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            SharedPreferences g4 = g();
            EditorHelper.putString(g4, str + "_fun_ad_current_sid_suffix", str2);
            SharedPreferences g5 = g();
            EditorHelper.putLong(g5, str + "_fun_ad_last_change_sid_time", System.currentTimeMillis() / 1000);
        }
    }

    public void k(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            if (jSONObject != null && d.i()) {
                for (String str : this.f68216a) {
                    if (!TextUtils.isEmpty(str)) {
                        FunAdSidConfigData funAdSidConfigData = new FunAdSidConfigData();
                        JSONObject jSONObject2 = null;
                        if (jSONObject.has(str)) {
                            try {
                                jSONObject2 = jSONObject.getJSONObject(str);
                            } catch (JSONException e2) {
                                BdLog.e(e2.getMessage());
                            }
                        }
                        if (jSONObject2 != null) {
                            funAdSidConfigData.parserJson(jSONObject2);
                            if (funAdSidConfigData.getForce() == 1) {
                                b.e().f(str, funAdSidConfigData);
                                SharedPreferences g2 = g();
                                EditorHelper.putInt(g2, str + "_fun_ad_current_sid_index_suffix", -1);
                                j(str, funAdSidConfigData);
                            } else {
                                SharedPreferences g3 = g();
                                if ((System.currentTimeMillis() / 1000) - g3.getLong(str + "_fun_ad_last_change_sid_time", 0L) > funAdSidConfigData.getSpace()) {
                                    b.e().f(str, funAdSidConfigData);
                                    SharedPreferences g4 = g();
                                    EditorHelper.putInt(g4, str + "_fun_ad_current_sid_index_suffix", -1);
                                    j(str, funAdSidConfigData);
                                }
                            }
                        }
                    }
                }
                return;
            }
            b();
        }
    }
}
