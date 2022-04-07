package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tieba.stampmission.mission.StampMission;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class st4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public st4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            o55.i(agreeEvent);
        }
    }

    public void b(Context context, wn4 wn4Var, AgreeData agreeData, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, wn4Var, agreeData, threadData) == null) || wn4Var == null || agreeData == null) {
            return;
        }
        BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
        StatisticItem param = new StatisticItem("c13271").param("obj_type", wn4Var.g).param("obj_locate", wn4Var.h).param("obj_id", wn4Var.i).param("obj_name", baijiahaoData != null ? baijiahaoData.oriUgcType : 0).param("post_id", agreeData.postId).param("nid", agreeData.nid);
        if (threadData != null) {
            param.param("tid", threadData.getId()).param("nid", threadData.getNid()).param("fid", threadData.getFid()).param("ab_tag", threadData.mRecomAbTag).param("recom_source", threadData.mRecomSource).param("weight", threadData.mRecomWeight).param("extra", threadData.mRecomExtra);
            if (threadData.getBaijiahaoData() != null) {
                param.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                if (threadData.isBJHVideoThreadType() || threadData.isBJHVideoDynamicThreadType()) {
                    param.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                }
            }
            if (threadData.isBjhDynamicThread()) {
                param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
            } else if (!threadData.isBJHArticleThreadType() && !threadData.isBJHVideoThreadType()) {
                int i = threadData.threadType;
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
            u75.b(context, param);
        }
        TiebaStatic.log(param);
    }

    public void c(AgreeData agreeData, int i, BdUniqueId bdUniqueId, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{agreeData, Integer.valueOf(i), bdUniqueId, Boolean.valueOf(z)}) == null) || agreeData == null) {
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
            if (!TextUtils.isEmpty(m55.b())) {
                httpMessage.addParam(HttpRequest.BDUSS, m55.b());
            }
            if (!TextUtils.isEmpty(m55.f())) {
                httpMessage.addParam(HttpRequest.TBS, m55.f());
            }
            if (!TextUtils.isEmpty(m55.e())) {
                httpMessage.addParam("stoken", m55.e());
            }
        }
        MessageManager.getInstance().sendMessage(httpMessage);
        if (TbadkCoreApplication.getCurrentAccount() == null || i != 0 || agreeData.agreeType == 5 || !TbadkCoreApplication.getInst().isMainProcess(true)) {
            return;
        }
        if (TbSingleton.getInstance().showStampMissionDialog && UbsABTestHelper.isStampMissionDialogABTestB()) {
            gi8.r().A(0, 3);
            gi8.r().G();
        }
        gi8.r().z(StampMission.Type.LIKE_THREAD);
    }

    public void d(AgreeData agreeData, lk8 lk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, agreeData, lk8Var) == null) {
            lk8Var.b = agreeData;
            if (agreeData.isInThread) {
                BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
                if (baijiahaoData != null) {
                    agreeData.nid = baijiahaoData.oriUgcNid;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, lk8Var));
                a(agreeData, AgreeEvent.IS_THREAD);
            } else if (agreeData.isInPost) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, lk8Var));
                a(agreeData, AgreeEvent.IS_POST);
            }
        }
    }
}
