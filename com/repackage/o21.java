package com.repackage;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.container.base.AbsContainer;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public interface o21 {
    public static final ServiceReference a = new ServiceReference("nad.core", "navBarTool");
    public static final o21 b = new a();

    /* loaded from: classes6.dex */
    public static class a implements o21 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.repackage.o21$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC0696a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AbsContainer a;

            public View$OnClickListenerC0696a(a aVar, AbsContainer absContainer) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, absContainer};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = absContainer;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AbsContainer absContainer;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (absContainer = this.a) == null) {
                    return;
                }
                absContainer.x();
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.o21
        public int[] a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new int[]{R.drawable.obfuscated_res_0x7f080db9} : (int[]) invokeV.objValue;
        }

        @Override // com.repackage.o21
        public void b(View view2, AbsContainer absContainer) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, absContainer) == null) && ((Integer) view2.getTag()).intValue() == R.drawable.obfuscated_res_0x7f080db9) {
                view2.setOnClickListener(new View$OnClickListenerC0696a(this, absContainer));
            }
        }

        @Override // com.repackage.o21
        public int[] c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new int[]{R.drawable.obfuscated_res_0x7f080dbb} : (int[]) invokeV.objValue;
        }
    }

    int[] a();

    void b(View view2, AbsContainer absContainer);

    int[] c();
}
