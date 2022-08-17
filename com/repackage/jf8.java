package com.repackage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jf8 extends gf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jf8(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.mf8
    public void a(ShareEntity shareEntity, nf8 nf8Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, shareEntity, nf8Var) == null) {
            if (shareEntity != null && !TextUtils.isEmpty(shareEntity.getContent())) {
                if (TextUtils.isEmpty(shareEntity.getContent())) {
                    str = shareEntity.getTitle() + shareEntity.getLinkUrl();
                } else {
                    str = shareEntity.getContent() + shareEntity.getLinkUrl();
                }
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", str);
                intent.setType("text/plain");
                Context context = this.b;
                if (of8.startActivity(context, Intent.createChooser(intent, context.getString(R.string.obfuscated_res_0x7f0f115f)))) {
                    if (nf8Var != null) {
                        nf8Var.d1(0, 1);
                        return;
                    }
                    return;
                } else if (nf8Var != null) {
                    nf8Var.d1(0, 2);
                    return;
                } else {
                    return;
                }
            }
            qi.M(d(), R.string.obfuscated_res_0x7f0f1131);
            if (nf8Var != null) {
                nf8Var.d1(0, 2);
            }
        }
    }
}
