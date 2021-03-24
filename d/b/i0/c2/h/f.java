package d.b.i0.c2.h;

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
                double threadImageMaxWidth = TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth();
                double height = x.getHeight() * x.getWidth();
                Double.isNaN(threadImageMaxWidth);
                Double.isNaN(height);
                double sqrt = Math.sqrt(threadImageMaxWidth / height);
                sb.append(BigImageLoaderProc.NCDN_PER);
                double width = x.getWidth();
                Double.isNaN(width);
                sb.append(String.valueOf((int) (width * sqrt)));
                sb.append("&height=");
                double height2 = x.getHeight();
                Double.isNaN(height2);
                sb.append(String.valueOf((int) (height2 * sqrt)));
            } else {
                double threadImageMaxWidth2 = TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth();
                double width2 = x.getWidth() / x.getHeight();
                Double.isNaN(threadImageMaxWidth2);
                Double.isNaN(width2);
                double sqrt2 = Math.sqrt(threadImageMaxWidth2 / width2);
                sb.append(BigImageLoaderProc.NCDN_PER);
                Double.isNaN(width2);
                sb.append(String.valueOf((int) (width2 * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(d.b.b.e.p.k.getUrlEncode(x.x()));
            return sb.toString();
        }
        return null;
    }

    public static void b(PostData postData, PbActivity.e eVar) {
        if (postData == null || postData.J() == null || postData.J().u() == null || eVar == null || eVar.f19506a == null || eVar.f19507b == null || postData.J().u().size() == 0) {
            return;
        }
        String str = (String) ListUtils.getItem(eVar.f19506a, eVar.j);
        if (StringUtils.isNull(str)) {
            return;
        }
        eVar.f19506a = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.f19507b;
        eVar.f19507b = new ConcurrentHashMap<>();
        Iterator<TbRichTextData> it = postData.J().u().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                String a2 = a(next);
                if (!StringUtils.isNull(a2) && concurrentHashMap.get(a2) != null) {
                    eVar.f19506a.add(a2);
                    eVar.f19507b.put(a2, concurrentHashMap.get(a2));
                }
            }
        }
        eVar.j = ListUtils.getPosition(eVar.f19506a, str);
    }

    public static PostData c(e eVar, boolean z, int i) {
        if (z) {
            if (eVar == null || eVar.D() == null || eVar.D().size() <= 0) {
                return null;
            }
            PostData postData = eVar.D().get(0);
            return postData.z() != 1 ? d(eVar) : postData;
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
        HashMap<String, MetaData> E1 = eVar.L().E1();
        if (E1 != null && (metaData = E1.get(userId)) != null && metaData.getUserId() != null) {
            T = metaData;
        }
        postData.g0(1);
        postData.j0(eVar.L().f0());
        postData.v0(eVar.L().x1());
        postData.u0(eVar.L().Z());
        postData.e0(T);
        return postData;
    }
}
