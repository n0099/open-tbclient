package d.b.j0.d2.k.e.y0;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.pb.data.PbFloorAgreeResponseMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import d.b.j0.d2.o.i;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final i f54797a;

    /* renamed from: b  reason: collision with root package name */
    public final HttpMessageListener f54798b = new a(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true);

    /* renamed from: c  reason: collision with root package name */
    public final HttpMessageListener f54799c = new b(CmdConfigHttp.CMD_CHANGE_FLOOR_AGREE);

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i, boolean z) {
            super(i, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            c.this.e(httpResponsedMessage, CmdConfigHttp.CMD_PB_FLOOR_AGREE);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends HttpMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            c.this.e(httpResponsedMessage, CmdConfigHttp.CMD_CHANGE_FLOOR_AGREE);
        }
    }

    public c(i iVar) {
        if (iVar != null) {
            this.f54797a = iVar;
            f();
            return;
        }
        throw new NullPointerException("PbActivity is NullPointerException");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(AgreeData agreeData) {
        d.b.i0.i0.c k;
        BaijiahaoData baijiahaoData;
        if (agreeData == null) {
            return;
        }
        int i = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 2) {
                agreeData.agreeType = 2;
                agreeData.hasAgree = false;
                agreeData.agreeNum--;
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
                k = TbPageExtraHelper.k(this.f54797a.P());
                if (k != null) {
                    httpMessage.addParam("obj_source", k.a());
                }
                if (!TextUtils.isEmpty(agreeData.postId)) {
                    httpMessage.addParam("post_id", agreeData.postId);
                }
                baijiahaoData = agreeData.baijiahaoData;
                if (baijiahaoData != null) {
                    httpMessage.addParam("ori_ugc_tid", baijiahaoData.oriUgcTid);
                    httpMessage.addParam("ori_ugc_nid", agreeData.baijiahaoData.oriUgcNid);
                    httpMessage.addParam("ori_ugc_vid", agreeData.baijiahaoData.oriUgcVid);
                    httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, agreeData.baijiahaoData.oriUgcType);
                }
                httpMessage.setTag(c());
                httpMessage.setExtra(Integer.valueOf(i));
                httpMessage.addHeader("needSig", "1");
                MessageManager.getInstance().sendMessage(httpMessage);
            }
            agreeData.agreeType = 2;
            agreeData.hasAgree = true;
            agreeData.agreeNum++;
            d.b.j0.r2.a.g().l(this.f54797a.getPageContext());
        } else {
            agreeData.agreeType = 2;
            agreeData.hasAgree = true;
            agreeData.agreeNum++;
            d.b.j0.r2.a.g().l(this.f54797a.getPageContext());
        }
        i = 0;
        HttpMessage httpMessage2 = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
        httpMessage2.addParam("z_id", TbadkCoreApplication.getInst().getZid());
        httpMessage2.addParam("thread_id", agreeData.threadId);
        httpMessage2.addParam("op_type", i);
        if (agreeData.objType == 0) {
        }
        httpMessage2.addParam("obj_type", agreeData.objType);
        httpMessage2.addParam("agree_type", agreeData.agreeType);
        httpMessage2.addParam("forum_id", agreeData.forumId);
        k = TbPageExtraHelper.k(this.f54797a.P());
        if (k != null) {
        }
        if (!TextUtils.isEmpty(agreeData.postId)) {
        }
        baijiahaoData = agreeData.baijiahaoData;
        if (baijiahaoData != null) {
        }
        httpMessage2.setTag(c());
        httpMessage2.setExtra(Integer.valueOf(i));
        httpMessage2.addHeader("needSig", "1");
        MessageManager.getInstance().sendMessage(httpMessage2);
    }

    public BdUniqueId c() {
        TbPageContext pageContext = this.f54797a.getPageContext();
        if (pageContext != null) {
            return pageContext.getUniqueId();
        }
        return null;
    }

    public void d() {
        g();
    }

    public final void e(HttpResponsedMessage httpResponsedMessage, int i) {
        PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage;
        if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != i || !(httpResponsedMessage instanceof PbFloorAgreeResponseMessage) || (pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage) == null || pbFloorAgreeResponseMessage.hasError() || this.f54797a == null || pbFloorAgreeResponseMessage.getActivityDialogData() == null) {
            return;
        }
        CustomDialogData activityDialogData = pbFloorAgreeResponseMessage.getActivityDialogData();
        activityDialogData.type = 0;
        d.b.j0.d2.j.c.a(this.f54797a.getPageContext(), activityDialogData).show();
    }

    public boolean f() {
        i iVar = this.f54797a;
        if (iVar != null) {
            iVar.registerListener(this.f54798b);
            this.f54797a.registerListener(this.f54799c);
            return true;
        }
        return true;
    }

    public final boolean g() {
        MessageManager.getInstance().unRegisterListener(this.f54798b);
        MessageManager.getInstance().unRegisterListener(this.f54799c);
        return true;
    }
}
