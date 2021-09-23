package com.bytedance.sdk.openadsdk.q;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view, long j2, View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{view, Long.valueOf(j2), onLongClickListener}) == null) || view == null || onLongClickListener == null) {
            return;
        }
        view.setOnTouchListener(new View.OnTouchListener(view, j2, onLongClickListener) { // from class: com.bytedance.sdk.openadsdk.q.r.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View f69190a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f69191b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ View.OnLongClickListener f69192c;

            /* renamed from: d  reason: collision with root package name */
            public int f69193d;

            /* renamed from: e  reason: collision with root package name */
            public int f69194e;

            /* renamed from: f  reason: collision with root package name */
            public Runnable f69195f;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view, Long.valueOf(j2), onLongClickListener};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f69190a = view;
                this.f69191b = j2;
                this.f69192c = onLongClickListener;
                this.f69195f = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.q.r.1.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass1 f69196a;

                    {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 != null) {
                            InitContext newInitContext2 = TitanRuntime.newInitContext();
                            newInitContext2.initArgs = r2;
                            Object[] objArr2 = {this};
                            interceptable3.invokeUnInit(65536, newInitContext2);
                            int i4 = newInitContext2.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext2.thisArg = this;
                                interceptable3.invokeInitBody(65536, newInitContext2);
                                return;
                            }
                        }
                        this.f69196a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1;
                        View.OnLongClickListener onLongClickListener2;
                        Interceptable interceptable3 = $ic;
                        if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (onLongClickListener2 = (anonymousClass1 = this.f69196a).f69192c) == null) {
                            return;
                        }
                        onLongClickListener2.onLongClick(anonymousClass1.f69190a);
                    }
                };
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                    Handler handler = this.f69190a.getHandler();
                    if (handler == null) {
                        return false;
                    }
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        handler.removeCallbacks(this.f69195f);
                        this.f69193d = x;
                        this.f69194e = y;
                        handler.postDelayed(this.f69195f, this.f69191b);
                    } else if (action != 1) {
                        if (action == 2 && (Math.abs(this.f69193d - x) > 50 || Math.abs(this.f69194e - y) > 50)) {
                            handler.removeCallbacks(this.f69195f);
                        }
                    } else {
                        handler.removeCallbacks(this.f69195f);
                    }
                    return true;
                }
                return invokeLL.booleanValue;
            }
        });
    }

    public static void a(View view, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, view, str) == null) {
            a(view, 3000L, new View.OnLongClickListener(view, str) { // from class: com.bytedance.sdk.openadsdk.q.r.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ View f69197a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f69198b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {view, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69197a = view;
                    this.f69198b = str;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view2)) == null) {
                        View view3 = this.f69197a;
                        if (view3 != null) {
                            c.b(view3.getContext(), this.f69198b);
                            return false;
                        }
                        return false;
                    }
                    return invokeL.booleanValue;
                }
            });
        }
    }
}
