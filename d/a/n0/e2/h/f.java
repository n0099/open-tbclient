package d.a.n0.e2.h;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class f {
    public static String a(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo x = tbRichTextData.x();
        if (x != null) {
            if (!StringUtils.isNull(x.s())) {
                return x.s();
            }
            if (x.getHeight() * x.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (x.getHeight() * x.getWidth()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (x.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (x.getHeight() * sqrt)));
            } else {
                double width = x.getWidth() / x.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(d.a.c.e.p.k.getUrlEncode(x.x()));
            return sb.toString();
        }
        return null;
    }

    public static void b(PostData postData, PbActivity.e eVar) {
        if (postData == null || postData.K() == null || postData.K().u() == null || eVar == null || eVar.f18855a == null || eVar.f18856b == null || postData.K().u().size() == 0) {
            return;
        }
        String str = (String) ListUtils.getItem(eVar.f18855a, eVar.j);
        if (StringUtils.isNull(str)) {
            return;
        }
        eVar.f18855a = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.f18856b;
        eVar.f18856b = new ConcurrentHashMap<>();
        Iterator<TbRichTextData> it = postData.K().u().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                String a2 = a(next);
                if (!StringUtils.isNull(a2) && concurrentHashMap.get(a2) != null) {
                    eVar.f18855a.add(a2);
                    eVar.f18856b.put(a2, concurrentHashMap.get(a2));
                }
            }
        }
        eVar.j = ListUtils.getPosition(eVar.f18855a, str);
    }

    public static PostData c(e eVar, boolean z, int i2) {
        if (z) {
            if (eVar == null || eVar.D() == null || eVar.D().size() <= 0) {
                return null;
            }
            PostData postData = eVar.D().get(0);
            return postData.A() != 1 ? d(eVar) : postData;
        }
        return d(eVar);
    }

    public static PostData d(e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.L() == null || eVar.L().T() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData T = eVar.L().T();
        String userId = T.getUserId();
        HashMap<String, MetaData> G1 = eVar.L().G1();
        if (G1 != null && (metaData = G1.get(userId)) != null && metaData.getUserId() != null) {
            T = metaData;
        }
        postData.i0(1);
        postData.l0(eVar.L().f0());
        postData.x0(eVar.L().z1());
        postData.w0(eVar.L().Z());
        postData.g0(T);
        return postData;
    }
}
