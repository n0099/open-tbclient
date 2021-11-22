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
/* loaded from: classes2.dex */
public class ao extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ an f71520a;

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
        this.f71520a = anVar;
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
                context = this.f71520a.f72a;
                if (ae.a(context).m94a(str)) {
                    context2 = this.f71520a.f72a;
                    if (ae.a(context2).a(str) < 10) {
                        if (at.f71525a.ordinal() == i2) {
                            context14 = this.f71520a.f72a;
                            if ("syncing".equals(ae.a(context14).a(at.f71525a))) {
                                anVar2 = this.f71520a;
                                atVar2 = at.f71525a;
                                anVar2.a(str, atVar2, true, (HashMap<String, String>) null);
                                context13 = this.f71520a.f72a;
                                ae.a(context13).b(str);
                            }
                        }
                        if (at.f71526b.ordinal() == i2) {
                            context12 = this.f71520a.f72a;
                            if ("syncing".equals(ae.a(context12).a(at.f71526b))) {
                                anVar2 = this.f71520a;
                                atVar2 = at.f71526b;
                                anVar2.a(str, atVar2, true, (HashMap<String, String>) null);
                                context13 = this.f71520a.f72a;
                                ae.a(context13).b(str);
                            }
                        }
                        if (at.f71527c.ordinal() == i2) {
                            context10 = this.f71520a.f72a;
                            if ("syncing".equals(ae.a(context10).a(at.f71527c))) {
                                anVar = this.f71520a;
                                atVar = at.f71527c;
                                context11 = this.f71520a.f72a;
                                a2 = i.a(context11, e.f71541a);
                                anVar.a(str, atVar, false, a2);
                                context13 = this.f71520a.f72a;
                                ae.a(context13).b(str);
                            }
                        }
                        if (at.f71528d.ordinal() == i2) {
                            context8 = this.f71520a.f72a;
                            if ("syncing".equals(ae.a(context8).a(at.f71528d))) {
                                anVar = this.f71520a;
                                atVar = at.f71528d;
                                context9 = this.f71520a.f72a;
                                a2 = i.a(context9, e.f71542b);
                                anVar.a(str, atVar, false, a2);
                                context13 = this.f71520a.f72a;
                                ae.a(context13).b(str);
                            }
                        }
                        if (at.f71529e.ordinal() == i2) {
                            context6 = this.f71520a.f72a;
                            if ("syncing".equals(ae.a(context6).a(at.f71529e))) {
                                anVar = this.f71520a;
                                atVar = at.f71529e;
                                context7 = this.f71520a.f72a;
                                a2 = i.a(context7, e.f71543c);
                                anVar.a(str, atVar, false, a2);
                                context13 = this.f71520a.f72a;
                                ae.a(context13).b(str);
                            }
                        }
                        if (at.f71530f.ordinal() == i2) {
                            context4 = this.f71520a.f72a;
                            if ("syncing".equals(ae.a(context4).a(at.f71530f))) {
                                anVar = this.f71520a;
                                atVar = at.f71530f;
                                context5 = this.f71520a.f72a;
                                a2 = i.a(context5, e.f71544d);
                                anVar.a(str, atVar, false, a2);
                            }
                        }
                        context13 = this.f71520a.f72a;
                        ae.a(context13).b(str);
                    } else {
                        context3 = this.f71520a.f72a;
                        ae.a(context3).c(str);
                    }
                }
            }
        }
    }
}
