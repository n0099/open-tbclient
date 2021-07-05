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
/* loaded from: classes7.dex */
public final class ah extends ab {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(com.vivo.push.y yVar) {
        super(yVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((com.vivo.push.y) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.vivo.push.v
    public final void a(com.vivo.push.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yVar) == null) {
            com.vivo.push.b.w wVar = (com.vivo.push.b.w) yVar;
            if (com.vivo.push.p.a().g() && !a(com.vivo.push.util.z.d(this.f42277a), wVar.e(), wVar.i())) {
                com.vivo.push.util.p.d("OnUndoMsgTask", " vertify msg is error ");
                com.vivo.push.b.aa aaVar = new com.vivo.push.b.aa(1021L);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("messageID", String.valueOf(wVar.f()));
                Context context = this.f42277a;
                String b2 = com.vivo.push.util.z.b(context, context.getPackageName());
                if (!TextUtils.isEmpty(b2)) {
                    hashMap.put("remoteAppId", b2);
                }
                aaVar.a(hashMap);
                com.vivo.push.p.a().a(aaVar);
                return;
            }
            boolean repealNotifyById = NotifyAdapterUtil.repealNotifyById(this.f42277a, (int) wVar.d());
            com.vivo.push.util.p.d("OnUndoMsgTask", "undo message " + wVar.d() + StringUtil.ARRAY_ELEMENT_SEPARATOR + repealNotifyById);
            if (repealNotifyById) {
                Context context2 = this.f42277a;
                com.vivo.push.util.p.b(context2, "回收client通知成功, 上报埋点 1031, messageId = " + wVar.d());
                com.vivo.push.util.d.a(this.f42277a, wVar.d(), 1031L);
                return;
            }
            com.vivo.push.util.p.d("OnUndoMsgTask", "undo message fail，messageId = " + wVar.d());
            Context context3 = this.f42277a;
            com.vivo.push.util.p.c(context3, "回收client通知失败，messageId = " + wVar.d());
        }
    }
}
