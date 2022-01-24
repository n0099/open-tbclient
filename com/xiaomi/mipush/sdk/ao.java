package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class ao extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ an a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(an anVar, Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {anVar, looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = anVar;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        an anVar;
        at atVar;
        Context context5;
        HashMap<String, String> a;
        Context context6;
        Context context7;
        Context context8;
        Context context9;
        Context context10;
        Context context11;
        Context context12;
        an anVar2;
        at atVar2;
        Context context13;
        Context context14;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 19) {
            String str = (String) message.obj;
            int i2 = message.arg1;
            synchronized (ae.class) {
                context = this.a.f72a;
                if (ae.a(context).m155a(str)) {
                    context2 = this.a.f72a;
                    if (ae.a(context2).a(str) < 10) {
                        if (at.a.ordinal() == i2) {
                            context14 = this.a.f72a;
                            if ("syncing".equals(ae.a(context14).a(at.a))) {
                                anVar2 = this.a;
                                atVar2 = at.a;
                                anVar2.a(str, atVar2, true, (HashMap<String, String>) null);
                                context13 = this.a.f72a;
                                ae.a(context13).b(str);
                            }
                        }
                        if (at.f60931b.ordinal() == i2) {
                            context12 = this.a.f72a;
                            if ("syncing".equals(ae.a(context12).a(at.f60931b))) {
                                anVar2 = this.a;
                                atVar2 = at.f60931b;
                                anVar2.a(str, atVar2, true, (HashMap<String, String>) null);
                                context13 = this.a.f72a;
                                ae.a(context13).b(str);
                            }
                        }
                        if (at.f60932c.ordinal() == i2) {
                            context10 = this.a.f72a;
                            if ("syncing".equals(ae.a(context10).a(at.f60932c))) {
                                anVar = this.a;
                                atVar = at.f60932c;
                                context11 = this.a.f72a;
                                a = i.a(context11, e.a);
                                anVar.a(str, atVar, false, a);
                                context13 = this.a.f72a;
                                ae.a(context13).b(str);
                            }
                        }
                        if (at.f60933d.ordinal() == i2) {
                            context8 = this.a.f72a;
                            if ("syncing".equals(ae.a(context8).a(at.f60933d))) {
                                anVar = this.a;
                                atVar = at.f60933d;
                                context9 = this.a.f72a;
                                a = i.a(context9, e.f60943b);
                                anVar.a(str, atVar, false, a);
                                context13 = this.a.f72a;
                                ae.a(context13).b(str);
                            }
                        }
                        if (at.f60934e.ordinal() == i2) {
                            context6 = this.a.f72a;
                            if ("syncing".equals(ae.a(context6).a(at.f60934e))) {
                                anVar = this.a;
                                atVar = at.f60934e;
                                context7 = this.a.f72a;
                                a = i.a(context7, e.f60944c);
                                anVar.a(str, atVar, false, a);
                                context13 = this.a.f72a;
                                ae.a(context13).b(str);
                            }
                        }
                        if (at.f60935f.ordinal() == i2) {
                            context4 = this.a.f72a;
                            if ("syncing".equals(ae.a(context4).a(at.f60935f))) {
                                anVar = this.a;
                                atVar = at.f60935f;
                                context5 = this.a.f72a;
                                a = i.a(context5, e.f60945d);
                                anVar.a(str, atVar, false, a);
                            }
                        }
                        context13 = this.a.f72a;
                        ae.a(context13).b(str);
                    } else {
                        context3 = this.a.f72a;
                        ae.a(context3).c(str);
                    }
                }
            }
        }
    }
}
