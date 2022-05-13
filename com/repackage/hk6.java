package com.repackage;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m36;
/* loaded from: classes6.dex */
public class hk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public BdUniqueId b;
    public boolean c;
    public n36 d;
    public boolean e;
    public VelocityTracker f;
    public m36.b g;

    /* loaded from: classes6.dex */
    public class a implements m36.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk6 a;

        public a(hk6 hk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk6Var;
        }

        @Override // com.repackage.m36.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && e(i2)) {
                this.a.e(true);
            }
        }

        @Override // com.repackage.m36.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && e(i2)) {
                this.a.e(false);
            }
        }

        @Override // com.repackage.m36.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.repackage.m36.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }

        public final boolean e(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f)) == null) ? Math.abs(f) >= 10.0f : invokeF.booleanValue;
        }
    }

    public hk6(Context context, BdUniqueId bdUniqueId, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.g = new a(this);
        this.a = context;
        this.b = bdUniqueId;
        this.e = z;
        if (z) {
            n36 n36Var = new n36(context);
            this.d = n36Var;
            n36Var.d(this.g);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (r5 != 3) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(View view2, MotionEvent motionEvent) {
        n36 n36Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, motionEvent) == null) {
            if (this.f == null) {
                this.f = VelocityTracker.obtain();
            }
            this.f.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2) {
                    this.f.computeCurrentVelocity(1000);
                    if (Math.abs(this.f.getXVelocity()) > Math.abs(this.f.getYVelocity())) {
                        this.e = false;
                    } else {
                        this.e = true;
                    }
                }
                if (this.e || (n36Var = this.d) == null) {
                }
                n36Var.c(motionEvent);
                return;
            }
            c();
            if (this.e) {
            }
        }
    }

    public final void c() {
        VelocityTracker velocityTracker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.f) == null) {
            return;
        }
        velocityTracker.clear();
        this.f.recycle();
        this.f = null;
    }

    public final void d(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                CustomMessage customMessage = new CustomMessage(2001617);
                customMessage.setTag(this.b);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001617, Boolean.valueOf(z2));
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            CustomMessage customMessage2 = new CustomMessage(2001618);
            customMessage2.setTag(this.b);
            CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001618, Boolean.valueOf(z2));
            customResponsedMessage2.setOrginalMessage(customMessage2);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
        }
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.c = z;
            if (this.e) {
                d(!z, true);
            }
        }
    }
}
