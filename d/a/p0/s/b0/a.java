package d.a.p0.s.b0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.h0.h;
import d.a.p0.l0.c;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.f;
import d.a.q0.h3.h0.e;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    public void a(AgreeData agreeData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, agreeData, str) == null) {
            AgreeEvent agreeEvent = new AgreeEvent();
            agreeEvent.agreeData = agreeData;
            agreeEvent.agreeExtra = str;
            h.i(agreeEvent);
        }
    }

    public void b(Context context, f fVar, AgreeData agreeData, b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, fVar, agreeData, b2Var) == null) || fVar == null || agreeData == null) {
            return;
        }
        BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
        StatisticItem param = new StatisticItem("c13271").param("obj_type", fVar.f53316g).param("obj_locate", fVar.f53317h).param("obj_id", fVar.f53318i).param("obj_name", baijiahaoData != null ? baijiahaoData.oriUgcType : 0).param("post_id", agreeData.postId).param("nid", agreeData.nid);
        if (b2Var != null) {
            param.param("tid", b2Var.d0()).param("nid", b2Var.B0()).param("fid", b2Var.R()).param("ab_tag", b2Var.V0).param("recom_source", b2Var.T0).param("weight", b2Var.U0).param("extra", b2Var.W0);
            if (b2Var.J() != null) {
                param.param(TiebaStatic.Params.OBJ_PARAM4, b2Var.J().oriUgcNid);
                if (b2Var.I1() || b2Var.H1()) {
                    param.param(TiebaStatic.Params.OBJ_PARAM6, b2Var.J().oriUgcVid);
                }
            }
            if (b2Var.K1()) {
                param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
            } else if (!b2Var.F1() && !b2Var.I1()) {
                int i2 = b2Var.Z;
                if (i2 == 0 || i2 == 40) {
                    param.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                }
            } else {
                param.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            }
        } else {
            param.param("tid", agreeData.threadId);
            param.param("nid", agreeData.nid);
            param.param("fid", agreeData.forumId);
            param.param("card_type", agreeData.cardType);
            param.param("ab_tag", agreeData.recomAbTag);
            param.param("recom_source", agreeData.recomSource);
            param.param("weight", agreeData.recomWeight);
            param.param("extra", agreeData.recomExtra);
            BaijiahaoData baijiahaoData2 = agreeData.baijiahaoData;
            if (baijiahaoData2 != null) {
                param.param(TiebaStatic.Params.OBJ_PARAM6, baijiahaoData2.oriUgcVid);
            }
        }
        if (context != null) {
            c.b(context, param);
        }
        TiebaStatic.log(param);
    }

    public void c(AgreeData agreeData, int i2, BdUniqueId bdUniqueId, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{agreeData, Integer.valueOf(i2), bdUniqueId, Boolean.valueOf(z)}) == null) || agreeData == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
        httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
        httpMessage.addParam("thread_id", agreeData.threadId);
        httpMessage.addParam("op_type", i2);
        if (agreeData.objType == 0) {
            agreeData.objType = 3;
        }
        httpMessage.addParam("obj_type", agreeData.objType);
        httpMessage.addParam("agree_type", agreeData.agreeType);
        httpMessage.addParam("forum_id", agreeData.forumId);
        if (!StringUtil.isEmpty(agreeData.objSource)) {
            httpMessage.addParam("obj_source", agreeData.objSource);
        }
        if (!TextUtils.isEmpty(agreeData.postId)) {
            httpMessage.addParam("post_id", agreeData.postId);
        }
        BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
        if (baijiahaoData != null) {
            httpMessage.addParam("ori_ugc_tid", baijiahaoData.oriUgcTid);
            httpMessage.addParam("ori_ugc_nid", agreeData.baijiahaoData.oriUgcNid);
            httpMessage.addParam("ori_ugc_vid", agreeData.baijiahaoData.oriUgcVid);
            httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, agreeData.baijiahaoData.oriUgcType);
        }
        httpMessage.setTag(bdUniqueId);
        httpMessage.setExtra(Integer.valueOf(i2));
        httpMessage.addHeader("needSig", "1");
        if (z) {
            if (!TextUtils.isEmpty(d.a.p0.h0.f.b())) {
                httpMessage.addParam(HttpRequest.BDUSS, d.a.p0.h0.f.b());
            }
            if (!TextUtils.isEmpty(d.a.p0.h0.f.d())) {
                httpMessage.addParam(HttpRequest.TBS, d.a.p0.h0.f.d());
            }
            if (!TextUtils.isEmpty(d.a.p0.h0.f.c())) {
                httpMessage.addParam("stoken", d.a.p0.h0.f.c());
            }
        }
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void d(AgreeData agreeData, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, agreeData, eVar) == null) {
            eVar.f58547b = agreeData;
            if (agreeData.isInThread) {
                BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
                if (baijiahaoData != null) {
                    agreeData.nid = baijiahaoData.oriUgcNid;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
                a(agreeData, AgreeEvent.IS_THREAD);
            } else if (agreeData.isInPost) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, eVar));
                a(agreeData, AgreeEvent.IS_POST);
            }
        }
    }
}
