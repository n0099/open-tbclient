package com.kwad.sdk.contentalliance.detail.photo.newui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.ao;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class MarqueeView extends View {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static a f34823a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f34824b;

    /* renamed from: c  reason: collision with root package name */
    public float f34825c;

    /* renamed from: d  reason: collision with root package name */
    public int f34826d;

    /* renamed from: e  reason: collision with root package name */
    public float f34827e;

    /* renamed from: f  reason: collision with root package name */
    public int f34828f;

    /* renamed from: g  reason: collision with root package name */
    public float f34829g;

    /* renamed from: h  reason: collision with root package name */
    public float f34830h;

    /* renamed from: i  reason: collision with root package name */
    public int f34831i;
    public boolean j;
    public TextPaint k;
    public Rect l;
    public int m;
    public int n;
    public boolean o;
    public String p;
    public float q;
    public b r;

    /* loaded from: classes7.dex */
    public static class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HandlerThread f34833a;

        /* renamed from: b  reason: collision with root package name */
        public Handler f34834b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f34835c;

        /* renamed from: d  reason: collision with root package name */
        public List<WeakReference<b>> f34836d;

        /* renamed from: e  reason: collision with root package name */
        public long f34837e;

        public a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34835c = new Object();
            this.f34836d = new ArrayList();
            this.f34837e = j;
            HandlerThread handlerThread = new HandlerThread("marquee");
            this.f34833a = handlerThread;
            handlerThread.start();
            this.f34834b = new Handler(this.f34833a.getLooper(), this);
        }

        private void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                synchronized (this.f34835c) {
                    for (WeakReference<b> weakReference : this.f34836d) {
                        b bVar = weakReference.get();
                        if (bVar != null) {
                            bVar.a();
                        }
                    }
                }
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34834b.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + this.f34837e);
            }
        }

        public void a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                synchronized (this.f34835c) {
                    if (this.f34836d.size() == 0) {
                        a();
                    }
                    boolean z = false;
                    Iterator<WeakReference<b>> it = this.f34836d.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        WeakReference<b> next = it.next();
                        if (next.get() == null) {
                            it.remove();
                        } else if (next.get() == bVar) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        this.f34836d.add(new WeakReference<>(bVar));
                    }
                }
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f34834b.removeMessages(0);
            }
        }

        public void b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
                synchronized (this.f34835c) {
                    Iterator<WeakReference<b>> it = this.f34836d.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        WeakReference<b> next = it.next();
                        if (next.get() == null) {
                            it.remove();
                        } else if (next.get().equals(bVar)) {
                            it.remove();
                            break;
                        }
                    }
                    if (this.f34836d.size() == 0) {
                        b();
                    }
                }
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, message)) == null) {
                if (message.what == 0) {
                    if (this.f34836d.size() > 0) {
                        try {
                            c();
                        } catch (Exception e2) {
                            com.kwad.sdk.core.d.a.a(e2);
                        }
                    }
                    this.f34834b.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + this.f34837e);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-764272208, "Lcom/kwad/sdk/contentalliance/detail/photo/newui/MarqueeView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-764272208, "Lcom/kwad/sdk/contentalliance/detail/photo/newui/MarqueeView;");
                return;
            }
        }
        f34823a = new a(40L);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MarqueeView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MarqueeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarqueeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f34825c = 1.0f;
        this.f34826d = -16777216;
        this.f34827e = 12.0f;
        this.f34828f = 1;
        this.f34829g = 1.0f;
        this.f34830h = 0.0f;
        this.j = false;
        this.n = 0;
        this.o = true;
        this.p = "";
        this.r = new b(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.MarqueeView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ MarqueeView f34832a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34832a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.photo.newui.MarqueeView.b
            public void a() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f34832a.j && !TextUtils.isEmpty(this.f34832a.p)) {
                    this.f34832a.f34830h -= this.f34832a.f34825c;
                    this.f34832a.postInvalidate();
                }
            }
        };
        c();
    }

    private float a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) {
            if (str == null || str.equals("")) {
                return 0.0f;
            }
            if (this.l == null) {
                this.l = new Rect();
            }
            this.k.getTextBounds(str, 0, str.length(), this.l);
            this.q = getContentHeight();
            return this.l.width();
        }
        return invokeL.floatValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.l = new Rect();
            TextPaint textPaint = new TextPaint(1);
            this.k = textPaint;
            textPaint.setStyle(Paint.Style.FILL);
            this.k.setColor(this.f34826d);
            this.k.setTextSize(ao.a(getContext(), this.f34827e));
        }
    }

    private float getBlacktWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? a("en en") - a("enen") : invokeV.floatValue;
    }

    private float getContentHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            Paint.FontMetrics fontMetrics = this.k.getFontMetrics();
            return Math.abs(fontMetrics.bottom - fontMetrics.top) / 2.0f;
        }
        return invokeV.floatValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.j) {
            return;
        }
        f34823a.a(this.r);
        this.j = true;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.j = false;
            f34823a.b(this.r);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.o) {
                float f2 = this.f34829g;
                if (f2 < 0.0f) {
                    this.f34829g = 0.0f;
                } else if (f2 > 1.0f) {
                    this.f34829g = 1.0f;
                }
                this.f34830h = getWidth() * this.f34829g;
                this.o = false;
            }
            int i2 = this.f34828f;
            if (i2 != 1) {
                if (i2 == 2) {
                    float f3 = this.f34830h;
                    if (f3 < 0.0f) {
                        int i3 = (int) ((-f3) / this.f34831i);
                        int i4 = this.n;
                        if (i3 >= i4) {
                            this.n = i4 + 1;
                            this.f34824b += this.p;
                        }
                    }
                } else if (this.f34831i < (-this.f34830h)) {
                    b();
                }
            } else if (this.f34831i <= (-this.f34830h)) {
                this.f34830h = getWidth();
            }
            String str = this.f34824b;
            if (str != null) {
                canvas.drawText(str, this.f34830h, (getHeight() / 2.0f) + (this.q / 2.0f), this.k);
            }
        }
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f34830h = getWidth() * this.f34829g;
        if (!str.endsWith("")) {
            str = str + "";
        }
        this.p = str;
        int i2 = this.f34828f;
        if (i2 == 2) {
            this.f34831i = (int) (a(str) + this.m);
            this.n = 0;
            int width = (getWidth() / this.f34831i) + 2;
            this.f34824b = "";
            StringBuilder sb = new StringBuilder("");
            for (int i3 = 0; i3 <= width; i3++) {
                sb.append(this.p);
            }
            str = sb.toString();
        } else {
            float f2 = this.f34830h;
            if (f2 < 0.0f && i2 == 0 && (-f2) > this.f34831i) {
                this.f34830h = getWidth() * this.f34829g;
            }
            this.f34831i = (int) a(this.p);
        }
        this.f34824b = str;
    }

    public void setRepetType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f34828f = i2;
            this.o = true;
            setContent(this.p);
        }
    }

    public void setStartLocationDistance(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            this.f34829g = f2;
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || i2 == 0) {
            return;
        }
        this.f34826d = i2;
        this.k.setColor(i2);
    }

    public void setTextDistance(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            float blacktWidth = getBlacktWidth();
            int a2 = (int) (ao.a(getContext(), i2) / blacktWidth);
            if (a2 == 0) {
                a2 = 1;
            }
            this.m = (int) (blacktWidth * a2);
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 <= a2; i3++) {
                sb.append(" ");
            }
            setContent(sb.toString());
        }
    }

    public void setTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) || f2 <= 0.0f) {
            return;
        }
        this.f34827e = f2;
        this.k.setTextSize(ao.a(getContext(), f2));
        this.f34831i = (int) (a(this.p) + this.m);
    }

    public void setTextSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.f34825c = f2;
        }
    }
}
