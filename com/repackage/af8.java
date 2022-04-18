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
/* loaded from: classes5.dex */
public class af8 implements oy4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public af8(Context context, ny4 ny4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, ny4Var};
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

    @Override // com.repackage.oy4
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
        shareEntity.setTitle(shareItem.r);
        shareEntity.setContent(shareItem.s);
        shareEntity.setReadCount(shareItem.R);
        int i2 = shareItem.M;
        shareEntity.setIsVideoThread(i2 == 2 || i2 == 6 || i2 == 8);
        shareEntity.setImageUri(shareItem.v);
        shareEntity.canShareBySmartApp = shareItem.m0;
        String str = shareItem.t;
        if (i == 6 && !StringUtils.isNull(shareItem.u)) {
            str = shareItem.u;
        }
        shareEntity.setLinkUrl(str);
        shareEntity.setLocalFile(shareItem.x);
        shareEntity.setLocation(shareItem.B);
        shareEntity.setShareTo(i);
        shareEntity.setStats(shareItem.e());
        shareEntity.setPreferImageToLink(shareItem.b0);
        shareEntity.setTid(shareItem.K);
        shareEntity.setfName(shareItem.p);
        shareEntity.setTypeShareToSmallApp(shareItem.y);
        shareEntity.topic = shareItem.O;
        if (i == 6 && !StringUtils.isNull(shareItem.Q)) {
            shareEntity.topic = shareItem.P + shareItem.Q;
            shareEntity.setContent("");
        }
        shareEntity.taskCompleteId = shareItem.S;
        shareEntity.diskPicOperate = shareItem.A;
        shareEntity.setExtLiveInfo(shareItem.r0);
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_share_data", shareEntity);
        bundle.putInt("extra_skin", TbadkCoreApplication.getInst().getSkinType());
        intentConfig.getIntent().putExtras(bundle);
        shareItem.j(true);
        intentConfig.startActivityForResult(24007, ShareHandlerActivity.class);
    }
}
