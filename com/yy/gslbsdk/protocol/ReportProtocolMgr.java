package com.yy.gslbsdk.protocol;

import com.baidu.fsg.base.statistics.k;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.yy.gslbsdk.cache.DataCacheMgr;
import com.yy.gslbsdk.db.HijackTB;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ReportProtocolMgr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ReportProtocolMgr";
    public transient /* synthetic */ FieldHolder $fh;

    public ReportProtocolMgr() {
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

    public static String reportProtocol(ReportInfo reportInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, reportInfo)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", GlobalTools.ACCOUNT_ID);
                jSONObject.put("h", reportInfo.getHost());
                jSONObject.put("ni", reportInfo.getView());
                jSONObject.put("nt", reportInfo.getNetInfo().getNetType());
                jSONObject.put("isp", reportInfo.getNetInfo().getIsp());
                jSONObject.put("plat", "andr");
                jSONObject.put("gid", DataCacheMgr.INSTANCE.getIdentity(GlobalTools.APP_CONTEXT));
                jSONObject.put("v", "2.2.18-lianyun");
                jSONObject.put("timestamp", System.currentTimeMillis());
                if (reportInfo.getStats0() != null) {
                    jSONObject.put("fc", reportInfo.getFc());
                    jSONObject.put(k.f39582h, reportInfo.getLc());
                    JSONArray jSONArray = new JSONArray();
                    StatsInfo stats0 = reportInfo.getStats0();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("sip", stats0.getSip());
                    JSONArray jSONArray2 = new JSONArray();
                    Iterator<long[]> it = stats0.getIts().iterator();
                    while (it.hasNext()) {
                        long[] next = it.next();
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("avg", next[0]);
                        jSONObject3.put(BeanConstants.DXM_OCR_KEY_CNT, next[1]);
                        jSONArray2.put(jSONObject3);
                    }
                    jSONObject2.put("its", jSONArray2);
                    jSONArray.put(jSONObject2);
                    jSONObject.put("stats0", jSONArray);
                }
                if (reportInfo.getStats1() != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (StatsInfo statsInfo : reportInfo.getStats1().values()) {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("sip", statsInfo.getSip());
                        JSONArray jSONArray4 = new JSONArray();
                        Iterator<long[]> it2 = statsInfo.getIts().iterator();
                        while (it2.hasNext()) {
                            long[] next2 = it2.next();
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("avg", next2[0]);
                            jSONObject5.put(BeanConstants.DXM_OCR_KEY_CNT, next2[1]);
                            jSONArray4.put(jSONObject5);
                        }
                        jSONObject4.put("its", jSONArray4);
                        jSONArray3.put(jSONObject4);
                    }
                    jSONObject.put("stats1", jSONArray3);
                }
                if (reportInfo.getStats15() != null) {
                    JSONArray jSONArray5 = new JSONArray();
                    for (StatsInfo statsInfo2 : reportInfo.getStats15().values()) {
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.put("sip", statsInfo2.getSip());
                        JSONArray jSONArray6 = new JSONArray();
                        Iterator<long[]> it3 = statsInfo2.getIts().iterator();
                        while (it3.hasNext()) {
                            long[] next3 = it3.next();
                            JSONObject jSONObject7 = new JSONObject();
                            jSONObject7.put("avg", next3[0]);
                            jSONObject7.put(BeanConstants.DXM_OCR_KEY_CNT, next3[1]);
                            jSONArray6.put(jSONObject7);
                        }
                        jSONObject6.put("its", jSONArray6);
                        jSONArray5.put(jSONObject6);
                    }
                    jSONObject.put("stats15", jSONArray5);
                }
                if (reportInfo.getCt() != -1) {
                    jSONObject.put("ct", reportInfo.getCt());
                }
                if (reportInfo.getTt() != -1) {
                    jSONObject.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, reportInfo.getTt());
                }
                if (reportInfo.getHijack() != null) {
                    JSONArray jSONArray7 = new JSONArray();
                    Iterator<HijackInfo> it4 = reportInfo.getHijack().iterator();
                    while (it4.hasNext()) {
                        HijackInfo next4 = it4.next();
                        JSONObject jSONObject8 = new JSONObject();
                        jSONObject8.put("uip", next4.getUip() == null ? "" : next4.getUip());
                        jSONObject8.put(HijackTB.DNSIP, next4.getDnsip());
                        jSONObject8.put(HijackTB.HIP, next4.getHip());
                        jSONArray7.put(jSONObject8);
                    }
                    jSONObject.put("hijack", jSONArray7);
                }
                return jSONObject.toString();
            } catch (Exception e2) {
                LogTools.printError(TAG, "reportProtocol: " + e2.getMessage());
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
