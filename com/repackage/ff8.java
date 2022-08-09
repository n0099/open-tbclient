package com.repackage;

import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.sharesdk.ShareHandlerActivity;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ff8 implements c05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public ff8(Context context, b05 b05Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, b05Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.a = context;
    }

    @Override // com.repackage.c05
    public void a(ShareItem shareItem, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{shareItem, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            b(shareItem, i);
        }
    }

    public final void b(ShareItem shareItem, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareItem, i) == null) || this.a == null || shareItem == null) {
            return;
        }
        IntentConfig intentConfig = new IntentConfig(this.a);
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.setTitle(shareItem.u);
        shareEntity.setContent(shareItem.v);
        shareEntity.setReadCount(shareItem.U);
        int i2 = shareItem.P;
        shareEntity.setIsVideoThread(i2 == 2 || i2 == 6 || i2 == 8);
        shareEntity.setImageUri(shareItem.y);
        shareEntity.canShareBySmartApp = shareItem.r0;
        String str = shareItem.w;
        if (i == 6 && !StringUtils.isNull(shareItem.x)) {
            str = shareItem.x;
        }
        shareEntity.setLinkUrl(str);
        shareEntity.setLocalFile(shareItem.A);
        shareEntity.setLocation(shareItem.E);
        shareEntity.setShareTo(i);
        shareEntity.setStats(shareItem.e());
        shareEntity.setPreferImageToLink(shareItem.g0);
        shareEntity.setTid(shareItem.N);
        shareEntity.setfName(shareItem.s);
        shareEntity.setTypeShareToSmallApp(shareItem.B);
        shareEntity.topic = shareItem.R;
        if (i == 6 && !StringUtils.isNull(shareItem.T)) {
            shareEntity.topic = shareItem.S + shareItem.T;
            shareEntity.setContent("");
        }
        shareEntity.taskCompleteId = shareItem.V;
        shareEntity.diskPicOperate = shareItem.D;
        shareEntity.setExtLiveInfo(shareItem.w0);
        shareEntity.setFromDuXiaoMan(shareItem.m);
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_share_data", shareEntity);
        bundle.putInt("extra_skin", TbadkCoreApplication.getInst().getSkinType());
        intentConfig.getIntent().putExtras(bundle);
        shareItem.j(true);
        intentConfig.startActivityForResult(24007, ShareHandlerActivity.class);
    }
}
