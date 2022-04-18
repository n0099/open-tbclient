package com.repackage;

import android.content.Context;
import android.location.Location;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes7.dex */
public class ze8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public ze8(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public final String a(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, shareItem)) == null) {
            String str = "【" + shareItem.r + "】 " + shareItem.s;
            shareItem.s = str;
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final Location b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? oz5.b() : (Location) invokeV.objValue;
    }

    public void c(int i, ShareItem shareItem, boolean z) {
        Location b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), shareItem, Boolean.valueOf(z)}) == null) || shareItem == null) {
            return;
        }
        if (!mi.z()) {
            oi.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1124);
            return;
        }
        if (z && (b = b()) != null) {
            shareItem.B = b;
        }
        ry4 ry4Var = new ry4(this.a, null);
        if (i == 3) {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
            if (createWXAPI != null && !createWXAPI.isWXAppInstalled()) {
                BdToast.c(this.a, TbadkCoreApplication.getInst().getText(R.string.obfuscated_res_0x7f0f1155)).q();
                return;
            }
            e(shareItem, 4);
            ry4Var.t(shareItem);
        } else if (i == 2) {
            IWXAPI createWXAPI2 = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
            if (createWXAPI2 != null && !createWXAPI2.isWXAppInstalled()) {
                BdToast.c(this.a, TbadkCoreApplication.getInst().getText(R.string.obfuscated_res_0x7f0f1155)).q();
                return;
            }
            e(shareItem, 3);
            if (shareItem.b) {
                shareItem.s = a(shareItem);
            }
            ry4Var.u(shareItem);
        } else if (i == 4) {
            if (gk8.b(this.a, "com.tencent.mobileqq")) {
                e(shareItem, 5);
                ry4Var.p(shareItem);
                return;
            }
            Context context = this.a;
            BdToast.c(context, context.getText(R.string.obfuscated_res_0x7f0f112f)).q();
        } else if (i == 5) {
            if (!shareItem.a) {
                shareItem.s = a(shareItem);
            }
            ry4Var.s(shareItem);
        } else if (i == 6) {
            e(shareItem, 7);
            if (!shareItem.a) {
                shareItem.s = a(shareItem);
            }
            ry4Var.r(shareItem);
        } else if (i == 7) {
            if (!shareItem.a) {
                shareItem.s = a(shareItem);
            }
            ry4Var.q(shareItem);
        } else if (i == 8) {
            if (gk8.b(this.a, "com.tencent.mobileqq")) {
                e(shareItem, 9);
                ry4Var.o(shareItem);
                return;
            }
            Context context2 = this.a;
            BdToast.c(context2, context2.getText(R.string.obfuscated_res_0x7f0f112f)).q();
        }
    }

    public final void d(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            TiebaStatic.eventStat(this.a, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
        }
    }

    public final void e(ShareItem shareItem, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, shareItem, i) == null) || shareItem == null || shareItem.q == null) {
            return;
        }
        if (shareItem.b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.q).param("obj_type", i));
        } else if (!shareItem.c && !shareItem.f) {
            if (shareItem.d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.q).param("obj_type", i));
            } else if (shareItem.a) {
                d(i, shareItem.C);
            } else if (shareItem.e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i).param("fid", shareItem.q));
            } else if (shareItem.g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i);
                param.param("obj_source", shareItem.E);
                if (!ni.isEmpty(shareItem.t) && shareItem.t.contains("worldcup")) {
                    param.param("obj_param1", 9);
                }
                TiebaStatic.log(param);
            } else if (shareItem.h) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("fid", shareItem.J).param("obj_type", i).param("obj_source", shareItem.E).param("obj_param1", shareItem.F).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G).param(TiebaStatic.Params.OBJ_PARAM3, shareItem.H).param("obj_locate", shareItem.I));
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("obj_type", i).param("obj_source", shareItem.E).param("obj_param1", shareItem.F).param("fid", shareItem.J).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
        }
    }
}
