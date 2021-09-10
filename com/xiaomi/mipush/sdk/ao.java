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
/* loaded from: classes10.dex */
public class ao extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ an f77284a;

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
        this.f77284a = anVar;
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
        HashMap<String, String> a2;
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
                context = this.f77284a.f71a;
                if (ae.a(context).m94a(str)) {
                    context2 = this.f77284a.f71a;
                    if (ae.a(context2).a(str) < 10) {
                        if (at.f77289a.ordinal() == i2) {
                            context14 = this.f77284a.f71a;
                            if ("syncing".equals(ae.a(context14).a(at.f77289a))) {
                                anVar2 = this.f77284a;
                                atVar2 = at.f77289a;
                                anVar2.a(str, atVar2, true, (HashMap<String, String>) null);
                                context13 = this.f77284a.f71a;
                                ae.a(context13).b(str);
                            }
                        }
                        if (at.f77290b.ordinal() == i2) {
                            context12 = this.f77284a.f71a;
                            if ("syncing".equals(ae.a(context12).a(at.f77290b))) {
                                anVar2 = this.f77284a;
                                atVar2 = at.f77290b;
                                anVar2.a(str, atVar2, true, (HashMap<String, String>) null);
                                context13 = this.f77284a.f71a;
                                ae.a(context13).b(str);
                            }
                        }
                        if (at.f77291c.ordinal() == i2) {
                            context10 = this.f77284a.f71a;
                            if ("syncing".equals(ae.a(context10).a(at.f77291c))) {
                                anVar = this.f77284a;
                                atVar = at.f77291c;
                                context11 = this.f77284a.f71a;
                                a2 = i.a(context11, e.f77305a);
                                anVar.a(str, atVar, false, a2);
                                context13 = this.f77284a.f71a;
                                ae.a(context13).b(str);
                            }
                        }
                        if (at.f77292d.ordinal() == i2) {
                            context8 = this.f77284a.f71a;
                            if ("syncing".equals(ae.a(context8).a(at.f77292d))) {
                                anVar = this.f77284a;
                                atVar = at.f77292d;
                                context9 = this.f77284a.f71a;
                                a2 = i.a(context9, e.f77306b);
                                anVar.a(str, atVar, false, a2);
                                context13 = this.f77284a.f71a;
                                ae.a(context13).b(str);
                            }
                        }
                        if (at.f77293e.ordinal() == i2) {
                            context6 = this.f77284a.f71a;
                            if ("syncing".equals(ae.a(context6).a(at.f77293e))) {
                                anVar = this.f77284a;
                                atVar = at.f77293e;
                                context7 = this.f77284a.f71a;
                                a2 = i.a(context7, e.f77307c);
                                anVar.a(str, atVar, false, a2);
                                context13 = this.f77284a.f71a;
                                ae.a(context13).b(str);
                            }
                        }
                        if (at.f77294f.ordinal() == i2) {
                            context4 = this.f77284a.f71a;
                            if ("syncing".equals(ae.a(context4).a(at.f77294f))) {
                                anVar = this.f77284a;
                                atVar = at.f77294f;
                                context5 = this.f77284a.f71a;
                                a2 = i.a(context5, e.f77308d);
                                anVar.a(str, atVar, false, a2);
                            }
                        }
                        context13 = this.f77284a.f71a;
                        ae.a(context13).b(str);
                    } else {
                        context3 = this.f77284a.f71a;
                        ae.a(context3).c(str);
                    }
                }
            }
        }
    }
}
