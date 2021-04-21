package d.b.i0.z0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
/* loaded from: classes3.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public static String f52503a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f52504b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f52505c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f52506d = "floor";

    public static void a(String str, String str2, String str3, int i, d.b.c.a.f fVar, BaijiahaoData baijiahaoData) {
        f52504b = str;
        f52505c = str2;
        f52503a = str3;
        if (StringUtils.isNull(str3) || fVar == null || fVar.getPageActivity() == null) {
            return;
        }
        if (f52506d.equals(f52503a)) {
            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(fVar.getPageActivity()).createSubPbActivityConfig(f52504b, f52505c, "search_post", true);
            createSubPbActivityConfig.setKeyPageStartFrom(8);
            createSubPbActivityConfig.setBjhData(baijiahaoData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            return;
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(fVar.getPageActivity()).createNormalCfg(f52504b, f52505c, "search_post");
        createNormalCfg.setStartFrom(8);
        createNormalCfg.setBjhData(baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }
}
