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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            int i = message.arg1;
            synchronized (ae.class) {
                context = this.a.f48a;
                if (ae.a(context).m130a(str)) {
                    context2 = this.a.f48a;
                    if (ae.a(context2).a(str) < 10) {
                        if (at.a.ordinal() == i) {
                            context14 = this.a.f48a;
                            if ("syncing".equals(ae.a(context14).a(at.a))) {
                                anVar2 = this.a;
                                atVar2 = at.a;
                                anVar2.a(str, atVar2, true, (HashMap<String, String>) null);
                                context13 = this.a.f48a;
                                ae.a(context13).b(str);
                            }
                        }
                        if (at.b.ordinal() == i) {
                            context12 = this.a.f48a;
                            if ("syncing".equals(ae.a(context12).a(at.b))) {
                                anVar2 = this.a;
                                atVar2 = at.b;
                                anVar2.a(str, atVar2, true, (HashMap<String, String>) null);
                                context13 = this.a.f48a;
                                ae.a(context13).b(str);
                            }
                        }
                        if (at.c.ordinal() == i) {
                            context10 = this.a.f48a;
                            if ("syncing".equals(ae.a(context10).a(at.c))) {
                                anVar = this.a;
                                atVar = at.c;
                                context11 = this.a.f48a;
                                a = i.a(context11, e.a);
                                anVar.a(str, atVar, false, a);
                                context13 = this.a.f48a;
                                ae.a(context13).b(str);
                            }
                        }
                        if (at.d.ordinal() == i) {
                            context8 = this.a.f48a;
                            if ("syncing".equals(ae.a(context8).a(at.d))) {
                                anVar = this.a;
                                atVar = at.d;
                                context9 = this.a.f48a;
                                a = i.a(context9, e.b);
                                anVar.a(str, atVar, false, a);
                                context13 = this.a.f48a;
                                ae.a(context13).b(str);
                            }
                        }
                        if (at.e.ordinal() == i) {
                            context6 = this.a.f48a;
                            if ("syncing".equals(ae.a(context6).a(at.e))) {
                                anVar = this.a;
                                atVar = at.e;
                                context7 = this.a.f48a;
                                a = i.a(context7, e.c);
                                anVar.a(str, atVar, false, a);
                                context13 = this.a.f48a;
                                ae.a(context13).b(str);
                            }
                        }
                        if (at.f.ordinal() == i) {
                            context4 = this.a.f48a;
                            if ("syncing".equals(ae.a(context4).a(at.f))) {
                                anVar = this.a;
                                atVar = at.f;
                                context5 = this.a.f48a;
                                a = i.a(context5, e.d);
                                anVar.a(str, atVar, false, a);
                            }
                        }
                        context13 = this.a.f48a;
                        ae.a(context13).b(str);
                    } else {
                        context3 = this.a.f48a;
                        ae.a(context3).c(str);
                    }
                }
            }
        }
    }
}
