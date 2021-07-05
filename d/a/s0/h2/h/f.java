package d.a.s0.h2.h;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbRichTextData)) == null) {
            if (tbRichTextData == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder(150);
            TbRichTextImageInfo B = tbRichTextData.B();
            if (B != null) {
                if (!StringUtils.isNull(B.w())) {
                    return B.w();
                }
                if (B.getHeight() * B.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                    double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (B.getHeight() * B.getWidth()));
                    sb.append(BigImageLoaderProc.NCDN_PER);
                    sb.append(String.valueOf((int) (B.getWidth() * sqrt)));
                    sb.append("&height=");
                    sb.append(String.valueOf((int) (B.getHeight() * sqrt)));
                } else {
                    double width = B.getWidth() / B.getHeight();
                    double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                    sb.append(BigImageLoaderProc.NCDN_PER);
                    sb.append(String.valueOf((int) (width * sqrt2)));
                    sb.append("&height=");
                    sb.append(String.valueOf((int) sqrt2));
                }
                sb.append("&src=");
                sb.append(d.a.c.e.p.k.getUrlEncode(B.B()));
                return sb.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void b(PostData postData, PbActivity.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, postData, eVar) == null) || postData == null || postData.K() == null || postData.K().y() == null || eVar == null || eVar.f19136a == null || eVar.f19137b == null || postData.K().y().size() == 0) {
            return;
        }
        String str = (String) ListUtils.getItem(eVar.f19136a, eVar.j);
        if (StringUtils.isNull(str)) {
            return;
        }
        eVar.f19136a = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.f19137b;
        eVar.f19137b = new ConcurrentHashMap<>();
        Iterator<TbRichTextData> it = postData.K().y().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                String a2 = a(next);
                if (!StringUtils.isNull(a2) && concurrentHashMap.get(a2) != null) {
                    eVar.f19136a.add(a2);
                    eVar.f19137b.put(a2, concurrentHashMap.get(a2));
                }
            }
        }
        eVar.j = ListUtils.getPosition(eVar.f19136a, str);
    }

    public static PostData c(e eVar, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{eVar, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            if (z) {
                if (eVar == null || eVar.E() == null || eVar.E().size() <= 0) {
                    return null;
                }
                PostData postData = eVar.E().get(0);
                return postData.A() != 1 ? d(eVar) : postData;
            }
            return d(eVar);
        }
        return (PostData) invokeCommon.objValue;
    }

    public static PostData d(e eVar) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, eVar)) == null) {
            if (eVar == null || eVar.N() == null || eVar.N().H() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData H = eVar.N().H();
            String userId = H.getUserId();
            HashMap<String, MetaData> u1 = eVar.N().u1();
            if (u1 != null && (metaData = u1.get(userId)) != null && metaData.getUserId() != null) {
                H = metaData;
            }
            postData.i0(1);
            postData.l0(eVar.N().T());
            postData.x0(eVar.N().getTitle());
            postData.w0(eVar.N().N());
            postData.g0(H);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }
}
