package d.b.i0.d2.k.e;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.pb.pb.main.PbModel;
import d.b.h0.a.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public int f54049a;

    public c0(PbModel pbModel, BaseFragmentActivity baseFragmentActivity) {
    }

    public HashMap<String, Object> a(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        String[] split = str.split("[&]");
        if (split.length == 0) {
            return null;
        }
        for (String str2 : split) {
            String[] split2 = str2.split("[=]");
            if (split2.length > 1) {
                hashMap.put(split2[0], split2[1]);
            }
        }
        return hashMap;
    }

    public void b(Intent intent, f.b bVar) {
        if (intent == null || intent.getParcelableExtra(IntentConfig.KEY_URI) == null) {
            return;
        }
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        String uri2 = uri.toString();
        if (StringUtils.isNull(uri2) || !uri2.startsWith("tbpb://")) {
            return;
        }
        String decode = Uri.decode(uri.getEncodedPath());
        if (StringUtils.isNull(decode)) {
            return;
        }
        c(decode);
        HashMap<String, Object> a2 = a(decode);
        String str = (String) a2.get("tid");
        if ("mpush".equals((String) a2.get("fr")) && !StringUtils.isNull(str)) {
            TiebaStatic.log(new StatisticItem("c11895").param("tid", str));
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
        httpMessage.addParam("call_url", uri2);
        MessageManager.getInstance().sendMessage(httpMessage);
        bVar.onCallBack(a2);
    }

    public final void c(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> paramPair = UrlManager.getParamPair(str);
        if (paramPair != null) {
            this.f54049a = 5;
            StatisticItem statisticItem = new StatisticItem("c10320");
            statisticItem.param("obj_locate", paramPair.get("obj_locate"));
            statisticItem.param("obj_type", 1);
            statisticItem.param("tid", paramPair.get("tid"));
            statisticItem.param("obj_source", paramPair.get("obj_source"));
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, paramPair.get(TiebaStatic.Params.OBJ_PARAM2));
            statisticItem.param(TiebaStatic.Params.OBJ_TO, 3);
            statisticItem.param("obj_id", paramPair.get("bdid"));
            statisticItem.param("obj_name", TbadkCoreApplication.getInst().getStartType());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, 1);
            if (!d.b.c.e.p.k.isEmpty(paramPair.get("ext_log"))) {
                try {
                    JSONObject jSONObject = new JSONObject(paramPair.get("ext_log"));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        statisticItem.param(next, jSONObject.getString(next));
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
