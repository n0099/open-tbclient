package com.vivo.push.c;

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
public final class af extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(com.vivo.push.o oVar) {
        super(oVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            if (com.vivo.push.e.a().g() && !a(com.vivo.push.util.aa.d(this.a), uVar.e(), uVar.i())) {
                com.vivo.push.util.p.d("OnUndoMsgTask", " vertify msg is error ");
                com.vivo.push.b.x xVar = new com.vivo.push.b.x(1021L);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("messageID", String.valueOf(uVar.f()));
                Context context = this.a;
                String b2 = com.vivo.push.util.aa.b(context, context.getPackageName());
                if (!TextUtils.isEmpty(b2)) {
                    hashMap.put("remoteAppId", b2);
                }
                xVar.a(hashMap);
                com.vivo.push.e.a().a(xVar);
                return;
            }
            boolean repealNotifyById = NotifyAdapterUtil.repealNotifyById(this.a, uVar.d());
            com.vivo.push.util.p.d("OnUndoMsgTask", "undo message " + uVar.d() + StringUtil.ARRAY_ELEMENT_SEPARATOR + repealNotifyById);
            if (repealNotifyById) {
                Context context2 = this.a;
                com.vivo.push.util.p.b(context2, "回收client通知成功, 上报埋点 1031, messageId = " + uVar.d());
                com.vivo.push.util.e.a(this.a, uVar.d(), 1031L);
                return;
            }
            com.vivo.push.util.p.d("OnUndoMsgTask", "undo message fail，messageId = " + uVar.d());
            Context context3 = this.a;
            com.vivo.push.util.p.c(context3, "回收client通知失败，messageId = " + uVar.d());
        }
    }
}
