package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
/* loaded from: classes2.dex */
public class SkipView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b a;

    /* renamed from: b  reason: collision with root package name */
    public View f59764b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59765c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59766d;

    /* renamed from: e  reason: collision with root package name */
    public a f59767e;

    /* renamed from: f  reason: collision with root package name */
    public int f59768f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59769g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f59770h;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b();
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f59771b;

        /* renamed from: c  reason: collision with root package name */
        public int f59772c;

        /* renamed from: d  reason: collision with root package name */
        public int f59773d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f59774e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f59775f;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = "跳过";
            this.f59771b = "";
            this.f59772c = 5;
            this.f59773d = 5;
            this.f59774e = true;
            this.f59775f = true;
        }

        public static /* synthetic */ int a(b bVar) {
            int i2 = bVar.f59773d;
            bVar.f59773d = i2 - 1;
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? this.f59774e && this.f59775f : invokeV.booleanValue;
        }

        public String a() {
            InterceptResult invokeV;
            StringBuilder sb;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i3 = this.f59773d;
                if (i3 < 0) {
                    return this.f59771b;
                }
                if (i3 == 0) {
                    sb = new StringBuilder();
                    sb.append(this.f59771b);
                    i2 = 1;
                } else {
                    sb = new StringBuilder();
                    sb.append(this.f59771b);
                    i2 = this.f59773d;
                }
                sb.append(i2);
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f59772c = i2;
                this.f59773d = i2;
            }
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f59773d = -1;
                this.f59771b = str;
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59773d <= 0 : invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkipView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new b();
        this.f59768f = -1;
        this.f59769g = false;
        this.f59770h = new Runnable(this) { // from class: com.kwad.sdk.widget.SkipView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SkipView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.a.f59769g) {
                        this.a.postDelayed(this, 300L);
                        return;
                    }
                    SkipView skipView = this.a;
                    skipView.a(skipView.a);
                    if (!this.a.a.b()) {
                        this.a.postDelayed(this, 1000L);
                        b.a(this.a.a);
                    } else if (this.a.f59767e != null) {
                        this.a.f59767e.b();
                    }
                }
            }
        };
        a(context, null, 0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkipView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new b();
        this.f59768f = -1;
        this.f59769g = false;
        this.f59770h = new Runnable(this) { // from class: com.kwad.sdk.widget.SkipView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SkipView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.a.f59769g) {
                        this.a.postDelayed(this, 300L);
                        return;
                    }
                    SkipView skipView = this.a;
                    skipView.a(skipView.a);
                    if (!this.a.a.b()) {
                        this.a.postDelayed(this, 1000L);
                        b.a(this.a.a);
                    } else if (this.a.f59767e != null) {
                        this.a.f59767e.b();
                    }
                }
            }
        };
        a(context, attributeSet, 0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkipView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new b();
        this.f59768f = -1;
        this.f59769g = false;
        this.f59770h = new Runnable(this) { // from class: com.kwad.sdk.widget.SkipView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SkipView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.a.f59769g) {
                        this.a.postDelayed(this, 300L);
                        return;
                    }
                    SkipView skipView = this.a;
                    skipView.a(skipView.a);
                    if (!this.a.a.b()) {
                        this.a.postDelayed(this, 1000L);
                        b.a(this.a.a);
                    } else if (this.a.f59767e != null) {
                        this.a.f59767e.b();
                    }
                }
            }
        };
        a(context, attributeSet, i2, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RequiresApi(api = 21)
    public SkipView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = new b();
        this.f59768f = -1;
        this.f59769g = false;
        this.f59770h = new Runnable(this) { // from class: com.kwad.sdk.widget.SkipView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SkipView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i52 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.a.f59769g) {
                        this.a.postDelayed(this, 300L);
                        return;
                    }
                    SkipView skipView = this.a;
                    skipView.a(skipView.a);
                    if (!this.a.a.b()) {
                        this.a.postDelayed(this, 1000L);
                        b.a(this.a.a);
                    } else if (this.a.f59767e != null) {
                        this.a.f59767e.b();
                    }
                }
            }
        };
        a(context, attributeSet, i2, i3);
    }

    private void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(InputDeviceCompat.SOURCE_TRACKBALL, this, context, attributeSet, i2, i3) == null) {
            setOrientation(0);
            LayoutInflater.from(context).inflate(R.layout.ksad_skip_view, this);
            this.f59765c = (TextView) findViewById(R.id.ksad_skip_view_skip);
            this.f59766d = (TextView) findViewById(R.id.ksad_skip_view_timer);
            this.f59764b = findViewById(R.id.ksad_skip_view_divider);
            setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.widget.SkipView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SkipView a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.a.f59767e == null) {
                        return;
                    }
                    this.a.f59767e.a();
                }
            });
            setSkipBtnVisible(true);
            setTimerBtnVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, bVar) == null) || bVar == null) {
            return;
        }
        if (this.f59765c != null) {
            if (bVar.a != null) {
                this.f59765c.setText(bVar.a);
            }
            this.f59765c.setVisibility(this.a.f59774e ? 0 : 8);
        }
        String a2 = bVar.a();
        TextView textView = this.f59766d;
        if (textView != null) {
            if (a2 != null) {
                textView.setText(a2);
            }
            this.f59766d.setVisibility(this.a.f59775f ? 0 : 8);
        }
        if (this.f59764b != null) {
            boolean c2 = this.a.c();
            this.f59764b.setVisibility(c2 ? 0 : 8);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                if (c2) {
                    i2 = this.f59768f;
                    if (i2 <= 0) {
                        return;
                    }
                } else {
                    i2 = -2;
                }
                layoutParams.width = i2;
                invalidate();
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a(this.a);
            post(this.f59770h);
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || str == null) {
            return;
        }
        this.a.a(str);
        a(this.a);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        setAlpha(0.0f);
        animate().alpha(1.0f).setDuration(500L).start();
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f59769g = true;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f59769g = false;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setVisibility(8);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            TextView textView = this.f59766d;
            return textView != null && textView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, layoutParams) == null) {
            super.setLayoutParams(layoutParams);
            this.f59768f = layoutParams.width;
        }
    }

    public void setOnViewListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f59767e = aVar;
        }
    }

    public void setSkipBtnVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.a.f59774e = z;
            a(this.a);
        }
    }

    public void setSkipText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.a.a = str;
            a(this.a);
        }
    }

    public void setTimerBtnVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.a.f59775f = z;
            a(this.a);
        }
    }

    public void setTimerPrefixText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.a.f59771b = str;
            a(this.a);
        }
    }

    public void setTimerSecond(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.a.a(i2);
            a(this.a);
        }
    }
}
