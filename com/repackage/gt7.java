package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class gt7 {
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
            TbRichTextImageInfo F = tbRichTextData.F();
            if (F != null) {
                if (!StringUtils.isNull(F.z())) {
                    return F.z();
                }
                if (F.getHeight() * F.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                    double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (F.getHeight() * F.getWidth()));
                    sb.append(BigImageLoaderProc.NCDN_PER);
                    sb.append(String.valueOf((int) (F.getWidth() * sqrt)));
                    sb.append("&height=");
                    sb.append(String.valueOf((int) (F.getHeight() * sqrt)));
                } else {
                    double width = F.getWidth() / F.getHeight();
                    double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                    sb.append(BigImageLoaderProc.NCDN_PER);
                    sb.append(String.valueOf((int) (width * sqrt2)));
                    sb.append("&height=");
                    sb.append(String.valueOf((int) sqrt2));
                }
                sb.append("&src=");
                sb.append(pi.getUrlEncode(F.F()));
                return sb.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void b(PostData postData, AbsPbActivity.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, postData, eVar) == null) || postData == null || postData.V() == null || postData.V().B() == null || eVar == null || eVar.a == null || eVar.b == null || postData.V().B().size() == 0) {
            return;
        }
        String str = (String) ListUtils.getItem(eVar.a, eVar.j);
        if (StringUtils.isNull(str)) {
            return;
        }
        eVar.a = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.b;
        eVar.b = new ConcurrentHashMap<>();
        Iterator<TbRichTextData> it = postData.V().B().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                String a = a(next);
                if (!StringUtils.isNull(a) && concurrentHashMap.get(a) != null) {
                    eVar.a.add(a);
                    eVar.b.put(a, concurrentHashMap.get(a));
                }
            }
        }
        eVar.j = ListUtils.getPosition(eVar.a, str);
    }

    public static PostData c(ft7 ft7Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{ft7Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (z) {
                if (ft7Var == null || ft7Var.F() == null || ft7Var.F().size() <= 0) {
                    return null;
                }
                PostData postData = ft7Var.F().get(0);
                return postData.B() != 1 ? d(ft7Var) : postData;
            }
            return d(ft7Var);
        }
        return (PostData) invokeCommon.objValue;
    }

    public static PostData d(ft7 ft7Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ft7Var)) == null) {
            if (ft7Var == null || ft7Var.O() == null || ft7Var.O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = ft7Var.O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = ft7Var.O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.C0(1);
            postData.I0(ft7Var.O().getFirstPostId());
            postData.Z0(ft7Var.O().getTitle());
            postData.Y0(ft7Var.O().getCreateTime());
            postData.A0(author);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }
}
