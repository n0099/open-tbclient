package com.repackage;

import android.os.SystemClock;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kf3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public long[] b;
        public final /* synthetic */ Runnable c;

        public a(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = runnable;
            this.a = 5;
            this.b = new long[5];
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                long[] jArr = this.b;
                System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
                long[] jArr2 = this.b;
                jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
                if (this.b[0] >= SystemClock.uptimeMillis() - 1000) {
                    this.b = new long[this.a];
                    this.c.run();
                }
            }
        }
    }

    public static void a(View view2, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, view2, runnable) == null) {
            view2.setOnClickListener(new a(runnable));
        }
    }
}
