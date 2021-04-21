package d.b.j0.d2.k.e.b1;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbPostShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.b.i0.r.q.a2;
import d.b.j0.d2.h.e;
import d.b.j0.d2.h.m;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f54466a;

    /* renamed from: b  reason: collision with root package name */
    public b f54467b = new a();

    /* loaded from: classes3.dex */
    public class a implements b {
        public a() {
        }

        @Override // d.b.j0.d2.k.e.b1.c.b
        public void a(e eVar, a2 a2Var, PostData postData, d.b.i0.b1.m.a aVar) {
            String e2;
            String w1;
            String str;
            if ((eVar == null && a2Var == null) || postData == null || c.this.f54466a == null) {
                return;
            }
            if (eVar == null) {
                e2 = c.this.e(a2Var);
            } else {
                String str2 = eVar.K(c.this.f54466a.getPageActivity(), false)[0];
                if (!StringUtils.isNull(str2) && str2.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str2 = str2.substring(37);
                }
                a2 L = eVar.L();
                if (L == null) {
                    return;
                }
                String str3 = str2;
                a2Var = L;
                e2 = str3;
            }
            m mVar = new m();
            mVar.h(a2Var.C());
            if (!StringUtils.isNull(e2)) {
                mVar.k(e2);
            }
            mVar.l(a2Var.s1());
            mVar.g(aVar);
            mVar.i(postData);
            String x1 = a2Var.x1();
            if (StringUtils.isNull(x1)) {
                x1 = a2Var.C();
            }
            mVar.h(x1);
            if (a2Var.y2()) {
                w1 = a2Var.V().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + a2Var.V().oriUgcType + "&dvid=" + a2Var.V().oriUgcVid + "&nid=" + a2Var.V().oriUgcNid;
            } else {
                w1 = a2Var.w1();
                str = "?share=9105&fr=share";
            }
            mVar.j(c.this.d("http://tieba.baidu.com/p/" + w1 + (str + "&post_id=" + postData.E() + "&share_from=comment&post_sort=1")));
            ShareItem shareItem = new ShareItem();
            shareItem.V = 1;
            shareItem.k = true;
            shareItem.q = w1;
            shareItem.U = postData.E();
            Bundle bundle = new Bundle();
            bundle.putString("tid", w1);
            bundle.putString("pid", postData.E());
            bundle.putInt("source", 1);
            shareItem.i(bundle);
            PbPostShareDialogConfig pbPostShareDialogConfig = new PbPostShareDialogConfig(c.this.f54466a.getPageActivity(), shareItem, true, mVar);
            pbPostShareDialogConfig.setIsCopyLink(false);
            pbPostShareDialogConfig.setHideMode(pbPostShareDialogConfig.hideMode | 32);
            c.this.f54466a.sendMessage(new CustomMessage(2001276, pbPostShareDialogConfig));
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem.param("tid", w1);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (a2Var.h0() != null) {
                statisticItem.param("fid", a2Var.h0().f51659a);
            }
            if (a2Var.z1() != null) {
                statisticItem.param("post_id", postData.E());
            }
            statisticItem.param("obj_locate", 21);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(e eVar, a2 a2Var, PostData postData, d.b.i0.b1.m.a aVar);
    }

    public c(TbPageContext tbPageContext) {
        this.f54466a = tbPageContext;
    }

    public final Bitmap d(String str) {
        CustomResponsedMessage runTask;
        if (str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
            return null;
        }
        return (Bitmap) runTask.getData();
    }

    public final String e(a2 a2Var) {
        String str = null;
        if (a2Var == null) {
            return null;
        }
        if (a2Var.q1() != null && !TextUtils.isEmpty(a2Var.q1().cover)) {
            return a2Var.q1().cover;
        }
        if (a2Var.K0() == null) {
            return null;
        }
        ArrayList<MediaData> K0 = a2Var.K0();
        int size = K0.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MediaData mediaData = K0.get(i);
            if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                    str = mediaData.getThumbnails_url();
                    break;
                } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                    str = mediaData.getPicUrl();
                    break;
                }
            }
            i++;
        }
        return (str != null || a2Var.u1() == null || TextUtils.isEmpty(a2Var.u1().thumbnail_url)) ? str : a2Var.u1().thumbnail_url;
    }
}
