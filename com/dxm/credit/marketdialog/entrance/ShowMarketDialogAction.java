package com.dxm.credit.marketdialog.entrance;

import android.app.Activity;
import android.content.Context;
import c.e.b.a.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class ShowMarketDialogAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<a> f69260a;

    public ShowMarketDialogAction() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void a(Context context, HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, context, hashMap) == null) {
            a aVar = new a((Activity) context);
            aVar.e((hashMap == null || hashMap.size() <= 0) ? "0" : (String) hashMap.get("queryType"));
            this.f69260a = new WeakReference<>(aVar);
        }
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, hashMap, routerCallback) == null) {
            if (!(context instanceof Activity)) {
                if (routerCallback != null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("errorMsg", "context must be activity");
                    routerCallback.onResult(3, hashMap2);
                    return;
                }
                return;
            }
            WeakReference<a> weakReference = this.f69260a;
            if (weakReference != null && weakReference.get() != null && (aVar = this.f69260a.get()) != null && aVar.d() != null && aVar.d().a() != null && aVar.d().a().size() > 0) {
                boolean z = false;
                int i2 = 0;
                while (true) {
                    if (i2 < aVar.d().a().size()) {
                        if (aVar.d().a().get(i2) != null && aVar.d().a().get(i2).isShowing()) {
                            z = true;
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
                if (z) {
                    return;
                }
            }
            a(context, hashMap);
        }
    }
}
