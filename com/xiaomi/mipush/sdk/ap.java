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
/* loaded from: classes8.dex */
public class ap extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ao a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(ao aoVar, Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aoVar, looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aoVar;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        ao aoVar;
        au auVar;
        Context context5;
        HashMap<String, String> m164a;
        Context context6;
        Context context7;
        Context context8;
        Context context9;
        Context context10;
        Context context11;
        Context context12;
        ao aoVar2;
        au auVar2;
        Context context13;
        Context context14;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 19) {
            String str = (String) message.obj;
            int i = message.arg1;
            synchronized (af.class) {
                context = this.a.f80a;
                if (af.a(context).m125a(str)) {
                    context2 = this.a.f80a;
                    if (af.a(context2).a(str) < 10) {
                        if (au.a.ordinal() == i) {
                            context14 = this.a.f80a;
                            if ("syncing".equals(af.a(context14).a(au.a))) {
                                aoVar2 = this.a;
                                auVar2 = au.a;
                                aoVar2.a(str, auVar2, true, (HashMap<String, String>) null);
                                context13 = this.a.f80a;
                                af.a(context13).b(str);
                            }
                        }
                        if (au.b.ordinal() == i) {
                            context12 = this.a.f80a;
                            if ("syncing".equals(af.a(context12).a(au.b))) {
                                aoVar2 = this.a;
                                auVar2 = au.b;
                                aoVar2.a(str, auVar2, true, (HashMap<String, String>) null);
                                context13 = this.a.f80a;
                                af.a(context13).b(str);
                            }
                        }
                        if (au.c.ordinal() == i) {
                            context10 = this.a.f80a;
                            if ("syncing".equals(af.a(context10).a(au.c))) {
                                aoVar = this.a;
                                auVar = au.c;
                                context11 = this.a.f80a;
                                m164a = i.m164a(context11, e.a);
                                aoVar.a(str, auVar, false, m164a);
                                context13 = this.a.f80a;
                                af.a(context13).b(str);
                            }
                        }
                        if (au.d.ordinal() == i) {
                            context8 = this.a.f80a;
                            if ("syncing".equals(af.a(context8).a(au.d))) {
                                aoVar = this.a;
                                auVar = au.d;
                                context9 = this.a.f80a;
                                m164a = i.m164a(context9, e.b);
                                aoVar.a(str, auVar, false, m164a);
                                context13 = this.a.f80a;
                                af.a(context13).b(str);
                            }
                        }
                        if (au.e.ordinal() == i) {
                            context6 = this.a.f80a;
                            if ("syncing".equals(af.a(context6).a(au.e))) {
                                aoVar = this.a;
                                auVar = au.e;
                                context7 = this.a.f80a;
                                m164a = i.m164a(context7, e.c);
                                aoVar.a(str, auVar, false, m164a);
                                context13 = this.a.f80a;
                                af.a(context13).b(str);
                            }
                        }
                        if (au.f.ordinal() == i) {
                            context4 = this.a.f80a;
                            if ("syncing".equals(af.a(context4).a(au.f))) {
                                aoVar = this.a;
                                auVar = au.f;
                                context5 = this.a.f80a;
                                m164a = i.m164a(context5, e.d);
                                aoVar.a(str, auVar, false, m164a);
                            }
                        }
                        context13 = this.a.f80a;
                        af.a(context13).b(str);
                    } else {
                        context3 = this.a.f80a;
                        af.a(context3).c(str);
                    }
                }
            }
        }
    }
}
