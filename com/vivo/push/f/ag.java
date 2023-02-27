package com.vivo.push.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class ag extends aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(com.vivo.push.o oVar) {
        super(oVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((com.vivo.push.o) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) {
            com.vivo.push.b.u uVar = (com.vivo.push.b.u) oVar;
            if (com.vivo.push.e.a().g() && !a(com.vivo.push.util.ag.c(this.a), uVar.e(), uVar.g())) {
                com.vivo.push.util.u.d("OnUndoMsgTask", " vertify msg is error ");
                com.vivo.push.b.x xVar = new com.vivo.push.b.x(1021L);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("messageID", String.valueOf(uVar.f()));
                String a = com.vivo.push.d.a.a().e().a();
                if (!TextUtils.isEmpty(a)) {
                    hashMap.put("remoteAppId", a);
                }
                xVar.a(hashMap);
                com.vivo.push.e.a().a(xVar);
                return;
            }
            boolean repealNotifyById = NotifyAdapterUtil.repealNotifyById(this.a, uVar.d());
            com.vivo.push.util.u.d("OnUndoMsgTask", "undo message " + uVar.d() + StringUtil.ARRAY_ELEMENT_SEPARATOR + repealNotifyById);
            if (repealNotifyById) {
                Context context = this.a;
                com.vivo.push.util.u.b(context, "回收client通知成功, 上报埋点 1031, messageId = " + uVar.d());
                com.vivo.push.util.f.a(uVar.d(), 1031L);
                return;
            }
            com.vivo.push.util.u.d("OnUndoMsgTask", "undo message fail，messageId = " + uVar.d());
            Context context2 = this.a;
            com.vivo.push.util.u.c(context2, "回收client通知失败，messageId = " + uVar.d());
        }
    }
}
