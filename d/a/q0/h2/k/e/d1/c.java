package d.a.q0.h2.k.e.d1;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
import d.a.q0.h2.h.e;
import d.a.q0.h2.h.m;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57780a;

    /* renamed from: b  reason: collision with root package name */
    public b f57781b;

    /* loaded from: classes8.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f57782a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57782a = cVar;
        }

        @Override // d.a.q0.h2.k.e.d1.c.b
        public void a(e eVar, b2 b2Var, PostData postData, d.a.p0.d1.m.a aVar) {
            String e2;
            String o1;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, b2Var, postData, aVar) == null) {
                if ((eVar == null && b2Var == null) || postData == null || this.f57782a.f57780a == null) {
                    return;
                }
                if (eVar == null) {
                    e2 = this.f57782a.e(b2Var);
                } else {
                    String str2 = eVar.M(this.f57782a.f57780a.getPageActivity(), false)[0];
                    if (!StringUtils.isNull(str2) && str2.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str2 = str2.substring(37);
                    }
                    b2 N = eVar.N();
                    if (N == null) {
                        return;
                    }
                    String str3 = str2;
                    b2Var = N;
                    e2 = str3;
                }
                m mVar = new m();
                mVar.h(b2Var.h());
                if (!StringUtils.isNull(e2)) {
                    mVar.k(e2);
                }
                mVar.l(b2Var.k1());
                mVar.g(aVar);
                mVar.i(postData);
                String title = b2Var.getTitle();
                if (StringUtils.isNull(title)) {
                    title = b2Var.h();
                }
                mVar.h(title);
                if (b2Var.r2()) {
                    o1 = b2Var.J().oriUgcTid;
                    str = "?share=9105&fr=dshare&dtype=" + b2Var.J().oriUgcType + "&dvid=" + b2Var.J().oriUgcVid + "&nid=" + b2Var.J().oriUgcNid;
                } else {
                    o1 = b2Var.o1();
                    str = "?share=9105&fr=share";
                }
                mVar.j(this.f57782a.d("http://tieba.baidu.com/p/" + o1 + (str + "&post_id=" + postData.E() + "&share_from=comment&post_sort=1")));
                ShareItem shareItem = new ShareItem();
                shareItem.W = 1;
                shareItem.k = true;
                shareItem.q = o1;
                shareItem.V = postData.E();
                Bundle bundle = new Bundle();
                bundle.putString("tid", o1);
                bundle.putString("pid", postData.E());
                bundle.putInt("source", 1);
                shareItem.k(bundle);
                PbPostShareDialogConfig pbPostShareDialogConfig = new PbPostShareDialogConfig(this.f57782a.f57780a.getPageActivity(), shareItem, true, mVar);
                pbPostShareDialogConfig.setIsCopyLink(false);
                pbPostShareDialogConfig.setHideMode(pbPostShareDialogConfig.hideMode | 32);
                this.f57782a.f57780a.sendMessage(new CustomMessage(2001276, pbPostShareDialogConfig));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                statisticItem.param("tid", o1);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (b2Var.W() != null) {
                    statisticItem.param("fid", b2Var.W().f53478a);
                }
                if (b2Var.q1() != null) {
                    statisticItem.param("post_id", postData.E());
                }
                statisticItem.param("obj_locate", 21);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(e eVar, b2 b2Var, PostData postData, d.a.p0.d1.m.a aVar);
    }

    public c(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57781b = new a(this);
        this.f57780a = tbPageContext;
    }

    public final Bitmap d(String str) {
        InterceptResult invokeL;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
                return null;
            }
            return (Bitmap) runTask.getData();
        }
        return (Bitmap) invokeL.objValue;
    }

    public final String e(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var)) == null) {
            String str = null;
            if (b2Var == null) {
                return null;
            }
            if (b2Var.h1() != null && !TextUtils.isEmpty(b2Var.h1().cover)) {
                return b2Var.h1().cover;
            }
            if (b2Var.A0() == null) {
                return null;
            }
            ArrayList<MediaData> A0 = b2Var.A0();
            int size = A0.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MediaData mediaData = A0.get(i2);
                if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                    if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                        str = mediaData.getThumbnails_url();
                        break;
                    } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                        str = mediaData.getPicUrl();
                        break;
                    }
                }
                i2++;
            }
            return (str != null || b2Var.m1() == null || TextUtils.isEmpty(b2Var.m1().thumbnail_url)) ? str : b2Var.m1().thumbnail_url;
        }
        return (String) invokeL.objValue;
    }
}
