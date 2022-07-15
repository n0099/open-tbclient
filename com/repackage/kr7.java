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
public class kr7 {
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
            TbRichTextImageInfo G = tbRichTextData.G();
            if (G != null) {
                if (!StringUtils.isNull(G.A())) {
                    return G.A();
                }
                if (G.getHeight() * G.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                    double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (G.getHeight() * G.getWidth()));
                    sb.append(BigImageLoaderProc.NCDN_PER);
                    sb.append(String.valueOf((int) (G.getWidth() * sqrt)));
                    sb.append("&height=");
                    sb.append(String.valueOf((int) (G.getHeight() * sqrt)));
                } else {
                    double width = G.getWidth() / G.getHeight();
                    double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                    sb.append(BigImageLoaderProc.NCDN_PER);
                    sb.append(String.valueOf((int) (width * sqrt2)));
                    sb.append("&height=");
                    sb.append(String.valueOf((int) sqrt2));
                }
                sb.append("&src=");
                sb.append(oi.getUrlEncode(G.G()));
                return sb.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void b(PostData postData, AbsPbActivity.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, postData, eVar) == null) || postData == null || postData.Q() == null || postData.Q().C() == null || eVar == null || eVar.a == null || eVar.b == null || postData.Q().C().size() == 0) {
            return;
        }
        String str = (String) ListUtils.getItem(eVar.a, eVar.j);
        if (StringUtils.isNull(str)) {
            return;
        }
        eVar.a = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.b;
        eVar.b = new ConcurrentHashMap<>();
        Iterator<TbRichTextData> it = postData.Q().C().iterator();
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

    public static PostData c(jr7 jr7Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{jr7Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (z) {
                if (jr7Var == null || jr7Var.F() == null || jr7Var.F().size() <= 0) {
                    return null;
                }
                PostData postData = jr7Var.F().get(0);
                return postData.B() != 1 ? d(jr7Var) : postData;
            }
            return d(jr7Var);
        }
        return (PostData) invokeCommon.objValue;
    }

    public static PostData d(jr7 jr7Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jr7Var)) == null) {
            if (jr7Var == null || jr7Var.O() == null || jr7Var.O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = jr7Var.O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = jr7Var.O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.s0(1);
            postData.x0(jr7Var.O().getFirstPostId());
            postData.J0(jr7Var.O().getTitle());
            postData.I0(jr7Var.O().getCreateTime());
            postData.q0(author);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }
}
