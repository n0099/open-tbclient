package d.b.h0.r.b0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import d.b.h0.f0.f;
import d.b.h0.f0.h;
import d.b.h0.j0.c;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.e;
/* loaded from: classes3.dex */
public class a {
    public void a(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        h.i(agreeEvent);
    }

    public void b(Context context, e eVar, AgreeData agreeData, a2 a2Var) {
        if (eVar == null || agreeData == null) {
            return;
        }
        BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
        StatisticItem param = new StatisticItem("c13271").param("obj_type", eVar.f51175g).param("obj_locate", eVar.f51176h).param("obj_id", eVar.i).param("obj_name", baijiahaoData != null ? baijiahaoData.oriUgcType : 0).param("post_id", agreeData.postId).param("nid", agreeData.nid);
        if (a2Var != null) {
            param.param("tid", a2Var.o0()).param("nid", a2Var.L0()).param("fid", a2Var.c0()).param("ab_tag", a2Var.T0).param("recom_source", a2Var.R0).param("weight", a2Var.S0).param("extra", a2Var.U0);
            if (a2Var.V() != null) {
                param.param(TiebaStatic.Params.OBJ_PARAM4, a2Var.V().oriUgcNid);
                if (a2Var.R1() || a2Var.Q1()) {
                    param.param(TiebaStatic.Params.OBJ_PARAM6, a2Var.V().oriUgcVid);
                }
            }
            if (a2Var.T1()) {
                param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
            } else if (!a2Var.O1() && !a2Var.R1()) {
                int i = a2Var.Z;
                if (i == 0 || i == 40) {
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

    public void c(AgreeData agreeData, int i, BdUniqueId bdUniqueId, boolean z) {
        if (agreeData == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
        httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
        httpMessage.addParam("thread_id", agreeData.threadId);
        httpMessage.addParam("op_type", i);
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
        httpMessage.setExtra(Integer.valueOf(i));
        httpMessage.addHeader("needSig", "1");
        if (z) {
            if (!TextUtils.isEmpty(f.b())) {
                httpMessage.addParam(HttpRequest.BDUSS, f.b());
            }
            if (!TextUtils.isEmpty(f.d())) {
                httpMessage.addParam(HttpRequest.TBS, f.d());
            }
            if (!TextUtils.isEmpty(f.c())) {
                httpMessage.addParam("stoken", f.c());
            }
        }
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void d(AgreeData agreeData, d.b.i0.d3.h0.e eVar) {
        eVar.f54819b = agreeData;
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
