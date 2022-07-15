package com.repackage;

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
import com.baidu.tbadk.core.data.ThreadData;
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
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class tw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public b b;

    /* loaded from: classes7.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tw7 a;

        public a(tw7 tw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tw7Var;
        }

        @Override // com.repackage.tw7.b
        public void a(jr7 jr7Var, ThreadData threadData, PostData postData, ng5 ng5Var) {
            String e;
            String tid;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, jr7Var, threadData, postData, ng5Var) == null) {
                if ((jr7Var == null && threadData == null) || postData == null || this.a.a == null) {
                    return;
                }
                if (jr7Var == null) {
                    e = this.a.e(threadData);
                } else {
                    String str2 = jr7Var.N(false)[0];
                    if (!StringUtils.isNull(str2) && str2.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str2 = str2.substring(37);
                    }
                    ThreadData O = jr7Var.O();
                    if (O == null) {
                        return;
                    }
                    String str3 = str2;
                    threadData = O;
                    e = str3;
                }
                ur7 ur7Var = new ur7();
                ur7Var.h(threadData.getAbstract());
                if (!StringUtils.isNull(e)) {
                    ur7Var.k(e);
                }
                ur7Var.l(threadData.getThreadType());
                ur7Var.g(ng5Var);
                ur7Var.i(postData);
                String title = threadData.getTitle();
                if (StringUtils.isNull(title)) {
                    title = threadData.getAbstract();
                }
                ur7Var.h(title);
                if (threadData.isUgcThreadType()) {
                    tid = threadData.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&dtype=" + threadData.getBaijiahaoData().oriUgcType + "&dvid=" + threadData.getBaijiahaoData().oriUgcVid + "&nid=" + threadData.getBaijiahaoData().oriUgcNid;
                } else {
                    tid = threadData.getTid();
                    str = "?share=9105&fr=share";
                }
                ur7Var.j(this.a.d("https://tieba.baidu.com/p/" + tid + (str + "&post_id=" + postData.J() + "&share_from=comment&post_sort=1")));
                ShareItem shareItem = new ShareItem();
                shareItem.g0 = 1;
                shareItem.k = true;
                shareItem.t = tid;
                shareItem.b0 = postData.J();
                Bundle bundle = new Bundle();
                bundle.putString("tid", tid);
                bundle.putString("pid", postData.J());
                bundle.putInt("source", 1);
                shareItem.k(bundle);
                PbPostShareDialogConfig pbPostShareDialogConfig = new PbPostShareDialogConfig(this.a.a.getPageActivity(), shareItem, true, ur7Var);
                pbPostShareDialogConfig.setIsCopyLink(false);
                pbPostShareDialogConfig.setHideMode(pbPostShareDialogConfig.hideMode | 32);
                this.a.a.sendMessage(new CustomMessage(2001276, pbPostShareDialogConfig));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                statisticItem.param("tid", tid);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (threadData.getForumData() != null) {
                    statisticItem.param("fid", threadData.getForumData().a);
                }
                if (threadData.getTopAgreePost() != null) {
                    statisticItem.param("post_id", postData.J());
                }
                statisticItem.param("obj_locate", 21);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(jr7 jr7Var, ThreadData threadData, PostData postData, ng5 ng5Var);
    }

    public tw7(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new a(this);
        this.a = tbPageContext;
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

    public final String e(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData)) == null) {
            String str = null;
            if (threadData == null) {
                return null;
            }
            if (threadData.getThreadAlaInfo() != null && !TextUtils.isEmpty(threadData.getThreadAlaInfo().cover)) {
                return threadData.getThreadAlaInfo().cover;
            }
            if (threadData.getMedias() == null) {
                return null;
            }
            ArrayList<MediaData> medias = threadData.getMedias();
            int size = medias.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                MediaData mediaData = medias.get(i);
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
            return (str != null || threadData.getThreadVideoInfo() == null || TextUtils.isEmpty(threadData.getThreadVideoInfo().thumbnail_url)) ? str : threadData.getThreadVideoInfo().thumbnail_url;
        }
        return (String) invokeL.objValue;
    }
}
