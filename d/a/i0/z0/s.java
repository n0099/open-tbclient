package d.a.i0.z0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
/* loaded from: classes3.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public static String f50185a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f50186b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f50187c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f50188d = "floor";

    public static void a(String str, String str2, String str3, int i2, d.a.c.a.f fVar, BaijiahaoData baijiahaoData) {
        f50186b = str;
        f50187c = str2;
        f50185a = str3;
        if (StringUtils.isNull(str3) || fVar == null || fVar.getPageActivity() == null) {
            return;
        }
        if (f50188d.equals(f50185a)) {
            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(fVar.getPageActivity()).createSubPbActivityConfig(f50186b, f50187c, "search_post", true);
            createSubPbActivityConfig.setKeyPageStartFrom(8);
            createSubPbActivityConfig.setBjhData(baijiahaoData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            return;
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(fVar.getPageActivity()).createNormalCfg(f50186b, f50187c, "search_post");
        createNormalCfg.setStartFrom(8);
        createNormalCfg.setBjhData(baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }
}
