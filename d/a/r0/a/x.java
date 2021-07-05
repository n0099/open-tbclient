package d.a.r0.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes9.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) {
            String paramStr = UrlManager.getParamStr(str);
            if (TextUtils.isEmpty(paramStr)) {
                return;
            }
            b(statisticItem, UrlManager.getParamPair(paramStr));
        }
    }

    public static void b(StatisticItem statisticItem, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, statisticItem, map) == null) || statisticItem == null || map == null) {
            return;
        }
        statisticItem.param(TiebaStatic.Params.REFER, map.get(TiebaStatic.Params.REFER));
    }

    public static void c(Uri uri) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, uri) == null) || uri == null) {
            return;
        }
        String d2 = d(uri);
        String queryParameter = uri.getQueryParameter("obj_source");
        if ("shoubai".equals(queryParameter) || ThirdPartyUtil.TYPE_WEIXIN.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "zhongjianye".equals(queryParameter) || "PC".equals(queryParameter)) {
            String queryParameter2 = uri.getQueryParameter("obj_locate");
            uri.getQueryParameter("obj_type");
            String queryParameter3 = uri.getQueryParameter("obj_param1");
            String queryParameter4 = uri.getQueryParameter(TiebaStatic.Params.OBJ_PARAM2);
            String queryParameter5 = uri.getQueryParameter(TiebaStatic.Params.OBJ_PARAM3);
            String queryParameter6 = uri.getQueryParameter("tid");
            String queryParameter7 = uri.getQueryParameter(TiebaStatic.Params.H5_FORUM_NAME);
            String queryParameter8 = uri.getQueryParameter(g.q);
            String queryParameter9 = uri.getQueryParameter(g.r);
            String queryParameter10 = uri.getQueryParameter(g.s);
            String queryParameter11 = uri.getQueryParameter(g.t);
            String queryParameter12 = uri.getQueryParameter("obj_name");
            String queryParameter13 = uri.getQueryParameter("eqid");
            String queryParameter14 = uri.getQueryParameter("topic_id");
            String queryParameter15 = uri.getQueryParameter("fid");
            String queryParameter16 = uri.getQueryParameter(TiebaStatic.Params.REFER);
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AIAPPS_CALL_NATIVE);
            statisticItem.param("obj_locate", queryParameter2);
            statisticItem.param("obj_type", d2);
            statisticItem.param("obj_param1", queryParameter3);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, queryParameter4);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, queryParameter5);
            statisticItem.param("tid", queryParameter6);
            statisticItem.param("fid", queryParameter15);
            statisticItem.param("fname", queryParameter7);
            statisticItem.param(g.q, queryParameter8);
            statisticItem.param(g.r, queryParameter9);
            statisticItem.param(g.s, queryParameter10);
            statisticItem.param(g.t, queryParameter11);
            statisticItem.param("obj_source", queryParameter);
            statisticItem.param("obj_name", queryParameter12);
            statisticItem.param("query", queryParameter13);
            statisticItem.param("topic_id", queryParameter14);
            statisticItem.param("obj_id", TbadkCoreApplication.getInst().getStartType());
            statisticItem.param(TiebaStatic.Params.OBJ_TO, 1);
            statisticItem.param(TiebaStatic.Params.REFER, !TextUtils.isEmpty(queryParameter16) ? queryParameter16 : StringUtil.NULL_STRING);
            TiebaStatic.log(statisticItem);
        }
    }

    public static String d(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, uri)) == null) {
            if (uri == null) {
                return "";
            }
            String uri2 = uri.toString();
            return TextUtils.isEmpty(uri2) ? "" : (uri2.contains("unidispatch/openapp") || uri2.contains("donothing")) ? "5" : (uri2.contains("tbpb") || uri2.contains("unidispatch/pb")) ? "tbpb://tieba.baidu.com".equals(uri2) ? "5" : !TextUtils.isEmpty(uri.getQueryParameter(g.q)) ? "6" : "1" : (uri2.contains("invoke_frs") || uri2.contains("tbfrs") || uri2.contains("unidispatch/frs")) ? "2" : uri2.contains("tbwebview") ? "9" : (uri2.contains("tbusercenter") || uri2.contains("unidispatch/usercenter") || uri2.contains("usercenter")) ? "4" : (uri2.contains("tbtopicdetail") || uri2.contains("unidispatch/topicdetail")) ? "3" : uri2.contains("unidispatch/hotuserrank") ? "7" : g.f54634c.equals(uri.getPath()) ? "5" : "10";
        }
        return (String) invokeL.objValue;
    }

    public static void e(Uri uri) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65540, null, uri) == null) || uri == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("is_new_schema");
        if (TextUtils.isEmpty(queryParameter) || !queryParameter.equals("1")) {
            return;
        }
        String queryParameter2 = uri.getQueryParameter("obj_source");
        String queryParameter3 = uri.getQueryParameter("obj_locate");
        String queryParameter4 = uri.getQueryParameter("obj_type");
        String queryParameter5 = uri.getQueryParameter("obj_param1");
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_PAY_PUT_TIE);
        statisticItem.param("obj_source", queryParameter2);
        statisticItem.param("obj_locate", queryParameter3);
        statisticItem.param("obj_type", queryParameter4);
        statisticItem.param("obj_param1", queryParameter5);
        TiebaStatic.log(statisticItem);
    }
}
