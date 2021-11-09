package tv.athena.revenue.payui.view.banner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Gallery;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class AdGallery extends Gallery implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f73197e;

    /* renamed from: f  reason: collision with root package name */
    public int f73198f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f73199g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f73200h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f73201i;
    public boolean j;
    public boolean k;
    public final BroadcastReceiver l;
    public boolean m;

    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdGallery this$0;

        public a(AdGallery adGallery) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adGallery};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = adGallery;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    this.this$0.k = false;
                    this.this$0.g();
                } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                    this.this$0.k = true;
                    this.this$0.h(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<AdGallery> f73202a;

        public b(AdGallery adGallery) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adGallery};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73202a = new WeakReference<>(adGallery);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AdGallery adGallery;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && (adGallery = this.f73202a.get()) != null && message.what == 1 && adGallery.f73200h) {
                if (adGallery.getSelectedItemPosition() >= adGallery.getCount() - 1) {
                    adGallery.setSelection(0, true);
                    adGallery.onKeyDown(21, null);
                } else {
                    adGallery.onKeyDown(22, null);
                }
                sendMessageDelayed(obtainMessage(1), adGallery.f73198f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdGallery(Context context, AttributeSet attributeSet, int i2) {
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
        this.f73197e = new b(this);
        this.f73198f = 10000;
        this.f73199g = false;
        this.f73200h = false;
        this.f73201i = false;
        this.j = false;
        this.k = true;
        this.l = new a(this);
        this.m = false;
        init();
    }

    private void registerReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            getContext().registerReceiver(this.l, intentFilter, null, this.f73197e);
            this.m = true;
            RLog.debug("AdGallery", "[onAttachedToWindow] mHasRegisterReceiver = " + this.m);
        }
    }

    private void unregisterReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            RLog.debug("AdGallery", "[onAttachedToWindow] mHasRegisterReceiver = " + this.m);
            if (this.m) {
                RLog.debug("AdGallery", "[onAttachedToWindow] unregisterReceiver");
                try {
                    getContext().unregisterReceiver(this.l);
                } catch (Exception e2) {
                    RLog.error("AdGallery", "unregisterReceiver exception ", e2);
                }
                this.m = false;
            }
        }
    }

    public void endAutoScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            stopFlipping();
        }
    }

    public final boolean f(MotionEvent motionEvent, MotionEvent motionEvent2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent, motionEvent2)) == null) ? motionEvent2.getX() > motionEvent.getX() + 50.0f : invokeLL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            h(true);
        }
    }

    public final void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            boolean z2 = this.j && this.f73201i && this.k;
            if (z2 != this.f73200h) {
                if (z2) {
                    setSelection(getSelectedItemPosition(), z);
                    this.f73197e.sendMessageDelayed(this.f73197e.obtainMessage(1), this.f73198f);
                } else {
                    this.f73197e.removeMessages(1);
                }
                this.f73200h = z2;
            }
        }
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setOnTouchListener(this);
            setSoundEffectsEnabled(false);
            setFocusableInTouchMode(true);
        }
    }

    public boolean isAutoStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f73199g : invokeV.booleanValue;
    }

    public boolean isFlipping() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f73201i : invokeV.booleanValue;
    }

    @Override // android.widget.Gallery, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onAttachedToWindow();
            registerReceiver();
            if (this.f73199g) {
                startFlipping();
            }
        }
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDetachedFromWindow();
            this.j = false;
            unregisterReceiver();
            g();
        }
    }

    @Override // android.widget.Gallery, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            onKeyDown(f(motionEvent, motionEvent2) ? 21 : 22, null);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.widget.Gallery, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) ? super.onScroll(motionEvent, motionEvent2, f2, f3) : invokeCommon.booleanValue;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, view, motionEvent)) == null) {
            if (1 != motionEvent.getAction() && 3 != motionEvent.getAction()) {
                stopFlipping();
                return false;
            }
            startFlipping();
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            this.j = i2 == 0;
            h(false);
        }
    }

    public void setAutoStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f73199g = z;
        }
    }

    public void setFlipInterval(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f73198f = i2;
        }
    }

    public void startAutoScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            startFlipping();
        }
    }

    public void startFlipping() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f73201i = true;
            g();
        }
    }

    public void stopFlipping() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f73201i = false;
            g();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdGallery(Context context) {
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
        this.f73197e = new b(this);
        this.f73198f = 10000;
        this.f73199g = false;
        this.f73200h = false;
        this.f73201i = false;
        this.j = false;
        this.k = true;
        this.l = new a(this);
        this.m = false;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdGallery(Context context, AttributeSet attributeSet) {
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
        this.f73197e = new b(this);
        this.f73198f = 10000;
        this.f73199g = false;
        this.f73200h = false;
        this.f73201i = false;
        this.j = false;
        this.k = true;
        this.l = new a(this);
        this.m = false;
        init();
    }
}
