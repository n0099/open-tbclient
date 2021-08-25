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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
/* loaded from: classes10.dex */
public class SkipView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b f73853a;

    /* renamed from: b  reason: collision with root package name */
    public View f73854b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f73855c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f73856d;

    /* renamed from: e  reason: collision with root package name */
    public a f73857e;

    /* renamed from: f  reason: collision with root package name */
    public int f73858f;

    /* loaded from: classes10.dex */
    public interface a {
        void a();

        void b();
    }

    /* loaded from: classes10.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f73860a;

        /* renamed from: b  reason: collision with root package name */
        public String f73861b;

        /* renamed from: c  reason: collision with root package name */
        public int f73862c;

        /* renamed from: d  reason: collision with root package name */
        public int f73863d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f73864e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f73865f;

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
            this.f73860a = "跳过";
            this.f73861b = "倒计时";
            this.f73862c = 5;
            this.f73863d = 5;
            this.f73864e = true;
            this.f73865f = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? this.f73864e && this.f73865f : invokeV.booleanValue;
        }

        public static /* synthetic */ int e(b bVar) {
            int i2 = bVar.f73863d;
            bVar.f73863d = i2 - 1;
            return i2;
        }

        public String a() {
            InterceptResult invokeV;
            StringBuilder sb;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i3 = this.f73863d;
                if (i3 < 0) {
                    return this.f73861b;
                }
                if (i3 == 0) {
                    sb = new StringBuilder();
                    sb.append(this.f73861b);
                    i2 = 1;
                } else {
                    sb = new StringBuilder();
                    sb.append(this.f73861b);
                    i2 = this.f73863d;
                }
                sb.append(i2);
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f73862c = i2;
                this.f73863d = i2;
            }
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f73863d = -1;
                this.f73861b = str;
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f73863d <= 0 : invokeV.booleanValue;
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
        this.f73853a = new b();
        this.f73858f = -1;
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
        this.f73853a = new b();
        this.f73858f = -1;
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
        this.f73853a = new b();
        this.f73858f = -1;
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
        this.f73853a = new b();
        this.f73858f = -1;
        a(context, attributeSet, i2, i3);
    }

    private void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(AdIconUtil.AD_TEXT_ID, this, context, attributeSet, i2, i3) == null) {
            setOrientation(0);
            LayoutInflater.from(context).inflate(R.layout.ksad_skip_view, this);
            this.f73855c = (TextView) findViewById(R.id.ksad_skip_view_skip);
            this.f73856d = (TextView) findViewById(R.id.ksad_skip_view_timer);
            this.f73854b = findViewById(R.id.ksad_skip_view_divider);
            this.f73855c.setOnClickListener(this);
            this.f73856d.setOnClickListener(this);
            setSkipBtnVisible(true);
            setTimerBtnVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, bVar) == null) || bVar == null) {
            return;
        }
        if (this.f73855c != null) {
            if (bVar.f73860a != null) {
                this.f73855c.setText(bVar.f73860a);
            }
            this.f73855c.setVisibility(this.f73853a.f73864e ? 0 : 8);
        }
        String a2 = bVar.a();
        TextView textView = this.f73856d;
        if (textView != null) {
            if (a2 != null) {
                textView.setText(a2);
            }
            this.f73856d.setVisibility(this.f73853a.f73865f ? 0 : 8);
        }
        if (this.f73854b != null) {
            boolean c2 = this.f73853a.c();
            this.f73854b.setVisibility(c2 ? 0 : 8);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                if (c2) {
                    i2 = this.f73858f;
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
            a(this.f73853a);
            post(new Runnable(this) { // from class: com.kwad.sdk.widget.SkipView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SkipView f73859a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f73859a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SkipView skipView = this.f73859a;
                        skipView.a(skipView.f73853a);
                        if (!this.f73859a.f73853a.b()) {
                            this.f73859a.postDelayed(this, 1000L);
                        }
                        b.e(this.f73859a.f73853a);
                    }
                }
            });
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || str == null) {
            return;
        }
        this.f73853a.a(str);
        a(this.f73853a);
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
            setVisibility(8);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TextView textView = this.f73856d;
            return textView != null && textView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            int id = view.getId();
            if (R.id.ksad_skip_view_skip == id) {
                a aVar2 = this.f73857e;
                if (aVar2 != null) {
                    aVar2.a();
                }
            } else if (R.id.ksad_skip_view_timer != id || (aVar = this.f73857e) == null) {
            } else {
                aVar.b();
            }
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, layoutParams) == null) {
            super.setLayoutParams(layoutParams);
            this.f73858f = layoutParams.width;
        }
    }

    public void setOnViewListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f73857e = aVar;
        }
    }

    public void setSkipBtnVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f73853a.f73864e = z;
            a(this.f73853a);
        }
    }

    public void setSkipText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f73853a.f73860a = str;
            a(this.f73853a);
        }
    }

    public void setTimerBtnVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f73853a.f73865f = z;
            a(this.f73853a);
        }
    }

    public void setTimerPrefixText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f73853a.f73861b = str;
            a(this.f73853a);
        }
    }

    public void setTimerSecond(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f73853a.a(i2);
            a(this.f73853a);
        }
    }
}
